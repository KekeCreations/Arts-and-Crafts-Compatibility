package com.kekecreations.arts_and_crafts_compatibility.core.registry.compat;

import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.yirmiri.excessive_building.registry.EBBlocks;

import java.util.HashMap;
import java.util.function.Supplier;

public class ExcessiveBuildingFlowerPots {
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_ANCIENT_SAPLING = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_GLOOM_SAPLING = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_ROSE = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_CYAN_ROSE = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_WHITE_ROSE = new HashMap<>();


    static {
        for (DyeColor colour : DyeColor.values()) {
            DYED_POTTED_ANCIENT_SAPLING.put(colour, CompatUtils.registerBlock(colour + "_potted_ancient_sapling",
                    () -> CompatUtils.flowerPot(CompatUtils.EXCESSIVE_BUILDING, EBBlocks.ANCIENT_SAPLING, colour)));

            DYED_POTTED_GLOOM_SAPLING.put(colour, CompatUtils.registerBlock(colour + "_potted_gloom_sapling",
                    () -> CompatUtils.flowerPot(CompatUtils.EXCESSIVE_BUILDING, EBBlocks.GLOOM_SAPLING, colour)));

            DYED_POTTED_ROSE.put(colour, CompatUtils.registerBlock(colour + "_potted_rose",
                    () -> CompatUtils.flowerPot(CompatUtils.EXCESSIVE_BUILDING, EBBlocks.ROSE, colour)));

            DYED_POTTED_CYAN_ROSE.put(colour, CompatUtils.registerBlock(colour + "_potted_cyan_rose",
                    () -> CompatUtils.flowerPot(CompatUtils.EXCESSIVE_BUILDING, EBBlocks.CYAN_ROSE, colour)));

            DYED_POTTED_WHITE_ROSE.put(colour, CompatUtils.registerBlock(colour + "_potted_white_rose",
                    () -> CompatUtils.flowerPot(CompatUtils.EXCESSIVE_BUILDING, EBBlocks.WHITE_ROSE, colour)));
        }
    }
    public static Block getDyedPottedAncientSapling(int colours) {
        return DYED_POTTED_ANCIENT_SAPLING.get(DyeColor.byId(colours)).get();
    }

    public static Block getDyedPottedGloomSapling(int colours) {
        return DYED_POTTED_GLOOM_SAPLING.get(DyeColor.byId(colours)).get();
    }

    public static Block getDyedPottedRose(int colours) {
        return DYED_POTTED_ROSE.get(DyeColor.byId(colours)).get();
    }

    public static Block getDyedPottedCyanRose(int colours) {
        return DYED_POTTED_CYAN_ROSE.get(DyeColor.byId(colours)).get();
    }

    public static Block getDyedPottedWhiteRose(int colours) {
        return DYED_POTTED_WHITE_ROSE.get(DyeColor.byId(colours)).get();
    }

    public static void register() {
    }
}
