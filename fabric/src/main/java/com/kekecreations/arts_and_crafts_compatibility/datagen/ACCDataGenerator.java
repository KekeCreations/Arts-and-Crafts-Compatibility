package com.kekecreations.arts_and_crafts_compatibility.datagen;

import com.kekecreations.arts_and_crafts_compatibility.datagen.client.ACCLanguageProvider;
import com.kekecreations.arts_and_crafts_compatibility.datagen.client.ACCModelProvider;
import com.kekecreations.arts_and_crafts_compatibility.datagen.server.ACCBlockLootTableProvider;
import com.kekecreations.arts_and_crafts_compatibility.datagen.server.ACCBlockTagProvider;
import com.kekecreations.arts_and_crafts_compatibility.datagen.server.ACCItemTagProvider;
import com.kekecreations.arts_and_crafts_compatibility.datagen.server.ACCRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ACCDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        // Server Data
        pack.addProvider(ACCBlockTagProvider::new);
        pack.addProvider(ACCLanguageProvider::new);
        pack.addProvider(ACCItemTagProvider::new);
        pack.addProvider(ACCRecipeProvider::new);
        pack.addProvider(ACCBlockLootTableProvider::new);

        // Client Data
        pack.addProvider(ACCModelProvider::new);
    }
}
