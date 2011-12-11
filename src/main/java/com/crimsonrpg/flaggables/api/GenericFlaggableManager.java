/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrpg.flaggables.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.configuration.ConfigurationSection;

/**
 * A generic flaggable manager.
 */
public abstract class GenericFlaggableManager<T extends Flaggable> implements FlaggableManager<T> {

    private final FlaggableLoader<T> loader;
    private Map<String, T> flaggables = new HashMap<String, T>();

    public GenericFlaggableManager(FlaggableLoader<T> loader) {
        this.loader = loader;
    }

    public void load(List<T> flaggables) {
        this.flaggables.clear();
        this.addAll(flaggables);
    }

    public void load(ConfigurationSection section) {
        List<T> loaded = new ArrayList<T>();

        for (String key : section.getKeys(false)) {

            //Set the flags
            ConfigurationSection flaggableSection = section.getConfigurationSection(key);
            List<Flag> flags = Flaggables.getFlagManager().makeFlagList(flaggableSection);
            T flaggable = loader.create(key, flags);

            //Add to the list
            loaded.add(flaggable);
        }

        load(loaded);
    }

    public void save(ConfigurationSection section) {
        for (Flaggable flaggable : getList()) {
            Flaggables.getFlagManager().storeFlagList(flaggable.getFlags(), section.createSection(flaggable.getId()));
        }
    }

    public T create(String id) {
        return create(id, null);
    }

    public T create(String id, List<Flag> flags) {
        if (flags == null) {
            flags = new ArrayList<Flag>();
        }
        T created = loader.create(id, flags);
        flaggables.put(id, created);
        return created;
    }

    public T get(String id) {
        return flaggables.get(id);
    }

    public void add(T flaggable) {
        flaggables.put(flaggable.getId(), flaggable);
    }

    public void addAll(List<T> flaggables) {
        for (T flaggable : flaggables) {
            add(flaggable);
        }
    }

    public T reassign(String newId, T flaggable) {
        flaggables.remove(flaggable.getId());
        flaggable.setId(newId);
        flaggables.put(newId, flaggable);
        return flaggable;
    }

    public T destroy(String id) {
        return flaggables.remove(id);
    }

    public T destroy(T flaggable) {
        return destroy(flaggable.getId());
    }

    public List<T> getList() {
        return new ArrayList<T>(flaggables.values());
    }

    public boolean idExists(String id) {
        return flaggables.containsKey(id);
    }
}
