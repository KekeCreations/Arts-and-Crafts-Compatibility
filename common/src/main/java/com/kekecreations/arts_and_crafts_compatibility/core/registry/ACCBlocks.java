package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.kekecreations.arts_and_crafts.common.misc.KekeBlockSetType;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACSoundTypes;
import com.kekecreations.arts_and_crafts_compatibility.common.block.*;
import com.kekecreations.arts_and_crafts_compatibility.common.item.*;
import com.kekecreations.arts_and_crafts_compatibility.core.util.ACCDecorativeBlocksWoodTypes;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.HashMap;
import java.util.function.Supplier;

public class ACCBlocks {


    //DRAMATIC DOORS
    public static final Supplier<Block> SHORT_CORK_DOOR = CompatUtils.registerBlock("short_cork_door",
            () -> new ACCShortDoorBlock(ACBlocks.CORK_DOOR.get(), KekeBlockSetType.CORK));

    public static final Supplier<Block> TALL_CORK_DOOR = CompatUtils.registerBlock("tall_cork_door",
            () -> new ACCTallDoorBlock(ACBlocks.CORK_DOOR.get(), KekeBlockSetType.CORK));

    //TWIGS COMPAT
    public static final Supplier<Block> CORK_TABLE = CompatUtils.registerBlockWithItem(CompatUtils.TWIGS, "cork_table",
            () -> new TableBlock(CompatUtils.TWIGS, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));

