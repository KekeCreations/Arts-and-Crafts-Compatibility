package com.kekecreations.arts_and_crafts_compatibility;

import com.kekecreations.arts_and_crafts.common.util.CreativeCategoryUtils;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCItems;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCFabricBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCFabricItems;
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
        ACCFabricBlocks.register();
        ACCFabricItems.register();
        addItemsToTabs();
        flammableAndStrippableBlocks();
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
                event.addBefore(ACBlocks.CORK_DOOR.get(), ACCFabricBlocks.SHORT_CORK_DOOR.get());
                event.addAfter(ACBlocks.CORK_DOOR.get(), ACCFabricBlocks.TALL_CORK_DOOR.get());
            });
        }
        if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.EXCESSIVE_BUILDING)) {
            ItemGroupEvents.modifyEntriesEvent(ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CompatUtils.EXCESSIVE_BUILDING, "excessive_building"))).register(event -> {
                event.addAfter(BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.EXCESSIVE_BUILDING, "acacia_ladder")), ACCFabricBlocks.CORK_MOSAIC.get());
                event.addAfter(ACCFabricBlocks.CORK_MOSAIC.get(), ACCFabricBlocks.CORK_MOSAIC_STAIRS.get());
                event.addAfter(ACCFabricBlocks.CORK_MOSAIC_STAIRS.get(), ACCFabricBlocks.CORK_MOSAIC_VERTICAL_STAIRS.get());
                event.addAfter(ACCFabricBlocks.CORK_MOSAIC_VERTICAL_STAIRS.get(), ACCFabricBlocks.CORK_MOSAIC_SLAB.get());
                event.addAfter(ACCFabricBlocks.CORK_MOSAIC_SLAB.get(), ACCFabricBlocks.CHISELED_CORK_PLANKS.get());
                event.addAfter(ACCFabricBlocks.CHISELED_CORK_PLANKS.get(), ACCFabricBlocks.CORK_BOOKSHELF.get());
                event.addAfter(ACCFabricBlocks.CORK_BOOKSHELF.get(), ACCFabricBlocks.CORK_DECORATIVE_SHELF.get());
                event.addAfter(ACCFabricBlocks.CORK_DECORATIVE_SHELF.get(), ACCFabricBlocks.CORK_CRAFTING_TABLE.get());
                event.addAfter(ACCFabricBlocks.CORK_CRAFTING_TABLE.get(), ACCFabricBlocks.CORK_LADDER.get());
                event.addAfter(BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.EXCESSIVE_BUILDING, "waxed_oxidized_cut_copper_vertical_stairs")), ACCFabricBlocks.TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get());
                for (DyeColor colour : CreativeCategoryUtils.colourOrder) {
                    event.addAfter(ACCFabricBlocks.TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get(), ACCFabricBlocks.getDyedTerracottaShingleVerticalStairs(colour.getId()));
                }
                event.addAfter(ACCFabricBlocks.getDyedTerracottaShingleVerticalStairs(DyeColor.PINK.getId()), ACCFabricBlocks.SOAPSTONE_VERTICAL_STAIRS.get());
                for (DyeColor colour : CreativeCategoryUtils.colourOrder) {
                    event.addAfter(ACCFabricBlocks.SOAPSTONE_VERTICAL_STAIRS.get(), ACCFabricBlocks.getDyedSoapstoneVerticalStairs(colour.getId()));
                }
            });

        }
    }
}
