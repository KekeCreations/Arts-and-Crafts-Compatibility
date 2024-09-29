package com.kekecreations.arts_and_crafts_compatibility.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts_compatibility.common.block.ACCFlowerPotBlock;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ExcessiveBuildingCompatRegistry;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.DBBlocks;
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
        dropSelf(DBBlocks.CORK_PALISADE.get());
        dropSelf(ACCBlocks.CORK_BEAM.get());
        dropSelf(ACCBlocks.CORK_SEAT.get());
        dropSelf(ACCBlocks.CORK_SUPPORT.get());
    }

    public void ecologics() {
        for (DyeColor colour : DyeColor.values()) {
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ACCBlocks.getDyedPottedWalnutSapling(colour));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ACCBlocks.getDyedPottedAzaleaFlower(colour));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ACCBlocks.getDyedPottedCoconutSeedling(colour));
        }
    }

    private void excessiveBuilding() {
        dropSelf(ExcessiveBuildingCompatRegistry.CORK_MOSAIC.get());
        dropSelf(ExcessiveBuildingCompatRegistry.CORK_MOSAIC_VERTICAL_STAIRS.get());
        add(ExcessiveBuildingCompatRegistry.CORK_MOSAIC_SLAB.get(), createSlabItemTable(ExcessiveBuildingCompatRegistry.CORK_MOSAIC_SLAB.get()));
        dropSelf(ExcessiveBuildingCompatRegistry.CORK_MOSAIC_STAIRS.get());
        dropSelf(ExcessiveBuildingCompatRegistry.CORK_CRAFTING_TABLE.get());
        dropSelf(ExcessiveBuildingCompatRegistry.BLEACHED_KNITTED_WOOL.get());
        dropSelf(ExcessiveBuildingCompatRegistry.BLEACHED_KNITTED_CARPET.get());
        dropSelf(ExcessiveBuildingCompatRegistry.CHISELED_CORK_PLANKS.get());
        add(ExcessiveBuildingCompatRegistry.CORK_BOOKSHELF.get(), createSingleItemTable(Items.BOOK, ConstantValue.exactly(3.0F)));
        dropSelf(ExcessiveBuildingCompatRegistry.CORK_DECORATIVE_SHELF.get());
        dropSelf(ExcessiveBuildingCompatRegistry.TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get());
        dropSelf(ExcessiveBuildingCompatRegistry.SOAPSTONE_VERTICAL_STAIRS.get());
        dropSelf(ExcessiveBuildingCompatRegistry.GYPSUM_VERTICAL_STAIRS.get());
        dropSelf(ExcessiveBuildingCompatRegistry.POLISHED_GYPSUM_VERTICAL_STAIRS.get());
        dropSelf(ExcessiveBuildingCompatRegistry.GYPSUM_BRICK_VERTICAL_STAIRS.get());
        dropSelf(ExcessiveBuildingCompatRegistry.POLISHED_SOAPSTONE_VERTICAL_STAIRS.get());
        dropSelf(ExcessiveBuildingCompatRegistry.SOAPSTONE_BRICK_VERTICAL_STAIRS.get());
        for (DyeColor colour : DyeColor.values()) {
            dropSelf(ExcessiveBuildingCompatRegistry.getDyedTerracottaShingleVerticalStairs(colour.getId()));
            dropSelf(ExcessiveBuildingCompatRegistry.getDyedSoapstoneVerticalStairs(colour.getId()));
            dropSelf(ExcessiveBuildingCompatRegistry.getDyedPolishedSoapstoneVerticalStairs(colour.getId()));
            dropSelf(ExcessiveBuildingCompatRegistry.getDyedSoapstoneBrickVerticalStairs(colour.getId()));
            dropSelf(ExcessiveBuildingCompatRegistry.getDyedMudBrickVerticalStairs(colour.getId()));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ExcessiveBuildingCompatRegistry.getDyedPottedAncientSapling(colour.getId()));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ExcessiveBuildingCompatRegistry.getDyedPottedGloomSapling(colour.getId()));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ExcessiveBuildingCompatRegistry.getDyedPottedRose(colour.getId()));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ExcessiveBuildingCompatRegistry.getDyedPottedWhiteRose(colour.getId()));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ExcessiveBuildingCompatRegistry.getDyedPottedCyanRose(colour.getId()));
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
