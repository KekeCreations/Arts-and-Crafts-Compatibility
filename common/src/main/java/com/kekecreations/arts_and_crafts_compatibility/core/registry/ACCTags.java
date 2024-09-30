package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ACCTags {


    //GILDED SHERDS COMPAT
    public static TagKey<Item> GILDED_SHERDS = TagKey.create(Registries.ITEM, new ResourceLocation(CompatUtils.GILDED_SHERDS, "gilded_sherds"));

    //DECORATIVE BLOCKS COMPAT
    public static TagKey<Block> PALISADES = TagKey.create(Registries.BLOCK, new ResourceLocation(CompatUtils.DECORATIVE_BLOCKS, "palisades"));

    //TWIGS COMPAT
    public static TagKey<Block> TABLES_BLOCK = TagKey.create(Registries.BLOCK, new ResourceLocation(CompatUtils.TWIGS, "tables"));

    public static void register() {
    }
}
