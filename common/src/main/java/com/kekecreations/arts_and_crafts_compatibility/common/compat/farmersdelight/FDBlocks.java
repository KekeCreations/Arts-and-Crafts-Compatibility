package com.kekecreations.arts_and_crafts_compatibility.common.compat.farmersdelight;

import com.kekecreations.arts_and_crafts.core.registry.ACSoundTypes;
import com.kekecreations.arts_and_crafts_compatibility.common.block.CabinetBlock;
import com.kekecreations.arts_and_crafts_compatibility.common.item.FuelBlockItem;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class FDBlocks {

    public static final Supplier<Block> CORK_CABINET = registerBlock("cork_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.BARREL).sound(ACSoundTypes.CORK)));

    public static final Supplier<Item> CORK_CABINET_ITEM = registerItem("cork_cabinet", () -> new FuelBlockItem(CORK_CABINET.get(), new Item.Properties()));

    private static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        return Services.REGISTRY.registerBlock(name, blockSupplier);
    }

    private static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        return Services.REGISTRY.register(BuiltInRegistries.ITEM, name, itemSupplier);
    }

    public static void register() {

    }
}
