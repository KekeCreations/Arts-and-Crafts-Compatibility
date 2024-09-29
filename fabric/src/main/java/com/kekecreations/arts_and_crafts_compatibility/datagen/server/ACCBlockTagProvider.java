package com.kekecreations.arts_and_crafts_compatibility.datagen.server;

import com.kekecreations.arts_and_crafts_compatibility.core.registry.*;
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
                .add(ExcessiveBuildingCompatRegistry.CORK_MOSAIC.get())
                .add(ExcessiveBuildingCompatRegistry.CORK_MOSAIC_STAIRS.get())
                .add(ExcessiveBuildingCompatRegistry.CORK_MOSAIC_SLAB.get())
                .add(ExcessiveBuildingCompatRegistry.CORK_MOSAIC_VERTICAL_STAIRS.get())
                .add(ExcessiveBuildingCompatRegistry.CORK_CRAFTING_TABLE.get())
                .add(ExcessiveBuildingCompatRegistry.CHISELED_CORK_PLANKS.get())
                .add(ExcessiveBuildingCompatRegistry.CORK_BOOKSHELF.get())
                .add(ExcessiveBuildingCompatRegistry.CORK_DECORATIVE_SHELF.get())
                .add(ExcessiveBuildingCompatRegistry.CORK_LADDER.get());
        this.getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(ExcessiveBuildingCompatRegistry.CORK_LADDER.get());
        this.getOrCreateTagBuilder(BlockTags.ENCHANTMENT_POWER_PROVIDER)
                .add(ExcessiveBuildingCompatRegistry.CORK_DECORATIVE_SHELF.get())
                .add(ExcessiveBuildingCompatRegistry.CORK_BOOKSHELF.get());
        this.getOrCreateTagBuilder(BlockTags.WOOL)
                .add(ExcessiveBuildingCompatRegistry.BLEACHED_KNITTED_WOOL.get());
        this.getOrCreateTagBuilder(BlockTags.WOOL_CARPETS)
                .add(ExcessiveBuildingCompatRegistry.BLEACHED_KNITTED_CARPET.get());
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ExcessiveBuildingCompatRegistry.TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get())
                .add(ExcessiveBuildingCompatRegistry.SOAPSTONE_VERTICAL_STAIRS.get())
                .add(ExcessiveBuildingCompatRegistry.GYPSUM_VERTICAL_STAIRS.get())
                .add(ExcessiveBuildingCompatRegistry.POLISHED_GYPSUM_VERTICAL_STAIRS.get())
                .add(ExcessiveBuildingCompatRegistry.GYPSUM_BRICK_VERTICAL_STAIRS.get())
                .add(ExcessiveBuildingCompatRegistry.POLISHED_SOAPSTONE_VERTICAL_STAIRS.get())
                .add(ExcessiveBuildingCompatRegistry.SOAPSTONE_BRICK_VERTICAL_STAIRS.get());
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(ExcessiveBuildingCompatRegistry.getDyedTerracottaShingleVerticalStairs(colour.getId()))
                    .add(ExcessiveBuildingCompatRegistry.getDyedSoapstoneVerticalStairs(colour.getId()))
                    .add(ExcessiveBuildingCompatRegistry.getDyedPolishedSoapstoneVerticalStairs(colour.getId()))
                    .add(ExcessiveBuildingCompatRegistry.getDyedSoapstoneBrickVerticalStairs(colour.getId()))
                    .add(ExcessiveBuildingCompatRegistry.getDyedMudBrickVerticalStairs(colour.getId()));
            this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                    .add(ExcessiveBuildingCompatRegistry.getDyedPottedAncientSapling(colour.getId()))
                    .add(ExcessiveBuildingCompatRegistry.getDyedPottedGloomSapling(colour.getId()))
                    .add(ExcessiveBuildingCompatRegistry.getDyedPottedRose(colour.getId()))
                    .add(ExcessiveBuildingCompatRegistry.getDyedPottedCyanRose(colour.getId()))
                    .add(ExcessiveBuildingCompatRegistry.getDyedPottedWhiteRose(colour.getId()));
        }
    }

    private void dramaticDoors() {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(DramaticDoorsCompatRegistry.SHORT_CORK_DOOR.get())
                .add(DramaticDoorsCompatRegistry.TALL_CORK_DOOR.get());
    }

    private void decorativeBlocks() {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(ACCBlocks.CORK_BEAM.get())
                .add(DecorativeBlocksRegistry.CORK_PALISADE.get())
                .add(ACCBlocks.CORK_SEAT.get())
                .add(ACCBlocks.CORK_SUPPORT.get());
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(DecorativeBlocksRegistry.CORK_PALISADE.get());
        this.getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ACCBlocks.CORK_BEAM.get());
        this.getOrCreateTagBuilder(BlockTags.WALLS)
                .add(DecorativeBlocksRegistry.CORK_PALISADE.get());
    }

    private void farmersDelight() {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .setReplace(false)
                .add(ACCBlocks.CORK_CABINET.get());
    }

    private void ecologics() {
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                    .add(EcologicsRegistry.getDyedPottedAzaleaFlower(colour))
                    .add(EcologicsRegistry.getDyedPottedWalnutSapling(colour))
                    .add(EcologicsRegistry.getDyedPottedCoconutSeedling(colour));
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
