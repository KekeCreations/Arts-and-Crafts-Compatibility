package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.kekecreations.arts_and_crafts_compatibility.common.item.CompatItem;
import com.kekecreations.arts_and_crafts_compatibility.common.item.FuelBlockItem;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ACCItems {

    //Gilded Sherds Compat
    public static final Supplier<Item> GILDED_ROLL_POTTERY_SHERD = CompatUtils.registerItem("gilded_roll_pottery_sherd", () -> new CompatItem(CompatUtils.GILDED_SHERDS, new Item.Properties()));
    public static final Supplier<Item> GILDED_RUINED_POTTERY_SHERD = CompatUtils.registerItem("gilded_ruined_pottery_sherd", () -> new CompatItem(CompatUtils.GILDED_SHERDS, new Item.Properties()));
    public static final Supplier<Item> GILDED_FINALE_POTTERY_SHERD = CompatUtils.registerItem("gilded_finale_pottery_sherd", () -> new CompatItem(CompatUtils.GILDED_SHERDS, new Item.Properties()));
    public static final Supplier<Item> GILDED_GATEWAY_POTTERY_SHERD = CompatUtils.registerItem("gilded_gateway_pottery_sherd", () -> new CompatItem(CompatUtils.GILDED_SHERDS, new Item.Properties()));

    //FARMERS DELIGHT COMPAT
    public static final Supplier<Item> CORK_CABINET_ITEM = CompatUtils.registerItem("cork_cabinet", () -> new FuelBlockItem(ACCBlocks.CORK_CABINET.get(), new Item.Properties()));

    public static void register() {
    }
}
