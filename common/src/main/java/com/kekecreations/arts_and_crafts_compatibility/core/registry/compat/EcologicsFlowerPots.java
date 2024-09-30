package com.kekecreations.arts_and_crafts_compatibility.core.registry.compat;

import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import samebutdifferent.ecologics.registry.ModBlocks;

import java.util.HashMap;
import java.util.function.Supplier;

public class EcologicsFlowerPots {

    //ECOLOGICS COMPAT
    public static final HashMap<DyeColor, Supplier<Block>> DYED_WALNUT_SAPLING_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_AZALEA_FLOWER_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_COCONUT_SEEDLING_FLOWER_POTS = new HashMap<>();

    static {
        for (DyeColor colours : DyeColor.values()) {
            //ECOLOGICS COMPAT
            DYED_WALNUT_SAPLING_FLOWER_POTS.put(colours, CompatUtils.registerBlock(colours + "_potted_walnut_sapling",
                    () -> CompatUtils.flowerPot(CompatUtils.ECOLOGICS, ModBlocks.WALNUT_SAPLING.get(), colours)));
            DYED_AZALEA_FLOWER_FLOWER_POTS.put(colours, CompatUtils.registerBlock(colours + "_potted_azalea_flower",
                    () -> CompatUtils.flowerPot(CompatUtils.ECOLOGICS, ModBlocks.AZALEA_FLOWER.get(), colours)));
            DYED_COCONUT_SEEDLING_FLOWER_POTS.put(colours, CompatUtils.registerBlock(colours + "_potted_coconut_seedling",
                    () -> CompatUtils.flowerPot(CompatUtils.ECOLOGICS, ModBlocks.COCONUT_SEEDLING.get(), colours)));
        }
    }

    public static Block getDyedPottedWalnutSapling(DyeColor dyeColor) {
        return DYED_WALNUT_SAPLING_FLOWER_POTS.get(dyeColor).get();
    }
    public static Block getDyedPottedAzaleaFlower(DyeColor dyeColor) {
        return DYED_AZALEA_FLOWER_FLOWER_POTS.get(dyeColor).get();
    }
    public static Block getDyedPottedCoconutSeedling(DyeColor dyeColor) {
        return DYED_COCONUT_SEEDLING_FLOWER_POTS.get(dyeColor).get();
    }

    public static void register() {}
}
