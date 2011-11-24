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
    private Map<Class, Flag> flags = new HashMap<Class, Flag>();

    public final <T extends Flag> T getFlag(Class<T> type) {
        Flag flag = flags.get(type);
        if (flag != null) return type.cast(flag);
        T flagg = Flaggables.getFlagManager().makeFlag(type);
        flags.put(type, flagg);
        return flagg;
    }

    public final void addFlags(List<Flag> flags) {
        for (Flag flag : flags) setFlag(flag);
    }

    public final void setFlag(Flag flag) {
        flags.put(flag.getClass(), flag);
    }

    public final List<Flag> getFlags() {
        return new ArrayList(flags.values());
    }
    
}
