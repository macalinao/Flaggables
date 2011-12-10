package com.crimsonrpg.flaggables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.configuration.ConfigurationSection;

import com.crimsonrpg.flaggables.api.Flag;
import com.crimsonrpg.flaggables.api.FlagId;
import com.crimsonrpg.flaggables.api.FlagManager;
import com.crimsonrpg.flaggables.api.Flaggable;
import com.crimsonrpg.flaggables.api.FlaggableLoader;

/**
 * Represents a simple flag manager.
 */
public class SimpleFlagManager implements FlagManager {

    private Map<String, Class<? extends Flag>> registeredFlags = new HashMap<String, Class<? extends Flag>>();

    public Class<? extends Flag> getFlagType(String name) {
        return registeredFlags.get(name);
    }

    public <T extends Flag> T makeFlag(Class<T> type) {
        return makeFlag(type, null);
    }

    public <T extends Flag> T makeFlag(Class<T> type, ConfigurationSection data) {
        T flag = null;

        //Create a new flag instance
        try {
            flag = type.newInstance();
        } catch (InstantiationException ex) {
            FlaggablesPlugin.LOGGER.severe("[Flaggables] Could not instantiate a new '" + type.getName() + "' flag.");
            return null;
        } catch (IllegalAccessException ex) {
            FlaggablesPlugin.LOGGER.severe("[Flaggables] Could not access the type '" + type.getName() + "' to create a flag of that type.");
            return null;
        }

        //Check for null data
        if (data == null) {
            flag.reset();
            return flag;
        }

        flag.load(data);

        return flag;
    }

    public void registerFlag(Class<? extends Flag> type) {

        //Check for the annotation
        if (!type.isAnnotationPresent(FlagId.class)) {
            FlaggablesPlugin.LOGGER.warning("[Flaggables] The flag type '" + type.getName() + "; does not have a FlagId annotation present; skipping.");
            return;
        }

        String id = type.getAnnotation(FlagId.class).value();

        //Check if the flag has already been registered
        if (registeredFlags.containsKey(id)) {
            FlaggablesPlugin.LOGGER.warning("[Flaggables] The flag '" + type.getName() + "' cannot be registered under '"
                    + id + "' as there is already a flag named '" + registeredFlags.get(id).getName() + "' in its place.");
            return;
        }

        FlaggablesPlugin.LOGGER.info("[Flaggables] Registering '" + type.getName() + "' as '" + id + "'.");
        registeredFlags.put(id, type);
    }

    public void registerFlags(Class<? extends Flag>... types) {
        for (Class<? extends Flag> type : types) {
            registerFlag(type);
        }
    }

    public List<Flag> makeFlagList(ConfigurationSection section) {
        List<Flag> flagList = new ArrayList<Flag>();

        for (String key : section.getKeys(false)) {
            ConfigurationSection flagSection = section.getConfigurationSection(key);
            Class type = this.getFlagType(key);
            if (type == null) {
                FlaggablesPlugin.LOGGER.warning("[Flaggables] Undefined type '" + key + "' presented; skipping.");
                continue;
            }
            flagList.add(this.makeFlag(type, flagSection));
        }

        return flagList;
    }

    public void storeFlagList(List<Flag> flags, ConfigurationSection section) {
        if (section == null) {
            return; //Always have to check for retards
        }
        for (Flag flag : flags) {
            Class<? extends Flag> type = flag.getClass();

            //Check for an annotation on the flag
            if (!type.isAnnotationPresent(FlagId.class)) {
                FlaggablesPlugin.LOGGER.warning("[Flaggables] The flag of type '" + type.getName() + "' does not have an annotation for Flag Id present; skipping.");
                continue;
            }

            //Get the flag id
            String flagId = type.getAnnotation(FlagId.class).value();

            //Save the section
            ConfigurationSection flagSection = section.createSection(flagId);
            flag.save(flagSection);
        }
    }
}
