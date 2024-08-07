package com.kekecreations.arts_and_crafts_compatibility.datagen.client.util;

import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class ACCModelTemplates {

    public static final ModelTemplate FLOWER_POT = createFlowerPot(TextureSlot.PARTICLE, ACCTextureSlots.FLOWER_POT, TextureSlot.PLANT);


    public static ModelTemplate createFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(new ResourceLocation("minecraft", "block/flower_pot_cross"))), Optional.empty(), textureSlots);
    }
}
