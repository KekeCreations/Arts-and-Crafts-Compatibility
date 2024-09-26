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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.ItemLike;

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
}
