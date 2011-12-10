/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrpg.flaggables.api;

import java.util.List;
import org.bukkit.configuration.ConfigurationSection;

/**
 * Represents a flaggable manager.
 */
public interface FlaggableManager<T extends Flaggable> {

    /**
     * Loads the flaggable manager with the given data.
     * 
     * @param flaggables 
     */
    public void load(List<T> flaggables);

    /**
     * Loads the flaggable manager with the data in
     * the given ConfigurationSection.
     * 
     * @param section The section to load from.
     */
    public void readFlaggables(ConfigurationSection section);
    
    /**
     * Saves the flaggables to a ConfigurationSection.
     * 
     * @param section The section to save to.
     */
    public void save(ConfigurationSection section);


    /**
     * Creates an instance of the flaggable with the given id.
     * 
     * @param id The id of the Flaggable.
     * @return The newly created flaggable.
     */
    public T create(String id);

    /**
     * Creates an instance of the flaggable with the given id and flags.
     * 
     * @param id The id of the flaggable.
     * @param flags The flags of the flaggable.
     * @return The newly created flaggable.
     */
    public T create(String id, List<Flag> flags);

    /**
     * Adds a flaggable to this flaggable manager.
     * 
     * @param flaggable 
     */
    public void add(T flaggable);

    /**
     * Adds a group of flaggables to this flaggable manager.
     * 
     * @param flaggables 
     */
    public void addAll(List<T> flaggables);

    /**
     * Gets the flaggable with the given id.
     * 
     * @param id 
     */
    public T get(String id);

    /**
     * Reassigns the given id to the flaggable.
     * 
     * @param newId
     * @param flaggable 
     */
    public T reassign(String newId, T flaggable);

    /**
     * Destroys the flaggable with the given id.
     * 
     * @param id 
     */
    public T destroy(String id);

    /**
     * Destroys the given flaggable.
     * 
     * @param flaggable 
     */
    public T destroy(T flaggable);

    /**
     * Gets a list of all flaggables in this flaggable manager.
     * 
     * @return 
     */
    public List<T> getList();

    /**
     * Checks if the given ID already exists within this Flaggable manager.
     * 
     * @param id The ID to check.
     * @return True if the id exists
     */
    public boolean idExists(String id);
}
