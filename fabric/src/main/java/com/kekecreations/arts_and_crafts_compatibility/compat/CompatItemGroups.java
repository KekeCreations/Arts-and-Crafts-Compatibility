package com.kekecreations.arts_and_crafts_compatibility.compat;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts_compatibility.FabricArtsAndCraftsCompatibility;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.built.BuiltBlocks;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.gildedsherds.GildedSherdsItems;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.twigs.TwigsBlocks;
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
                event.accept(GildedSherdsItems.GILDED_FINALE_POTTERY_SHERD.get());
                event.accept(GildedSherdsItems.GILDED_GATEWAY_POTTERY_SHERD.get());
                event.accept(GildedSherdsItems.GILDED_ROLL_POTTERY_SHERD.get());
                event.accept(GildedSherdsItems.GILDED_RUINED_POTTERY_SHERD.get());
            });
        }
        if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.BUILT)) {
            ItemGroupEvents.modifyEntriesEvent(ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CompatUtils.BUILT, "built"))).register(event -> {
                event.addAfter(BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.BUILT, "acacia_shakes_slab")), BuiltBlocks.CORK_COMPACT_PLANKS.get());
                event.addAfter(BuiltBlocks.CORK_COMPACT_PLANKS.get(), BuiltBlocks.CORK_SHAKES.get());
                event.addAfter(BuiltBlocks.CORK_SHAKES.get(), BuiltBlocks.CORK_SHAKES_STAIRS.get());
                event.addAfter(BuiltBlocks.CORK_SHAKES_STAIRS.get(), BuiltBlocks.CORK_SHAKES_SLAB.get());
            });
        }
        if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.TWIGS)) {
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(event -> {
                event.addAfter(BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.ARTS_AND_CRAFTS, "cork_slab")), TwigsBlocks.CORK_TABLE.get());
            });

        }
    }



}
