package com.kekecreations.arts_and_crafts_compatibility;

import com.kekecreations.arts_and_crafts_compatibility.compat.CompatItemGroups;
import com.kekecreations.arts_and_crafts_compatibility.compat.FabricArtsAndCraftsCompatResourcePacks;
import com.kekecreations.arts_and_crafts_compatibility.compat.FlammableAndStrippableBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCFabricBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCFabricItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class FabricArtsAndCraftsCompatibility implements ModInitializer {
    
    @Override
    public void onInitialize() {
        FabricArtsAndCraftsCompatResourcePacks.loadBuiltinResourcePacks();
        ArtsAndCraftsCompatibility.init();
        CompatItemGroups.addItemsToTabs();
        FlammableAndStrippableBlocks.register();
        ACCFabricBlocks.register();
        ACCFabricItems.register();
    }

    public static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
}
