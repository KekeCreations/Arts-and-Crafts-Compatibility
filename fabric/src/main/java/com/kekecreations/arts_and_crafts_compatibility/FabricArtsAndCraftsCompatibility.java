package com.kekecreations.arts_and_crafts_compatibility;

import com.kekecreations.arts_and_crafts_compatibility.compat.dramatic_doors.DDBlocks;
import com.kekecreations.arts_and_crafts_compatibility.compat.dramatic_doors.DDItems;
import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.compat.CompatItemGroups;
import com.kekecreations.arts_and_crafts_compatibility.compat.FabricArtsAndCraftsCompatResourcePacks;
import com.kekecreations.arts_and_crafts_compatibility.compat.built.BuiltFlammableAndStrippableBlocks;
import com.kekecreations.arts_and_crafts_compatibility.compat.caffeinated.CaffeinatedBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class FabricArtsAndCraftsCompatibility implements ModInitializer {
    
    @Override
    public void onInitialize() {
        FabricArtsAndCraftsCompatResourcePacks.loadBuiltinResourcePacks();
        ArtsAndCraftsCompatibility.init();
        CompatItemGroups.addItemsToTabs();
        if (isModLoaded(CompatUtils.BUILT)) {
            BuiltFlammableAndStrippableBlocks.register();
        }
        if (isModLoaded(CompatUtils.CAFFEINATED)) {
            CaffeinatedBlocks.register();
        }
        if (isModLoaded(CompatUtils.DRAMATIC_DOORS)) {
            DDBlocks.register();
            DDItems.register();
        }
    }

    public static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
}
