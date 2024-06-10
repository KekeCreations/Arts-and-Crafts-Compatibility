package com.kekecreations.arts_and_crafts_compatibility.common.compat.farmersdelight;

import com.kekecreations.arts_and_crafts_compatibility.common.blockentity.CabinetBlockEntity;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.services.IPlatformHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class FDEntityTypes {

    public static final Supplier<BlockEntityType<CabinetBlockEntity>> CABINET = registerBlockEntityType("compat_cabinet", () ->
            createBlockEntity(CabinetBlockEntity::new,
                    FDBlocks.CORK_CABINET.get()
            )
    );


    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntityType(String name, Supplier<BlockEntityType<T>> type) {
        return Services.REGISTRY.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, name, type);
    }
    private static <T extends BlockEntity> BlockEntityType<T> createBlockEntity(IPlatformHelper.BlockEntitySupplier<T> blockEntitySupplier, Block... blocks) {
        return Services.PLATFORM.createBlockEntity(blockEntitySupplier, blocks);
    }

    public static void register() {

    }
}
