package com.kekecreations.arts_and_crafts_compatibility.compat;

import com.kekecreations.arts_and_crafts_compatibility.FabricArtsAndCraftsCompatibility;
import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class FlammableAndStrippableBlocks {


    public static void register() {
        if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.BUILT)) {
            FlammableBlockRegistry.getDefaultInstance().add(ACCBlocks.CORK_COMPACT_PLANKS.get(), 5, 20);
            FlammableBlockRegistry.getDefaultInstance().add(ACCBlocks.CORK_SHAKES.get(), 5, 20);
            FlammableBlockRegistry.getDefaultInstance().add(ACCBlocks.CORK_SHAKES_STAIRS.get(), 5, 20);
            FlammableBlockRegistry.getDefaultInstance().add(ACCBlocks.CORK_SHAKES_SLAB.get(), 5, 20);
        }
    }
}
