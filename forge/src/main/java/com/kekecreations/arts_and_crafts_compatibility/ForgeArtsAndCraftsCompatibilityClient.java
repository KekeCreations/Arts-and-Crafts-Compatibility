package com.kekecreations.arts_and_crafts_compatibility;

import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(modid = ArtsAndCraftsCompatibility.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeArtsAndCraftsCompatibilityClient {


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
        if (Services.PLATFORM.isModLoaded(CompatUtils.DRAMATIC_DOORS)) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                rpDramaticDoors(event);
            }
            if (event.getPackType() == PackType.SERVER_DATA) {
                bpDramaticDoors(event);
            }
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.COBBLEMON)) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                rpCobblemon(event);
            }
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.NETHER_EXPANSION)) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                rpNetherExpansion(event);
            }
        }
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


    private static void rpDramaticDoors(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/dramaticdoors_resource_pack");
        var pack = Pack.readMetaAndCreate("builtin/dramaticdoors_resource_pack", Component.literal("Dramatic Doors Compatibility Resource Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void bpDramaticDoors(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/dramaticdoors_datapack");
        var pack = Pack.readMetaAndCreate("builtin/dramaticdoors_datapack", Component.literal("Dramatic Doors Compatibility Data Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.SERVER_DATA, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void rpCobblemon(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/cobblemon_resource_pack");
        var pack = Pack.readMetaAndCreate("builtin/cobblemon_resource_pack", Component.literal("Cobblemon Compatibility Resource Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private static void rpNetherExpansion(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/netherexp_resource_pack");
        var pack = Pack.readMetaAndCreate("builtin/netherexp_resource_pack", Component.literal("Nether Expansion Compatibility Resource Pack"), true,
                (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }
}