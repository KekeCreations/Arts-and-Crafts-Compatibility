package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.fizzware.dramaticdoors.fabric.blocks.ShortDoorBlock;
import com.fizzware.dramaticdoors.fabric.blocks.TallDoorBlock;
import com.kekecreations.arts_and_crafts.common.misc.KekeBlockSetType;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts_compatibility.common.item.ACCShortDoorItem;
import com.kekecreations.arts_and_crafts_compatibility.common.item.ACCTallDoorItem;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class DramaticDoorsCompatRegistry {

    public static final Supplier<Block> SHORT_CORK_DOOR = CompatUtils.registerBlock("short_cork_door",
            () -> new ShortDoorBlock(ACBlocks.CORK_DOOR.get(), KekeBlockSetType.CORK));

    public static final Supplier<Block> TALL_CORK_DOOR = CompatUtils.registerBlock("tall_cork_door",
            () -> new TallDoorBlock(ACBlocks.CORK_DOOR.get(), KekeBlockSetType.CORK));

    public static final Supplier<ACCShortDoorItem> CORK_SHORT_DOOR_ITEM = CompatUtils.registerItem("short_cork_door",
            () -> new ACCShortDoorItem(DramaticDoorsCompatRegistry.SHORT_CORK_DOOR.get(), new Item.Properties()));

    public static final Supplier<BlockItem> TALL_CORK_DOOR_ITEM = CompatUtils.registerItem("tall_cork_door",
            () -> new ACCTallDoorItem(DramaticDoorsCompatRegistry.TALL_CORK_DOOR.get(), new Item.Properties()));

    public static void register() {
    }
}
