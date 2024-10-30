package com.kekecreations.arts_and_crafts_compatibility.core.registry.compat;

import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.leafenzo.mint.block.ModBlocks;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.function.Supplier;

public class MintFlowerPots {

    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_WILD_MINT = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_WINTERGREEN_SAPLING = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_PEACH_SAPLING = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_HYPERICUM = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_HIDCOTE_LAVENDER = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_THISTLE_FLOWER = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_WAXCAP_MUSHROOM = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_CORDYLINE = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_PLUM_CORDYLINE = new HashMap<>();

    public static void register() {}

    static {
        for (DyeColor colour : DyeColor.values()) {
            DYED_POTTED_WILD_MINT.put(colour, CompatUtils.registerBlock(colour + "_potted_wild_mint",
                    () -> CompatUtils.flowerPot(CompatUtils.MINT, ModBlocks.WILD_MINT, colour)));

            DYED_POTTED_WINTERGREEN_SAPLING.put(colour, CompatUtils.registerBlock(colour + "_potted_wintergreen_sapling",
                    () -> CompatUtils.flowerPot(CompatUtils.MINT, ModBlocks.WINTERGREEN_WOODSET.getSapling(), colour)));

            DYED_POTTED_PEACH_SAPLING.put(colour, CompatUtils.registerBlock(colour + "_potted_peach_sapling",
                    () -> CompatUtils.flowerPot(CompatUtils.MINT, ModBlocks.PEACH_SAPLING, colour)));

            DYED_POTTED_HYPERICUM.put(colour, CompatUtils.registerBlock(colour + "_potted_hypericum",
                    () -> CompatUtils.flowerPot(CompatUtils.MINT, ModBlocks.HYPERICUM, colour)));

            DYED_POTTED_HIDCOTE_LAVENDER.put(colour, CompatUtils.registerBlock(colour + "_potted_hidcote_lavender",
                    () -> CompatUtils.flowerPot(CompatUtils.MINT, ModBlocks.HIDCOTE_LAVENDER, colour)));

            DYED_POTTED_THISTLE_FLOWER.put(colour, CompatUtils.registerBlock(colour + "_potted_thistle_flower",
                    () -> CompatUtils.flowerPot(CompatUtils.MINT, ModBlocks.THISTLE_FLOWER, colour)));

            DYED_POTTED_WAXCAP_MUSHROOM.put(colour, CompatUtils.registerBlock(colour + "_potted_waxcap_mushroom",
                    () -> CompatUtils.flowerPot(CompatUtils.MINT, ModBlocks.WAXCAP_MUSHROOM, colour)));

            DYED_POTTED_CORDYLINE.put(colour, CompatUtils.registerBlock(colour + "_potted_cordyline",
                    () -> CompatUtils.flowerPot(CompatUtils.MINT, ModBlocks.CORDYLINE, colour)));

            DYED_POTTED_PLUM_CORDYLINE.put(colour, CompatUtils.registerBlock(colour + "_potted_plum_cordyline",
                    () -> CompatUtils.flowerPot(CompatUtils.MINT, ModBlocks.PLUM_CORDYLINE, colour)));
        }
    }
    public static Block getDyedPottedWildMint(int colours) {
        return DYED_POTTED_WILD_MINT.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedPottedWintergreenSapling(int colours) {
        return DYED_POTTED_WINTERGREEN_SAPLING.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedPottedPeachSapling(int colours) {
        return DYED_POTTED_PEACH_SAPLING.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedPottedHypericum(int colours) {
        return DYED_POTTED_HYPERICUM.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedPottedHidcoteLavender(int colours) {
        return DYED_POTTED_HIDCOTE_LAVENDER.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedPottedThistleFlower(int colours) {
        return DYED_POTTED_THISTLE_FLOWER.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedPottedWaxcapMushroom(int colours) {
        return DYED_POTTED_WAXCAP_MUSHROOM.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedPottedCordyline(int colours) {
        return DYED_POTTED_CORDYLINE.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedPottedPlumCordyline(int colours) {
        return DYED_POTTED_PLUM_CORDYLINE.get(DyeColor.byId(colours)).get();
    }
}
