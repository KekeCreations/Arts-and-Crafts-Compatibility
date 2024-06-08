package com.kekecreations.arts_and_crafts_compatibility.common.compat.gildedsherds;

import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class GildedSherdsItems {

    public static final Supplier<Item> GILDED_ROLL_POTTERY_SHERD = registerItem("gilded_roll_pottery_sherd", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GILDED_RUINED_POTTERY_SHERD = registerItem("gilded_ruined_pottery_sherd", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GILDED_FINALE_POTTERY_SHERD = registerItem("gilded_finale_pottery_sherd", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GILDED_GATEWAY_POTTERY_SHERD = registerItem("gilded_gateway_pottery_sherd", () -> new Item(new Item.Properties()));


    private static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        return Services.REGISTRY.register(BuiltInRegistries.ITEM, name, itemSupplier);
    }


    public static void register() {
    }
}
