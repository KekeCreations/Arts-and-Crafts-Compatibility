package com.kekecreations.arts_and_crafts_compatibility.common.block;

import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.minecraft.world.flag.FeatureFlagSet;
import net.yirmiri.excessive_building.EBConfig;
import net.yirmiri.excessive_building.block.EBCraftingTableBlock;

public class FabricCraftingTableBlock extends EBCraftingTableBlock {
    public FabricCraftingTableBlock(Properties settings) {
        super(settings);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet featureFlagSet) {
        return Services.PLATFORM.isModLoaded(CompatUtils.EXCESSIVE_BUILDING) && EBConfig.ENABLE_CRAFTING_TABLE_VARIANTS.get();
    }
}
