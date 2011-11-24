/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrpg.flaggables.api;

/**
 * Flaggables
 */
public class Flaggables {
    private static Flaggables instance = new Flaggables();
    private FlagManager flagManager = null;
    
    private Flaggables() {
        
    }
    
    public static Flaggables getInstance() {
        return instance;
    }
    
    public static FlagManager getFlagManager() {
        return getInstance().flagManager;
    }
    
    public void setFlagManager(FlagManager flagManager) {
        System.out.println("HI!!! " + flagManager);
        if (flagManager == null) {
            System.out.println("BYE!!! " + flagManager);
            this.flagManager = flagManager;
        }
    }
}
