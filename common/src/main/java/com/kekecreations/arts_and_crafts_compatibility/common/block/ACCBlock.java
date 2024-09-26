package com.kekecreations.arts_and_crafts_compatibility.common.block;

import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;

public class ACCBlock extends Block {
    private final String modID;

    public ACCBlock(String modID, Properties $$0) {
        super($$0);
        this.modID = modID;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet $$0) {
        return Services.PLATFORM.isModLoaded(modID);
    }
}
