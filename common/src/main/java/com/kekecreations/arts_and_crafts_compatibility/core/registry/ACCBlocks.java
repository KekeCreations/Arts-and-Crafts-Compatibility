package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.kekecreations.arts_and_crafts.core.registry.ACSoundTypes;
import com.kekecreations.arts_and_crafts_compatibility.common.block.*;
import com.kekecreations.arts_and_crafts_compatibility.common.item.FuelBlockItem;
import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import lilypuree.decorative_blocks.blocks.PalisadeBlock;
import lilypuree.decorative_blocks.blocks.types.VanillaWoodTypes;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import samebutdifferent.ecologics.registry.ModBlocks;

import java.util.HashMap;
import java.util.function.Supplier;

public class ACCBlocks {


    //ECOLOGICS COMPAT
    public static final HashMap<DyeColor, Supplier<Block>> DYED_WALNUT_SAPLING_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_AZALEA_FLOWER_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_COCONUT_SEEDLING_FLOWER_POTS = new HashMap<>();

    static {
        for (DyeColor colours : DyeColor.values()) {
            //ECOLOGICS COMPAT
            DYED_WALNUT_SAPLING_FLOWER_POTS.put(colours, CompatUtils.registerBlock(colours + "_potted_walnut_sapling",
                    () -> CompatUtils.flowerPot(CompatUtils.ECOLOGICS, ModBlocks.WALNUT_SAPLING.get(), colours)));
            DYED_AZALEA_FLOWER_FLOWER_POTS.put(colours, CompatUtils.registerBlock(colours + "_potted_azalea_flower",
                    () -> CompatUtils.flowerPot(CompatUtils.ECOLOGICS, ModBlocks.AZALEA_FLOWER.get(), colours)));
            DYED_COCONUT_SEEDLING_FLOWER_POTS.put(colours, CompatUtils.registerBlock(colours + "_potted_coconut_seedling",
                    () -> CompatUtils.flowerPot(CompatUtils.ECOLOGICS, ModBlocks.COCONUT_SEEDLING.get(), colours)));
        }
    }

    //TWIGS COMPAT
    public static final Supplier<Block> CORK_TABLE = CompatUtils.registerBlockWithItem(CompatUtils.TWIGS, "cork_table",
            () -> new TableBlock(CompatUtils.TWIGS, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));

    //FARMERS DELIGHT COMPAT
    public static final Supplier<Block> CORK_CABINET = CompatUtils.registerBlock("cork_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.BARREL).sound(ACSoundTypes.CORK)));

    //DECORATIVE BLOCKS COMPAT
    public static final Supplier<Block> CORK_PALISADE = CompatUtils.registerBlockWithItem(CompatUtils.DECORATIVE_BLOCKS, "cork_palisade",
            () -> new ACCPalisadeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 4.0F).sound(ACSoundTypes.CORK).ignitedByLava(), VanillaWoodTypes.OAK));

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


    //ECOLOGICS COMPAT
    public static Block getDyedPottedWalnutSapling(DyeColor dyeColor) {
        return DYED_WALNUT_SAPLING_FLOWER_POTS.get(dyeColor).get();
    }

    public static Block getDyedPottedAzaleaFlower(DyeColor dyeColor) {
        return DYED_AZALEA_FLOWER_FLOWER_POTS.get(dyeColor).get();
    }
    public static Block getDyedPottedCoconutSeedling(DyeColor dyeColor) {
        return DYED_COCONUT_SEEDLING_FLOWER_POTS.get(dyeColor).get();
    }

    public static void register() {
    }
}
