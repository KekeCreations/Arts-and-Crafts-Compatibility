package com.kekecreations.arts_and_crafts_compatibility.common.item;

import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class ConfigurableCompatBlockItem extends BlockItem {
    private final String modID;
    private final boolean configValue;


    public ConfigurableCompatBlockItem(String modID, boolean configValue, Block $$0, Properties $$1) {
        super($$0, $$1);
        this.modID = modID;
        this.configValue = configValue;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet $$0) {
        return Services.PLATFORM.isModLoaded(modID) && configValue;
    }
}