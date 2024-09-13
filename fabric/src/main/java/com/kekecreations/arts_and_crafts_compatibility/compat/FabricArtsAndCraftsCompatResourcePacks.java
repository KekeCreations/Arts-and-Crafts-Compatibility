package com.kekecreations.arts_and_crafts_compatibility.compat;

import com.kekecreations.arts_and_crafts_compatibility.ArtsAndCraftsCompatibility;
import com.kekecreations.arts_and_crafts_compatibility.FabricArtsAndCraftsCompatibility;
import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
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
            if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.FARMERS_DELIGHT)) {
                registerBuiltinResourcePack(modContainer.get(), CompatUtils.FARMERS_DELIGHT);
                registerBuiltinDataPack(modContainer.get(), CompatUtils.FARMERS_DELIGHT);
            }
            if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.TWIGS)) {
                registerBuiltinResourcePack(modContainer.get(), CompatUtils.TWIGS);
                registerBuiltinDataPack(modContainer.get(), CompatUtils.TWIGS);
            }
            if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.CAFFEINATED)) {
                registerBuiltinResourcePack(modContainer.get(), CompatUtils.CAFFEINATED);
                registerBuiltinDataPack(modContainer.get(), CompatUtils.CAFFEINATED);
            }
            if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.DECORATIVE_BLOCKS)) {
                registerBuiltinResourcePack(modContainer.get(), CompatUtils.DECORATIVE_BLOCKS);
                registerBuiltinDataPack(modContainer.get(), CompatUtils.DECORATIVE_BLOCKS);
            }
            if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.YAPPING_TOOLTIPS)) {
                registerBuiltinResourcePack(modContainer.get(), CompatUtils.YAPPING_TOOLTIPS);
            }
            if (FabricArtsAndCraftsCompatibility.isModLoaded(CompatUtils.DRAMATIC_DOORS)) {
                registerBuiltinResourcePack(modContainer.get(), CompatUtils.DRAMATIC_DOORS);
                registerBuiltinDataPack(modContainer.get(), CompatUtils.DRAMATIC_DOORS);
            }
        }
    }
}
