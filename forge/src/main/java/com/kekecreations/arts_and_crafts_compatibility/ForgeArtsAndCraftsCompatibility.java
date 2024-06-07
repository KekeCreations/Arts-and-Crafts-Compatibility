package com.kekecreations.arts_and_crafts_compatibility;

import net.minecraftforge.fml.common.Mod;

@Mod(ArtsAndCraftsCompatibility.MOD_ID)
public class ForgeArtsAndCraftsCompatibility {
    
    public ForgeArtsAndCraftsCompatibility() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        ArtsAndCraftsCompatibility.LOG.info("Hello Forge world!");
        ArtsAndCraftsCompatibility.init();
        
    }
}