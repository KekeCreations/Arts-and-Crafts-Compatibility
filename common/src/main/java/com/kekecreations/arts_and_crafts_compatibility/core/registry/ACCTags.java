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

    //DECORATIVE DOORS COMPAT
    public static final TagKey<Block> SHORT_DOORS = TagKey.create(Registries.BLOCK, new ResourceLocation(CompatUtils.DRAMATIC_DOORS, "short_doors"));
    public static final TagKey<Block> SHORT_WOODEN_DOORS = TagKey.create(Registries.BLOCK, new ResourceLocation(CompatUtils.DRAMATIC_DOORS, "short_wooden_doors"));
    public static final TagKey<Block> MOB_INTERACTABLE_SHORT_DOORS = TagKey.create(Registries.BLOCK, new ResourceLocation(CompatUtils.DRAMATIC_DOORS, "mob_interactable_short_doors"));

    public static final TagKey<Block> TALL_DOORS = TagKey.create(Registries.BLOCK, new ResourceLocation(CompatUtils.DRAMATIC_DOORS, "tall_doors"));
    public static final TagKey<Block> TALL_WOODEN_DOORS = TagKey.create(Registries.BLOCK, new ResourceLocation(CompatUtils.DRAMATIC_DOORS, "tall_wooden_doors"));
    public static final TagKey<Block> MOB_INTERACTABLE_TALL_DOORS = TagKey.create(Registries.BLOCK, new ResourceLocation(CompatUtils.DRAMATIC_DOORS, "mob_interactable_tall_doors"));


    public static final TagKey<Item> SHORT_DOORS_ITEM = TagKey.create(Registries.ITEM, new ResourceLocation(CompatUtils.DRAMATIC_DOORS, "short_doors"));
    public static final TagKey<Item> SHORT_WOODEN_DOORS_ITEM = TagKey.create(Registries.ITEM, new ResourceLocation(CompatUtils.DRAMATIC_DOORS, "short_wooden_doors"));

    public static final TagKey<Item> TALL_DOORS_ITEM = TagKey.create(Registries.ITEM, new ResourceLocation(CompatUtils.DRAMATIC_DOORS, "tall_doors"));
    public static final TagKey<Item> TALL_WOODEN_DOORS_ITEM = TagKey.create(Registries.ITEM, new ResourceLocation(CompatUtils.DRAMATIC_DOORS, "tall_wooden_doors"));

    public static void register() {
    }
}
