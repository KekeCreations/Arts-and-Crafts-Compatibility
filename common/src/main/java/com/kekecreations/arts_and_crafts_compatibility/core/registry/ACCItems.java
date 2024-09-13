package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.kekecreations.arts_and_crafts_compatibility.common.item.CompatItem;
import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ACCItems {

    //Gilded Sherds Compat
    public static final Supplier<Item> GILDED_ROLL_POTTERY_SHERD = CompatUtils.registerItem("gilded_roll_pottery_sherd", () -> new CompatItem(CompatUtils.GILDED_SHERDS, new Item.Properties()));
    public static final Supplier<Item> GILDED_RUINED_POTTERY_SHERD = CompatUtils.registerItem("gilded_ruined_pottery_sherd", () -> new CompatItem(CompatUtils.GILDED_SHERDS, new Item.Properties()));
    public static final Supplier<Item> GILDED_FINALE_POTTERY_SHERD = CompatUtils.registerItem("gilded_finale_pottery_sherd", () -> new CompatItem(CompatUtils.GILDED_SHERDS, new Item.Properties()));
    public static final Supplier<Item> GILDED_GATEWAY_POTTERY_SHERD = CompatUtils.registerItem("gilded_gateway_pottery_sherd", () -> new CompatItem(CompatUtils.GILDED_SHERDS, new Item.Properties()));


    public static void register() {
    }
}
