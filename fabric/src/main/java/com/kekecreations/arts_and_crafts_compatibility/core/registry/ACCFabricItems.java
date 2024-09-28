package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.kekecreations.arts_and_crafts_compatibility.common.item.ACCShortDoorItem;
import com.kekecreations.arts_and_crafts_compatibility.common.item.ACCTallDoorItem;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ACCFabricItems {

    public static final Supplier<ACCShortDoorItem> CORK_SHORT_DOOR = CompatUtils.registerItem("short_cork_door",
            () -> new ACCShortDoorItem(ACCFabricBlocks.SHORT_CORK_DOOR.get(), new Item.Properties()));

    public static final Supplier<BlockItem> TALL_CORK_DOOR = CompatUtils.registerItem("tall_cork_door",
            () -> new ACCTallDoorItem(ACCFabricBlocks.TALL_CORK_DOOR.get(), new Item.Properties()));

    public static void register() {}
}
