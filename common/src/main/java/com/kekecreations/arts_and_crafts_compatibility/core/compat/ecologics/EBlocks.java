package com.kekecreations.arts_and_crafts_compatibility.core.compat.ecologics;

import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import samebutdifferent.ecologics.registry.ModBlocks;

import java.util.HashMap;
import java.util.function.Supplier;

public class EBlocks {

    public static final HashMap<DyeColor, Supplier<Block>> DYED_WALNUT_SAPLING_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_AZALEA_FLOWER_FLOWER_POTS = new HashMap<>();

    static {
        for (DyeColor colours : DyeColor.values()) {
            DYED_WALNUT_SAPLING_FLOWER_POTS.put(colours, CompatUtils.registerBlock(colours + "_potted_walnut_sapling", () -> CompatUtils.flowerPot(ModBlocks.WALNUT_SAPLING.get(), colours)));
            DYED_AZALEA_FLOWER_FLOWER_POTS.put(colours, CompatUtils.registerBlock(colours + "_potted_azalea_flower", () -> CompatUtils.flowerPot(ModBlocks.AZALEA_FLOWER.get(), colours)));
        }
    }

    public static Block getDyedPottedWalnutSapling(DyeColor dyeColor) {
        return DYED_WALNUT_SAPLING_FLOWER_POTS.get(dyeColor).get();
    }

    public static Block getDyedPottedAzaleaFlower(DyeColor dyeColor) {
        return DYED_AZALEA_FLOWER_FLOWER_POTS.get(dyeColor).get();
    }

    public static void register() {

    }
}
