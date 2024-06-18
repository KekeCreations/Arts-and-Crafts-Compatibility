package com.kekecreations.arts_and_crafts_compatibility.compat.built;

import com.kekecreations.arts_and_crafts_compatibility.common.compat.built.BuiltBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class BuiltFlammableAndStrippableBlocks {


    public static void register() {
        FlammableBlockRegistry.getDefaultInstance().add(BuiltBlocks.CORK_COMPACT_PLANKS.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BuiltBlocks.CORK_SHAKES.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BuiltBlocks.CORK_SHAKES_STAIRS.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BuiltBlocks.CORK_SHAKES_SLAB.get(), 5, 20);
    }
}
