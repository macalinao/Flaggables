/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrpg.flaggables.api;

import org.bukkit.configuration.ConfigurationSection;

/**
 * Represents a flag that cannot be loaded or saved.
 */
public abstract class SessionFlag<T extends Flaggable> extends GenericFlag<T> {

    public final void load(ConfigurationSection section) {
    }

    public final void save(ConfigurationSection section) {
    }

}
