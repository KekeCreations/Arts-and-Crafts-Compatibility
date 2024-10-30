package com.kekecreations.arts_and_crafts_compatibility.datagen.server;

import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsTags;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.leafenzo.mint.util.ModDyeColor;
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
        mint();
    }

    private void mint() {
        for (DyeColor colour : ModDyeColor.VALUES) {
            this.getOrCreateTagBuilder(ArtsAndCraftsTags.BlockTags.CHALK_DUST)
                    .add(ACBlocks.getChalkDust(colour.getId()));
            this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                    .add(ACBlocks.getDyedFlowerPot(colour.getId()));
            this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(ACBlocks.getChalk(colour.getId()))
                    .add(ACBlocks.getDyedSoapstone(colour.getId()))
                    .add(ACBlocks.getDyedSoapstoneSlab(colour.getId()))
                    .add(ACBlocks.getDyedSoapstoneStairs(colour.getId()))
                    .add(ACBlocks.getDyedSoapstoneWall(colour.getId()))
                    .add(ACBlocks.getDyedPolishedSoapstone(colour.getId()))
                    .add(ACBlocks.getDyedPolishedSoapstoneSlab(colour.getId()))
                    .add(ACBlocks.getDyedPolishedSoapstoneStairs(colour.getId()))
                    .add(ACBlocks.getDyedPolishedSoapstoneWall(colour.getId()))
                    .add(ACBlocks.getDyedSoapstoneBricks(colour.getId()))
                    .add(ACBlocks.getDyedSoapstoneBrickSlab(colour.getId()))
                    .add(ACBlocks.getDyedSoapstoneBrickStairs(colour.getId()))
                    .add(ACBlocks.getDyedSoapstoneBrickWall(colour.getId()))
                    .add(ACBlocks.getDyedMudBricks(colour.getId()))
                    .add(ACBlocks.getDyedMudBrickSlab(colour.getId()))
                    .add(ACBlocks.getDyedMudBrickStairs(colour.getId()))
                    .add(ACBlocks.getDyedMudBrickWall(colour.getId()))
                    .add(ACBlocks.getDyedTerracottaShingles(colour.getId()))
                    .add(ACBlocks.getDyedTerracottaShingleSlab(colour.getId()))
                    .add(ACBlocks.getDyedTerracottaShingleStairs(colour.getId()))
                    .add(ACBlocks.getDyedTerracottaShingleWall(colour.getId()))
                    .add(ACBlocks.getDyedPlaster(colour.getId()));
            this.getOrCreateTagBuilder(BlockTags.WALLS)
                    .add(ACBlocks.getDyedTerracottaShingleWall(colour.getId()))
                    .add(ACBlocks.getDyedMudBrickWall(colour.getId()))
                    .add(ACBlocks.getDyedSoapstoneWall(colour.getId()))
                    .add(ACBlocks.getDyedPolishedSoapstoneWall(colour.getId()))
                    .add(ACBlocks.getDyedSoapstoneBrickWall(colour.getId()));
            this.getOrCreateTagBuilder(BlockTags.STAIRS)
                    .add(ACBlocks.getDyedTerracottaShingleStairs(colour.getId()))
                    .add(ACBlocks.getDyedMudBrickStairs(colour.getId()))
                    .add(ACBlocks.getDyedSoapstoneStairs(colour.getId()))
                    .add(ACBlocks.getDyedPolishedSoapstoneStairs(colour.getId()))
                    .add(ACBlocks.getDyedSoapstoneBrickStairs(colour.getId()));
            this.getOrCreateTagBuilder(BlockTags.SLABS)
                    .add(ACBlocks.getDyedTerracottaShingleSlab(colour.getId()))
                    .add(ACBlocks.getDyedMudBrickSlab(colour.getId()))
                    .add(ACBlocks.getDyedSoapstoneSlab(colour.getId()))
                    .add(ACBlocks.getDyedPolishedSoapstoneSlab(colour.getId()))
                    .add(ACBlocks.getDyedSoapstoneBrickSlab(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.CHALK)
                    .add(ACBlocks.getChalk(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.CHALK_DUST)
                    .add(ACBlocks.getChalkDust(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.SOAPSTONE)
                    .add(ACBlocks.getDyedSoapstone(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.SOAPSTONE_BRICKS)
                    .add(ACBlocks.getDyedSoapstoneBricks(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.POLISHED_SOAPSTONE)
                    .add(ACBlocks.getDyedPolishedSoapstone(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.SOAPSTONE_STAIRS)
                    .add(ACBlocks.getDyedSoapstoneStairs(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.SOAPSTONE_BRICK_STAIRS)
                    .add(ACBlocks.getDyedSoapstoneBrickStairs(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.POLISHED_SOAPSTONE_STAIRS)
                    .add(ACBlocks.getDyedPolishedSoapstoneStairs(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.SOAPSTONE_SLAB)
                    .add(ACBlocks.getDyedSoapstoneSlab(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.SOAPSTONE_BRICK_SLAB)
                    .add(ACBlocks.getDyedSoapstoneBrickSlab(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.POLISHED_SOAPSTONE_SLAB)
                    .add(ACBlocks.getDyedPolishedSoapstoneSlab(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.SOAPSTONE_WALL)
                    .add(ACBlocks.getDyedSoapstoneWall(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.SOAPSTONE_BRICK_WALL)
                    .add(ACBlocks.getDyedSoapstoneBrickWall(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.POLISHED_SOAPSTONE_WALL)
                    .add(ACBlocks.getDyedPolishedSoapstoneWall(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.MUD_BRICKS)
                    .add(ACBlocks.getDyedMudBricks(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.MUD_BRICK_STAIRS)
                    .add(ACBlocks.getDyedMudBrickStairs(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.MUD_BRICK_WALL)
                    .add(ACBlocks.getDyedMudBrickWall(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.MUD_BRICK_SLAB)
                    .add(ACBlocks.getDyedMudBrickSlab(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.TERRACOTTA_SHINGLES)
                    .add(ACBlocks.getDyedTerracottaShingles(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.TERRACOTTA_SHINGLE_STAIRS)
                    .add(ACBlocks.getDyedTerracottaShingleStairs(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.TERRACOTTA_SHINGLE_SLAB)
                    .add(ACBlocks.getDyedTerracottaShingleSlab(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.TERRACOTTA_SHINGLE_WALL)
                    .add(ACBlocks.getDyedTerracottaShingleWall(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.PLASTER)
                    .add(ACBlocks.getDyedPlaster(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.FLOWER_POTS).add(ACBlocks.getDyedFlowerPot(colour.getId()));
            this.getOrCreateTagBuilder(ACCTags.DECORATED_POTS).add(ACBlocks.getDyedDecoratedPot(colour.getId()));
        }
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
