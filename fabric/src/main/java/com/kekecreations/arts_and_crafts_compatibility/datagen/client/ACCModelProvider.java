package com.kekecreations.arts_and_crafts_compatibility.datagen.client;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCFabricBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCItems;
import com.kekecreations.arts_and_crafts_compatibility.datagen.client.util.ACCModelTemplates;
import com.kekecreations.arts_and_crafts_compatibility.datagen.client.util.ACCTextureMapping;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.Direction;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

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


        //EXCESSIVE BUILDING
        BlockModelGenerators.BlockFamilyProvider corkMosaic = generator.family(ACCFabricBlocks.CORK_MOSAIC.get());
        corkMosaic.stairs(ACCFabricBlocks.CORK_MOSAIC_STAIRS.get());
        corkMosaic.slab(ACCFabricBlocks.CORK_MOSAIC_SLAB.get());
        registerVerticalStairs(generator, ACCFabricBlocks.CORK_MOSAIC_VERTICAL_STAIRS.get(), ACCFabricBlocks.CORK_MOSAIC.get());
        generator.createFullAndCarpetBlocks(ACCFabricBlocks.BLEACHED_KNITTED_WOOL.get(), ACCFabricBlocks.BLEACHED_KNITTED_CARPET.get());
        generator.createCraftingTableLike(ACCFabricBlocks.CORK_CRAFTING_TABLE.get(), ACBlocks.CORK_PLANKS.get(), TextureMapping::craftingTable);
        generator.createTrivialBlock(ACCFabricBlocks.CHISELED_CORK_PLANKS.get(), TexturedModel.COLUMN);
        registerEBBookshelf(generator, ACCFabricBlocks.CORK_BOOKSHELF.get(), ACBlocks.CORK_PLANKS.get());
        registerDecorativeShelfModel(generator, ACCFabricBlocks.CORK_DECORATIVE_SHELF.get(), "0", ACCFabricBlocks.CORK_MOSAIC.get());
        registerDecorativeShelfModel(generator, ACCFabricBlocks.CORK_DECORATIVE_SHELF.get(), "1", ACCFabricBlocks.CORK_MOSAIC.get());
        registerDecorativeShelfModel(generator, ACCFabricBlocks.CORK_DECORATIVE_SHELF.get(), "2", ACCFabricBlocks.CORK_MOSAIC.get());
        registerDecorativeShelfModel(generator, ACCFabricBlocks.CORK_DECORATIVE_SHELF.get(), "3", ACCFabricBlocks.CORK_MOSAIC.get());
        registerDecorativeShelfModel(generator, ACCFabricBlocks.CORK_DECORATIVE_SHELF.get(), "4", ACCFabricBlocks.CORK_MOSAIC.get());
        registerDecorativeShelfModel(generator, ACCFabricBlocks.CORK_DECORATIVE_SHELF.get(), "5", ACCFabricBlocks.CORK_MOSAIC.get());
        registerDecorativeShelfModel(generator, ACCFabricBlocks.CORK_DECORATIVE_SHELF.get(), "6", ACCFabricBlocks.CORK_MOSAIC.get());
        registerLadder(generator, ACCFabricBlocks.CORK_LADDER.get());
        registerVerticalStairs(generator, ACCFabricBlocks.TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get(), ACBlocks.TERRACOTTA_SHINGLES.get());
        registerVerticalStairs(generator, ACCFabricBlocks.SOAPSTONE_VERTICAL_STAIRS.get(), ACBlocks.SOAPSTONE.get());
        registerVerticalStairs(generator, ACCFabricBlocks.GYPSUM_VERTICAL_STAIRS.get(), ACBlocks.GYPSUM.get());
        registerVerticalStairs(generator, ACCFabricBlocks.POLISHED_GYPSUM_VERTICAL_STAIRS.get(), ACBlocks.POLISHED_GYPSUM.get());
        registerVerticalStairs(generator, ACCFabricBlocks.GYPSUM_BRICK_VERTICAL_STAIRS.get(), ACBlocks.GYPSUM_BRICKS.get());
        registerVerticalStairs(generator, ACCFabricBlocks.POLISHED_SOAPSTONE_VERTICAL_STAIRS.get(), ACBlocks.POLISHED_SOAPSTONE.get());
        registerVerticalStairs(generator, ACCFabricBlocks.SOAPSTONE_BRICK_VERTICAL_STAIRS.get(), ACBlocks.SOAPSTONE_BRICKS.get());
        for (DyeColor colour : DyeColor.values()) {
            registerVerticalStairs(generator, ACCFabricBlocks.getDyedTerracottaShingleVerticalStairs(colour.getId()), ACBlocks.getDyedTerracottaShingles(colour.getId()));
            registerVerticalStairs(generator, ACCFabricBlocks.getDyedSoapstoneVerticalStairs(colour.getId()), ACBlocks.getDyedSoapstone(colour.getId()));
            registerVerticalStairs(generator, ACCFabricBlocks.getDyedPolishedSoapstoneVerticalStairs(colour.getId()), ACBlocks.getDyedPolishedSoapstone(colour.getId()));
            registerVerticalStairs(generator, ACCFabricBlocks.getDyedSoapstoneBrickVerticalStairs(colour.getId()), ACBlocks.getDyedSoapstoneBricks(colour.getId()));
            registerVerticalStairs(generator, ACCFabricBlocks.getDyedMudBrickVerticalStairs(colour.getId()), ACBlocks.getDyedMudBricks(colour.getId()));
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ACCItems.GILDED_FINALE_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ACCItems.GILDED_RUINED_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ACCItems.GILDED_GATEWAY_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ACCItems.GILDED_ROLL_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ACCFabricBlocks.CORK_LADDER.get().asItem(), ModelTemplates.FLAT_ITEM);
    }

    public static void registerLadder(BlockModelGenerators generator, Block ladder) {
        ResourceLocation model = ACCModelTemplates.LADDER.create(ladder, TextureMapping.defaultTexture(ladder), generator.modelOutput);
        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(ladder).with(PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING).select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0).with(VariantProperties.UV_LOCK, true)).select(Direction.EAST, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true)).select(Direction.WEST, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true)).select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true))));
    }

    public static void registerVerticalStairs(BlockModelGenerators generator, Block verticalStairs, Block texture) {
        ResourceLocation model = ACCModelTemplates.VERTICAL_STAIRS.create(verticalStairs, TextureMapping.defaultTexture(texture), generator.modelOutput);
        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(verticalStairs).with(PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING).select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0).with(VariantProperties.UV_LOCK, true)).select(Direction.EAST, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true)).select(Direction.WEST, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true)).select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true))));
    }

    private static void registerDecorativeShelfModel(BlockModelGenerators generator, Block bookshelf, String variant, Block planks) {
        TextureMapping textureMap = TextureMapping.column(TextureMapping.getBlockTexture(bookshelf, variant), TextureMapping.getBlockTexture(planks));
        ModelTemplates.CUBE_COLUMN.createWithSuffix(bookshelf, variant, textureMap, generator.modelOutput);
    }

    private static void registerEBBookshelf(BlockModelGenerators generator, Block bookshelf, Block planks) {
        TextureMapping textureMap = TextureMapping.column(TextureMapping.getBlockTexture(bookshelf), TextureMapping.getBlockTexture(planks));
        ResourceLocation model = ModelTemplates.CUBE_COLUMN.create(bookshelf, textureMap, generator.modelOutput);
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(bookshelf, model));
    }


    public final void createFlowerPot(String modID, Block flowerPot, String plant, DyeColor colour, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACCTextureMapping.flowerPotTextureMappings(modID, plant, colour);
        ResourceLocation resourceLocation = ACCModelTemplates.FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, resourceLocation));
    }
}
