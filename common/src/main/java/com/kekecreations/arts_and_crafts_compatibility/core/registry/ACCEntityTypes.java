package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.kekecreations.arts_and_crafts_compatibility.ArtsAndCraftsCompatibility;
import com.kekecreations.arts_and_crafts_compatibility.common.blockentity.CabinetBlockEntity;
import com.kekecreations.arts_and_crafts_compatibility.common.entity.EntityForSitting;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ACCEntityTypes {

    public static final Supplier<BlockEntityType<CabinetBlockEntity>> CABINET = CompatUtils.registerBlockEntityType("compat_cabinet", () ->
            CompatUtils.createBlockEntity(CabinetBlockEntity::new,
                    ACCBlocks.CORK_CABINET.get()
            )
    );

    public static final Supplier<EntityType<EntityForSitting>> ENTITY_FOR_SITTING = CompatUtils.registerEntityType("entity_for_sitting", () ->
            EntityType.Builder.of(EntityForSitting::new, MobCategory.MISC)
                    .clientTrackingRange(256)
                    .updateInterval(20)
                    .sized(0.0001F, 0.0001F)
                    .build(dataFixer("entity_for_sitting")));

    public static void register() {

    }

    private static String dataFixer(String mobName) {
        return ArtsAndCraftsCompatibility.MOD_ID + ":" + mobName;
    }
}
