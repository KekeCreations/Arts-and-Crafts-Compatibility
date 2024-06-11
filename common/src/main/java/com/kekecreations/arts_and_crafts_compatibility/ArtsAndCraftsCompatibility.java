package com.kekecreations.arts_and_crafts_compatibility;

import com.kekecreations.arts_and_crafts_compatibility.common.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.built.BuiltBlocks;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.decorative_blocks.DBBlocks;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.farmersdelight.FDBlocks;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.farmersdelight.FDEntityTypes;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.gildedsherds.GildedSherdsItems;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.gildedsherds.GildedSherdsPatterns;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.twigs.TwigsBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ArtsAndCraftsCompatibility {

    public static final String MOD_ID = "arts_and_crafts_compat";
    public static final String MOD_NAME = "Arts And Crafts Compatibility";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);


    public static void init() {
        if (Services.PLATFORM.isModLoaded(CompatUtils.GILDED_SHERDS)) {
            GildedSherdsItems.register();
            GildedSherdsPatterns.register();
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.BUILT)) {
            BuiltBlocks.register();
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.TWIGS)) {
            TwigsBlocks.register();
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