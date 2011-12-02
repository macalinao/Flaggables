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
 * A generic flaggable manager.
 */
public abstract class GenericFlaggableManager<T extends Flaggable> implements FlaggableManager<T> {
    private Map<String, T> flaggables = new HashMap<String, T>();
    
    public void load(List<T> flaggables) {
        flaggables.clear();
        flaggables.addAll(flaggables);
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
        return new ArrayList(flaggables.values());
    }
}
