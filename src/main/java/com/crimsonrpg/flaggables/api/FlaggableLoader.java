/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrpg.flaggables.api;

import java.util.List;

/**
 * Loads flaggables.
 */
public interface FlaggableLoader<T extends Flaggable> {
    /**
     * Creates a flaggable with the specified information.
     * 
     * @param id The ID of the flaggable.
     * @return The created flaggable.
     */
    public T create(String id);
}
