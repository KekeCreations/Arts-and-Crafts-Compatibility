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
import net.yirmiri.excessive_building.registry.EBBlocks;

import java.util.HashMap;
import java.util.function.Supplier;

public class ACCFabricBlocks {
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLE_VERTICAL_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_SOAPSTONE_VERTICAL_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POLISHED_SOAPSTONE_VERTICAL_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_SOAPSTONE_BRICK_VERTICAL_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_MUD_BRICK_VERTICAL_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_ANCIENT_SAPLING = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_GLOOM_SAPLING = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_ROSE = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_CYAN_ROSE = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_WHITE_ROSE = new HashMap<>();

    //DRAMATIC DOORS
    public static final Supplier<Block> SHORT_CORK_DOOR = CompatUtils.registerBlock("short_cork_door",
            () -> new ShortDoorBlock(ACBlocks.CORK_DOOR.get(), KekeBlockSetType.CORK));

    public static final Supplier<Block> TALL_CORK_DOOR = CompatUtils.registerBlock("tall_cork_door",
            () -> new TallDoorBlock(ACBlocks.CORK_DOOR.get(), KekeBlockSetType.CORK));


    //EXCESSIVE BUILDING
    public static final Supplier<Block> CORK_MOSAIC = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "cork_mosaic", () -> new ACCBlock(CompatUtils.EXCESSIVE_BUILDING, FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_MOSAIC_STAIRS = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "cork_mosaic_stairs", () -> new FlammableStairBlock(CompatUtils.EXCESSIVE_BUILDING, CORK_MOSAIC.get().defaultBlockState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_MOSAIC_SLAB = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "cork_mosaic_slab", () -> new FlammableSlabBlock(CompatUtils.EXCESSIVE_BUILDING, FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_MOSAIC_VERTICAL_STAIRS = registerVStairs("cork_mosaic_vertical_stairs", () -> new ACCVerticalStairsBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(ACSoundTypes.CORK)));

    public static final Supplier<Block> BLEACHED_KNITTED_WOOL = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "bleached_knitted_wool", () -> new ACCBlock(CompatUtils.EXCESSIVE_BUILDING, FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DyeColor.WHITE)));
    public static final Supplier<Block> BLEACHED_KNITTED_CARPET = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "bleached_knitted_carpet", () -> new ACCCarpetBlock(CompatUtils.EXCESSIVE_BUILDING, FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DyeColor.WHITE)));

    public static final Supplier<Block> CORK_CRAFTING_TABLE = registerCraftingTable("cork_crafting_table", () -> new ACCCraftingTableBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(ACSoundTypes.CORK)));
    public static final Supplier<Block> CHISELED_CORK_PLANKS = registerCraftingTable("chiseled_cork_planks", () -> new ACCBlock(CompatUtils.EXCESSIVE_BUILDING, FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_BOOKSHELF = registerBookShelf("cork_bookshelf", () -> new ACCBookshelfBlock(FabricBlockSettings.copyOf(Blocks.BOOKSHELF).sounds(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_DECORATIVE_SHELF = registerDecorativeShelf("cork_decorative_shelf", () -> new ACCDecorativeShelfBlock(FabricBlockSettings.copyOf(Blocks.BOOKSHELF).sounds(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_LADDER = registerLadder("cork_ladder", () -> new ACCLadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER).sounds(ACSoundTypes.CORK)));

    public static final Supplier<Block> TERRACOTTA_SHINGLE_VERTICAL_STAIRS = registerVStairs("terracotta_shingle_vertical_stairs", () -> new ACCVerticalStairsBlock(FabricBlockSettings.copyOf(ACBlocks.TERRACOTTA_SHINGLES.get())));
    public static final Supplier<Block> SOAPSTONE_VERTICAL_STAIRS = registerVStairs("soapstone_vertical_stairs", () -> new ACCVerticalStairsBlock(FabricBlockSettings.copyOf(ACBlocks.SOAPSTONE.get())));
    public static final Supplier<Block> GYPSUM_VERTICAL_STAIRS = registerVStairs("gypsum_vertical_stairs", () -> new ACCVerticalStairsBlock(FabricBlockSettings.copyOf(ACBlocks.GYPSUM.get())));
    public static final Supplier<Block> POLISHED_GYPSUM_VERTICAL_STAIRS = registerVStairs("polished_gypsum_vertical_stairs", () -> new ACCVerticalStairsBlock(FabricBlockSettings.copyOf(ACBlocks.POLISHED_GYPSUM.get())));
    public static final Supplier<Block> GYPSUM_BRICK_VERTICAL_STAIRS = registerVStairs("gypsum_brick_vertical_stairs", () -> new ACCVerticalStairsBlock(FabricBlockSettings.copyOf(ACBlocks.GYPSUM_BRICKS.get())));
    public static final Supplier<Block> POLISHED_SOAPSTONE_VERTICAL_STAIRS = registerVStairs("polished_soapstone_vertical_stairs", () -> new ACCVerticalStairsBlock(FabricBlockSettings.copyOf(ACBlocks.POLISHED_SOAPSTONE.get())));
    public static final Supplier<Block> SOAPSTONE_BRICK_VERTICAL_STAIRS = registerVStairs("soapstone_brick_vertical_stairs", () -> new ACCVerticalStairsBlock(FabricBlockSettings.copyOf(ACBlocks.SOAPSTONE_BRICKS.get())));
    static {
        for (DyeColor colour : DyeColor.values()) {
            DYED_TERRACOTTA_SHINGLE_VERTICAL_STAIRS.put(colour, registerVStairs(colour + "_terracotta_shingle_vertical_stairs", () -> new ACCVerticalStairsBlock(FabricBlockSettings.copyOf(ACBlocks.TERRACOTTA_SHINGLES.get()))));
            DYED_SOAPSTONE_VERTICAL_STAIRS.put(colour, registerVStairs(colour + "_soapstone_vertical_stairs", () -> new ACCVerticalStairsBlock(FabricBlockSettings.copyOf(ACBlocks.getDyedSoapstone(colour.getId())))));
            DYED_POLISHED_SOAPSTONE_VERTICAL_STAIRS.put(colour, registerVStairs(colour + "_polished_soapstone_vertical_stairs", () -> new ACCVerticalStairsBlock(FabricBlockSettings.copyOf(ACBlocks.getDyedPolishedSoapstone(colour.getId())))));
            DYED_SOAPSTONE_BRICK_VERTICAL_STAIRS.put(colour, registerVStairs(colour + "_soapstone_brick_vertical_stairs", () -> new ACCVerticalStairsBlock(FabricBlockSettings.copyOf(ACBlocks.getDyedSoapstoneBricks(colour.getId())))));
            DYED_MUD_BRICK_VERTICAL_STAIRS.put(colour, registerVStairs(colour + "_mud_brick_vertical_stairs", () -> new ACCVerticalStairsBlock(FabricBlockSettings.copyOf(ACBlocks.getDyedMudBricks(colour.getId())))));

            DYED_POTTED_ANCIENT_SAPLING.put(colour, CompatUtils.registerBlock(colour + "_potted_ancient_sapling",
                    () -> CompatUtils.flowerPot(CompatUtils.EXCESSIVE_BUILDING, EBBlocks.ANCIENT_SAPLING, colour)));

            DYED_POTTED_GLOOM_SAPLING.put(colour, CompatUtils.registerBlock(colour + "_potted_gloom_sapling",
                    () -> CompatUtils.flowerPot(CompatUtils.EXCESSIVE_BUILDING, EBBlocks.GLOOM_SAPLING, colour)));

            DYED_POTTED_ROSE.put(colour, CompatUtils.registerBlock(colour + "_potted_rose",
                    () -> CompatUtils.flowerPot(CompatUtils.EXCESSIVE_BUILDING, EBBlocks.ROSE, colour)));

            DYED_POTTED_CYAN_ROSE.put(colour, CompatUtils.registerBlock(colour + "_potted_cyan_rose",
                    () -> CompatUtils.flowerPot(CompatUtils.EXCESSIVE_BUILDING, EBBlocks.CYAN_ROSE, colour)));

            DYED_POTTED_WHITE_ROSE.put(colour, CompatUtils.registerBlock(colour + "_potted_white_rose",
                    () -> CompatUtils.flowerPot(CompatUtils.EXCESSIVE_BUILDING, EBBlocks.WHITE_ROSE, colour)));
        }

    }

    public static Block getDyedPottedAncientSapling(int colours) {
        return DYED_POTTED_ANCIENT_SAPLING.get(DyeColor.byId(colours)).get();
    }

    public static Block getDyedPottedGloomSapling(int colours) {
        return DYED_POTTED_GLOOM_SAPLING.get(DyeColor.byId(colours)).get();
    }

    public static Block getDyedPottedRose(int colours) {
        return DYED_POTTED_ROSE.get(DyeColor.byId(colours)).get();
    }

    public static Block getDyedPottedCyanRose(int colours) {
        return DYED_POTTED_CYAN_ROSE.get(DyeColor.byId(colours)).get();
    }

    public static Block getDyedPottedWhiteRose(int colours) {
        return DYED_POTTED_WHITE_ROSE.get(DyeColor.byId(colours)).get();
    }

    public static Block getDyedTerracottaShingleVerticalStairs(int colours) {
        return DYED_TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get(DyeColor.byId(colours)).get();
    }

    public static Block getDyedSoapstoneVerticalStairs(int colours) {
        return DYED_SOAPSTONE_VERTICAL_STAIRS.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedPolishedSoapstoneVerticalStairs(int colours) {
        return DYED_POLISHED_SOAPSTONE_VERTICAL_STAIRS.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedSoapstoneBrickVerticalStairs(int colours) {
        return DYED_SOAPSTONE_BRICK_VERTICAL_STAIRS.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedMudBrickVerticalStairs(int colours) {
        return DYED_MUD_BRICK_VERTICAL_STAIRS.get(DyeColor.byId(colours)).get();
    }


    public static <T extends Block> Supplier<T> registerVStairs(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), new ACCVerticalStairsBlockItem(block, new Item.Properties()));
        return () -> block;
    }

    public static <T extends Block> Supplier<T> registerCraftingTable(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), new ACCCraftingTableBlockItem(block, new Item.Properties()));
        return () -> block;
    }

    public static <T extends Block> Supplier<T> registerBookShelf(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), new ACCBookshelfBlockItem(block, new Item.Properties()));
        return () -> block;
    }

    public static <T extends Block> Supplier<T> registerDecorativeShelf(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), new ACCDecorativeShelfBlockItem(block, new Item.Properties()));
        return () -> block;
    }

    public static <T extends Block> Supplier<T> registerLadder(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), new ACCLadderBlockItem(block, new Item.Properties()));
        return () -> block;
    }

    public static void register() {}
}
