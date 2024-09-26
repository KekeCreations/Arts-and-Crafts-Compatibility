package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.fizzware.dramaticdoors.fabric.blocks.ShortDoorBlock;
import com.fizzware.dramaticdoors.fabric.blocks.TallDoorBlock;
import com.kekecreations.arts_and_crafts.common.misc.KekeBlockSetType;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACSoundTypes;
import com.kekecreations.arts_and_crafts_compatibility.ArtsAndCraftsCompatibility;
import com.kekecreations.arts_and_crafts_compatibility.common.block.*;
import com.kekecreations.arts_and_crafts_compatibility.common.item.CompatBlockItem;
import com.kekecreations.arts_and_crafts_compatibility.common.item.FabricVerticalStairsBlockItem;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.yirmiri.excessive_building.util.EBProperties;

import java.util.function.Supplier;

public class ACCFabricBlocks {

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

    public static <T extends Block> Supplier<T> registerVStairs(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, id), new FabricVerticalStairsBlockItem(block, new Item.Properties()));
        return () -> block;
    }

    public static void register() {}
}
