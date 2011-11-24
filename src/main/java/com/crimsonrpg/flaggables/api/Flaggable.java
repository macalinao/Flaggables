/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrpg.flaggables.api;

import java.util.List;

/**
 * Represents an object that can contain flags.
 */
public interface Flaggable {
    /**
     * Gets the ID of this flaggable.
     * 
     * @return 
     */
    public String getId();
    
    /**
     * Gets the value of a flag.
     * 
     * @param <T>
     * @param type
     * @return 
     */
    public <T extends Flag> T getFlag(Class<T> type);
    
    /**
     * Adds multiple flags to this Flaggable object.
     * 
     * @param flags 
     */
    public void addFlags(List<Flag> flags);
    
    /**
     * Sets the value of a flag.
     * 
     * @param flag 
     */
    public void setFlag(Flag flag);
    
    /**
     * Gets the flags a Flaggable contains.
     * 
     * @return 
     */
    public List<Flag> getFlags();
}
