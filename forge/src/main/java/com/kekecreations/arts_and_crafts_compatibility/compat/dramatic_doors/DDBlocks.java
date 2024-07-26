package com.kekecreations.arts_and_crafts_compatibility.compat.dramatic_doors;

import com.fizzware.dramaticdoors.forge.blocks.ShortDoorBlock;
import com.kekecreations.arts_and_crafts.common.misc.KekeBlockSetType;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts_compatibility.core.compat.CompatUtils;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class DDBlocks {

    public static final Supplier<Block> CORK_SHORT_DOOR = CompatUtils.registerBlock("short_cork_door", () -> new ShortDoorBlock(ACBlocks.CORK_DOOR.get(), KekeBlockSetType.CORK));


    public static void register() {

    }
}
