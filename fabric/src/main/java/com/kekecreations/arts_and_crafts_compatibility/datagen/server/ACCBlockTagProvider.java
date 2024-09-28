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
                .add(ACCFabricBlocks.CORK_MOSAIC_VERTICAL_STAIRS.get())
                .add(ACCFabricBlocks.CORK_CRAFTING_TABLE.get())
                .add(ACCFabricBlocks.CHISELED_CORK_PLANKS.get())
                .add(ACCFabricBlocks.CORK_BOOKSHELF.get())
                .add(ACCFabricBlocks.CORK_DECORATIVE_SHELF.get())
                .add(ACCFabricBlocks.CORK_LADDER.get());
        this.getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(ACCFabricBlocks.CORK_LADDER.get());
        this.getOrCreateTagBuilder(BlockTags.ENCHANTMENT_POWER_PROVIDER)
                .add(ACCFabricBlocks.CORK_DECORATIVE_SHELF.get())
                .add(ACCFabricBlocks.CORK_BOOKSHELF.get());
        this.getOrCreateTagBuilder(BlockTags.WOOL)
                .add(ACCFabricBlocks.BLEACHED_KNITTED_WOOL.get());
        this.getOrCreateTagBuilder(BlockTags.WOOL_CARPETS)
                .add(ACCFabricBlocks.BLEACHED_KNITTED_CARPET.get());
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ACCFabricBlocks.TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get())
                .add(ACCFabricBlocks.SOAPSTONE_VERTICAL_STAIRS.get())
                .add(ACCFabricBlocks.GYPSUM_VERTICAL_STAIRS.get())
                .add(ACCFabricBlocks.POLISHED_GYPSUM_VERTICAL_STAIRS.get())
                .add(ACCFabricBlocks.GYPSUM_BRICK_VERTICAL_STAIRS.get())
                .add(ACCFabricBlocks.POLISHED_SOAPSTONE_VERTICAL_STAIRS.get())
                .add(ACCFabricBlocks.SOAPSTONE_BRICK_VERTICAL_STAIRS.get());
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(ACCFabricBlocks.getDyedTerracottaShingleVerticalStairs(colour.getId()))
                    .add(ACCFabricBlocks.getDyedSoapstoneVerticalStairs(colour.getId()))
                    .add(ACCFabricBlocks.getDyedPolishedSoapstoneVerticalStairs(colour.getId()))
                    .add(ACCFabricBlocks.getDyedSoapstoneBrickVerticalStairs(colour.getId()))
                    .add(ACCFabricBlocks.getDyedMudBrickVerticalStairs(colour.getId()));
            this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                    .add(ACCFabricBlocks.getDyedPottedAncientSapling(colour.getId()))
                    .add(ACCFabricBlocks.getDyedPottedGloomSapling(colour.getId()))
                    .add(ACCFabricBlocks.getDyedPottedRose(colour.getId()))
                    .add(ACCFabricBlocks.getDyedPottedCyanRose(colour.getId()))
                    .add(ACCFabricBlocks.getDyedPottedWhiteRose(colour.getId()));
        }
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
