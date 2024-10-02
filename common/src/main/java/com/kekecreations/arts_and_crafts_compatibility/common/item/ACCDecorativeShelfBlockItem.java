package com.kekecreations.arts_and_crafts_compatibility.common.item;

import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.util.ExcessiveBuildingUtils;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class ACCDecorativeShelfBlockItem extends BlockItem {

    public ACCDecorativeShelfBlockItem(Block block, Properties settings) {
        super(block, settings);
    }

    public boolean isEnabled(FeatureFlagSet enable) {
        if (Services.PLATFORM.isModLoaded(CompatUtils.EXCESSIVE_BUILDING)) {
            return ExcessiveBuildingUtils.decorativeShelves();
        }
        return false;
    }
}
