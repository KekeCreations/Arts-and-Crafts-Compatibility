package com.kekecreations.arts_and_crafts_compatibility.event;

import com.kekecreations.arts_and_crafts_compatibility.ArtsAndCraftsCompatibility;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(modid = ArtsAndCraftsCompatibility.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LoadResourcePacksEvent {


    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        System.out.println("ADD PACK FINDERS WORKS");
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            var resourcePath = ModList.get().getModFileById(ArtsAndCraftsCompatibility.MOD_ID).getFile().findResource("gildedsherds_resource_pack");
            var pack = Pack.readMetaAndCreate("builtin/add_pack_finders_test", Component.literal("display name"), false,
                    (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
            event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
        }
    }
}
