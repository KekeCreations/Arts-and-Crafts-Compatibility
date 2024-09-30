package com.kekecreations.arts_and_crafts_compatibility.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts_compatibility.common.block.ACCFlowerPotBlock;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCFabricBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.compat.EcologicsFlowerPots;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.compat.ExcessiveBuildingFlowerPots;
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
        dropSelf(ACCBlocks.CORK_TABLE.get());
    }

    public void decorativeBlocks() {
        dropSelf(ACCBlocks.CORK_PALISADE.get());
        dropSelf(ACCBlocks.CORK_BEAM.get());
        dropSelf(ACCBlocks.CORK_SEAT.get());
        dropSelf(ACCBlocks.CORK_SUPPORT.get());
    }

    public void ecologics() {
        for (DyeColor colour : DyeColor.values()) {
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), EcologicsFlowerPots.getDyedPottedWalnutSapling(colour));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), EcologicsFlowerPots.getDyedPottedAzaleaFlower(colour));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), EcologicsFlowerPots.getDyedPottedCoconutSeedling(colour));
        }
    }

    private void excessiveBuilding() {
        dropSelf(ACCFabricBlocks.CORK_MOSAIC.get());
        dropSelf(ACCFabricBlocks.CORK_MOSAIC_VERTICAL_STAIRS.get());
        add(ACCFabricBlocks.CORK_MOSAIC_SLAB.get(), createSlabItemTable(ACCFabricBlocks.CORK_MOSAIC_SLAB.get()));
        dropSelf(ACCFabricBlocks.CORK_MOSAIC_STAIRS.get());
        dropSelf(ACCFabricBlocks.CORK_CRAFTING_TABLE.get());
        dropSelf(ACCFabricBlocks.BLEACHED_KNITTED_WOOL.get());
        dropSelf(ACCFabricBlocks.BLEACHED_KNITTED_CARPET.get());
        dropSelf(ACCFabricBlocks.CHISELED_CORK_PLANKS.get());
        add(ACCFabricBlocks.CORK_BOOKSHELF.get(), createSingleItemTable(Items.BOOK, ConstantValue.exactly(3.0F)));
        dropSelf(ACCFabricBlocks.CORK_DECORATIVE_SHELF.get());
        dropSelf(ACCFabricBlocks.TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get());
        dropSelf(ACCFabricBlocks.SOAPSTONE_VERTICAL_STAIRS.get());
        dropSelf(ACCFabricBlocks.GYPSUM_VERTICAL_STAIRS.get());
        dropSelf(ACCFabricBlocks.POLISHED_GYPSUM_VERTICAL_STAIRS.get());
        dropSelf(ACCFabricBlocks.GYPSUM_BRICK_VERTICAL_STAIRS.get());
        dropSelf(ACCFabricBlocks.POLISHED_SOAPSTONE_VERTICAL_STAIRS.get());
        dropSelf(ACCFabricBlocks.SOAPSTONE_BRICK_VERTICAL_STAIRS.get());
        for (DyeColor colour : DyeColor.values()) {
            dropSelf(ACCFabricBlocks.getDyedTerracottaShingleVerticalStairs(colour.getId()));
            dropSelf(ACCFabricBlocks.getDyedSoapstoneVerticalStairs(colour.getId()));
            dropSelf(ACCFabricBlocks.getDyedPolishedSoapstoneVerticalStairs(colour.getId()));
            dropSelf(ACCFabricBlocks.getDyedSoapstoneBrickVerticalStairs(colour.getId()));
            dropSelf(ACCFabricBlocks.getDyedMudBrickVerticalStairs(colour.getId()));
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
