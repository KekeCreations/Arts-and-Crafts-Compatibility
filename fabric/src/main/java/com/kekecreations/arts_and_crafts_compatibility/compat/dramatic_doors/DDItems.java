package com.kekecreations.arts_and_crafts_compatibility.compat.dramatic_doors;

import com.fizzware.dramaticdoors.fabric.items.ShortDoorItem;
import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class DDItems {

    public static final Supplier<ShortDoorItem> CORK_SHORT_DOOR = CompatUtils.registerItem("short_cork_door",
            () -> new ShortDoorItem(DDBlocks.CORK_SHORT_DOOR.get(), new Item.Properties()));

    public static void register() {
    }
}
