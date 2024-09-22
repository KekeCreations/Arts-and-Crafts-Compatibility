package com.kekecreations.arts_and_crafts_compatibility;

import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.compat.decorative_blocks.DBBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.compat.farmersdelight.FDBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.compat.farmersdelight.FDEntityTypes;
import com.kekecreations.arts_and_crafts_compatibility.core.compat.GildedSherdsPatterns;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCItems;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCTags;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ArtsAndCraftsCompatibility {

    public static final String MOD_ID = "arts_and_crafts_compat";
    public static final String MOD_NAME = "Arts And Crafts Compatibility";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);


    public static void init() {
        ACCItems.register();
        ACCBlocks.register();
        if (Services.PLATFORM.isModLoaded(CompatUtils.GILDED_SHERDS)) {
            GildedSherdsPatterns.register();
            ACCTags.register();
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.FARMERS_DELIGHT)) {
            FDBlocks.register();
            FDEntityTypes.register();
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.DECORATIVE_BLOCKS)) {
            DBBlocks.register();
        }
    }

    public static ResourceLocation id(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}