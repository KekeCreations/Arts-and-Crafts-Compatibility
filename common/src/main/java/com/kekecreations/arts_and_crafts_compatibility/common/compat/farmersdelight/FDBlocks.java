package com.kekecreations.arts_and_crafts_compatibility.common.compat.farmersdelight;

import com.kekecreations.arts_and_crafts_compatibility.common.block.CabinetBlock;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class FDBlocks {

    public static final Supplier<CabinetBlock> CORK_CABINET = registerBlockWithItem("cork_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));

    private static <T extends Block> Supplier<T> registerBlockWithItem(String name, java.util.function.Supplier<T> blockSupplier) {
        return Services.REGISTRY.registerBlockWithItem(name, blockSupplier);
    }

    public static void register() {

    }
}
