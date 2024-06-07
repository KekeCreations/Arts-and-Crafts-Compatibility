package com.kekecreations.arts_and_crafts_compatibility;

import net.fabricmc.api.ModInitializer;

public class FabricArtsAndCraftsCompatibility implements ModInitializer {
    
    @Override
    public void onInitialize() {
        ArtsAndCraftsCompatibility.init();
    }
}
