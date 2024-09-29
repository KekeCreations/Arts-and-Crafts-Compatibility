package com.kekecreations.arts_and_crafts_compatibility;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.DBBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.ForgeRegistryHelper;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.DramaticDoorsCompatRegistry;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(ArtsAndCraftsCompatibility.MOD_ID)
public class ForgeArtsAndCraftsCompatibility {

    public ForgeArtsAndCraftsCompatibility() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ForgeRegistryHelper.SOUNDS.register(modEventBus);
        ForgeRegistryHelper.PARTICLE_TYPES.register(modEventBus);
        ForgeRegistryHelper.BLOCKS.register(modEventBus);
        ForgeRegistryHelper.ITEMS.register(modEventBus);

        ArtsAndCraftsCompatibility.init();
        if (isModLoaded(CompatUtils.DRAMATIC_DOORS)) {
            DramaticDoorsCompatRegistry.register();
        }

        modEventBus.addListener(this::creativeItemGroups);
    }

    public static boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    private void addAfter(BuildCreativeModeTabContentsEvent event, Item beforeItem, Item item) {
        event.getEntries().putAfter(beforeItem.getDefaultInstance(), item.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
    private void addAfter(BuildCreativeModeTabContentsEvent event, Block beforeItem, Item item) {
        event.getEntries().putAfter(beforeItem.asItem().getDefaultInstance(), item.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
    private void addAfter(BuildCreativeModeTabContentsEvent event, Item beforeItem, Block item) {
        event.getEntries().putAfter(beforeItem.getDefaultInstance(), item.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
    private void addAfter(BuildCreativeModeTabContentsEvent event, Block beforeItem, Block item) {
        event.getEntries().putAfter(beforeItem.asItem().getDefaultInstance(), item.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    private void addBefore(BuildCreativeModeTabContentsEvent event, Block beforeItem, Block item) {
        event.getEntries().putBefore(beforeItem.asItem().getDefaultInstance(), item.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
    private void addBefore(BuildCreativeModeTabContentsEvent event, Item beforeItem, Item item) {
        event.getEntries().putBefore(beforeItem.getDefaultInstance(), item.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }


    public void creativeItemGroups(BuildCreativeModeTabContentsEvent event) {
        if (isModLoaded(CompatUtils.GILDED_SHERDS)) {
            if (event.getTabKey() == ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CompatUtils.GILDED_SHERDS, "tab"))) {
                event.accept(ACCItems.GILDED_FINALE_POTTERY_SHERD.get());
                event.accept(ACCItems.GILDED_GATEWAY_POTTERY_SHERD.get());
                event.accept(ACCItems.GILDED_ROLL_POTTERY_SHERD.get());
                event.accept(ACCItems.GILDED_RUINED_POTTERY_SHERD.get());
            }
        }
        if (isModLoaded(CompatUtils.TWIGS)) {
            if (event.getTabKey() == ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CompatUtils.TWIGS, "twig"))) {
                addAfter(event, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CompatUtils.TWIGS, "acacia_table")), ACCBlocks.CORK_TABLE.get());
            }
        }
        if (isModLoaded(CompatUtils.FARMERS_DELIGHT)) {
            if (event.getTabKey() == ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CompatUtils.FARMERS_DELIGHT, "farmersdelight"))) {
                addAfter(event, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CompatUtils.FARMERS_DELIGHT, "acacia_cabinet")), ACCBlocks.CORK_CABINET.get());
            }
        }
        if (isModLoaded(CompatUtils.DECORATIVE_BLOCKS)) {
            if (event.getTabKey() == ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CompatUtils.DECORATIVE_BLOCKS, "general"))) {
                addAfter(event, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CompatUtils.DECORATIVE_BLOCKS, "acacia_seat")), ACCBlocks.CORK_SEAT.get());
                addAfter(event, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CompatUtils.DECORATIVE_BLOCKS, "acacia_support")), ACCBlocks.CORK_SUPPORT.get());
                addAfter(event, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CompatUtils.DECORATIVE_BLOCKS, "acacia_palisade")), DBBlocks.CORK_PALISADE.get());
                addAfter(event, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CompatUtils.DECORATIVE_BLOCKS, "acacia_beam")), ACCBlocks.CORK_BEAM.get());
            }
        }
        if (isModLoaded(CompatUtils.BUILT)) {
            if (event.getTabKey() == ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CompatUtils.BUILT, "built_tab"))) {
                addAfter(event, ForgeRegistries.ITEMS.getValue(new ResourceLocation(CompatUtils.BUILT, "acacia_shakes_slab")), ACCBlocks.CORK_COMPACT_PLANKS.get());
                addAfter(event, ACCBlocks.CORK_COMPACT_PLANKS.get(), ACCBlocks.CORK_SHAKES.get());
                addAfter(event, ACCBlocks.CORK_SHAKES.get(), ACCBlocks.CORK_SHAKES_STAIRS.get());
                addAfter(event, ACCBlocks.CORK_SHAKES_STAIRS.get(), ACCBlocks.CORK_SHAKES_SLAB.get());
            }
        }
        if (isModLoaded(CompatUtils.DRAMATIC_DOORS)) {
            if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
                addBefore(event, ACBlocks.CORK_DOOR.get(), DramaticDoorsCompatRegistry.SHORT_CORK_DOOR.get());
                addAfter(event, ACBlocks.CORK_DOOR.get(), DramaticDoorsCompatRegistry.TALL_CORK_DOOR.get());
            }
        }
    }
}