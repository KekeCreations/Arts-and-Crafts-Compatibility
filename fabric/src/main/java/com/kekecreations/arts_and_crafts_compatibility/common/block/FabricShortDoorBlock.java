package com.kekecreations.arts_and_crafts_compatibility.common.block;

import com.fizzware.dramaticdoors.fabric.blocks.ShortDoorBlock;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class FabricShortDoorBlock extends ShortDoorBlock {
    public FabricShortDoorBlock(Block from, BlockSetType blockset) {
        super(from, blockset);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet featureFlagSet) {
        return Services.PLATFORM.isModLoaded(CompatUtils.DRAMATIC_DOORS);
    }
}
