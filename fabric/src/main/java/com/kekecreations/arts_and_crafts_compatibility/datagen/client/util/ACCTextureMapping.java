package com.kekecreations.arts_and_crafts_compatibility.datagen.client.util;

import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;

public class ACCTextureMapping {

    public static TextureMapping flowerPotTextureMappings(String modID, String plant, DyeColor colour) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, getFlowerPotTexture(colour))
                .put(ACCTextureSlots.FLOWER_POT, getFlowerPotTexture(colour))
                .put(TextureSlot.PLANT, getPlantTexture(plant, modID));
    }

    public static ResourceLocation getPlantTexture(String plant, String modID) {
        //ResourceLocation resourceLocation = BuiltInRegistries.BLOCK.getKey(plant);
        return new ResourceLocation(modID, "block/" + plant);
    }

    public static ResourceLocation getFlowerPotTexture(DyeColor colour) {
        return new ResourceLocation("arts_and_crafts:block/" + colour.getName() + "_flower_pot");
    }
}
