package com.kekecreations.arts_and_crafts_compatibility.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class ACCRecipeProvider extends FabricRecipeProvider {

    public ACCRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        //TWIGS
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ACCBlocks.CORK_TABLE.get())
                .pattern("___")
                .pattern("0 0")
                .pattern("0 0")
                .define('_', ACBlocks.CORK_SLAB.get())
                .define('0', ACBlocks.CORK_FENCE.get())
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

    }
}
