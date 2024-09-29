package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.kekecreations.arts_and_crafts.core.registry.ACSoundTypes;
import com.kekecreations.arts_and_crafts_compatibility.common.block.*;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import java.util.function.Supplier;

public class ACCBlocks {

    //TWIGS COMPAT
    public static final Supplier<Block> CORK_TABLE = CompatUtils.registerBlockWithItem(CompatUtils.TWIGS, "cork_table",
            () -> new TableBlock(CompatUtils.TWIGS, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));

    //FARMERS DELIGHT COMPAT
    public static final Supplier<Block> CORK_CABINET = CompatUtils.registerBlock("cork_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.BARREL).sound(ACSoundTypes.CORK)));

    //DECORATIVE BLOCKS COMPAT
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

    public static void register() {
    }
}
