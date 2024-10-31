package com.kekecreations.arts_and_crafts_compatibility.datagen.client;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCItems;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.compat.EcologicsFlowerPots;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.compat.ExcessiveBuildingFlowerPots;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
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

import java.util.Objects;

public class ACCModelProvider extends FabricModelProvider {
    public ACCModelProvider(FabricDataOutput output) {
        super(output);
    }

    public void generateBlockStateModels(BlockModelGenerators generator) {
        for (DyeColor colour : DyeColor.values()) {
            //ECOLOGICS
            if (colour.getId() <= 16) {
                this.createFlowerPot(CompatUtils.ECOLOGICS, EcologicsFlowerPots.getDyedPottedAzaleaFlower(colour), "azalea_flower", colour, generator);
                this.createFlowerPot(CompatUtils.ECOLOGICS, EcologicsFlowerPots.getDyedPottedWalnutSapling(colour), "walnut_sapling", colour, generator);
                this.createFlowerPot(CompatUtils.ECOLOGICS, EcologicsFlowerPots.getDyedPottedCoconutSeedling(colour), "coconut_seedling", colour, generator);
            }
        }
        //BUILT
        generator.createTrivialBlock(ACCBlocks.CORK_COMPACT_PLANKS.get(), TexturedModel.CUBE);
        BlockModelGenerators.BlockFamilyProvider corkShakes = generator.family(ACCBlocks.CORK_SHAKES.get());
        corkShakes.stairs(ACCBlocks.CORK_SHAKES_STAIRS.get());
        corkShakes.slab(ACCBlocks.CORK_SHAKES_SLAB.get());



        //EXCESSIVE BUILDING
        BlockModelGenerators.BlockFamilyProvider corkMosaic = generator.family(ACCBlocks.CORK_MOSAIC.get());
        corkMosaic.stairs(ACCBlocks.CORK_MOSAIC_STAIRS.get());
        corkMosaic.slab(ACCBlocks.CORK_MOSAIC_SLAB.get());
        registerVerticalStairs(generator, ACCBlocks.CORK_MOSAIC_VERTICAL_STAIRS.get(), ACCBlocks.CORK_MOSAIC.get());
        generator.createFullAndCarpetBlocks(ACCBlocks.BLEACHED_KNITTED_WOOL.get(), ACCBlocks.BLEACHED_KNITTED_CARPET.get());
        generator.createCraftingTableLike(ACCBlocks.CORK_CRAFTING_TABLE.get(), ACBlocks.CORK_PLANKS.get(), TextureMapping::craftingTable);
        generator.createTrivialBlock(ACCBlocks.CHISELED_CORK_PLANKS.get(), TexturedModel.COLUMN);
        registerEBBookshelf(generator, ACCBlocks.CORK_BOOKSHELF.get(), ACBlocks.CORK_PLANKS.get());
        registerDecorativeShelfModel(generator, ACCBlocks.CORK_DECORATIVE_SHELF.get(), "0", ACCBlocks.CORK_MOSAIC.get());
        registerDecorativeShelfModel(generator, ACCBlocks.CORK_DECORATIVE_SHELF.get(), "1", ACCBlocks.CORK_MOSAIC.get());
        registerDecorativeShelfModel(generator, ACCBlocks.CORK_DECORATIVE_SHELF.get(), "2", ACCBlocks.CORK_MOSAIC.get());
        registerDecorativeShelfModel(generator, ACCBlocks.CORK_DECORATIVE_SHELF.get(), "3", ACCBlocks.CORK_MOSAIC.get());
        registerDecorativeShelfModel(generator, ACCBlocks.CORK_DECORATIVE_SHELF.get(), "4", ACCBlocks.CORK_MOSAIC.get());
        registerDecorativeShelfModel(generator, ACCBlocks.CORK_DECORATIVE_SHELF.get(), "5", ACCBlocks.CORK_MOSAIC.get());
        registerDecorativeShelfModel(generator, ACCBlocks.CORK_DECORATIVE_SHELF.get(), "6", ACCBlocks.CORK_MOSAIC.get());
        registerLadder(generator, ACCBlocks.CORK_LADDER.get());
        registerVerticalStairs(generator, ACCBlocks.TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get(), ACBlocks.TERRACOTTA_SHINGLES.get());
        registerVerticalStairs(generator, ACCBlocks.SOAPSTONE_VERTICAL_STAIRS.get(), ACBlocks.SOAPSTONE.get());
        registerVerticalStairs(generator, ACCBlocks.GYPSUM_VERTICAL_STAIRS.get(), ACBlocks.GYPSUM.get());
        registerVerticalStairs(generator, ACCBlocks.POLISHED_GYPSUM_VERTICAL_STAIRS.get(), ACBlocks.POLISHED_GYPSUM.get());
        registerVerticalStairs(generator, ACCBlocks.GYPSUM_BRICK_VERTICAL_STAIRS.get(), ACBlocks.GYPSUM_BRICKS.get());
        registerVerticalStairs(generator, ACCBlocks.POLISHED_SOAPSTONE_VERTICAL_STAIRS.get(), ACBlocks.POLISHED_SOAPSTONE.get());
        registerVerticalStairs(generator, ACCBlocks.SOAPSTONE_BRICK_VERTICAL_STAIRS.get(), ACBlocks.SOAPSTONE_BRICKS.get());
        for (DyeColor colour : DyeColor.values()) {
            if (colour.getId() <= 16) {
                registerVerticalStairs(generator, ACCBlocks.getDyedTerracottaShingleVerticalStairs(colour.getId()), ACBlocks.getDyedTerracottaShingles(colour.getId()));
                registerVerticalStairs(generator, ACCBlocks.getDyedSoapstoneVerticalStairs(colour.getId()), ACBlocks.getDyedSoapstone(colour.getId()));
                registerVerticalStairs(generator, ACCBlocks.getDyedPolishedSoapstoneVerticalStairs(colour.getId()), ACBlocks.getDyedPolishedSoapstone(colour.getId()));
                registerVerticalStairs(generator, ACCBlocks.getDyedSoapstoneBrickVerticalStairs(colour.getId()), ACBlocks.getDyedSoapstoneBricks(colour.getId()));
                registerVerticalStairs(generator, ACCBlocks.getDyedMudBrickVerticalStairs(colour.getId()), ACBlocks.getDyedMudBricks(colour.getId()));
                this.createFlowerPot(CompatUtils.EXCESSIVE_BUILDING, ExcessiveBuildingFlowerPots.getDyedPottedAncientSapling(colour.getId()), "ancient_sapling", colour, generator);
                this.createFlowerPot(CompatUtils.EXCESSIVE_BUILDING, ExcessiveBuildingFlowerPots.getDyedPottedGloomSapling(colour.getId()), "gloom_sapling", colour, generator);
                this.createFlowerPot(CompatUtils.EXCESSIVE_BUILDING, ExcessiveBuildingFlowerPots.getDyedPottedRose(colour.getId()), "rose", colour, generator);
                this.createFlowerPot(CompatUtils.EXCESSIVE_BUILDING, ExcessiveBuildingFlowerPots.getDyedPottedCyanRose(colour.getId()), "cyan_rose", colour, generator);
                this.createFlowerPot(CompatUtils.EXCESSIVE_BUILDING, ExcessiveBuildingFlowerPots.getDyedPottedWhiteRose(colour.getId()), "white_rose", colour, generator);
            }
        }

        /*
        //DYE MOD STUFF
        for (DyeColor colour : ModDyeColor.VALUES) {
            BlockModelGenerators.BlockFamilyProvider soapstone = generator.family(ACBlocks.getDyedSoapstone(colour.getId()));
            soapstone.stairs(ACBlocks.getDyedSoapstoneStairs(colour.getId()));
            soapstone.slab(ACBlocks.getDyedSoapstoneSlab(colour.getId()));
            soapstone.wall(ACBlocks.getDyedSoapstoneWall(colour.getId()));
            generator.delegateItemModel(ACBlocks.getDyedSoapstone(colour.getId()), new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/" + colour + "_soapstone"));

            BlockModelGenerators.BlockFamilyProvider soapstoneBricks = generator.family(ACBlocks.getDyedSoapstoneBricks(colour.getId()));
            soapstoneBricks.stairs(ACBlocks.getDyedSoapstoneBrickStairs(colour.getId()));
            soapstoneBricks.slab(ACBlocks.getDyedSoapstoneBrickSlab(colour.getId()));
            soapstoneBricks.wall(ACBlocks.getDyedSoapstoneBrickWall(colour.getId()));
            generator.delegateItemModel(ACBlocks.getDyedSoapstoneBricks(colour.getId()), new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/" + colour + "_soapstone_bricks"));

            BlockModelGenerators.BlockFamilyProvider polishedSoapstone = generator.family(ACBlocks.getDyedPolishedSoapstone(colour.getId()));
            polishedSoapstone.stairs(ACBlocks.getDyedPolishedSoapstoneStairs(colour.getId()));
            polishedSoapstone.slab(ACBlocks.getDyedPolishedSoapstoneSlab(colour.getId()));
            polishedSoapstone.wall(ACBlocks.getDyedPolishedSoapstoneWall(colour.getId()));
            generator.delegateItemModel(ACBlocks.getDyedPolishedSoapstone(colour.getId()), new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/" + colour + "_polished_soapstone"));

            BlockModelGenerators.BlockFamilyProvider mudBricks = generator.family(ACBlocks.getDyedMudBricks(colour.getId()));
            mudBricks.stairs(ACBlocks.getDyedMudBrickStairs(colour.getId()));
            mudBricks.slab(ACBlocks.getDyedMudBrickSlab(colour.getId()));
            mudBricks.wall(ACBlocks.getDyedMudBrickWall(colour.getId()));
            generator.delegateItemModel(ACBlocks.getDyedMudBricks(colour.getId()), new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/" + colour + "_mud_bricks"));

            BlockModelGenerators.BlockFamilyProvider shingles = generator.family(ACBlocks.getDyedTerracottaShingles(colour.getId()));
            shingles.stairs(ACBlocks.getDyedTerracottaShingleStairs(colour.getId()));
            shingles.slab(ACBlocks.getDyedTerracottaShingleSlab(colour.getId()));
            shingles.wall(ACBlocks.getDyedTerracottaShingleWall(colour.getId()));
            generator.delegateItemModel(ACBlocks.getDyedTerracottaShingles(colour.getId()), new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/" + colour + "_terracotta_shingles"));

            plasterBlock(generator, ACBlocks.getDyedPlaster(colour.getId()));
            generator.delegateItemModel(ACBlocks.getDyedPlaster(colour.getId()), new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/" + colour + "_plaster"));

            generator.createTrivialBlock(ACBlocks.getChalk(colour.getId()), TexturedModel.CUBE);
            generator.delegateItemModel(ACBlocks.getChalk(colour.getId()), new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/" + colour + "_chalk"));

            this.createEmptyFlowerPot(ACBlocks.getDyedFlowerPot(colour.getId()), colour, generator);
            flowerPotBlock(ACBlocks.getDyedPottedCorkSapling(colour), colour, "cork_sapling", "arts_and_crafts", generator);
            flowerPotBlock(ACBlocks.getDyedPottedOakSapling(colour), colour, "oak_sapling", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedSpruceSapling(colour), colour, "spruce_sapling", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedBirchSapling(colour), colour, "birch_sapling", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedJungleSapling(colour), colour, "jungle_sapling", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedAcaciaSapling(colour), colour, "acacia_sapling", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedCherrySapling(colour), colour, "cherry_sapling", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedDarkOakSapling(colour), colour, "dark_oak_sapling", "minecraft", generator);
            mangrovePropaguleFlowerPotBlock(ACBlocks.getDyedPottedMangrovePropagule(colour), colour, generator);

            flowerPotBlock(ACBlocks.getDyedPottedCrimsonFungus(colour), colour, "crimson_fungus", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedCrimsonRoots(colour), colour, "crimson_roots_pot", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedWarpedFungus(colour), colour, "warped_fungus", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedWarpedRoots(colour), colour, "warped_roots_pot", "minecraft", generator);

            tintedFlowerPotBlock(ACBlocks.getDyedPottedFern(colour), colour, "fern", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedDandelion(colour), colour, "dandelion", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedPoppy(colour), colour, "poppy", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedBlueOrchid(colour), colour, "blue_orchid", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedAllium(colour), colour, "allium", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedAzureBluet(colour), colour, "azure_bluet", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedRedTulip(colour), colour, "red_tulip", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedOrangeTulip(colour), colour, "orange_tulip", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedWhiteTulip(colour), colour, "white_tulip", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedPinkTulip(colour), colour, "pink_tulip", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedOxeyeDaisy(colour), colour, "oxeye_daisy", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedCornflower(colour), colour, "cornflower", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedLilyOfTheValley(colour), colour, "lily_of_the_valley", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedWitherRose(colour), colour, "wither_rose", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedRedMushroom(colour), colour, "red_mushroom", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedBrownMushroom(colour), colour, "brown_mushroom", "minecraft", generator);
            flowerPotBlock(ACBlocks.getDyedPottedDeadBush(colour), colour, "dead_bush", "minecraft", generator);
            cactusFlowerPotBlock(ACBlocks.getDyedPottedCactus(colour), colour, generator);
            bambooFlowerPotBlock(ACBlocks.getDyedPottedBamboo(colour), colour, generator);
            azaleaFlowerPotBlock(ACBlocks.getDyedPottedAzalea(colour), colour, "potted_azalea_bush", generator);
            azaleaFlowerPotBlock(ACBlocks.getDyedPottedFloweringAzalea(colour), colour, "potted_flowering_azalea_bush", generator);
            flowerPotBlock(ACBlocks.getDyedPottedTorchFlower(colour), colour, "torchflower", "minecraft", generator);
        }
        for (DyeColor colour : DyeColor.values()) {
            createFlowerPot(CompatUtils.MINT, MintFlowerPots.getDyedPottedWildMint(colour.getId()), "wild_mint", colour, generator);
            createFlowerPot(CompatUtils.MINT, MintFlowerPots.getDyedPottedWintergreenSapling(colour.getId()), "wintergreen_sapling", colour, generator);
            createFlowerPot(CompatUtils.MINT, MintFlowerPots.getDyedPottedPeachSapling(colour.getId()), "peach_sapling", colour, generator);
            createFlowerPot(CompatUtils.MINT, MintFlowerPots.getDyedPottedHypericum(colour.getId()), "hypericum", colour, generator);
            createFlowerPot(CompatUtils.MINT, MintFlowerPots.getDyedPottedHidcoteLavender(colour.getId()), "hidcote_lavender", colour, generator);
            createFlowerPot(CompatUtils.MINT, MintFlowerPots.getDyedPottedThistleFlower(colour.getId()), "thistle_flower", colour, generator);
            createFlowerPot(CompatUtils.MINT, MintFlowerPots.getDyedPottedWaxcapMushroom(colour.getId()), "waxcap_mushroom", colour, generator);
            createFlowerPot(CompatUtils.MINT, MintFlowerPots.getDyedPottedCordyline(colour.getId()), "cordyline", colour, generator);
            createFlowerPot(CompatUtils.MINT, MintFlowerPots.getDyedPottedPlumCordyline(colour.getId()), "plum_cordyline", colour, generator);
        }

         */
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ACCItems.GILDED_FINALE_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ACCItems.GILDED_RUINED_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ACCItems.GILDED_GATEWAY_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ACCItems.GILDED_ROLL_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        //itemModelGenerator.generateFlatItem(ACCBlocks.CORK_LADDER.get().asItem(), ModelTemplates.FLAT_ITEM);

        /*
        for (DyeColor colour : ModDyeColor.VALUES) {
            itemModelGenerator.generateFlatItem(ACItems.getChalkStick(colour.getId()), ModelTemplates.FLAT_HANDHELD_ITEM);
            itemModelGenerator.generateFlatItem(ACItems.getPaintBrush(colour.getId()), ModelTemplates.FLAT_HANDHELD_ITEM);
            itemModelGenerator.generateFlatItem(ACBlocks.getDyedFlowerPot(colour.getId()).asItem(), ModelTemplates.FLAT_ITEM);
        }

         */
    }

