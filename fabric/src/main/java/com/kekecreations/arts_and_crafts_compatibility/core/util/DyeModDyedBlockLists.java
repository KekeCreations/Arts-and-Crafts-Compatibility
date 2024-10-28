package com.kekecreations.arts_and_crafts_compatibility.core.util;

import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsDyedBlockLists;
import net.leafenzo.mint.block.ModBlocks;
import net.leafenzo.mint.util.ModDyeColor;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;

public class DyeModDyedBlockLists extends ArtsAndCraftsDyedBlockLists {

    public static HashMap<StringRepresentable, Block> DYE_MOD_TERRACOTTA = new HashMap();

    public static void add() {
        DYE_MOD_TERRACOTTA.put(ModDyeColor.ACORN, ModBlocks.ACORN_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.AMBER, ModBlocks.AMBER_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.ARTICHOKE, ModBlocks.ARTICHOKE_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.BANANA, ModBlocks.BANANA_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.CERULEAN, ModBlocks.CERULEAN_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.FUCHSIA, ModBlocks.FUCHSIA_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.GRAPE, ModBlocks.GRAPE_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.INDIGO, ModBlocks.INDIGO_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.MAROON, ModBlocks.MAROON_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.MAUVE, ModBlocks.MAUVE_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.MINT, ModBlocks.MINT_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.MOLD, ModBlocks.MOLD_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.NAVY, ModBlocks.NAVY_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.PEACH, ModBlocks.PEACH_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.PERIWINKLE, ModBlocks.PERIWINKLE_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.SAGE, ModBlocks.SAGE_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.SAP, ModBlocks.SAP_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.SHAMROCK, ModBlocks.SHAMROCK_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.VELVET, ModBlocks.VELVET_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ModDyeColor.VERMILION, ModBlocks.VERMILION_TERRACOTTA);
    }

    public static Block getDyeModTerracotta(int colours) {
        return DYE_MOD_TERRACOTTA.get(DyeColor.byId(colours));
    }
}
