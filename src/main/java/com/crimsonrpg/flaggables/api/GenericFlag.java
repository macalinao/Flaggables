/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrpg.flaggables.api;

import org.bukkit.configuration.ConfigurationSection;

/**
 *
 * @author simplyianm
 */
public abstract class GenericFlag<T extends Flaggable> implements Flag {

    private Flaggable flaggable = null;

    public final Flaggable getFlaggable() {
        return flaggable;
    }

    public void setFlaggable(Flaggable flaggable) {
        this.flaggable = flaggable;
    }

    public abstract void load(ConfigurationSection section);

    public abstract void save(ConfigurationSection section);

    public abstract void reset();

}
