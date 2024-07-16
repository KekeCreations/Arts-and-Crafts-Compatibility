package com.kekecreations.arts_and_crafts_compatibility.client;

import com.kekecreations.arts_and_crafts_compatibility.FabricArtsAndCraftsCompatibility;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.ecologics.EBlocks;
import com.kekecreations.arts_and_crafts_compatibility.compat.caffeinated.CaffeinatedBlocks;
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
            if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.CAFFEINATED)) {
                BlockRenderLayerMap.INSTANCE.putBlock(CaffeinatedBlocks.getDyedPottedCoffeeShrub(colour), RenderType.cutout());
            }
            if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.ECOLOGICS)) {
                BlockRenderLayerMap.INSTANCE.putBlock(EBlocks.getDyedPottedWalnutSapling(colour), RenderType.cutout());
                BlockRenderLayerMap.INSTANCE.putBlock(EBlocks.getDyedPottedAzaleaFlower(colour), RenderType.cutout());
            }
        }
    }
}
