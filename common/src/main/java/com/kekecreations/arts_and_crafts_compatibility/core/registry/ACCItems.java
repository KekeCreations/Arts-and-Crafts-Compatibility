package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACSoundTypes;
import com.kekecreations.arts_and_crafts_compatibility.common.block.*;
import com.kekecreations.arts_and_crafts_compatibility.common.item.*;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.HashMap;
import java.util.function.Supplier;

public class ACCItems {

    //Gilded Sherds Compat
    public static final Supplier<Item> GILDED_ROLL_POTTERY_SHERD = CompatUtils.registerItem("gilded_roll_pottery_sherd", () -> new CompatItem(CompatUtils.GILDED_SHERDS, new Item.Properties()));
    public static final Supplier<Item> GILDED_RUINED_POTTERY_SHERD = CompatUtils.registerItem("gilded_ruined_pottery_sherd", () -> new CompatItem(CompatUtils.GILDED_SHERDS, new Item.Properties()));
    public static final Supplier<Item> GILDED_FINALE_POTTERY_SHERD = CompatUtils.registerItem("gilded_finale_pottery_sherd", () -> new CompatItem(CompatUtils.GILDED_SHERDS, new Item.Properties()));
    public static final Supplier<Item> GILDED_GATEWAY_POTTERY_SHERD = CompatUtils.registerItem("gilded_gateway_pottery_sherd", () -> new CompatItem(CompatUtils.GILDED_SHERDS, new Item.Properties()));

    //FARMERS DELIGHT COMPAT
    public static final Supplier<Item> CORK_CABINET_ITEM = CompatUtils.registerItem("cork_cabinet", () -> new FuelBlockItem(ACCBlocks.CORK_CABINET.get(), new Item.Properties()));


    //DRAMATIC DOORS COMPAT
    public static final Supplier<ACCShortDoorItem> CORK_SHORT_DOOR = CompatUtils.registerItem("short_cork_door",
            () -> new ACCShortDoorItem(ACCBlocks.SHORT_CORK_DOOR.get(), new Item.Properties()));

    public static final Supplier<BlockItem> TALL_CORK_DOOR = CompatUtils.registerItem("tall_cork_door",
            () -> new ACCTallDoorItem(ACCBlocks.TALL_CORK_DOOR.get(), new Item.Properties()));

    //EXCESSIVE BUILDING COMPAT
    public static final HashMap<DyeColor, Supplier<Item>> DYED_TERRACOTTA_SHINGLE_VERTICAL_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Item>> DYED_SOAPSTONE_VERTICAL_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Item>> DYED_POLISHED_SOAPSTONE_VERTICAL_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Item>> DYED_SOAPSTONE_BRICK_VERTICAL_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Item>> DYED_MUD_BRICK_VERTICAL_STAIRS = new HashMap<>();

    public static final Supplier<Item> CORK_CRAFTING_TABLE = CompatUtils.registerItem("cork_crafting_table", () -> new ACCCraftingTableBlockItem(ACCBlocks.CORK_CRAFTING_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> CORK_BOOKSHELF = CompatUtils.registerItem("cork_bookshelf", () -> new ACCBookshelfBlockItem(ACCBlocks.CORK_BOOKSHELF.get(), new Item.Properties()));
    public static final Supplier<Item> CORK_DECORATIVE_SHELF = CompatUtils.registerItem("cork_decorative_shelf", () -> new ACCDecorativeShelfBlockItem(ACCBlocks.CORK_DECORATIVE_SHELF.get(), new Item.Properties()));
    public static final Supplier<Item> CORK_LADDER = CompatUtils.registerItem("cork_ladder", () -> new ACCLadderBlockItem(ACCBlocks.CORK_LADDER.get(), new Item.Properties()));


    public static final Supplier<Item> CORK_MOSAIC_VERTICAL_STAIRS = CompatUtils.registerItem("cork_mosaic_vertical_stairs", () -> new ACCVerticalStairsBlockItem(ACCBlocks.CORK_MOSAIC_VERTICAL_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> TERRACOTTA_SHINGLE_VERTICAL_STAIRS = CompatUtils.registerItem("terracotta_shingle_vertical_stairs", () -> new ACCVerticalStairsBlockItem(ACCBlocks.TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> SOAPSTONE_VERTICAL_STAIRS = CompatUtils.registerItem("soapstone_vertical_stairs", () -> new ACCVerticalStairsBlockItem(ACCBlocks.SOAPSTONE_VERTICAL_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> GYPSUM_VERTICAL_STAIRS = CompatUtils.registerItem("gypsum_vertical_stairs", () -> new ACCVerticalStairsBlockItem(ACCBlocks.GYPSUM_VERTICAL_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> POLISHED_GYPSUM_VERTICAL_STAIRS = CompatUtils.registerItem("polished_gypsum_vertical_stairs", () -> new ACCVerticalStairsBlockItem(ACCBlocks.POLISHED_GYPSUM_VERTICAL_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> GYPSUM_BRICK_VERTICAL_STAIRS = CompatUtils.registerItem("gypsum_brick_vertical_stairs", () -> new ACCVerticalStairsBlockItem(ACCBlocks.GYPSUM_BRICK_VERTICAL_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> POLISHED_SOAPSTONE_VERTICAL_STAIRS = CompatUtils.registerItem("polished_soapstone_vertical_stairs", () -> new ACCVerticalStairsBlockItem(ACCBlocks.POLISHED_SOAPSTONE_VERTICAL_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> SOAPSTONE_BRICK_VERTICAL_STAIRS = CompatUtils.registerItem("soapstone_brick_vertical_stairs", () -> new ACCVerticalStairsBlockItem(ACCBlocks.SOAPSTONE_BRICK_VERTICAL_STAIRS.get(), new Item.Properties()));
    static {
        for (DyeColor colour : DyeColor.values()) {
            DYED_TERRACOTTA_SHINGLE_VERTICAL_STAIRS.put(colour, CompatUtils.registerItem(colour + "_terracotta_shingle_vertical_stairs", () -> new ACCVerticalStairsBlockItem(ACCBlocks.getDyedTerracottaShingleVerticalStairs(colour.getId()), new Item.Properties())));
            DYED_SOAPSTONE_VERTICAL_STAIRS.put(colour, CompatUtils.registerItem(colour + "_soapstone_vertical_stairs", () -> new ACCVerticalStairsBlockItem(ACCBlocks.getDyedSoapstoneVerticalStairs(colour.getId()), new Item.Properties())));
            DYED_POLISHED_SOAPSTONE_VERTICAL_STAIRS.put(colour, CompatUtils.registerItem(colour + "_polished_soapstone_vertical_stairs", () -> new ACCVerticalStairsBlockItem(ACCBlocks.getDyedPolishedSoapstoneVerticalStairs(colour.getId()), new Item.Properties())));
            DYED_SOAPSTONE_BRICK_VERTICAL_STAIRS.put(colour, CompatUtils.registerItem(colour + "_soapstone_brick_vertical_stairs", () -> new ACCVerticalStairsBlockItem(ACCBlocks.getDyedSoapstoneBrickVerticalStairs(colour.getId()), new Item.Properties())));
            DYED_MUD_BRICK_VERTICAL_STAIRS.put(colour, CompatUtils.registerItem(colour + "_mud_brick_vertical_stairs", () -> new ACCVerticalStairsBlockItem(ACCBlocks.getDyedMudBrickVerticalStairs(colour.getId()), new Item.Properties())));
        }

    }


    public static void register() {
    }
}
