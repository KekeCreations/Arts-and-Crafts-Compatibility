package com.kekecreations.arts_and_crafts_compatibility.common.compat.gildedsherds;

import com.kekecreations.arts_and_crafts_compatibility.common.compat.CompatUtils;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class GildedSherdsItems {

    public static final Supplier<Item> GILDED_ROLL_POTTERY_SHERD = CompatUtils.registerItem("gilded_roll_pottery_sherd", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GILDED_RUINED_POTTERY_SHERD = CompatUtils.registerItem("gilded_ruined_pottery_sherd", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GILDED_FINALE_POTTERY_SHERD = CompatUtils.registerItem("gilded_finale_pottery_sherd", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GILDED_GATEWAY_POTTERY_SHERD = CompatUtils.registerItem("gilded_gateway_pottery_sherd", () -> new Item(new Item.Properties()));


    public static void register() {
    }
}
