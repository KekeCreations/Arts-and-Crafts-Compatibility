package com.kekecreations.arts_and_crafts_compatibility.common.compat.built;

import com.kekecreations.arts_and_crafts.core.registry.ACSoundTypes;
import com.kekecreations.arts_and_crafts_compatibility.common.block.FlammableBlock;
import com.kekecreations.arts_and_crafts_compatibility.common.block.FlammableSlabBlock;
import com.kekecreations.arts_and_crafts_compatibility.common.block.FlammableStairBlock;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

public class BuiltBlocks {

    public static final Supplier<FlammableBlock> CORK_COMPACT_PLANKS = registerBlockWithItem("cork_compact_planks", () -> new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));
    public static final Supplier<FlammableBlock> CORK_SHAKES = registerBlockWithItem("cork_shakes", () -> new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));
    public static final Supplier<FlammableStairBlock> CORK_SHAKES_STAIRS = registerBlockWithItem("cork_shakes_stairs", () -> new FlammableStairBlock(CORK_SHAKES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));
    public static final Supplier<FlammableSlabBlock> CORK_SHAKES_SLAB = registerBlockWithItem("cork_shakes_slab", () -> new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));

    private static <T extends Block> Supplier<T> registerBlockWithItem(String name, java.util.function.Supplier<T> blockSupplier) {
        return Services.REGISTRY.registerBlockWithItem(name, blockSupplier);
    }

    public static void register() {

    }
}
