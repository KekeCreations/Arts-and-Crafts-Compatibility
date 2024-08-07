package com.kekecreations.arts_and_crafts_compatibility.compat.caffeinated;

import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.function.Supplier;

public class CaffeinatedBlocks {

    public static final HashMap<DyeColor, Supplier<Block>> DYED_COFFEE_SHRUB_FLOWER_POTS = new HashMap<>();

    static {
        for (DyeColor colours : DyeColor.values()) {
            DYED_COFFEE_SHRUB_FLOWER_POTS.put(colours, CompatUtils.registerBlock(colours + "_potted_coffee_shrub", () -> CompatUtils.flowerPot(CompatUtils.CAFFEINATED, com.chikoritalover.caffeinated.registry.CaffeinatedBlocks.COFFEE_SHRUB, colours)));
        }
    }

    public static Block getDyedPottedCoffeeShrub(DyeColor dyeColor) {
        return DYED_COFFEE_SHRUB_FLOWER_POTS.get(dyeColor).get();
    }

    public static void register() {

    }
}
