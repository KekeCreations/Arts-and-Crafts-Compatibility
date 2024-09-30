package com.kekecreations.arts_and_crafts_compatibility;

import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCEntityTypes;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import net.minecraft.SharedConstants;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.forgespi.language.IModFileInfo;

import java.nio.file.Path;


@Mod.EventBusSubscriber(modid = ArtsAndCraftsCompatibility.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeArtsAndCraftsCompatibilityClient {


    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Entity Renderers
        event.registerEntityRenderer(ACCEntityTypes.ENTITY_FOR_SITTING.get(), NoopRenderer::new);
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        for (DyeColor colour : DyeColor.values()) {
            if (ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.ECOLOGICS)) {
                ItemBlockRenderTypes.setRenderLayer(ACCBlocks.getDyedPottedWalnutSapling(colour), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ACCBlocks.getDyedPottedAzaleaFlower(colour), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ACCBlocks.getDyedPottedCoconutSeedling(colour), RenderType.cutout());
            }
        }
    }

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        if (Services.PLATFORM.isModLoaded(CompatUtils.TWIGS)) {
            if (event.getPackType() == PackType.SERVER_DATA) {
                bpTwigs(event);
            }
        }
    }


    private static void bpTwigs(AddPackFindersEvent event) {
        IModFileInfo mod = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID);
        Path file = mod.getFile().findResource("resourcepacks/twigs_datapack");
        event.addRepositorySource((packConsumer) ->
                packConsumer.accept(Pack.create(
                        "twigs_datapack",
                        Component.literal("Twigs Compatibility Data Pack"),
                        false,
                        (path) -> new PathPackResources(path, file, true),
                        new Pack.Info(Component.literal("Arts & Crafts Compat features for Twigs"), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA), FeatureFlagSet.of()),
                        PackType.SERVER_DATA, Pack.Position.TOP, true, PackSource.BUILT_IN)));
    }
}