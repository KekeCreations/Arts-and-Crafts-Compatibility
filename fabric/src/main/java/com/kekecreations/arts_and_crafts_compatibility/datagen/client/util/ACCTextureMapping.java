package com.kekecreations.arts_and_crafts_compatibility.datagen.client.util;

import com.kekecreations.arts_and_crafts.common.block.ChalkDustBlock;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import net.leafenzo.mint.util.ModDyeColor;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

import static net.minecraft.data.models.model.TextureMapping.defaultTexture;
import static net.minecraft.data.models.model.TextureMapping.getBlockTexture;

public class ACCTextureMapping {

    public static TextureMapping flowerPotTextureMappings(String modID, String plant, DyeColor colour) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, getFlowerPotTexture(colour))
                .put(ACCTextureSlots.FLOWER_POT, getFlowerPotTexture(colour))
                .put(TextureSlot.PLANT, getPlantTexture(plant, modID));
    }

    public static TextureMapping chalkDustTextureMappings(ChalkDustBlock block) {
        ResourceLocation resourceLocation = new ResourceLocation("arts_and_crafts:block/" + "velvet_chalk");
        if (block.getChalkDustStates(block.defaultBlockState()) == 0) {
            resourceLocation = new ResourceLocation("arts_and_crafts:block/" + "mint_chalk");

        }
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, resourceLocation)
                .put(ACCTextureSlots.DUST, resourceLocation);
    }

    public static ResourceLocation getPlantTexture(String plant, String modID) {
        //ResourceLocation resourceLocation = BuiltInRegistries.BLOCK.getKey(plant);
        return new ResourceLocation(modID, "block/" + plant);
    }

    public static ResourceLocation getFlowerPotTexture(DyeColor colour) {
        return new ResourceLocation("arts_and_crafts:block/" + colour.getName() + "_flower_pot");
    }
}
