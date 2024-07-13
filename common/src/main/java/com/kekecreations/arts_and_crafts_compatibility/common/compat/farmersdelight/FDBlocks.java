package com.kekecreations.arts_and_crafts_compatibility.common.compat.farmersdelight;

import com.kekecreations.arts_and_crafts.core.registry.ACSoundTypes;
import com.kekecreations.arts_and_crafts_compatibility.common.block.CabinetBlock;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.common.item.FuelBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class FDBlocks {

    public static final Supplier<Block> CORK_CABINET = CompatUtils.registerBlock("cork_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.BARREL).sound(ACSoundTypes.CORK)));

    public static final Supplier<Item> CORK_CABINET_ITEM = CompatUtils.registerItem("cork_cabinet", () -> new FuelBlockItem(CORK_CABINET.get(), new Item.Properties()));


    public static void register() {

    }
}
