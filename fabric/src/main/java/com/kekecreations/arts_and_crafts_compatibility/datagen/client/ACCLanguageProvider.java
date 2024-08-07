package com.kekecreations.arts_and_crafts_compatibility.datagen.client;

import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ACCLanguageProvider extends FabricLanguageProvider {
    public ACCLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder builder) {
        //BUILT
        builder.add(ACCBlocks.CORK_SHAKES.get(), "Cork Shakes");
        builder.add(ACCBlocks.CORK_SHAKES_SLAB.get(), "Cork Shakes Slab");
        builder.add(ACCBlocks.CORK_SHAKES_STAIRS.get(), "Cork Shakes Stairs");
        builder.add(ACCBlocks.CORK_COMPACT_PLANKS.get(), "Cork Compact Planks");

    }
}
