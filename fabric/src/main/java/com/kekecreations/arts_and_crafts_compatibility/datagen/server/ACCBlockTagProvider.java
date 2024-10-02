package com.kekecreations.arts_and_crafts_compatibility.datagen.server;

import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;

import java.util.concurrent.CompletableFuture;

import static com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks.*;


public class ACCBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ACCBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        built();
        farmersDelight();
        decorativeBlocks();
        dramaticDoors();
        excessiveBuilding();
    }

    private void excessiveBuilding() {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(CORK_MOSAIC.get())
                .add(CORK_MOSAIC_STAIRS.get())
                .add(CORK_MOSAIC_SLAB.get())
                .add(CORK_MOSAIC_VERTICAL_STAIRS.get())
                .add(CORK_CRAFTING_TABLE.get())
                .add(CHISELED_CORK_PLANKS.get())
                .add(CORK_BOOKSHELF.get())
                .add(CORK_DECORATIVE_SHELF.get())
                .add(CORK_LADDER.get());
        this.getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(CORK_LADDER.get());
        this.getOrCreateTagBuilder(BlockTags.ENCHANTMENT_POWER_PROVIDER)
                .add(CORK_DECORATIVE_SHELF.get())
                .add(CORK_BOOKSHELF.get());
        this.getOrCreateTagBuilder(BlockTags.WOOL)
                .add(BLEACHED_KNITTED_WOOL.get());
        this.getOrCreateTagBuilder(BlockTags.WOOL_CARPETS)
                .add(BLEACHED_KNITTED_CARPET.get());
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get())
                .add(SOAPSTONE_VERTICAL_STAIRS.get())
                .add(GYPSUM_VERTICAL_STAIRS.get())
                .add(POLISHED_GYPSUM_VERTICAL_STAIRS.get())
                .add(GYPSUM_BRICK_VERTICAL_STAIRS.get())
                .add(POLISHED_SOAPSTONE_VERTICAL_STAIRS.get())
                .add(SOAPSTONE_BRICK_VERTICAL_STAIRS.get());
        for (DyeColor colour : DyeColor.values()) {
            this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(getDyedTerracottaShingleVerticalStairs(colour.getId()))
                    .add(getDyedSoapstoneVerticalStairs(colour.getId()))
                    .add(getDyedPolishedSoapstoneVerticalStairs(colour.getId()))
                    .add(getDyedSoapstoneBrickVerticalStairs(colour.getId()))
                    .add(getDyedMudBrickVerticalStairs(colour.getId()));
        }
    }

    private void dramaticDoors() {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(SHORT_CORK_DOOR.get())
                .add(ACCBlocks.TALL_CORK_DOOR.get());
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
