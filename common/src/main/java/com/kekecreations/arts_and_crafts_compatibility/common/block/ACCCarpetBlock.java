package com.kekecreations.arts_and_crafts_compatibility.common.block;

import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.CarpetBlock;

public class ACCCarpetBlock extends CarpetBlock {
    private final String modID;

    public ACCCarpetBlock(String modID, Properties $$0) {
        super($$0);
        this.modID = modID;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet $$0) {
        return Services.PLATFORM.isModLoaded(modID);
    }
}
