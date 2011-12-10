/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrpg.flaggables.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a generic flaggable object.
 */
public abstract class GenericFlaggable implements Flaggable {

    private String id;

    private Map<Class, Flag> flags = new HashMap<Class, Flag>();

    public GenericFlaggable(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public final <T extends Flag> T getFlag(Class<T> type) {
        Flag flag = flags.get(type);

        if (flag != null) {
            return type.cast(flag);
        }

        T flagg = Flaggables.getFlagManager().makeFlag(type);
        flagg.setFlaggable(this);
        flags.put(type, flagg);
        return flagg;
    }

    public final void addFlags(List<Flag> flags) {
        if (flags == null) {
            throw new IllegalArgumentException("Cannot add a list of null flags!");
        }
        
        for (Flag flag : flags) {
            setFlag(flag);
        }
    }

    public final void setFlag(Flag flag) {
        if (flag == null) {
            throw new IllegalArgumentException("Cannot set a null flag!");
        }
        flag.setFlaggable(this);
        flags.put(flag.getClass(), flag);
    }

    public final List<Flag> getFlags() {
        return new ArrayList<Flag>(flags.values());
    }

}
