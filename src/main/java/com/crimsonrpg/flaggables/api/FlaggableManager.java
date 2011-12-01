/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrpg.flaggables.api;

import java.util.List;

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
     * Creates an instance of the flaggable with the given id.
     * 
     * @param id The id of the Flaggable.
     */
    public T create(String id);

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

}
