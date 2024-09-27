package com.kekecreations.arts_and_crafts_compatibility.common.item;

import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import net.yirmiri.excessive_building.EBConfig;
import net.yirmiri.excessive_building.item.configurable.EBLadderBlockItem;

public class ACCLadderBlockItem extends EBLadderBlockItem {

    public ACCLadderBlockItem(Block block, Properties settings) {
        super(block, settings);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enable) {
        return Services.PLATFORM.isModLoaded(CompatUtils.EXCESSIVE_BUILDING) && EBConfig.ENABLE_LADDER_VARIANTS.get();
    }
}
