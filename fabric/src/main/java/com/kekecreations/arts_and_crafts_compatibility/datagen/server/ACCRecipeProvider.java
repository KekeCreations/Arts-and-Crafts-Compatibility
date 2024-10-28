package com.kekecreations.arts_and_crafts_compatibility.datagen.server;

import com.kekecreations.arts_and_crafts.common.item.PaintbrushItem;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCItems;
import com.kekecreations.arts_and_crafts_compatibility.core.util.DyeModDyedBlockLists;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.leafenzo.mint.util.ModDyeColor;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.yirmiri.excessive_building.registry.EBBlocks;
import net.yirmiri.excessive_building.util.EBTags;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ACCRecipeProvider extends FabricRecipeProvider {

    public ACCRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        //MINT
        List<Item> dyeList = new ArrayList<>(List.of());
        List<Item> everyChalkStickList = new ArrayList<>(List.of());
        List<Item> chalkStickList = new ArrayList<>(List.of());
        List<Item> everyChalkList = new ArrayList<>(List.of());
        List<Item> chalkList = new ArrayList<>(List.of());
        List<Item> soapstoneList = new ArrayList<>(List.of());
        List<Item> soapstoneBrickList = new ArrayList<>(List.of());
        List<Item> polishedSoapstoneList = new ArrayList<>(List.of());
        List<Item> mudBrickList = new ArrayList<>(List.of());
        List<Item> terracottaShingleList = new ArrayList<>(List.of());
        for (DyeColor colour : DyeColor.values()) {
            dyeList.add(DyeItem.byColor(colour));
            everyChalkStickList.add(ACItems.getChalkStick(colour.getId()));
            everyChalkList.add(ACBlocks.getChalk(colour.getId()).asItem());
        }
        for (DyeColor colour : ModDyeColor.VALUES) {
            chalkList.add(ACBlocks.getChalk(colour.getId()).asItem());
            chalkStickList.add(ACItems.getChalkStick(colour.getId()));
            soapstoneList.add(ACBlocks.getDyedSoapstone(colour.getId()).asItem());
            polishedSoapstoneList.add(ACBlocks.getDyedPolishedSoapstone(colour.getId()).asItem());
            soapstoneBrickList.add(ACBlocks.getDyedSoapstoneBricks(colour.getId()).asItem());
            mudBrickList.add(ACBlocks.getDyedMudBricks(colour.getId()).asItem());
            terracottaShingleList.add(ACBlocks.getDyedTerracottaShingles(colour.getId()).asItem());
        }
        for (DyeColor colour : ModDyeColor.VALUES) {
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACItems.getChalkStick(colour.getId()), ACBlocks.getChalk(colour.getId()));
            //SOAP
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstoneSlab(colour.getId()), ACBlocks.getDyedSoapstone(colour.getId()));
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstoneStairs(colour.getId()), ACBlocks.getDyedSoapstone(colour.getId()));
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstoneWall(colour.getId()), ACBlocks.getDyedSoapstone(colour.getId()));
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstoneBricks(colour.getId()), ACBlocks.getDyedSoapstone(colour.getId()));
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstoneBrickSlab(colour.getId()), ACBlocks.getDyedSoapstone(colour.getId()));
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstoneBrickStairs(colour.getId()), ACBlocks.getDyedSoapstone(colour.getId()));
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstoneBrickWall(colour.getId()), ACBlocks.getDyedSoapstone(colour.getId()));
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedPolishedSoapstone(colour.getId()), ACBlocks.getDyedSoapstone(colour.getId()));
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedPolishedSoapstoneSlab(colour.getId()), ACBlocks.getDyedSoapstone(colour.getId()));
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedPolishedSoapstoneStairs(colour.getId()), ACBlocks.getDyedSoapstone(colour.getId()));
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedPolishedSoapstoneWall(colour.getId()), ACBlocks.getDyedSoapstone(colour.getId()));

            eightDyeRecipe(ACBlocks.getDyedSoapstone(colour.getId()), ACBlocks.SOAPSTONE.get(), DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedPolishedSoapstone(colour.getId()), ACBlocks.POLISHED_SOAPSTONE.get(), DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedSoapstoneBricks(colour.getId()), ACBlocks.SOAPSTONE_BRICKS.get(), DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedSoapstoneStairs(colour.getId()), ACBlocks.SOAPSTONE_STAIRS.get(), DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedPolishedSoapstoneStairs(colour.getId()), ACBlocks.POLISHED_SOAPSTONE_STAIRS.get(), DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedSoapstoneBrickStairs(colour.getId()), ACBlocks.SOAPSTONE_BRICK_STAIRS.get(), DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedSoapstoneSlab(colour.getId()), ACBlocks.SOAPSTONE_SLAB.get(), DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedPolishedSoapstoneSlab(colour.getId()), ACBlocks.POLISHED_SOAPSTONE_SLAB.get(), DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedSoapstoneBrickSlab(colour.getId()), ACBlocks.SOAPSTONE_BRICK_SLAB.get(), DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedSoapstoneWall(colour.getId()), ACBlocks.SOAPSTONE_WALL.get(), DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedPolishedSoapstoneWall(colour.getId()), ACBlocks.POLISHED_SOAPSTONE_WALL.get(), DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedSoapstoneBrickWall(colour.getId()), ACBlocks.SOAPSTONE_BRICK_WALL.get(), DyeItem.byColor(colour), exporter);

            stairRecipe(ACBlocks.getDyedSoapstone(colour.getId()), ACBlocks.getDyedSoapstoneStairs(colour.getId()), exporter);
            stairRecipe(ACBlocks.getDyedPolishedSoapstone(colour.getId()), ACBlocks.getDyedPolishedSoapstoneStairs(colour.getId()), exporter);
            stairRecipe(ACBlocks.getDyedSoapstoneBricks(colour.getId()), ACBlocks.getDyedSoapstoneBrickStairs(colour.getId()), exporter);
            slabRecipe(ACBlocks.getDyedSoapstone(colour.getId()), ACBlocks.getDyedSoapstoneSlab(colour.getId()), exporter);
            slabRecipe(ACBlocks.getDyedPolishedSoapstone(colour.getId()), ACBlocks.getDyedPolishedSoapstoneSlab(colour.getId()), exporter);
            slabRecipe(ACBlocks.getDyedSoapstoneBricks(colour.getId()), ACBlocks.getDyedSoapstoneBrickSlab(colour.getId()), exporter);
            wallRecipe(ACBlocks.getDyedSoapstone(colour.getId()), ACBlocks.getDyedSoapstoneWall(colour.getId()), exporter);
            wallRecipe(ACBlocks.getDyedPolishedSoapstone(colour.getId()), ACBlocks.getDyedPolishedSoapstoneWall(colour.getId()), exporter);
            wallRecipe(ACBlocks.getDyedSoapstoneBricks(colour.getId()), ACBlocks.getDyedSoapstoneBrickWall(colour.getId()), exporter);

            typeRecipe(ACBlocks.getDyedSoapstone(colour.getId()), ACBlocks.getDyedPolishedSoapstone(colour.getId()), exporter);
            typeRecipe(ACBlocks.getDyedPolishedSoapstone(colour.getId()), ACBlocks.getDyedSoapstoneBricks(colour.getId()), exporter);



            //MUD
            stairRecipe(ACBlocks.getDyedMudBricks(colour.getId()), ACBlocks.getDyedMudBrickStairs(colour.getId()), exporter);
            slabRecipe(ACBlocks.getDyedMudBricks(colour.getId()), ACBlocks.getDyedMudBrickSlab(colour.getId()), exporter);
            wallRecipe(ACBlocks.getDyedMudBricks(colour.getId()), ACBlocks.getDyedMudBrickWall(colour.getId()), exporter);
            eightDyeRecipe(ACBlocks.getDyedMudBricks(colour.getId()), Blocks.MUD_BRICKS, DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedMudBrickStairs(colour.getId()), Blocks.MUD_BRICK_STAIRS, DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedMudBrickSlab(colour.getId()), Blocks.MUD_BRICK_SLAB, DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedMudBrickWall(colour.getId()), Blocks.MUD_BRICK_WALL, DyeItem.byColor(colour), exporter);
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedMudBrickSlab(colour.getId()), ACBlocks.getDyedMudBricks(colour.getId()));
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedMudBrickStairs(colour.getId()), ACBlocks.getDyedMudBricks(colour.getId()));
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedMudBrickWall(colour.getId()), ACBlocks.getDyedMudBricks(colour.getId()));

            //SHINGLE
            stairRecipe(ACBlocks.getDyedTerracottaShingles(colour.getId()), ACBlocks.getDyedTerracottaShingleStairs(colour.getId()), exporter);
            slabRecipe(ACBlocks.getDyedTerracottaShingles(colour.getId()), ACBlocks.getDyedTerracottaShingleSlab(colour.getId()), exporter);
            wallRecipe(ACBlocks.getDyedTerracottaShingles(colour.getId()), ACBlocks.getDyedTerracottaShingleWall(colour.getId()), exporter);
            eightDyeRecipe(ACBlocks.getDyedTerracottaShingles(colour.getId()), ACBlocks.TERRACOTTA_SHINGLES.get(), DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedTerracottaShingleStairs(colour.getId()), ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedTerracottaShingleSlab(colour.getId()), ACBlocks.TERRACOTTA_SHINGLE_SLAB.get(), DyeItem.byColor(colour), exporter);
            eightDyeRecipe(ACBlocks.getDyedTerracottaShingleWall(colour.getId()), ACBlocks.TERRACOTTA_SHINGLE_WALL.get(), DyeItem.byColor(colour), exporter);
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedTerracottaShingleSlab(colour.getId()), ACBlocks.getDyedTerracottaShingles(colour.getId()));
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedTerracottaShingleStairs(colour.getId()), ACBlocks.getDyedTerracottaShingles(colour.getId()));
            stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedTerracottaShingleWall(colour.getId()), ACBlocks.getDyedTerracottaShingles(colour.getId()));
            typeRecipe(DyeModDyedBlockLists.getDyeModTerracotta(colour.getId()), ACBlocks.getDyedTerracottaShingles(colour.getId()), exporter);



            paintbrushRecipe(colour, ACItems.getPaintBrush(colour.getId()), exporter);
        }
        bleachBlockAlt(exporter, soapstoneList, ACBlocks.SOAPSTONE.get().asItem(), "soapstone");
        bleachBlockAlt(exporter, polishedSoapstoneList, ACBlocks.POLISHED_SOAPSTONE.get().asItem(), "polished_soapstone");
        bleachBlockAlt(exporter, soapstoneBrickList, ACBlocks.SOAPSTONE_BRICKS.get().asItem(), "soapstone_bricks");
        bleachBlock(exporter, chalkStickList, ACItems.BLEACHED_CHALK_STICK.get().asItem(), "chalk_sticks");
        bleachBlock(exporter, chalkList, ACBlocks.BLEACHED_CHALK.get().asItem(), "chalk");
        bleachBlockAlt(exporter, mudBrickList, Blocks.MUD_BRICKS, "mud_bricks");
        bleachBlockAlt(exporter, terracottaShingleList, ACBlocks.TERRACOTTA_SHINGLES.get(), "terracotta_shingles");

        colorBlockWithDye(exporter, dyeList, everyChalkStickList, "chalk_sticks");
        colorBlockWithDye(exporter, dyeList, everyChalkList, "chalk");

        //DRAMATIC DOORS
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACCItems.CORK_SHORT_DOOR.get(), ACBlocks.CORK_DOOR.get(), 2);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ACCItems.TALL_CORK_DOOR.get(), 2)
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .define('#', ACBlocks.CORK_DOOR.get())
                .unlockedBy("has_planks", has(ACBlocks.CORK_TRAPDOOR.get()))
                .save(exporter);
        //FARMERS DELIGHT
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ACCBlocks.CORK_CABINET.get())
                .pattern("___")
                .pattern("D D")
                .pattern("___")
                .define('_', ACBlocks.CORK_SLAB.get())
                .define('D', ACBlocks.CORK_TRAPDOOR.get())
                .unlockedBy("has_planks", has(ACBlocks.CORK_TRAPDOOR.get()))
                .save(exporter);
        //TWIGS
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ACCBlocks.CORK_TABLE.get())
                .pattern("___")
                .pattern("0 0")
                .pattern("0 0")
                .define('_', ACBlocks.CORK_SLAB.get())
                .define('0', ACBlocks.CORK_FENCE.get())
                .unlockedBy("has_planks", has(ACBlocks.CORK_PLANKS.get()))
                .save(exporter);

        //DECORATIVE BLOCKS
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ACCBlocks.CORK_BEAM.get(), 2)
                .pattern(" x ")
                .pattern(" x ")
                .define('x', ACBlocks.STRIPPED_CORK_LOG.get())
                .unlockedBy("has_log", has(ACBlocks.STRIPPED_CORK_LOG.get()))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ACCBlocks.CORK_PALISADE.get(), 6)
                .pattern("xx ")
                .define('x', ACBlocks.CORK_LOG.get())
                .unlockedBy("has_log", has(ACBlocks.CORK_LOG.get()))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ACCBlocks.CORK_SEAT.get(), 6)
                .pattern("x  ")
                .pattern("y  ")
                .define('x', ACBlocks.CORK_SLAB.get())
                .define('y', ACBlocks.CORK_FENCE.get())
                .unlockedBy("has_planks", has(ACBlocks.CORK_PLANKS.get()))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ACCBlocks.CORK_SUPPORT.get(), 6)
                .pattern("xx ")
                .pattern("x  ")
                .define('x', ACBlocks.CORK_PLANKS.get())
                .unlockedBy("has_planks", has(ACBlocks.CORK_PLANKS.get()))
                .save(exporter);


        //GILDED SHERDS
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ACCItems.GILDED_FINALE_POTTERY_SHERD.get())
                .requires(Items.GOLD_NUGGET, 1)
                .requires(ACItems.FINALE_POTTERY_SHERD.get())
                .unlockedBy("unlock", has(ACCItems.GILDED_FINALE_POTTERY_SHERD.get()))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ACCItems.GILDED_GATEWAY_POTTERY_SHERD.get())
                .requires(Items.GOLD_NUGGET, 1)
                .requires(ACItems.GATEWAY_POTTERY_SHERD.get())
                .unlockedBy("unlock", has(ACCItems.GILDED_GATEWAY_POTTERY_SHERD.get()))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ACCItems.GILDED_RUINED_POTTERY_SHERD.get())
                .requires(Items.GOLD_NUGGET, 1)
                .requires(ACItems.RUINED_POTTERY_SHERD.get())
                .unlockedBy("unlock", has(ACCItems.GILDED_RUINED_POTTERY_SHERD.get()))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ACCItems.GILDED_ROLL_POTTERY_SHERD.get())
                .requires(Items.GOLD_NUGGET, 1)
                .requires(ACItems.ROLL_POTTERY_SHERD.get())
                .unlockedBy("unlock", has(ACCItems.GILDED_ROLL_POTTERY_SHERD.get()))
                .save(exporter);

        //EXCESSIVE BUILDING
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ACCBlocks.CORK_MOSAIC.get(), 1)
                .define('#', ACBlocks.CORK_SLAB.get())
                .pattern("#")
                .pattern("#")
                .unlockedBy("unlock", has(ACBlocks.CORK_SLAB.get()))
                .save(exporter);

        stairBuilder(ACCBlocks.CORK_MOSAIC_STAIRS.get(),
                Ingredient.of(ACCBlocks.CORK_MOSAIC.get()))
                .unlockedBy("unlock", has(ACCBlocks.CORK_MOSAIC.get()))
                .save(exporter);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ACCBlocks.CORK_MOSAIC_SLAB.get(),
                Ingredient.of(ACCBlocks.CORK_MOSAIC.get()))
                .unlockedBy("unlock", has(ACCBlocks.CORK_MOSAIC.get()))
                .save(exporter);

       createVerticalStairsRecipe(ACCBlocks.CORK_MOSAIC_VERTICAL_STAIRS.get(), ACCBlocks.CORK_MOSAIC.get(), exporter);
       carpet(exporter, ACCBlocks.BLEACHED_KNITTED_CARPET.get(), ACCBlocks.BLEACHED_KNITTED_WOOL.get());
       eightDyeRecipe(ACCBlocks.BLEACHED_KNITTED_WOOL.get(), EBTags.Items.KNITTED_WOOL, ACItems.BLEACHDEW.get(), exporter);
       eightDyeRecipe(ACCBlocks.BLEACHED_KNITTED_CARPET.get(), EBTags.Items.KNITTED_CARPET, ACItems.BLEACHDEW.get(), exporter);
       for (DyeColor colour : DyeColor.values()) {
           eightDyeRecipe(EBBlocks.getDyedKnittedWools(colour.getId()), ACCBlocks.BLEACHED_KNITTED_WOOL.get(), DyeItem.byColor(colour), exporter);
           eightDyeRecipe(EBBlocks.getDyedKnittedCarpets(colour.getId()), ACCBlocks.BLEACHED_KNITTED_CARPET.get(), DyeItem.byColor(colour), exporter);
           createVerticalStairsRecipe(ACCBlocks.getDyedTerracottaShingleVerticalStairs(colour.getId()), ACBlocks.getDyedTerracottaShingles(colour.getId()), exporter);
           createVerticalStairsRecipe(ACCBlocks.getDyedSoapstoneVerticalStairs(colour.getId()), ACBlocks.getDyedSoapstone(colour.getId()), exporter);
           createVerticalStairsRecipe(ACCBlocks.getDyedPolishedSoapstoneVerticalStairs(colour.getId()), ACBlocks.getDyedPolishedSoapstone(colour.getId()), exporter);
           createVerticalStairsRecipe(ACCBlocks.getDyedSoapstoneBrickVerticalStairs(colour.getId()), ACBlocks.getDyedSoapstoneBricks(colour.getId()), exporter);
           createVerticalStairsRecipe(ACCBlocks.getDyedMudBrickVerticalStairs(colour.getId()), ACBlocks.getDyedMudBricks(colour.getId()), exporter);
       }
       twoByTwoRecipe(ACCBlocks.BLEACHED_KNITTED_WOOL.get(), ACBlocks.BLEACHED_WOOL.get(), 4, exporter);
       twoByTwoRecipe(ACCBlocks.CORK_CRAFTING_TABLE.get(), ACBlocks.CORK_PLANKS.get(), 1, exporter);
       twoByTwoRecipe(ACCBlocks.CHISELED_CORK_PLANKS.get(), ACBlocks.CORK_SLAB.get(), 2, exporter);
       createShelfBlock(ACCBlocks.CORK_BOOKSHELF.get(), 1, Ingredient.of(ACBlocks.CORK_PLANKS.get()), Ingredient.of(Items.BOOK), exporter);
       createShelfBlock(ACCBlocks.CORK_DECORATIVE_SHELF.get(), 1, Ingredient.of(ACCBlocks.CORK_MOSAIC.get()), Ingredient.of(Items.BOOK), exporter);
       createLadderRecipe(ACCBlocks.CORK_LADDER.get(), ACBlocks.CORK_PLANKS.get(), exporter);
       createVerticalStairsRecipe(ACCBlocks.TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get(), ACBlocks.TERRACOTTA_SHINGLES.get(), exporter);
       createVerticalStairsRecipe(ACCBlocks.SOAPSTONE_VERTICAL_STAIRS.get(), ACBlocks.SOAPSTONE.get(), exporter);
       createVerticalStairsRecipe(ACCBlocks.GYPSUM_VERTICAL_STAIRS.get(), ACBlocks.GYPSUM.get(), exporter);
       createVerticalStairsRecipe(ACCBlocks.POLISHED_GYPSUM_VERTICAL_STAIRS.get(), ACBlocks.POLISHED_GYPSUM.get(), exporter);
       createVerticalStairsRecipe(ACCBlocks.GYPSUM_BRICK_VERTICAL_STAIRS.get(), ACBlocks.GYPSUM_BRICKS.get(), exporter);
       createVerticalStairsRecipe(ACCBlocks.POLISHED_SOAPSTONE_VERTICAL_STAIRS.get(), ACBlocks.POLISHED_SOAPSTONE.get(), exporter);
       createVerticalStairsRecipe(ACCBlocks.SOAPSTONE_BRICK_VERTICAL_STAIRS.get(), ACBlocks.SOAPSTONE_BRICKS.get(), exporter);
    }

    protected static void typeRecipe(Block craftingBlock, Block resultBlock, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,4)
                .pattern("KK")
                .pattern("KK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }

    protected static void stairRecipe(Block craftingBlock, Block resultBlock, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,4)
                .pattern("K  ")
                .pattern("KK ")
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }

    protected static void slabRecipe(Block craftingBlock, Block resultBlock, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,6)
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }

    protected static void wallRecipe(Block craftingBlock, Block resultBlock, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,6)
                .pattern("KKK")
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }

    protected static void paintbrushRecipe(DyeColor dyeColour, PaintbrushItem paintbrushItem, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, paintbrushItem, 1)
                .pattern("KK")
                .pattern("KQ")
                .define('K', DyeItem.byColor(dyeColour))
                .define('Q', Items.BRUSH)
                .group("paintbrush")
                .unlockedBy(getItemName(DyeItem.byColor(dyeColour)), has(DyeItem.byColor(dyeColour)))
                .save(recipeConsumer);
    }

    public void createShelfBlock(ItemLike output, int count, Ingredient input, Ingredient input2, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, output, count)
                .define('#', input).define('@', input2)
                .pattern("###")
                .pattern("@@@")
                .pattern("###")
                .unlockedBy("unlock", has(Items.BOOK))
                .save(exporter);
    }

    public void createVerticalStairsRecipe(ItemLike output, ItemLike input, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .unlockedBy("unlock", has(input))
                .define('#', input)
                .pattern("###")
                .pattern("## ")
                .pattern("#  ")
                .save(exporter);
    }

    public void twoByTwoRecipe(ItemLike output, ItemLike input, int count, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, count)
                .unlockedBy("unlock", has(input))
                .define('#', input)
                .pattern("##")
                .pattern("##")
                .save(exporter);
    }

    public void eightDyeRecipe(ItemLike output, TagKey<Item> input, ItemLike dye, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 8)
                .unlockedBy("unlock", has(input))
                .define('#', input)
                .define('K', dye)
                .pattern("###")
                .pattern("#K#")
                .pattern("###")
                .save(exporter, getItemName(output) + "_dye_recipe");
    }

    public void eightDyeRecipe(ItemLike output, ItemLike input, ItemLike dye, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 8)
                .unlockedBy("unlock", has(input))
                .define('#', input)
                .define('K', dye)
                .pattern("###")
                .pattern("#K#")
                .pattern("###")
                .save(exporter, getItemName(output) + "_dye_recipe");
    }

    public void createLadderRecipe(ItemLike output, ItemLike input, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, output, 8)
                .define('#', Ingredient.of(Items.STICK)).define('@', input)
                .pattern("# #")
                .pattern("#@#")
                .pattern("# #")
                .unlockedBy("unlock", has(input))
                .save(exporter);
    }

    protected static void bleachBlock(Consumer<FinishedRecipe> p_289666_,  List<Item> p_289675_, ItemLike bleachedBlock, String p_289641_) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, bleachedBlock)
                .requires(Ingredient.of(p_289675_.stream().map(ItemStack::new)))
                .requires(ACItems.BLEACHDEW.get())
                .group(p_289641_)
                .unlockedBy("has_needed_dye", has(ACItems.BLEACHDEW.get())).save(p_289666_, "arts_and_crafts:" + "bleach_" + p_289641_);
    }

    protected static void bleachBlockAlt(Consumer<FinishedRecipe> p_289666_, List<Item> itemList, ItemLike bleachedBlock, String string) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bleachedBlock, 8)
                .pattern("KKK")
                .pattern("KQK")
                .pattern("KKK")
                .define('K', Ingredient.of(itemList.stream().map(ItemStack::new)))
                .define('Q', ACItems.BLEACHDEW.get())
                .group(string)
                .unlockedBy("has_needed_dye", has(ACItems.BLEACHDEW.get())).save(p_289666_, "arts_and_crafts:" + "bleach_" + string);
    }

}
