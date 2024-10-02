package com.kekecreations.arts_and_crafts_compatibility.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts_compatibility.common.block.ACCFlowerPotBlock;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.compat.EcologicsFlowerPots;
import com.kekecreations.arts_and_crafts_compatibility.registry.compat.ExcessiveBuildingFlowerPots;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import static com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks.*;

public class ACCBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ACCBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        ecologics();
        twigs();
        decorativeBlocks();
        excessiveBuilding();
    }

    public void twigs() {
        dropSelf(CORK_TABLE.get());
    }

    public void decorativeBlocks() {
        dropSelf(CORK_PALISADE.get());
        dropSelf(CORK_BEAM.get());
        dropSelf(CORK_SEAT.get());
        dropSelf(CORK_SUPPORT.get());
    }

    public void ecologics() {
        for (DyeColor colour : DyeColor.values()) {
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), EcologicsFlowerPots.getDyedPottedWalnutSapling(colour));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), EcologicsFlowerPots.getDyedPottedAzaleaFlower(colour));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), EcologicsFlowerPots.getDyedPottedCoconutSeedling(colour));
        }
    }

    private void excessiveBuilding() {
        dropSelf(CORK_MOSAIC.get());
        dropSelf(CORK_MOSAIC_VERTICAL_STAIRS.get());
        add(CORK_MOSAIC_SLAB.get(), createSlabItemTable(CORK_MOSAIC_SLAB.get()));
        dropSelf(CORK_MOSAIC_STAIRS.get());
        dropSelf(CORK_CRAFTING_TABLE.get());
        dropSelf(BLEACHED_KNITTED_WOOL.get());
        dropSelf(BLEACHED_KNITTED_CARPET.get());
        dropSelf(CHISELED_CORK_PLANKS.get());
        add(CORK_BOOKSHELF.get(), createSingleItemTable(Items.BOOK, ConstantValue.exactly(3.0F)));
        dropSelf(CORK_DECORATIVE_SHELF.get());
        dropSelf(TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get());
        dropSelf(SOAPSTONE_VERTICAL_STAIRS.get());
        dropSelf(GYPSUM_VERTICAL_STAIRS.get());
        dropSelf(POLISHED_GYPSUM_VERTICAL_STAIRS.get());
        dropSelf(GYPSUM_BRICK_VERTICAL_STAIRS.get());
        dropSelf(POLISHED_SOAPSTONE_VERTICAL_STAIRS.get());
        dropSelf(SOAPSTONE_BRICK_VERTICAL_STAIRS.get());
        for (DyeColor colour : DyeColor.values()) {
            dropSelf(getDyedTerracottaShingleVerticalStairs(colour.getId()));
            dropSelf(getDyedSoapstoneVerticalStairs(colour.getId()));
            dropSelf(getDyedPolishedSoapstoneVerticalStairs(colour.getId()));
            dropSelf(getDyedSoapstoneBrickVerticalStairs(colour.getId()));
            dropSelf(getDyedMudBrickVerticalStairs(colour.getId()));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ExcessiveBuildingFlowerPots.getDyedPottedAncientSapling(colour.getId()));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ExcessiveBuildingFlowerPots.getDyedPottedGloomSapling(colour.getId()));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ExcessiveBuildingFlowerPots.getDyedPottedRose(colour.getId()));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ExcessiveBuildingFlowerPots.getDyedPottedWhiteRose(colour.getId()));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ExcessiveBuildingFlowerPots.getDyedPottedCyanRose(colour.getId()));
        }
    }

    public void dropDyedPotContents(Block flowerPot, Block flowerPotWithPlant) {
        this.add(flowerPotWithPlant, (blockx) -> {
            return this.createDyedPotFlowerItemTable(flowerPot, ((ACCFlowerPotBlock)blockx).getContent());
        });
    }

    public final LootTable.Builder createDyedPotFlowerItemTable(Block flowerPot, ItemLike itemLike) {
        return LootTable.lootTable().withPool((LootPool.Builder)this.applyExplosionCondition(flowerPot, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(flowerPot)))).withPool((LootPool.Builder)this.applyExplosionCondition(itemLike, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike))));
    }
}
