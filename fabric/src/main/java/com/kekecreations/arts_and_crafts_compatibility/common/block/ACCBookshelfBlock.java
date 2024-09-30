package com.kekecreations.arts_and_crafts_compatibility.common.block;

import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.util.ExcessiveBuildingUtils;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;

public class ACCBookshelfBlock extends Block {
    public ACCBookshelfBlock(Properties settings) {
        super(settings);
    }

    public boolean isEnabled(FeatureFlagSet enable) {
        if (Services.PLATFORM.isModLoaded(CompatUtils.EXCESSIVE_BUILDING)) {
            return ExcessiveBuildingUtils.shelfVariants();
        }
        return false;
    }
}
