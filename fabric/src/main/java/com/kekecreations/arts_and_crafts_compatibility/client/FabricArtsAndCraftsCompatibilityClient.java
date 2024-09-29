package com.kekecreations.arts_and_crafts_compatibility.client;

import com.kekecreations.arts_and_crafts_compatibility.core.registry.EcologicsRegistry;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ExcessiveBuildingCompatRegistry;
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
            BlockRenderLayerMap.INSTANCE.putBlock(EcologicsRegistry.getDyedPottedWalnutSapling(colour), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(EcologicsRegistry.getDyedPottedAzaleaFlower(colour), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(EcologicsRegistry.getDyedPottedCoconutSeedling(colour), RenderType.cutout());

            BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingCompatRegistry.getDyedPottedAncientSapling(colour.getId()), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingCompatRegistry.getDyedPottedGloomSapling(colour.getId()), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingCompatRegistry.getDyedPottedRose(colour.getId()), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingCompatRegistry.getDyedPottedWhiteRose(colour.getId()), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingCompatRegistry.getDyedPottedCyanRose(colour.getId()), RenderType.cutout());
        }
        BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingCompatRegistry.CORK_LADDER.get(), RenderType.cutout());
    }
}
