package com.kekecreations.arts_and_crafts_compatibility.datagen.server;

import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;

import java.util.concurrent.CompletableFuture;

public class ACCBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ACCBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        ecologics();
        built();
    }

    private void ecologics() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                    .add(ACCBlocks.getDyedPottedAzaleaFlower(colour))
                    .add(ACCBlocks.getDyedPottedWalnutSapling(colour))
                    .add(ACCBlocks.getDyedPottedCoconutSeedling(colour));
        }
    }
    private void built() {
        this.getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ACCBlocks.CORK_SHAKES.get())
                .add(ACCBlocks.CORK_COMPACT_PLANKS.get());
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(ACCBlocks.CORK_SHAKES.get())
                .add(ACCBlocks.CORK_SHAKES_SLAB.get())
                .add(ACCBlocks.CORK_SHAKES_STAIRS.get())
                .add(ACCBlocks.CORK_COMPACT_PLANKS.get());
        this.getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ACCBlocks.CORK_SHAKES_SLAB.get());
        this.getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ACCBlocks.CORK_SHAKES_STAIRS.get());
    }
}
