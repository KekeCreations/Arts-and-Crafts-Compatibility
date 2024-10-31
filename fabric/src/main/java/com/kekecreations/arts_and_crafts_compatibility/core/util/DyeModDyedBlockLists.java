package com.kekecreations.arts_and_crafts_compatibility.core.util;

import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsDyedBlockLists;
import net.leafenzo.mint.block.ElsDyeModBlocks;
import net.leafenzo.mint.util.ElsDyeModDyeColor;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;

public class DyeModDyedBlockLists extends ArtsAndCraftsDyedBlockLists {

    public static HashMap<StringRepresentable, Block> DYE_MOD_TERRACOTTA = new HashMap();

    public static void add() {
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.ACORN, ElsDyeModBlocks.ACORN_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.AMBER, ElsDyeModBlocks.AMBER_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.ARTICHOKE, ElsDyeModBlocks.ARTICHOKE_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.BANANA, ElsDyeModBlocks.BANANA_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.CERULEAN, ElsDyeModBlocks.CERULEAN_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.FUCHSIA, ElsDyeModBlocks.FUCHSIA_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.GRAPE, ElsDyeModBlocks.GRAPE_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.INDIGO, ElsDyeModBlocks.INDIGO_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.MAROON, ElsDyeModBlocks.MAROON_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.MAUVE, ElsDyeModBlocks.MAUVE_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.MINT, ElsDyeModBlocks.MINT_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.MOLD, ElsDyeModBlocks.MOLD_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.NAVY, ElsDyeModBlocks.NAVY_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.PEACH, ElsDyeModBlocks.PEACH_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.PERIWINKLE, ElsDyeModBlocks.PERIWINKLE_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.SAGE, ElsDyeModBlocks.SAGE_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.SAP, ElsDyeModBlocks.SAP_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.SHAMROCK, ElsDyeModBlocks.SHAMROCK_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.VELVET, ElsDyeModBlocks.VELVET_TERRACOTTA);
        DYE_MOD_TERRACOTTA.put(ElsDyeModDyeColor.VERMILION, ElsDyeModBlocks.VERMILION_TERRACOTTA);
    }

    public static Block getDyeModTerracotta(int colours) {
        return DYE_MOD_TERRACOTTA.get(DyeColor.byId(colours));
    }
}
