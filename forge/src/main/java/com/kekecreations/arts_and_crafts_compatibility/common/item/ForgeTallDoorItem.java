package com.kekecreations.arts_and_crafts_compatibility.common.item;

import com.fizzware.dramaticdoors.forge.items.TallDoorItem;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;

public class ForgeTallDoorItem extends TallDoorItem {
    public ForgeTallDoorItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet featureFlagSet) {
        return Services.PLATFORM.isModLoaded(CompatUtils.DRAMATIC_DOORS);
    }
}
