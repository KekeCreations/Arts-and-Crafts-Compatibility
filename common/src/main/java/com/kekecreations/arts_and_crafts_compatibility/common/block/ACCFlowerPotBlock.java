package com.kekecreations.arts_and_crafts_compatibility.common.block;

import com.kekecreations.arts_and_crafts.common.block.ACFlowerPotBlock;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

public class ACCFlowerPotBlock extends ACFlowerPotBlock {
    private final String modID;


    public ACCFlowerPotBlock(String modID, Block block, DyeColor dyeColor, Properties properties) {
        super(block, dyeColor, properties);
        this.modID = modID;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet $$0) {
        return Services.PLATFORM.isModLoaded(modID);
    }
}
