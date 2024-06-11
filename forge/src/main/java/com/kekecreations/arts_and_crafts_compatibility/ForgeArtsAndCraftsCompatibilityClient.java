package com.kekecreations.arts_and_crafts_compatibility;

import com.kekecreations.arts_and_crafts_compatibility.common.compat.CompatUtils;
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
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            rpGildedSherds(event);
            rpOhMySherd(event);
            rpBuilt(event);
            rpFarmerDelight(event);
            rpTwigs(event);
            rpDecorativeBlocks(event);
            rpNeapolitan(event);
        }
        if (event.getPackType() == PackType.SERVER_DATA) {
            bpGildedSherds(event);
            bpBuilt(event);
            bpFarmerDelight(event);
            bpTwigs(event);
            bpDecorativeBlocks(event);
        }
    }
    private static void rpGildedSherds(AddPackFindersEvent event) {
        IModFileInfo mod = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID);
        Path file = mod.getFile().findResource("resourcepacks/gildedsherds_resource_pack");
        event.addRepositorySource((packConsumer) ->
                packConsumer.accept(Pack.create(
                        "arts_and_crafts_compat:gildedsherds_resource_pack",
                        Component.literal("Gilded Sherds Compatibility Resource Pack"),
                        ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.GILDED_SHERDS),
                        (path) -> new PathPackResources(path, file, ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.GILDED_SHERDS)),
                        new Pack.Info(Component.literal("Gilded Sherds Compatibility Resource Pack"), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES), FeatureFlagSet.of()),
                        PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, false, PackSource.BUILT_IN)));
    }
    private static void bpGildedSherds(AddPackFindersEvent event) {
        IModFileInfo mod = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID);
        Path file = mod.getFile().findResource("resourcepacks/gildedsherds_datapack");
        event.addRepositorySource((packConsumer) ->
                packConsumer.accept(Pack.create(
                        "arts_and_crafts_compat:gildedsherds_datapack",
                        Component.literal("GildedSherds Compatibility Data Pack"),
                        ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.GILDED_SHERDS),
                        (path) -> new PathPackResources(path, file, ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.GILDED_SHERDS)),
                        new Pack.Info(Component.literal("GildedSherds Compatibility Data Pack"), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA), FeatureFlagSet.of()),
                        PackType.SERVER_DATA, Pack.Position.BOTTOM, false, PackSource.BUILT_IN)));
    }

    private static void rpOhMySherd(AddPackFindersEvent event) {
        IModFileInfo mod = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID);
        Path file = mod.getFile().findResource("resourcepacks/ohmysherd_resource_pack");
        event.addRepositorySource((packConsumer) ->
                packConsumer.accept(Pack.create(
                        "arts_and_crafts_compat:ohmysherd_resource_pack",
                        Component.literal("Oh My Sherd Compatibility Resource Pack"),
                        ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.OH_MY_SHERD),
                        (path) -> new PathPackResources(path, file, ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.OH_MY_SHERD)),
                        new Pack.Info(Component.literal("Oh My Sherd Compatibility Resource Pack"), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES), FeatureFlagSet.of()),
                        PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, false, PackSource.BUILT_IN)));
    }

    private static void rpBuilt(AddPackFindersEvent event) {
        IModFileInfo mod = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID);
        Path file = mod.getFile().findResource("resourcepacks/built_resource_pack");
        event.addRepositorySource((packConsumer) ->
                packConsumer.accept(Pack.create(
                        "arts_and_crafts_compat:built_resource_pack",
                        Component.literal("Built Compatibility Resource Pack"),
                        ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.BUILT),
                        (path) -> new PathPackResources(path, file, ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.BUILT)),
                        new Pack.Info(Component.literal("Built Compatibility Resource Pack"), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES), FeatureFlagSet.of()),
                        PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, false, PackSource.BUILT_IN)));
    }
    private static void bpBuilt(AddPackFindersEvent event) {
        IModFileInfo mod = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID);
        Path file = mod.getFile().findResource("resourcepacks/built_datapack");
        event.addRepositorySource((packConsumer) ->
                packConsumer.accept(Pack.create(
                        "arts_and_crafts_compat:built_datapack",
                        Component.literal("Built Compatibility Data Pack"),
                        ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.BUILT),
                        (path) -> new PathPackResources(path, file, ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.BUILT)),
                        new Pack.Info(Component.literal("Built Compatibility Data Pack"), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA), FeatureFlagSet.of()),
                        PackType.SERVER_DATA, Pack.Position.BOTTOM, false, PackSource.BUILT_IN)));
    }

    private static void rpFarmerDelight(AddPackFindersEvent event) {
        IModFileInfo mod = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID);
        Path file = mod.getFile().findResource("resourcepacks/farmersdelight_resource_pack");
        event.addRepositorySource((packConsumer) ->
                packConsumer.accept(Pack.create(
                        "arts_and_crafts_compat:farmersdelight_resource_pack",
                        Component.literal("Farmer's Delight Compatibility Resource Pack"),
                        ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.FARMERS_DELIGHT),
                        (path) -> new PathPackResources(path, file, ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.FARMERS_DELIGHT)),
                        new Pack.Info(Component.literal("Farmer's Delight Compatibility Resource Pack"), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES), FeatureFlagSet.of()),
                        PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, false, PackSource.BUILT_IN)));
    }
    private static void bpFarmerDelight(AddPackFindersEvent event) {
        IModFileInfo mod = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID);
        Path file = mod.getFile().findResource("resourcepacks/built_datapack");
        event.addRepositorySource((packConsumer) ->
                packConsumer.accept(Pack.create(
                        "arts_and_crafts_compat:built_datapack",
                        Component.literal("Built Compatibility Data Pack"),
                        ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.BUILT),
                        (path) -> new PathPackResources(path, file, ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.BUILT)),
                        new Pack.Info(Component.literal("Built Compatibility Data Pack"), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA), FeatureFlagSet.of()),
                        PackType.SERVER_DATA, Pack.Position.BOTTOM, false, PackSource.BUILT_IN)));
    }

    private static void rpTwigs(AddPackFindersEvent event) {
        IModFileInfo mod = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID);
        Path file = mod.getFile().findResource("resourcepacks/twigs_resource_pack");
        event.addRepositorySource((packConsumer) ->
                packConsumer.accept(Pack.create(
                        "arts_and_crafts_compat:twigs_resource_pack",
                        Component.literal("Twigs Compatibility Resource Pack"),
                        ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.TWIGS),
                        (path) -> new PathPackResources(path, file, ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.TWIGS)),
                        new Pack.Info(Component.literal("Twigs Compatibility Resource Pack"), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES), FeatureFlagSet.of()),
                        PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, false, PackSource.BUILT_IN)));
    }
    private static void bpTwigs(AddPackFindersEvent event) {
        IModFileInfo mod = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID);
        Path file = mod.getFile().findResource("resourcepacks/twigs_datapack");
        event.addRepositorySource((packConsumer) ->
                packConsumer.accept(Pack.create(
                        "arts_and_crafts_compat:twigs_datapack",
                        Component.literal("Twigs Compatibility Data Pack"),
                        ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.TWIGS),
                        (path) -> new PathPackResources(path, file, ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.TWIGS)),
                        new Pack.Info(Component.literal("Twigs Compatibility Data Pack"), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA), FeatureFlagSet.of()),
                        PackType.SERVER_DATA, Pack.Position.BOTTOM, false, PackSource.BUILT_IN)));
    }

    private static void rpDecorativeBlocks(AddPackFindersEvent event) {
        IModFileInfo mod = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID);
        Path file = mod.getFile().findResource("resourcepacks/decorative_blocks_resource_pack");
        event.addRepositorySource((packConsumer) ->
                packConsumer.accept(Pack.create(
                        "arts_and_crafts_compat:decorative_blocks_resource_pack",
                        Component.literal("Decorative Blocks Compatibility Resource Pack"),
                        ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.DECORATIVE_BLOCKS),
                        (path) -> new PathPackResources(path, file, ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.DECORATIVE_BLOCKS)),
                        new Pack.Info(Component.literal("Decorative Blocks Compatibility Resource Pack"), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES), FeatureFlagSet.of()),
                        PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, false, PackSource.BUILT_IN)));
    }
    private static void bpDecorativeBlocks(AddPackFindersEvent event) {
        IModFileInfo mod = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID);
        Path file = mod.getFile().findResource("resourcepacks/decorative_blocks_datapack");
        event.addRepositorySource((packConsumer) ->
                packConsumer.accept(Pack.create(
                        "arts_and_crafts_compat:decorative_blocks_datapack",
                        Component.literal("Decorative Blocks Compatibility Data Pack"),
                        ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.DECORATIVE_BLOCKS),
                        (path) -> new PathPackResources(path, file, ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.DECORATIVE_BLOCKS)),
                        new Pack.Info(Component.literal("Decorative Blocks Compatibility Data Pack"), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA), FeatureFlagSet.of()),
                        PackType.SERVER_DATA, Pack.Position.BOTTOM, false, PackSource.BUILT_IN)));
    }

    private static void rpNeapolitan(AddPackFindersEvent event) {
        IModFileInfo mod = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID);
        Path file = mod.getFile().findResource("resourcepacks/neapolitan_resource_pack");
        event.addRepositorySource((packConsumer) ->
                packConsumer.accept(Pack.create(
                        "arts_and_crafts_compat:neapolitan_resource_pack",
                        Component.literal("Neapolitan Compatibility Resource Pack"),
                        ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.NEAPOLITAN),
                        (path) -> new PathPackResources(path, file, ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.NEAPOLITAN)),
                        new Pack.Info(Component.literal("Neapolitan Compatibility Resource Pack"), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES), FeatureFlagSet.of()),
                        PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, false, PackSource.BUILT_IN)));
    }
}