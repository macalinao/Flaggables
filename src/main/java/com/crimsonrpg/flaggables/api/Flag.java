/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrpg.flaggables.api;

import org.bukkit.configuration.ConfigurationSection;

/**
 * Represents a flag.
 */
public interface Flag<T extends Flaggable> {

    /**
     * Gets the Flaggable that this Flag is attached to.
     * 
     * @return The Flaggable.
     */
    public T getFlaggable();

    /**
     * Sets the Flaggable that this Flag is attached to.
     * 
     * @param flaggable The flaggable.
     */
    public void setFlaggable(T flaggable);

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
