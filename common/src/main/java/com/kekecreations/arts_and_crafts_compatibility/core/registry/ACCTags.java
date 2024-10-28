package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ACCTags {

    //MINT - PAINTABLE TAGS
    public static final TagKey<Block> CHALK = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/chalk"));
    public static final TagKey<Block> CHALK_DUST = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/chalk_dust"));
    public static final TagKey<Block> SOAPSTONE = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/soapstone"));
    public static final TagKey<Block> SOAPSTONE_BRICKS = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/soapstone_bricks"));
    public static final TagKey<Block> POLISHED_SOAPSTONE = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/polished_soapstone"));
    public static final TagKey<Block> SOAPSTONE_STAIRS = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/soapstone_stairs"));
    public static final TagKey<Block> SOAPSTONE_BRICK_STAIRS = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/soapstone_brick_stairs"));
    public static final TagKey<Block> POLISHED_SOAPSTONE_STAIRS = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/polished_soapstone_stairs"));
    public static final TagKey<Block> SOAPSTONE_SLAB = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/soapstone_slab"));
    public static final TagKey<Block> SOAPSTONE_BRICK_SLAB = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/soapstone_brick_slab"));
    public static final TagKey<Block> POLISHED_SOAPSTONE_SLAB = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/polished_soapstone_slab"));
    public static final TagKey<Block> SOAPSTONE_WALL = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/soapstone_wall"));
    public static final TagKey<Block> SOAPSTONE_BRICK_WALL = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/soapstone_brick_wall"));
    public static final TagKey<Block> POLISHED_SOAPSTONE_WALL = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/polished_soapstone_wall"));
    public static final TagKey<Block> MUD_BRICKS = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/mud_bricks"));
    public static final TagKey<Block> MUD_BRICK_STAIRS = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/mud_brick_stairs"));
    public static final TagKey<Block> MUD_BRICK_SLAB = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/mud_brick_slab"));
    public static final TagKey<Block> MUD_BRICK_WALL = TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, "paintable/mud_brick_wall"));


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
