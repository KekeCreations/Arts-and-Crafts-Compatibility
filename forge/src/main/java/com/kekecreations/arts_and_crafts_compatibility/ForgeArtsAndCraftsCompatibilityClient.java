package com.kekecreations.arts_and_crafts_compatibility;

import com.kekecreations.arts_and_crafts_compatibility.common.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.SharedConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.forgespi.language.IModFileInfo;

import java.nio.file.Path;


@Mod.EventBusSubscriber(modid = ArtsAndCraftsCompatibility.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeArtsAndCraftsCompatibilityClient {

    @SubscribeEvent
    @SuppressWarnings("all")
    public static void clientSetup(FMLClientSetupEvent event) {
    }

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        if (Services.PLATFORM.isModLoaded(CompatUtils.BUILT)) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                rpBuilt(event);
            }
            if (event.getPackType() == PackType.SERVER_DATA) {
                bpBuilt(event);
            }
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.GILDED_SHERDS)) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                rpGildedSherds(event);
            }
            if (event.getPackType() == PackType.SERVER_DATA) {
                bpGildedSherds(event);
            }
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.OH_MY_SHERD)) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                rpOhMySherd(event);
            }
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.FARMERS_DELIGHT)) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                rpFarmerDelight(event);
            }
            if (event.getPackType() == PackType.SERVER_DATA) {
                bpFarmerDelight(event);
            }
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.TWIGS)) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                rpTwigs(event);
            }
            if (event.getPackType() == PackType.SERVER_DATA) {
                bpTwigs(event);
            }
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.DECORATIVE_BLOCKS)) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                rpDecorativeBlocks(event);
            }
            if (event.getPackType() == PackType.SERVER_DATA) {
                bpDecorativeBlocks(event);
            }
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.NEAPOLITAN)) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                rpNeapolitan(event);
            }
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.SPAWN)) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                rpSpawn(event);
            }
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.BIOME_MAKEOVER)) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                rpBiomeMakeover(event);
            }
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.ALEX_CAVES)) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                rpAlexCaves(event);
            }
        }
    }


    private static void rpGildedSherds(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/gildedsherds_resource_pack");
        var pack = Pack.readMetaAndCreate("builtin/gildedsherds_resource_pack", Component.literal("Gilded Sherds Compatibility Resource Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void bpGildedSherds(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/gildedsherds_datapack");
        var pack = Pack.readMetaAndCreate("builtin/gildedsherds_datapack", Component.literal("Gilded Sherds Compatibility Data Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.SERVER_DATA, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void rpOhMySherd(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/ohmysherd_resource_pack");
        var pack = Pack.readMetaAndCreate("builtin/ohmysherd_resource_pack", Component.literal("Oh My Sherd Compatibility Resource Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }


    private static void rpBuilt(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/built_resource_pack");
        var pack = Pack.readMetaAndCreate("builtin/built_resource_pack", Component.literal("Built Compatibility Resource Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void bpBuilt(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/built_datapack");
        var pack = Pack.readMetaAndCreate("builtin/built_datapack", Component.literal("Built Compatibility Data Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.SERVER_DATA, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void rpFarmerDelight(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/farmersdelight_resource_pack");
        var pack = Pack.readMetaAndCreate("builtin/farmersdelight_resource_pack", Component.literal("Farmer's Delight Compatibility Resource Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void bpFarmerDelight(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/farmersdelight_datapack");
        var pack = Pack.readMetaAndCreate("builtin/farmersdelight_datapack", Component.literal("Farmer's Delight Compatibility Data Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.SERVER_DATA, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void rpTwigs(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/twigs_resource_pack");
        var pack = Pack.readMetaAndCreate("builtin/twigs_resource_pack", Component.literal("Twigs Compatibility Resource Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void bpTwigs(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/twigs_datapack");
        var pack = Pack.readMetaAndCreate("builtin/twigs_datapack", Component.literal("Twigs Compatibility Data Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.SERVER_DATA, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void rpDecorativeBlocks(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/decorative_blocks_resource_pack");
        var pack = Pack.readMetaAndCreate("builtin/decorative_blocks_resource_pack", Component.literal("Decorative Blocks Compatibility Resource Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void bpDecorativeBlocks(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/decorative_blocks_datapack");
        var pack = Pack.readMetaAndCreate("builtin/decorative_blocks_datapack", Component.literal("Decorative Blocks Compatibility Data Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.SERVER_DATA, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void rpNeapolitan(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/neapolitan_resource_pack");
        var pack = Pack.readMetaAndCreate("builtin/neapolitan_resource_pack", Component.literal("Neapolitan Compatibility Resource Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void rpSpawn(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/spawn_resource_pack");
        var pack = Pack.readMetaAndCreate("builtin/spawn_resource_pack", Component.literal("Spawn Compatibility Resource Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void rpBiomeMakeover(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/biomemakeover_resource_pack");
        var pack = Pack.readMetaAndCreate("builtin/biomemakeover_resource_pack", Component.literal("Biome Makeover Compatibility Resource Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void rpAlexCaves(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/alexcaves_resource_pack");
        var pack = Pack.readMetaAndCreate("builtin/alexcaves_resource_pack", Component.literal("Alex's Caves Compatibility Resource Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }
}