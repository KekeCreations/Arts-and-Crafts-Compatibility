package com.kekecreations.arts_and_crafts_compatibility.client;

import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCEntityTypes;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCFabricBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.compat.EcologicsFlowerPots;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.compat.ExcessiveBuildingFlowerPots;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.world.item.DyeColor;

@Environment(EnvType.CLIENT)
public class FabricArtsAndCraftsCompatibilityClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerBlockLayers();
        registerRenderers();
    }

    private static void registerRenderers() {
        EntityRendererRegistry.register(ACCEntityTypes.ENTITY_FOR_SITTING.get(), NoopRenderer::new);
    }

    public static void registerBlockLayers() {
        for (DyeColor colour : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(EcologicsFlowerPots.getDyedPottedWalnutSapling(colour), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(EcologicsFlowerPots.getDyedPottedAzaleaFlower(colour), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(EcologicsFlowerPots.getDyedPottedCoconutSeedling(colour), RenderType.cutout());

            BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingFlowerPots.getDyedPottedAncientSapling(colour.getId()), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingFlowerPots.getDyedPottedGloomSapling(colour.getId()), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingFlowerPots.getDyedPottedRose(colour.getId()), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingFlowerPots.getDyedPottedWhiteRose(colour.getId()), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingFlowerPots.getDyedPottedCyanRose(colour.getId()), RenderType.cutout());
        }
        BlockRenderLayerMap.INSTANCE.putBlock(ACCFabricBlocks.CORK_LADDER.get(), RenderType.cutout());
    }
}
