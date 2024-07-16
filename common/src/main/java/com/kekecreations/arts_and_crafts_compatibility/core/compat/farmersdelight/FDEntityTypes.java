package com.kekecreations.arts_and_crafts_compatibility.core.compat.farmersdelight;

import com.kekecreations.arts_and_crafts_compatibility.common.blockentity.CabinetBlockEntity;
import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class FDEntityTypes {

    public static final Supplier<BlockEntityType<CabinetBlockEntity>> CABINET = CompatUtils.registerBlockEntityType("compat_cabinet", () ->
            CompatUtils.createBlockEntity(CabinetBlockEntity::new,
                    FDBlocks.CORK_CABINET.get()
            )
    );

    public static void register() {

    }
}