    public static void plasterBlock(BlockModelGenerators generator, Block plaster) {
        ResourceLocation model = ACCModelTemplates.PLASTER.create(plaster, ACCTextureMapping.plasterTextureMappings(plaster), generator.modelOutput);
        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(plaster)
                .with(PropertyDispatch.property(BlockStateProperties.FACING)
                        .select(Direction.NORTH, Variant.variant()
                                .with(VariantProperties.MODEL, model)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.EAST, Variant.variant()
                                .with(VariantProperties.MODEL, model)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                        .select(Direction.WEST, Variant.variant()
                                .with(VariantProperties.MODEL, model)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.SOUTH, Variant.variant()
                                .with(VariantProperties.MODEL, model)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.UP, Variant.variant()
                                .with(VariantProperties.MODEL, model)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.DOWN, Variant.variant()
                                .with(VariantProperties.MODEL, model)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270))));
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

    public final void flowerPotBlock(Block flowerPot, DyeColor colour, String plant, String modID,  BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACCTextureMapping.flowerPotTextureMappings(modID, plant, colour);
        ResourceLocation resourceLocation = ACCModelTemplates.FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, resourceLocation));
    }

    public final void cactusFlowerPotBlock(Block flowerPot, DyeColor colour, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACCTextureMapping.emptyFlowerPotTextureMappings(colour);
        ResourceLocation resourceLocation = ACCModelTemplates.CACTUS_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, resourceLocation));
    }

    public final void bambooFlowerPotBlock(Block flowerPot, DyeColor colour, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACCTextureMapping.emptyFlowerPotTextureMappings(colour);
        ResourceLocation resourceLocation = ACCModelTemplates.BAMBOO_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, resourceLocation));
    }

    public final void mangrovePropaguleFlowerPotBlock(Block flowerPot, DyeColor colour, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACCTextureMapping.emptyFlowerPotTextureMappings(colour);
        ResourceLocation resourceLocation = ACCModelTemplates.MANGROVE_PROPAGULE_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, resourceLocation));
    }

    public final void azaleaFlowerPotBlock(Block flowerPot, DyeColor colour, String bush, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACCTextureMapping.emptyFlowerPotTextureMappings(colour);
        ResourceLocation resourceLocation = new ResourceLocation("ifyouevergetthisihavezerocluewhathappened");
        if (Objects.equals(bush, "potted_azalea_bush")) {
            resourceLocation = ACCModelTemplates.AZALEA_BUSH_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        } else if (Objects.equals(bush, "potted_flowering_azalea_bush")) {
            resourceLocation = ACCModelTemplates.FLOWERING_AZALEA_BUSH_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        }
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, resourceLocation));
    }

    public final void tintedFlowerPotBlock(Block flowerPot, DyeColor colour, String plant, String modID,  BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACCTextureMapping.flowerPotTextureMappings(modID, plant, colour);
        ResourceLocation resourceLocation = ACCModelTemplates.TINTED_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, resourceLocation));
    }

    public final void createEmptyFlowerPot(Block flowerPot, DyeColor colour, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACCTextureMapping.emptyFlowerPotTextureMappings(colour);
        ResourceLocation resourceLocation = ACCModelTemplates.EMPTY_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, resourceLocation));
    }
}
