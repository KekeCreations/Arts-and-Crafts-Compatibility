package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.fizzware.dramaticdoors.forge.items.ShortDoorItem;
import com.fizzware.dramaticdoors.forge.items.TallDoorItem;
import com.kekecreations.arts_and_crafts_compatibility.common.item.ForgeShortDoorItem;
import com.kekecreations.arts_and_crafts_compatibility.common.item.ForgeTallDoorItem;
import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ACCForgeItems {

    public static final Supplier<ShortDoorItem> SHORT_CORK_DOOR = CompatUtils.registerItem("short_cork_door",
            () -> new ForgeShortDoorItem(ACCForgeBlocks.SHORT_CORK_DOOR.get(), new Item.Properties()));

    public static final Supplier<TallDoorItem> TALL_CORK_DOOR = CompatUtils.registerItem("tall_cork_door",
            () -> new ForgeTallDoorItem(ACCForgeBlocks.TALL_CORK_DOOR.get(), new Item.Properties()));


    public static void register() {}
}
