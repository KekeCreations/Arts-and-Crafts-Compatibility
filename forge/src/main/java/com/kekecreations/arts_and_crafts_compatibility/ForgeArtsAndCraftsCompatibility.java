package com.kekecreations.arts_and_crafts_compatibility;

import com.kekecreations.arts_and_crafts_compatibility.common.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.built.BuiltBlocks;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.gildedsherds.GildedSherdsItems;
import com.kekecreations.arts_and_crafts_compatibility.compat.farmersdelight.FDCompatBlocks;
import com.kekecreations.arts_and_crafts_compatibility.platform.ForgeRegistryHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ArtsAndCraftsCompatibility.MOD_ID)
public class ForgeArtsAndCraftsCompatibility {

    public ForgeArtsAndCraftsCompatibility() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ForgeRegistryHelper.SOUNDS.register(modEventBus);
        ForgeRegistryHelper.PARTICLE_TYPES.register(modEventBus);
        ForgeRegistryHelper.BLOCKS.register(modEventBus);
        ForgeRegistryHelper.ITEMS.register(modEventBus);

        ArtsAndCraftsCompatibility.init();
        if (isModLoaded(CompatUtils.FARMERS_DELIGHT)) {
            FDCompatBlocks.register();
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
                event.accept(GildedSherdsItems.GILDED_FINALE_POTTERY_SHERD.get());
                event.accept(GildedSherdsItems.GILDED_GATEWAY_POTTERY_SHERD.get());
                event.accept(GildedSherdsItems.GILDED_ROLL_POTTERY_SHERD.get());
                event.accept(GildedSherdsItems.GILDED_RUINED_POTTERY_SHERD.get());
            }
        }
        if (isModLoaded(CompatUtils.BUILT)) {
            if (event.getTabKey() == ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CompatUtils.BUILT, "built_tab"))) {
                addAfter(event, BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.BUILT, "acacia_shakes_slab")), BuiltBlocks.CORK_COMPACT_PLANKS.get());
                addAfter(event, BuiltBlocks.CORK_COMPACT_PLANKS.get(), BuiltBlocks.CORK_SHAKES.get());
                addAfter(event, BuiltBlocks.CORK_SHAKES.get(), BuiltBlocks.CORK_SHAKES_STAIRS.get());
                addAfter(event, BuiltBlocks.CORK_SHAKES_STAIRS.get(), BuiltBlocks.CORK_SHAKES_SLAB.get());
            }
        }
        if (isModLoaded(CompatUtils.FARMERS_DELIGHT)) {
            if (event.getTabKey() == ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CompatUtils.FARMERS_DELIGHT, "farmersdelight"))) {
                addAfter(event, BuiltInRegistries.ITEM.get(new ResourceLocation(CompatUtils.FARMERS_DELIGHT, "acacia_cabinet")), FDCompatBlocks.CORK_CABINET.get());
            }
        }
    }
}