package com.kekecreations.arts_and_crafts_compatibility;

import com.kekecreations.arts_and_crafts_compatibility.common.compat.CompatUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(modid = ArtsAndCraftsCompatibility.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeArtsAndCraftsCompatibilityClient {

    @SubscribeEvent
    @SuppressWarnings("all")
    public static void clientSetup(FMLClientSetupEvent event) {
    }

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            gildedsherds_res_compat(event);
            ohmysherd_res_compat(event);
        }
        if (event.getPackType() == PackType.SERVER_DATA) {
            gildedsherds_data_compat(event);
        }
    }
    //GILDED SHERDS
    public static void gildedsherds_res_compat(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/gildedsherds_resource_pack");
        var pack = Pack.readMetaAndCreate("builtin/gildedsherds_resource_pack", Component.literal("GildedSherds Compatibility Resource Pack"), ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.GILDED_SHERDS),
                (path) -> new PathPackResources(path, resourcePath, ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.GILDED_SHERDS)), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }
    public static void gildedsherds_data_compat(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/gildedsherds_datapack");
        var pack = Pack.readMetaAndCreate("builtin/gildedsherds_data_pack", Component.literal("GildedSherds Compatibility Data Pack"), ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.GILDED_SHERDS),
                (path) -> new PathPackResources(path, resourcePath, ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.GILDED_SHERDS)), PackType.SERVER_DATA, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }
    //OH MY SHERD
    public static void ohmysherd_res_compat(AddPackFindersEvent event) {
        var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("resourcepacks/ohmysherd_resource_pack");
        var pack = Pack.readMetaAndCreate("builtin/ohmysherd_resource_pack", Component.literal("Oh My Sherd Compatibility Resource Pack"), ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.OH_MY_SHERD),
                (path) -> new PathPackResources(path, resourcePath, ForgeArtsAndCraftsCompatibility.isModLoaded(CompatUtils.OH_MY_SHERD)), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }
}