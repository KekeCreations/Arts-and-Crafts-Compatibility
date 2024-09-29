package com.kekecreations.arts_and_crafts_compatibility.common.block;

import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import net.yirmiri.excessive_building.EBConfig;

public class ACCBookshelfBlock extends Block {
    public ACCBookshelfBlock(Properties settings) {
        super(settings);
    }

    public boolean isEnabled(FeatureFlagSet enable) {
        return Services.PLATFORM.isModLoaded(CompatUtils.EXCESSIVE_BUILDING) && EBConfig.ENABLE_SHELF_VARIANTS.get();
    }
}
