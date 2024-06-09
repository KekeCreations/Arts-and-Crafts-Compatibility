package com.kekecreations.arts_and_crafts_compatibility.compat.farmersdelight;

import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import vectorwing.farmersdelight.common.block.CabinetBlock;

import java.util.function.Supplier;

public class FDCompatBlocks {

    public static final Supplier<CabinetBlock> CORK_CABINET = registerBlockWithItem("cork_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));

    private static <T extends Block> Supplier<T> registerBlockWithItem(String name, java.util.function.Supplier<T> blockSupplier) {
        return Services.REGISTRY.registerBlockWithItem(name, blockSupplier);
    }

    private static <T extends Block> Supplier<T> registerBlock(String name, java.util.function.Supplier<T> blockSupplier) {
        return Services.REGISTRY.registerBlock(name, blockSupplier);
    }


    private static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        return Services.REGISTRY.register(BuiltInRegistries.ITEM, name, itemSupplier);
    }

    public static void register() {

    }
}
