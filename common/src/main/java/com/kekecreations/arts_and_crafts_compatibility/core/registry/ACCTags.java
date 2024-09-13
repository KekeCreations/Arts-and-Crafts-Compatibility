package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;


public class ACCTags {


    //GILDED SHERDS COMPAT
    public static TagKey<Item> GILDED_SHERDS = TagKey.create(Registries.ITEM, new ResourceLocation(CompatUtils.GILDED_SHERDS, "gilded_sherds"));

    public static void register() {
    }
}
