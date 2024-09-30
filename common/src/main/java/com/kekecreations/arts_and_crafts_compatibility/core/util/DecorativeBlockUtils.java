package com.kekecreations.arts_and_crafts_compatibility.core.util;

import lilypuree.decorative_blocks.items.SwitchableBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class DecorativeBlockUtils {

    public static void switchableBlockItem(ItemStack stack, BlockState blockstate) {
        if (stack.getItem() instanceof SwitchableBlockItem) {
            blockstate = ((SwitchableBlockItem<?, ?>) stack.getItem()).getSwitchedState(blockstate, stack);
        }
    }
}
