package com.kekecreations.arts_and_crafts_compatibility.client;

import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCFabricBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeColor;

@Environment(EnvType.CLIENT)
public class FabricArtsAndCraftsCompatibilityClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerBlockLayers();
    }


    public static void registerBlockLayers() {
        for (DyeColor colour : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(ACCBlocks.getDyedPottedWalnutSapling(colour), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACCBlocks.getDyedPottedAzaleaFlower(colour), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACCBlocks.getDyedPottedCoconutSeedling(colour), RenderType.cutout());

            BlockRenderLayerMap.INSTANCE.putBlock(ACCFabricBlocks.getDyedPottedAncientSapling(colour.getId()), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACCFabricBlocks.getDyedPottedGloomSapling(colour.getId()), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACCFabricBlocks.getDyedPottedRose(colour.getId()), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACCFabricBlocks.getDyedPottedWhiteRose(colour.getId()), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACCFabricBlocks.getDyedPottedCyanRose(colour.getId()), RenderType.cutout());
        }
        BlockRenderLayerMap.INSTANCE.putBlock(ACCFabricBlocks.CORK_LADDER.get(), RenderType.cutout());
    }
}
