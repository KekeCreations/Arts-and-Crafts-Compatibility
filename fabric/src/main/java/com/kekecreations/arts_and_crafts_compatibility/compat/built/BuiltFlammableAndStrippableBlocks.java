package com.kekecreations.arts_and_crafts_compatibility.compat.built;

import com.kekecreations.arts_and_crafts_compatibility.common.compat.built.BuiltBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class BuiltFlammableAndStrippableBlocks {


    public static void register() {
        FlammableBlockRegistry.getDefaultInstance().add(BuiltBlocks.CORK_COMPACT_PLANKS_BLOCK.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BuiltBlocks.CORK_SHAKES_BLOCK.get(), 5, 20);
        FuelRegistry.INSTANCE.add(BuiltBlocks.CORK_COMPACT_PLANKS_BLOCK.get(), 300);
        FuelRegistry.INSTANCE.add(BuiltBlocks.CORK_SHAKES.get(), 300);
    }
}
