package com.kekecreations.arts_and_crafts_compatibility.core.compat.twigs;

import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;


public class TwigsTags {

    public static TagKey<Block> TABLES_BLOCK = TagKey.create(Registries.BLOCK, new ResourceLocation(CompatUtils.TWIGS, "tables"));
}
