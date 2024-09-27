package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.fizzware.dramaticdoors.fabric.blocks.ShortDoorBlock;
import com.fizzware.dramaticdoors.fabric.blocks.TallDoorBlock;
import com.kekecreations.arts_and_crafts.common.misc.KekeBlockSetType;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACSoundTypes;
import com.kekecreations.arts_and_crafts_compatibility.ArtsAndCraftsCompatibility;
import com.kekecreations.arts_and_crafts_compatibility.common.block.*;
import com.kekecreations.arts_and_crafts_compatibility.common.item.*;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.HashMap;
import java.util.function.Supplier;

public class ACCFabricBlocks {
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLE_VERTICAL_STAIRS = new HashMap<>();

    //DRAMATIC DOORS
    public static final Supplier<Block> SHORT_CORK_DOOR = CompatUtils.registerBlock("short_cork_door",
            () -> new ShortDoorBlock(ACBlocks.CORK_DOOR.get(), KekeBlockSetType.CORK));

    public static final Supplier<Block> TALL_CORK_DOOR = CompatUtils.registerBlock("tall_cork_door",
            () -> new TallDoorBlock(ACBlocks.CORK_DOOR.get(), KekeBlockSetType.CORK));


    //EXCESSIVE BUILDING
    public static final Supplier<Block> CORK_MOSAIC = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "cork_mosaic", () -> new ACCBlock(CompatUtils.EXCESSIVE_BUILDING, FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_MOSAIC_STAIRS = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "cork_mosaic_stairs", () -> new FlammableStairBlock(CompatUtils.EXCESSIVE_BUILDING, CORK_MOSAIC.get().defaultBlockState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_MOSAIC_SLAB = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "cork_mosaic_slab", () -> new FlammableSlabBlock(CompatUtils.EXCESSIVE_BUILDING, FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_MOSAIC_VERTICAL_STAIRS = registerVStairs("cork_mosaic_vertical_stairs", () -> new FabricVerticalStairsBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(ACSoundTypes.CORK)));

    public static final Supplier<Block> BLEACHED_KNITTED_WOOL = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "bleached_knitted_wool", () -> new ACCBlock(CompatUtils.EXCESSIVE_BUILDING, FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DyeColor.WHITE)));
    public static final Supplier<Block> BLEACHED_KNITTED_CARPET = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "bleached_knitted_carpet", () -> new ACCCarpetBlock(CompatUtils.EXCESSIVE_BUILDING, FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DyeColor.WHITE)));

    public static final Supplier<Block> CORK_CRAFTING_TABLE = registerCraftingTable("cork_crafting_table", () -> new FabricCraftingTableBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(ACSoundTypes.CORK)));
    public static final Supplier<Block> CHISELED_CORK_PLANKS = registerCraftingTable("chiseled_cork_planks", () -> new ACCBlock(CompatUtils.EXCESSIVE_BUILDING, FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_BOOKSHELF = registerBookShelf("cork_bookshelf", () -> new FabricBookshelfBlock(FabricBlockSettings.copyOf(Blocks.BOOKSHELF).sounds(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_DECORATIVE_SHELF = registerDecorativeShelf("cork_decorative_shelf", () -> new FabricDecorativeShelfBlock(FabricBlockSettings.copyOf(Blocks.BOOKSHELF).sounds(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_LADDER = registerLadder("cork_ladder", () -> new ACCLadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(ACSoundTypes.CORK)));

    public static final Supplier<Block> TERRACOTTA_SHINGLE_VERTICAL_STAIRS = registerVStairs("terracotta_shingle_vertical_stairs", () -> new FabricVerticalStairsBlock(FabricBlockSettings.copyOf(ACBlocks.TERRACOTTA_SHINGLES.get())));
    static {
        for (DyeColor colour : DyeColor.values()) {
            DYED_TERRACOTTA_SHINGLE_VERTICAL_STAIRS.put(colour, registerVStairs(colour + "_terracotta_shingle_vertical_stairs", () -> new FabricVerticalStairsBlock(FabricBlockSettings.copyOf(ACBlocks.TERRACOTTA_SHINGLES.get()))));
        }
    }

    public static Block getDyedTerracottaShingleVerticalStairs(int colours) {
        return DYED_TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get(DyeColor.byId(colours)).get();
    }


    public static <T extends Block> Supplier<T> registerVStairs(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), new FabricVerticalStairsBlockItem(block, new Item.Properties()));
        return () -> block;
    }

    public static <T extends Block> Supplier<T> registerCraftingTable(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), new FabricCraftingTableBlockItem(block, new Item.Properties()));
        return () -> block;
    }

    public static <T extends Block> Supplier<T> registerBookShelf(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), new FabricBookshelfBlockItem(block, new Item.Properties()));
        return () -> block;
    }

    public static <T extends Block> Supplier<T> registerDecorativeShelf(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), new FabricDecorativeShelfBlockItem(block, new Item.Properties()));
        return () -> block;
    }

    public static <T extends Block> Supplier<T> registerLadder(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), new ACCLadderBlockItem(block, new Item.Properties()));
        return () -> block;
    }

    public static void register() {}
}
