package com.kekecreations.arts_and_crafts_compatibility.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts_compatibility.common.block.ACCFlowerPotBlock;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.world.item.DyeColor;
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
    }

    public void ecologics() {
        for (DyeColor colour : DyeColor.values()) {
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ACCBlocks.getDyedPottedWalnutSapling(colour));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ACCBlocks.getDyedPottedAzaleaFlower(colour));
            dropDyedPotContents(ACBlocks.getDyedFlowerPot(colour.getId()), ACCBlocks.getDyedPottedCoconutSeedling(colour));
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
