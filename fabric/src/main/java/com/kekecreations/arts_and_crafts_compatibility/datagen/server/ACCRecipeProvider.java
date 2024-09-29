package com.kekecreations.arts_and_crafts_compatibility.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCFabricBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCFabricItems;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.yirmiri.excessive_building.registry.EBBlocks;
import net.yirmiri.excessive_building.util.EBTags;

import java.util.function.Consumer;

public class ACCRecipeProvider extends FabricRecipeProvider {

    public ACCRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        //DRAMATIC DOORS
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, ACCFabricItems.CORK_SHORT_DOOR.get(), ACBlocks.CORK_DOOR.get(), 2);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ACCFabricItems.TALL_CORK_DOOR.get(), 2)
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
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ACCFabricBlocks.CORK_MOSAIC.get(), 1)
                .define('#', ACBlocks.CORK_SLAB.get())
                .pattern("#")
                .pattern("#")
                .unlockedBy("unlock", has(ACBlocks.CORK_SLAB.get()))
                .save(exporter);

        stairBuilder(ACCFabricBlocks.CORK_MOSAIC_STAIRS.get(),
                Ingredient.of(ACCFabricBlocks.CORK_MOSAIC.get()))
                .unlockedBy("unlock", has(ACCFabricBlocks.CORK_MOSAIC.get()))
                .save(exporter);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ACCFabricBlocks.CORK_MOSAIC_SLAB.get(),
                Ingredient.of(ACCFabricBlocks.CORK_MOSAIC.get()))
                .unlockedBy("unlock", has(ACCFabricBlocks.CORK_MOSAIC.get()))
                .save(exporter);

       createVerticalStairsRecipe(ACCFabricBlocks.CORK_MOSAIC_VERTICAL_STAIRS.get(), ACCFabricBlocks.CORK_MOSAIC.get(), exporter);
       carpet(exporter, ACCFabricBlocks.BLEACHED_KNITTED_CARPET.get(), ACCFabricBlocks.BLEACHED_KNITTED_WOOL.get());
       eightDyeRecipe(ACCFabricBlocks.BLEACHED_KNITTED_WOOL.get(), EBTags.Items.KNITTED_WOOL, ACItems.BLEACHDEW.get(), exporter);
       eightDyeRecipe(ACCFabricBlocks.BLEACHED_KNITTED_CARPET.get(), EBTags.Items.KNITTED_CARPET, ACItems.BLEACHDEW.get(), exporter);
       for (DyeColor colour : DyeColor.values()) {
           eightDyeRecipe(EBBlocks.getDyedKnittedWools(colour.getId()), ACCFabricBlocks.BLEACHED_KNITTED_WOOL.get(), DyeItem.byColor(colour), exporter);
           eightDyeRecipe(EBBlocks.getDyedKnittedCarpets(colour.getId()), ACCFabricBlocks.BLEACHED_KNITTED_CARPET.get(), DyeItem.byColor(colour), exporter);
           createVerticalStairsRecipe(ACCFabricBlocks.getDyedTerracottaShingleVerticalStairs(colour.getId()), ACBlocks.getDyedTerracottaShingles(colour.getId()), exporter);
           createVerticalStairsRecipe(ACCFabricBlocks.getDyedSoapstoneVerticalStairs(colour.getId()), ACBlocks.getDyedSoapstone(colour.getId()), exporter);
           createVerticalStairsRecipe(ACCFabricBlocks.getDyedPolishedSoapstoneVerticalStairs(colour.getId()), ACBlocks.getDyedPolishedSoapstone(colour.getId()), exporter);
           createVerticalStairsRecipe(ACCFabricBlocks.getDyedSoapstoneBrickVerticalStairs(colour.getId()), ACBlocks.getDyedSoapstoneBricks(colour.getId()), exporter);
           createVerticalStairsRecipe(ACCFabricBlocks.getDyedMudBrickVerticalStairs(colour.getId()), ACBlocks.getDyedMudBricks(colour.getId()), exporter);
       }
       twoByTwoRecipe(ACCFabricBlocks.BLEACHED_KNITTED_WOOL.get(), ACBlocks.BLEACHED_WOOL.get(), 4, exporter);
       twoByTwoRecipe(ACCFabricBlocks.CORK_CRAFTING_TABLE.get(), ACBlocks.CORK_PLANKS.get(), 1, exporter);
       twoByTwoRecipe(ACCFabricBlocks.CHISELED_CORK_PLANKS.get(), ACBlocks.CORK_SLAB.get(), 2, exporter);
       createShelfBlock(ACCFabricBlocks.CORK_BOOKSHELF.get(), 1, Ingredient.of(ACBlocks.CORK_PLANKS.get()), Ingredient.of(Items.BOOK), exporter);
       createShelfBlock(ACCFabricBlocks.CORK_DECORATIVE_SHELF.get(), 1, Ingredient.of(ACCFabricBlocks.CORK_MOSAIC.get()), Ingredient.of(Items.BOOK), exporter);
       createLadderRecipe(ACCFabricBlocks.CORK_LADDER.get(), ACBlocks.CORK_PLANKS.get(), exporter);
       createVerticalStairsRecipe(ACCFabricBlocks.TERRACOTTA_SHINGLE_VERTICAL_STAIRS.get(), ACBlocks.TERRACOTTA_SHINGLES.get(), exporter);
       createVerticalStairsRecipe(ACCFabricBlocks.SOAPSTONE_VERTICAL_STAIRS.get(), ACBlocks.SOAPSTONE.get(), exporter);
       createVerticalStairsRecipe(ACCFabricBlocks.GYPSUM_VERTICAL_STAIRS.get(), ACBlocks.GYPSUM.get(), exporter);
       createVerticalStairsRecipe(ACCFabricBlocks.POLISHED_GYPSUM_VERTICAL_STAIRS.get(), ACBlocks.POLISHED_GYPSUM.get(), exporter);
       createVerticalStairsRecipe(ACCFabricBlocks.GYPSUM_BRICK_VERTICAL_STAIRS.get(), ACBlocks.GYPSUM_BRICKS.get(), exporter);
       createVerticalStairsRecipe(ACCFabricBlocks.POLISHED_SOAPSTONE_VERTICAL_STAIRS.get(), ACBlocks.POLISHED_SOAPSTONE.get(), exporter);
       createVerticalStairsRecipe(ACCFabricBlocks.SOAPSTONE_BRICK_VERTICAL_STAIRS.get(), ACBlocks.SOAPSTONE_BRICKS.get(), exporter);
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
}
