package com.kekecreations.arts_and_crafts_compatibility.compat.caffeinated;

import com.kekecreations.arts_and_crafts_compatibility.common.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.function.Supplier;

public class CaffeinatedBlocks {

    public static final HashMap<DyeColor, Supplier<Block>> DYED_COFFEE_SHRUB_FLOWER_POTS = new HashMap<>();

    static {
        for (DyeColor colours : DyeColor.values()) {
            DYED_COFFEE_SHRUB_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_coffee_shrub", () -> CompatUtils.flowerPot(com.chikoritalover.caffeinated.registry.CaffeinatedBlocks.COFFEE_SHRUB, colours)));
        }
    }

    private static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        return Services.REGISTRY.registerBlock(name, blockSupplier);
    }

    public static Block getDyedPottedCoffeeShrub(DyeColor dyeColor) {
        return DYED_COFFEE_SHRUB_FLOWER_POTS.get(dyeColor).get();
    }

    public static void register() {

    }
}
