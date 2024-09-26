package com.kekecreations.arts_and_crafts_compatibility.common.block;

import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import lilypuree.decorative_blocks.blocks.PalisadeBlock;
import lilypuree.decorative_blocks.blocks.types.IWoodType;
import net.minecraft.world.flag.FeatureFlagSet;

public class ACCPalisadeBlock extends PalisadeBlock {
    public ACCPalisadeBlock(Properties properties, IWoodType woodType) {
        super(properties, woodType);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet $$0) {
        return Services.PLATFORM.isModLoaded(CompatUtils.DECORATIVE_BLOCKS);
    }
}
