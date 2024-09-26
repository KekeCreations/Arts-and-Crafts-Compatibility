package com.kekecreations.arts_and_crafts_compatibility.common.item;

import com.fizzware.dramaticdoors.forge.items.ShortDoorItem;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;

public class ForgeShortDoorItem extends ShortDoorItem {
    public ForgeShortDoorItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet featureFlagSet) {
        return Services.PLATFORM.isModLoaded(CompatUtils.DRAMATIC_DOORS);
    }
}
