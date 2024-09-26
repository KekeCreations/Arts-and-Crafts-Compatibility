package com.kekecreations.arts_and_crafts_compatibility.client;

import com.kekecreations.arts_and_crafts_compatibility.FabricArtsAndCraftsCompatibility;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
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
            if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.ECOLOGICS)) {
                BlockRenderLayerMap.INSTANCE.putBlock(ACCBlocks.getDyedPottedWalnutSapling(colour), RenderType.cutout());
                BlockRenderLayerMap.INSTANCE.putBlock(ACCBlocks.getDyedPottedAzaleaFlower(colour), RenderType.cutout());
                BlockRenderLayerMap.INSTANCE.putBlock(ACCBlocks.getDyedPottedCoconutSeedling(colour), RenderType.cutout());
            }
        }
    }
}
