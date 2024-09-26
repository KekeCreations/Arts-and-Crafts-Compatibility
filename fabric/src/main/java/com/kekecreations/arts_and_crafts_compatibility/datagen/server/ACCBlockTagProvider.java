package com.kekecreations.arts_and_crafts_compatibility.datagen.server;

import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCFabricBlocks;
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
        farmersDelight();
        decorativeBlocks();
        dramaticDoors();
        excessiveBuilding();
    }

    private void excessiveBuilding() {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(ACCFabricBlocks.CORK_MOSAIC.get())
                .add(ACCFabricBlocks.CORK_MOSAIC_STAIRS.get())
                .add(ACCFabricBlocks.CORK_MOSAIC_SLAB.get())
                .add(ACCFabricBlocks.CORK_MOSAIC_VERTICAL_STAIRS.get());
        this.getOrCreateTagBuilder(BlockTags.WOOL)
                .add(ACCFabricBlocks.BLEACHED_KNITTED_WOOL.get());
        this.getOrCreateTagBuilder(BlockTags.WOOL_CARPETS)
                .add(ACCFabricBlocks.BLEACHED_KNITTED_CARPET.get());
    }

    private void dramaticDoors() {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(ACCFabricBlocks.SHORT_CORK_DOOR.get())
                .add(ACCFabricBlocks.TALL_CORK_DOOR.get());
    }

    private void decorativeBlocks() {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(ACCBlocks.CORK_BEAM.get())
                .add(ACCBlocks.CORK_PALISADE.get())
                .add(ACCBlocks.CORK_SEAT.get())
                .add(ACCBlocks.CORK_SUPPORT.get());
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ACCBlocks.CORK_PALISADE.get());
        this.getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ACCBlocks.CORK_BEAM.get());
        this.getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ACCBlocks.CORK_PALISADE.get());
    }

    private void farmersDelight() {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .setReplace(false)
                .add(ACCBlocks.CORK_CABINET.get());
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
