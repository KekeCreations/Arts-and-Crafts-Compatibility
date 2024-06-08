package com.kekecreations.arts_and_crafts_compatibility.compat;

import com.kekecreations.arts_and_crafts_compatibility.ArtsAndCraftsCompatibility;
import com.kekecreations.arts_and_crafts_compatibility.FabricArtsAndCraftsCompatibility;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.CompatUtils;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class FabricArtsAndCraftsCompatResourcePacks {
    private static void registerBuiltinResourcePack(ModContainer modContainer, String forModID) {
        ResourceManagerHelper.registerBuiltinResourcePack(
                new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, forModID + "_resource_pack"),
                modContainer,
                Component.translatable("pack." + ArtsAndCraftsCompatibility.MOD_ID + "." + forModID),
                ResourcePackActivationType.ALWAYS_ENABLED
        );
    }
    private static void registerBuiltinDataPack(ModContainer modContainer, String packId) {
        ResourceManagerHelper.registerBuiltinResourcePack(
                new ResourceLocation(ArtsAndCraftsCompatibility.MOD_ID, packId + "_datapack"),
                modContainer,
                Component.translatable("pack." + ArtsAndCraftsCompatibility.MOD_ID + "." + packId),
                ResourcePackActivationType.ALWAYS_ENABLED
        );
    }

    public static void loadBuiltinResourcePacks() {
        Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(ArtsAndCraftsCompatibility.MOD_ID);
        if (modContainer.isPresent()) {
            if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.GILDED_SHERDS)) {
                registerBuiltinResourcePack(modContainer.get(), CompatUtils.GILDED_SHERDS);
                registerBuiltinDataPack(modContainer.get(), CompatUtils.GILDED_SHERDS);
            }
        }
    }
}
