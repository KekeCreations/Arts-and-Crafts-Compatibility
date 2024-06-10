package com.kekecreations.arts_and_crafts_compatibility.client;

import com.kekecreations.arts_and_crafts_compatibility.FabricArtsAndCraftsCompatibility;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.CompatUtils;
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
        if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.CAFFEINATED)) {
            for (DyeColor colours : DyeColor.values()) {
                BlockRenderLayerMap.INSTANCE.putBlock(CaffeinatedBlocks.getDyedPottedCoffeeShrub(colours), RenderType.cutout());
            }
        }
    }
}
