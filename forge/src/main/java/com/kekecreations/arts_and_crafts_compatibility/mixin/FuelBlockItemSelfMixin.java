package com.kekecreations.arts_and_crafts_compatibility.mixin;

import com.kekecreations.arts_and_crafts_compatibility.common.item.FuelBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(FuelBlockItem.class)
public class FuelBlockItemSelfMixin extends BlockItem {


    public FuelBlockItemSelfMixin(Block p_40565_, Properties p_40566_) {
        super(p_40565_, p_40566_);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType ) {
        return ((FuelBlockItem) itemStack.getItem()).getBurnTimeInt();
    }
}
