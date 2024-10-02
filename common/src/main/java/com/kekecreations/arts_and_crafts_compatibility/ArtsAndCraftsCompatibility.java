package com.kekecreations.arts_and_crafts_compatibility;

import com.kekecreations.arts_and_crafts_compatibility.core.registry.compat.EcologicsFlowerPots;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.util.GildedSherdsPatterns;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCEntityTypes;
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
        ACCEntityTypes.register();
        ACCTags.register();
        if (Services.PLATFORM.isModLoaded(CompatUtils.GILDED_SHERDS)) {
            GildedSherdsPatterns.register();
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.ECOLOGICS)) {
            EcologicsFlowerPots.register();
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.EXCESSIVE_BUILDING)) {
            //ExcessiveBuildingFlowerPots.register();
        }
    }

    public static ResourceLocation id(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}