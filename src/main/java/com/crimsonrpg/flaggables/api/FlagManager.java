/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrpg.flaggables.api;

import java.util.List;
import org.bukkit.configuration.ConfigurationSection;

/**
 * Represents a manager of Flags.
 */
public interface FlagManager {
    /**
     * Gets a flag type from a name.
     * 
     * @param name
     * @return 
     */
    public Class<? extends Flag> getFlagType(String name);
    
    /**
     * Makes a new flag with default data.
     * 
     * @param <T>
     * @param type
     * @return The flag.
     */
    public <T extends Flag> T makeFlag(Class<T> type);
    
    /**
     * Makes a new flag with the specified data,
     * 
     * @param <T>
     * @param type
     * @param data
     * @return The flag.
     */
    public <T extends Flag> T makeFlag(Class<T> type, ConfigurationSection data);
    
    /**
     * Registers the given flag type.
     * 
     * @param type The flag type.
     */
    public void registerFlag(Class<? extends Flag> type);
    
    /**
     * Makes a list of flags from the given configuration section.
     * 
     * @param section The section containing the flags.
     * @return The flags.
     */
    public List<Flag> makeFlagList(ConfigurationSection section);
    
    /**
     * Stores a list of flags in the given section.
     * 
     * @param flags The list of flags.
     * @param section The section to store the flags in.
     */
    public void storeFlagList(List<Flag> flags, ConfigurationSection section);
    
    /**
     * Reads a list of Flaggables from a ConfigurationSection.
     * 
     * @param <T>
     * @param section
     * @param type
     * @return 
     */
    public <T extends Flaggable> List<T> readFlaggables(ConfigurationSection section, Class<T> type);
    
    /**
     * Writes a list of Flaggables to a ConfigurationSection.
     * 
     * @param flaggables
     * @param section 
     */
    public void writeFlaggables(List<? extends Flaggable> flaggables, ConfigurationSection section);
}
