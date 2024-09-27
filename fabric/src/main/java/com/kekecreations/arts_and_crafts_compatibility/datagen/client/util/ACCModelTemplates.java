package com.kekecreations.arts_and_crafts_compatibility.datagen.client.util;

import com.kekecreations.arts_and_crafts_compatibility.ArtsAndCraftsCompatibility;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class ACCModelTemplates {
    public static final ModelTemplate VERTICAL_STAIRS;
    public static final ModelTemplate LADDER;

    public static final ModelTemplate FLOWER_POT = createFlowerPot(TextureSlot.PARTICLE, ACCTextureSlots.FLOWER_POT, TextureSlot.PLANT);


    public static ModelTemplate createFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(new ResourceLocation("minecraft", "block/flower_pot_cross"))), Optional.empty(), textureSlots);
    }

    static {
        VERTICAL_STAIRS = new ModelTemplate(Optional.of(ResourceLocation.tryBuild(ArtsAndCraftsCompatibility.MOD_ID, "template_vertical_stairs").withPrefix("template/credit_to_yirmiri/")), Optional.empty(), new TextureSlot[]{TextureSlot.TEXTURE, TextureSlot.PARTICLE});
        LADDER = new ModelTemplate(Optional.of(ResourceLocation.tryBuild(ArtsAndCraftsCompatibility.MOD_ID, "template_ladder").withPrefix("template/credit_to_yirmiri/")), Optional.empty(), new TextureSlot[]{TextureSlot.TEXTURE, TextureSlot.PARTICLE});
    }
}
