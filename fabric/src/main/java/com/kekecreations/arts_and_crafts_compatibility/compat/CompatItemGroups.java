package com.kekecreations.arts_and_crafts_compatibility.compat;

import com.kekecreations.arts_and_crafts_compatibility.FabricArtsAndCraftsCompatibility;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.gildedsherds.GildedSherdsItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

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
    }



}
