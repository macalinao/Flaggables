/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrpg.flaggables.api;

import java.util.List;
import org.bukkit.configuration.ConfigurationSection;


/**
 * Class providing useful things relating to flags.
 */
public class FlagUtils {
    /**
     * Writes a list of Flaggables to a ConfigurationSection.
     * 
     * @param flaggables
     * @param section 
     */
    public static void writeFlaggables(List<Flaggable> flaggables, ConfigurationSection section) {
        //Loop through all flaggables and write them
        for (Flaggable flaggable : flaggables) {
            Flaggables.getFlagManager().storeFlagList(flaggable.getFlags(), section.createSection(flaggable.getId()));
        }
    }
}
