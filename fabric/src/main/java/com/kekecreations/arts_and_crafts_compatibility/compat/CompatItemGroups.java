package com.kekecreations.arts_and_crafts_compatibility.compat;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts_compatibility.FabricArtsAndCraftsCompatibility;
import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCFabricBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;

public class CompatItemGroups {

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
    }
}
