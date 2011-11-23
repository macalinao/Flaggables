/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrpg.flaggables.api;

import org.bukkit.configuration.ConfigurationSection;

/**
 * Represents a flag.
 */
public interface Flag {
    /**
     * Loads the flag.
     * 
     * @param section 
     */
    public void load(ConfigurationSection section);
    
    /**
     * Saves the flag.
     * 
     * @param section 
     */
    public void save(ConfigurationSection section);
    
    /**
     * Resets the flag to default values.
     */
    public void reset();
}
