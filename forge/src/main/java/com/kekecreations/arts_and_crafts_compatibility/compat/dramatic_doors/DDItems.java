package com.kekecreations.arts_and_crafts_compatibility.compat.dramatic_doors;

import com.fizzware.dramaticdoors.forge.items.TallDoorItem;
import com.fizzware.dramaticdoors.forge.items.ShortDoorItem;
import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class DDItems {

    public static final Supplier<ShortDoorItem> CORK_SHORT_DOOR = CompatUtils.registerItem("short_cork_door",
            () -> new ShortDoorItem(DDBlocks.SHORT_CORK_DOOR.get(), new Item.Properties()));

    public static final Supplier<TallDoorItem> TALL_CORK_DOOR = CompatUtils.registerItem("tall_cork_door",
            () -> new TallDoorItem(DDBlocks.TALL_CORK_DOOR.get(), new Item.Properties()));

    public static void register() {
    }
}
