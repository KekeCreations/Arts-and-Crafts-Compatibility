package com.kekecreations.arts_and_crafts_compatibility.datagen.client.util;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts_compatibility.ArtsAndCraftsCompatibility;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class ACCModelTemplates {
    public static final ModelTemplate VERTICAL_STAIRS;
    public static final ModelTemplate LADDER;
    public static final ModelTemplate PLASTER;

    public static final ModelTemplate FLOWER_POT = createFlowerPot(TextureSlot.PARTICLE, ACCTextureSlots.FLOWER_POT, TextureSlot.PLANT);
    public static final ModelTemplate TINTED_FLOWER_POT = createTintedFlowerPot(TextureSlot.PARTICLE, ACCTextureSlots.FLOWER_POT, TextureSlot.PLANT);
    public static final ModelTemplate EMPTY_FLOWER_POT = createEmptyFlowerPot(TextureSlot.PARTICLE, ACCTextureSlots.FLOWER_POT);
    public static final ModelTemplate CACTUS_FLOWER_POT = createCactusFlowerPot(TextureSlot.PARTICLE, ACCTextureSlots.FLOWER_POT);
    public static final ModelTemplate BAMBOO_FLOWER_POT = createBambooFlowerPot(TextureSlot.PARTICLE, ACCTextureSlots.FLOWER_POT);
    public static final ModelTemplate AZALEA_BUSH_FLOWER_POT = createAzaleaBushFlowerPot(TextureSlot.PARTICLE, ACCTextureSlots.FLOWER_POT);
    public static final ModelTemplate FLOWERING_AZALEA_BUSH_FLOWER_POT = createFloweringAzaleaBushFlowerPot(TextureSlot.PARTICLE, ACCTextureSlots.FLOWER_POT);
    public static final ModelTemplate MANGROVE_PROPAGULE_FLOWER_POT = createMangrovePropaguleFlowerPot(TextureSlot.PARTICLE, ACCTextureSlots.FLOWER_POT);

    public static ModelTemplate createEmptyFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(new ResourceLocation("minecraft", "block/flower_pot"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(new ResourceLocation("minecraft", "block/flower_pot_cross"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createCactusFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(new ResourceLocation("minecraft", "block/potted_cactus"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createMangrovePropaguleFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(new ResourceLocation("minecraft", "block/potted_mangrove_propagule"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createBambooFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(new ResourceLocation("minecraft", "block/potted_bamboo"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createAzaleaBushFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(new ResourceLocation("minecraft", "block/potted_azalea_bush"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createFloweringAzaleaBushFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(new ResourceLocation("minecraft", "block/potted_flowering_azalea_bush"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createTintedFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(new ResourceLocation("minecraft", "block/tinted_flower_pot_cross"))), Optional.empty(), textureSlots);
    }

    static {
        VERTICAL_STAIRS = new ModelTemplate(Optional.of(ResourceLocation.tryBuild(ArtsAndCraftsCompatibility.MOD_ID, "template_vertical_stairs").withPrefix("template/credit_to_yirmiri/")), Optional.empty(), new TextureSlot[]{TextureSlot.TEXTURE, TextureSlot.PARTICLE});
        LADDER = new ModelTemplate(Optional.of(ResourceLocation.tryBuild(ArtsAndCraftsCompatibility.MOD_ID, "template_ladder").withPrefix("template/credit_to_yirmiri/")), Optional.empty(), new TextureSlot[]{TextureSlot.TEXTURE, TextureSlot.PARTICLE});
        PLASTER = new ModelTemplate(Optional.of(ResourceLocation.tryBuild(ArtsAndCrafts.MOD_ID, "plaster_model").withPrefix("block/")), Optional.empty(), new TextureSlot[]{ACCTextureSlots.PLASTER, TextureSlot.PARTICLE});
    }
}
