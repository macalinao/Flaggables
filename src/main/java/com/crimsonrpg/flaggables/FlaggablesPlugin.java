/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrpg.flaggables;

import com.FlaggablesPluginrpg.flaggables.SimpleFlagManager;
import com.crimsonrpg.flaggables.api.Flaggables;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The Flaggables plugin.
 */
public class FlaggablesPlugin extends JavaPlugin {
    public static final Logger LOGGER = Logger.getLogger("Minecraft");
    
    public FlaggablesPlugin() {
        super();
        Flaggables.getInstance().setFlagManager(new SimpleFlagManager());
    }
    
    public void onDisable() {
        LOGGER.info("[Flaggables] Plugin disabled.");
    }

    public void onEnable() {
        LOGGER.info("[Flaggables] Plugin enabled.");
    }
    
}
