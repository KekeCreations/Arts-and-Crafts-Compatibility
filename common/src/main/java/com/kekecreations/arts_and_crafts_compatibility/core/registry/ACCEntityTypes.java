package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.kekecreations.arts_and_crafts_compatibility.common.blockentity.CabinetBlockEntity;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ACCEntityTypes {

    public static final Supplier<BlockEntityType<CabinetBlockEntity>> CABINET = CompatUtils.registerBlockEntityType("compat_cabinet", () ->
            CompatUtils.createBlockEntity(CabinetBlockEntity::new,
                    ACCBlocks.CORK_CABINET.get()
            )
    );

    public static void register() {

    }
}
