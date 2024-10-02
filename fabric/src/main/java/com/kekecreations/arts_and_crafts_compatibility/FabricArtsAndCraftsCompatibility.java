package com.kekecreations.arts_and_crafts_compatibility;

import com.kekecreations.arts_and_crafts.common.util.CreativeCategoryUtils;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCItems;
import com.kekecreations.arts_and_crafts_compatibility.registry.compat.ExcessiveBuildingFlowerPots;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;

public class FabricArtsAndCraftsCompatibility implements ModInitializer {
    
    @Override
    public void onInitialize() {
        FabricArtsAndCraftsCompatResourcePacks.loadBuiltinResourcePacks();
        ArtsAndCraftsCompatibility.init();
        addItemsToTabs();
        flammableAndStrippableBlocks();
        if (isModLoaded(CompatUtils.EXCESSIVE_BUILDING)) {
            ExcessiveBuildingFlowerPots.register();
        }
    }

    public static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    public static void flammableAndStrippableBlocks() {
        if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.BUILT)) {
            FlammableBlockRegistry.getDefaultInstance().add(ACCBlocks.CORK_COMPACT_PLANKS.get(), 5, 20);
            FlammableBlockRegistry.getDefaultInstance().add(ACCBlocks.CORK_SHAKES.get(), 5, 20);
            FlammableBlockRegistry.getDefaultInstance().add(ACCBlocks.CORK_SHAKES_STAIRS.get(), 5, 20);
            FlammableBlockRegistry.getDefaultInstance().add(ACCBlocks.CORK_SHAKES_SLAB.get(), 5, 20);
        }
    }

    public static void addItemsToTabs() {
        if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.GILDED_SHERDS)) {
            ItemGroupEvents.modifyEntriesEvent(ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CompatUtils.GILDED_SHERDS, "tab"))).register(event -> {
                event.accept(ACCItems.GILDED_FINALE_POTTERY_SHERD.get());
                event.accept(ACCItems.GILDED_GATEWAY_POTTERY_SHERD.get());
                event.accept(ACCItems.GILDED_ROLL_POTTERY_SHERD.get());
                event.accept(ACCItems.GILDED_RUINED_POTTERY_SHERD.get());
            });
        }
        if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.BUILT)) {
            ItemGroupEvents.modifyEntriesEvent(ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CompatUtils.BUILT, "built"))).register(event -> {
                event.addAfter(BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.BUILT, "acacia_shakes_slab")), ACCBlocks.CORK_COMPACT_PLANKS.get());
                event.addAfter(ACCBlocks.CORK_COMPACT_PLANKS.get(), ACCBlocks.CORK_SHAKES.get());
                event.addAfter(ACCBlocks.CORK_SHAKES.get(), ACCBlocks.CORK_SHAKES_STAIRS.get());
                event.addAfter(ACCBlocks.CORK_SHAKES_STAIRS.get(), ACCBlocks.CORK_SHAKES_SLAB.get());
            });
        }
        if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.TWIGS)) {
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(event -> {
                event.addAfter(BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.ARTS_AND_CRAFTS, "cork_slab")), ACCBlocks.CORK_TABLE.get());
            });
        }
        if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.FARMERS_DELIGHT)) {
            ItemGroupEvents.modifyEntriesEvent(ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CompatUtils.FARMERS_DELIGHT, "farmersdelight"))).register(event -> {
                event.addAfter(BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.FARMERS_DELIGHT, "acacia_cabinet")), ACCBlocks.CORK_CABINET.get());
            });
        }
        if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.DECORATIVE_BLOCKS)) {
            ItemGroupEvents.modifyEntriesEvent(ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CompatUtils.DECORATIVE_BLOCKS, "general"))).register(event -> {
                event.addAfter(BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.DECORATIVE_BLOCKS, "acacia_seat")), ACCBlocks.CORK_SEAT.get());
                event.addAfter(BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.DECORATIVE_BLOCKS, "acacia_support")), ACCBlocks.CORK_SUPPORT.get());
                event.addAfter(BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.DECORATIVE_BLOCKS, "acacia_palisade")), ACCBlocks.CORK_PALISADE.get());
                event.addAfter(BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.DECORATIVE_BLOCKS, "acacia_beam")), ACCBlocks.CORK_BEAM.get());
            });
        }
        if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.DRAMATIC_DOORS)) {
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(event -> {
                event.addBefore(ACBlocks.CORK_DOOR.get(), ACCBlocks.SHORT_CORK_DOOR.get());
                event.addAfter(ACBlocks.CORK_DOOR.get(), ACCBlocks.TALL_CORK_DOOR.get());
            });
        }
        if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.EXCESSIVE_BUILDING)) {
            ItemGroupEvents.modifyEntriesEvent(ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CompatUtils.EXCESSIVE_BUILDING, "excessive_building"))).register(event -> {
                event.addAfter(BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.EXCESSIVE_BUILDING, "acacia_ladder")), ACCBlocks.CORK_MOSAIC.get());
                event.addAfter(ACCBlocks.CORK_MOSAIC.get(), ACCBlocks.CORK_MOSAIC_STAIRS.get());
                event.addAfter(ACCBlocks.CORK_MOSAIC_STAIRS.get(), ACCBlocks.CORK_MOSAIC_VERTICAL_STAIRS.get());
                event.addAfter(ACCBlocks.CORK_MOSAIC_VERTICAL_STAIRS.get(), ACCBlocks.CORK_MOSAIC_SLAB.get());
                event.addAfter(ACCBlocks.CORK_MOSAIC_SLAB.get(), ACCBlocks.CHISELED_CORK_PLANKS.get());
                event.addAfter(ACCBlocks.CHISELED_CORK_PLANKS.get(), ACCBlocks.CORK_BOOKSHELF.get());
                event.addAfter(ACCBlocks.CORK_BOOKSHELF.get(), ACCBlocks.CORK_DECORATIVE_SHELF.get());
                event.addAfter(ACCBlocks.CORK_DECORATIVE_SHELF.get(), ACCBlocks.CORK_CRAFTING_TABLE.get());
                event.addAfter(ACCBlocks.CORK_CRAFTING_TABLE.get(), ACCBlocks.CORK_LADDER.get());
                event.addAfter(BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.EXCESSIVE_BUILDING, "waxed_oxidized_cut_copper_vertical_stairs")), ACCBlocks.GYPSUM_VERTICAL_STAIRS.get());
                event.addAfter(ACCBlocks.GYPSUM_VERTICAL_STAIRS.get(), ACCBlocks.POLISHED_GYPSUM_VERTICAL_STAIRS.get());
                event.addAfter(ACCBlocks.POLISHED_GYPSUM_VERTICAL_STAIRS.get(), ACCBlocks.GYPSUM_BRICK_VERTICAL_STAIRS.get());
                event.addAfter(ACCBlocks.GYPSUM_BRICK_VERTICAL_STAIRS.get(), ACCBlocks.TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get());
                for (DyeColor colour : CreativeCategoryUtils.colourOrder) {
                    event.addAfter(ACCBlocks.TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get(), ACCBlocks.getDyedTerracottaShingleVerticalStairs(colour.getId()));
                }
                event.addAfter(ACCBlocks.getDyedTerracottaShingleVerticalStairs(DyeColor.PINK.getId()), ACCBlocks.SOAPSTONE_VERTICAL_STAIRS.get());
                for (DyeColor colour : CreativeCategoryUtils.colourOrder) {
                    event.addAfter(ACCBlocks.SOAPSTONE_VERTICAL_STAIRS.get(), ACCBlocks.getDyedSoapstoneVerticalStairs(colour.getId()));
                }
                event.addAfter(ACCBlocks.getDyedSoapstoneVerticalStairs(DyeColor.PINK.getId()), ACCBlocks.POLISHED_SOAPSTONE_VERTICAL_STAIRS.get());
                for (DyeColor colour : CreativeCategoryUtils.colourOrder) {
                    event.addAfter(ACCBlocks.POLISHED_SOAPSTONE_VERTICAL_STAIRS.get(), ACCBlocks.getDyedPolishedSoapstoneVerticalStairs(colour.getId()));
                }
                event.addAfter(ACCBlocks.getDyedPolishedSoapstoneVerticalStairs(DyeColor.PINK.getId()), ACCBlocks.SOAPSTONE_BRICK_VERTICAL_STAIRS.get());
                for (DyeColor colour : CreativeCategoryUtils.colourOrder) {
                    event.addAfter(ACCBlocks.SOAPSTONE_BRICK_VERTICAL_STAIRS.get(), ACCBlocks.getDyedSoapstoneBrickVerticalStairs(colour.getId()));
                    event.addAfter(BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.EXCESSIVE_BUILDING, "mud_brick_vertical_stairs")), ACCBlocks.getDyedMudBrickVerticalStairs(colour.getId()));
                }
            });
        }
    }
}