    //FARMERS DELIGHT COMPAT
    public static final Supplier<Block> CORK_CABINET = CompatUtils.registerBlock("cork_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.BARREL).sound(ACSoundTypes.CORK)));

    //DECORATIVE BLOCKS COMPAT
    public static final Supplier<Block> CORK_PALISADE = CompatUtils.registerBlockWithItem(CompatUtils.DECORATIVE_BLOCKS, "cork_palisade",
            () -> new ACCPalisadeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 4.0F).sound(ACSoundTypes.CORK).ignitedByLava(), ACCDecorativeBlocksWoodTypes.CORK));

    public static final Supplier<Block> CORK_SEAT = CompatUtils.registerBlockWithItem(CompatUtils.DECORATIVE_BLOCKS, "cork_seat",
            () -> new SeatBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(1.2F).sound(ACSoundTypes.CORK).ignitedByLava()));

    public static final Supplier<Block> CORK_BEAM = CompatUtils.registerBlockWithItem(CompatUtils.DECORATIVE_BLOCKS, "cork_beam",
            () -> new ACCRotatedPillarBlock(CompatUtils.DECORATIVE_BLOCKS, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(1.2F).sound(ACSoundTypes.CORK).ignitedByLava()));

    public static final Supplier<Block> CORK_SUPPORT = CompatUtils.registerBlockWithItem(CompatUtils.DECORATIVE_BLOCKS, "cork_support",
            () -> new SupportBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(1.2F).sound(ACSoundTypes.CORK).ignitedByLava()));



    //BUILT COMPAT
    public static final Supplier<FlammableBlock> CORK_COMPACT_PLANKS = CompatUtils.registerBlockWithItem(CompatUtils.BUILT, "cork_compact_planks",
            () -> new FlammableBlock(CompatUtils.BUILT,
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));

    public static final Supplier<FlammableBlock> CORK_SHAKES = CompatUtils.registerBlockWithItem(CompatUtils.BUILT,"cork_shakes",
            () -> new FlammableBlock(CompatUtils.BUILT,
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));

    public static final Supplier<FlammableStairBlock> CORK_SHAKES_STAIRS = CompatUtils.registerBlockWithItem(CompatUtils.BUILT,"cork_shakes_stairs",
            () -> new FlammableStairBlock(CompatUtils.BUILT, CORK_SHAKES.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));

    public static final Supplier<FlammableSlabBlock> CORK_SHAKES_SLAB = CompatUtils.registerBlockWithItem(CompatUtils.BUILT,"cork_shakes_slab",
            () -> new FlammableSlabBlock(CompatUtils.BUILT,
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));


    //EXCESSIVE BUILDING COMPAT
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLE_VERTICAL_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_SOAPSTONE_VERTICAL_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POLISHED_SOAPSTONE_VERTICAL_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_SOAPSTONE_BRICK_VERTICAL_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_MUD_BRICK_VERTICAL_STAIRS = new HashMap<>();


    //EXCESSIVE BUILDING
    public static final Supplier<Block> CORK_MOSAIC = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "cork_mosaic", () -> new ACCBlock(CompatUtils.EXCESSIVE_BUILDING, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_MOSAIC_STAIRS = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "cork_mosaic_stairs", () -> new FlammableStairBlock(CompatUtils.EXCESSIVE_BUILDING, CORK_MOSAIC.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_MOSAIC_SLAB = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "cork_mosaic_slab", () -> new FlammableSlabBlock(CompatUtils.EXCESSIVE_BUILDING, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_MOSAIC_VERTICAL_STAIRS = CompatUtils.registerBlock("cork_mosaic_vertical_stairs", () -> new ACCVerticalStairsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(ACSoundTypes.CORK)));

    public static final Supplier<Block> BLEACHED_KNITTED_WOOL = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "bleached_knitted_wool", () -> new ACCBlock(CompatUtils.EXCESSIVE_BUILDING, BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DyeColor.WHITE)));
    public static final Supplier<Block> BLEACHED_KNITTED_CARPET = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "bleached_knitted_carpet", () -> new ACCCarpetBlock(CompatUtils.EXCESSIVE_BUILDING, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DyeColor.WHITE)));

    public static final Supplier<Block> CORK_CRAFTING_TABLE = CompatUtils.registerBlock("cork_crafting_table", () -> new ACCCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(ACSoundTypes.CORK)));
    public static final Supplier<Block> CHISELED_CORK_PLANKS = CompatUtils.registerBlockWithItem(CompatUtils.EXCESSIVE_BUILDING, "chiseled_cork_planks", () -> new ACCBlock(CompatUtils.EXCESSIVE_BUILDING, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_BOOKSHELF = CompatUtils.registerBlock("cork_bookshelf", () -> new ACCBookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF).sound(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_DECORATIVE_SHELF = CompatUtils.registerBlock("cork_decorative_shelf", () -> new ACCDecorativeShelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF).sound(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_LADDER = CompatUtils.registerBlock("cork_ladder", () -> new ACCLadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(ACSoundTypes.CORK)));

    public static final Supplier<Block> TERRACOTTA_SHINGLE_VERTICAL_STAIRS = CompatUtils.registerBlock("terracotta_shingle_vertical_stairs", () -> new ACCVerticalStairsBlock(BlockBehaviour.Properties.copy(ACBlocks.TERRACOTTA_SHINGLES.get())));
    public static final Supplier<Block> SOAPSTONE_VERTICAL_STAIRS = CompatUtils.registerBlock("soapstone_vertical_stairs", () -> new ACCVerticalStairsBlock(BlockBehaviour.Properties.copy(ACBlocks.SOAPSTONE.get())));
    public static final Supplier<Block> GYPSUM_VERTICAL_STAIRS = CompatUtils.registerBlock("gypsum_vertical_stairs", () -> new ACCVerticalStairsBlock(BlockBehaviour.Properties.copy(ACBlocks.GYPSUM.get())));
    public static final Supplier<Block> POLISHED_GYPSUM_VERTICAL_STAIRS = CompatUtils.registerBlock("polished_gypsum_vertical_stairs", () -> new ACCVerticalStairsBlock(BlockBehaviour.Properties.copy(ACBlocks.POLISHED_GYPSUM.get())));
    public static final Supplier<Block> GYPSUM_BRICK_VERTICAL_STAIRS = CompatUtils.registerBlock("gypsum_brick_vertical_stairs", () -> new ACCVerticalStairsBlock(BlockBehaviour.Properties.copy(ACBlocks.GYPSUM_BRICKS.get())));
    public static final Supplier<Block> POLISHED_SOAPSTONE_VERTICAL_STAIRS = CompatUtils.registerBlock("polished_soapstone_vertical_stairs", () -> new ACCVerticalStairsBlock(BlockBehaviour.Properties.copy(ACBlocks.POLISHED_SOAPSTONE.get())));
    public static final Supplier<Block> SOAPSTONE_BRICK_VERTICAL_STAIRS = CompatUtils.registerBlock("soapstone_brick_vertical_stairs", () -> new ACCVerticalStairsBlock(BlockBehaviour.Properties.copy(ACBlocks.SOAPSTONE_BRICKS.get())));
    static {
        for (DyeColor colour : DyeColor.values()) {
            DYED_TERRACOTTA_SHINGLE_VERTICAL_STAIRS.put(colour, CompatUtils.registerBlock(colour + "_terracotta_shingle_vertical_stairs", () -> new ACCVerticalStairsBlock(BlockBehaviour.Properties.copy(ACBlocks.TERRACOTTA_SHINGLES.get()))));
            DYED_SOAPSTONE_VERTICAL_STAIRS.put(colour, CompatUtils.registerBlock(colour + "_soapstone_vertical_stairs", () -> new ACCVerticalStairsBlock(BlockBehaviour.Properties.copy(ACBlocks.getDyedSoapstone(colour.getId())))));
            DYED_POLISHED_SOAPSTONE_VERTICAL_STAIRS.put(colour, CompatUtils.registerBlock(colour + "_polished_soapstone_vertical_stairs", () -> new ACCVerticalStairsBlock(BlockBehaviour.Properties.copy(ACBlocks.getDyedPolishedSoapstone(colour.getId())))));
            DYED_SOAPSTONE_BRICK_VERTICAL_STAIRS.put(colour, CompatUtils.registerBlock(colour + "_soapstone_brick_vertical_stairs", () -> new ACCVerticalStairsBlock(BlockBehaviour.Properties.copy(ACBlocks.getDyedSoapstoneBricks(colour.getId())))));
            DYED_MUD_BRICK_VERTICAL_STAIRS.put(colour, CompatUtils.registerBlock(colour + "_mud_brick_vertical_stairs", () -> new ACCVerticalStairsBlock(BlockBehaviour.Properties.copy(ACBlocks.getDyedMudBricks(colour.getId())))));
        }

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

    public static void register() {
    }
}
