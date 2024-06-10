package com.kekecreations.arts_and_crafts_compatibility.common.compat.built;

import com.kekecreations.arts_and_crafts_compatibility.common.block.FlammableBlock;
import com.kekecreations.arts_and_crafts_compatibility.common.block.FlammableSlabBlock;
import com.kekecreations.arts_and_crafts_compatibility.common.block.FlammableStairBlock;
import com.kekecreations.arts_and_crafts_compatibility.common.item.FuelBlockItem;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

public class BuiltBlocks {

    public static final Supplier<FlammableBlock> CORK_COMPACT_PLANKS_BLOCK = registerBlock("cork_compact_planks", () -> new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(SoundType.WOOD).ignitedByLava()));
    public static final Supplier<FuelBlockItem> CORK_COMPACT_PLANKS = registerItem("cork_compact_planks", () -> new FuelBlockItem(CORK_COMPACT_PLANKS_BLOCK.get(), new Item.Properties(), 300));
    public static final Supplier<FlammableBlock> CORK_SHAKES_BLOCK = registerBlock("cork_shakes", () -> new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(SoundType.WOOD).ignitedByLava()));
    public static final Supplier<FlammableStairBlock> CORK_SHAKES_STAIRS_BLOCK = registerBlock("cork_shakes_stairs", () -> new FlammableStairBlock(CORK_SHAKES_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(SoundType.WOOD).ignitedByLava()));
    public static final Supplier<FlammableSlabBlock> CORK_SHAKES_SLAB_BLOCK = registerBlock("cork_shakes_slab", () -> new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(SoundType.WOOD).ignitedByLava()));
    public static final Supplier<FuelBlockItem> CORK_SHAKES = registerItem("cork_shakes", () -> new FuelBlockItem(CORK_SHAKES_BLOCK.get(), new Item.Properties(), 300));
    public static final Supplier<FuelBlockItem> CORK_SHAKES_SLAB = registerItem("cork_shakes_slab", () -> new FuelBlockItem(CORK_SHAKES_SLAB_BLOCK.get(), new Item.Properties(), 300));
    public static final Supplier<FuelBlockItem> CORK_SHAKES_STAIRS = registerItem("cork_shakes_stairs", () -> new FuelBlockItem(CORK_SHAKES_STAIRS_BLOCK.get(), new Item.Properties(), 300));

    private static <T extends Block> Supplier<T> registerBlock(String name, java.util.function.Supplier<T> blockSupplier) {
        return Services.REGISTRY.registerBlock(name, blockSupplier);
    }


    private static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        return Services.REGISTRY.register(BuiltInRegistries.ITEM, name, itemSupplier);
    }

    public static void register() {

    }
}
