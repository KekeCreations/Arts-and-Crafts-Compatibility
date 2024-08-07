package com.kekecreations.arts_and_crafts_compatibility.datagen.client;

import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.datagen.client.util.ACCModelTemplates;
import com.kekecreations.arts_and_crafts_compatibility.datagen.client.util.ACCTextureMapping;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

public class ACCModelProvider extends FabricModelProvider {
    public ACCModelProvider(FabricDataOutput output) {
        super(output);
    }

    public void generateBlockStateModels(BlockModelGenerators generator) {
        for (DyeColor colour : DyeColor.values()) {
            //ECOLOGICS
            this.createFlowerPot(CompatUtils.ECOLOGICS, ACCBlocks.getDyedPottedAzaleaFlower(colour), "azalea_flower", colour, generator);
            this.createFlowerPot(CompatUtils.ECOLOGICS, ACCBlocks.getDyedPottedWalnutSapling(colour), "walnut_sapling", colour, generator);
            this.createFlowerPot(CompatUtils.ECOLOGICS, ACCBlocks.getDyedPottedCoconutSeedling(colour), "coconut_seedling", colour, generator);
        }
        //BUILT
        generator.createTrivialBlock(ACCBlocks.CORK_COMPACT_PLANKS.get(), TexturedModel.CUBE);
        BlockModelGenerators.BlockFamilyProvider corkShakes = generator.family(ACCBlocks.CORK_SHAKES.get());
        corkShakes.stairs(ACCBlocks.CORK_SHAKES_STAIRS.get());
        corkShakes.slab(ACCBlocks.CORK_SHAKES_SLAB.get());
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    }


    public final void createFlowerPot(String modID, Block flowerPot, String plant, DyeColor colour, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACCTextureMapping.flowerPotTextureMappings(modID, plant, colour);
        ResourceLocation resourceLocation = ACCModelTemplates.FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, resourceLocation));
    }
}
