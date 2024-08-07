package com.kekecreations.arts_and_crafts_compatibility.datagen;

import com.kekecreations.arts_and_crafts_compatibility.datagen.client.ACCModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ACCDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        // Server Data
        //pack.addProvider(VerdanceRecipeProvider::new);
        //pack.addProvider(VerdanceBlockTagProvider::new);
        //pack.addProvider(VerdanceItemTagProvider::new);
        //pack.addProvider(VerdanceEntityTypeTagProvider::new);
        //pack.addProvider(VerdanceBiomeTagProvider::new);
        //pack.addProvider(VerdanceBlockLootTableProvider::new);
        //pack.addProvider(VerdanceDynamicRegistryProvider::new);
        //pack.addProvider(VerdanceAdvancementProvider::new);

        // Client Data
        pack.addProvider(ACCModelProvider::new);
    }
}
