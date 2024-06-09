package com.kekecreations.arts_and_crafts_compatibility.common.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class FuelBlockItem extends BlockItem {

    private int burnTime = 0;

    public FuelBlockItem(Block $$0, Properties $$1, int burnTime) {
        super($$0, $$1);
        this.burnTime = burnTime;
    }

    public int getBurnTimeInt() {
        return this.burnTime;
    }
}
