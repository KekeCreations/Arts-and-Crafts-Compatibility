package com.kekecreations.arts_and_crafts_compatibility.datagen.server;

import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCItems;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ACCItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ACCItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        gildedSherds();
    }

    private void gildedSherds() {
        this.getOrCreateTagBuilder(ItemTags.DECORATED_POT_SHERDS)
                .add(ACCItems.GILDED_FINALE_POTTERY_SHERD.get())
                .add(ACCItems.GILDED_ROLL_POTTERY_SHERD.get())
                .add(ACCItems.GILDED_GATEWAY_POTTERY_SHERD.get())
                .add(ACCItems.GILDED_RUINED_POTTERY_SHERD.get());

        this.getOrCreateTagBuilder(ACCTags.GILDED_SHERDS)
                .add(ACCItems.GILDED_FINALE_POTTERY_SHERD.get())
                .add(ACCItems.GILDED_ROLL_POTTERY_SHERD.get())
                .add(ACCItems.GILDED_GATEWAY_POTTERY_SHERD.get())
                .add(ACCItems.GILDED_RUINED_POTTERY_SHERD.get());
    }
}
