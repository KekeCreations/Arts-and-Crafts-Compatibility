package com.kekecreations.arts_and_crafts_compatibility.core.mixin;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import net.leafenzo.mint.util.ModDyeColor;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin {


    @Inject(method = "isValid", at = @At("HEAD"), cancellable = true)
    private void arts_and_crafts_compat_isValid(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        var $this = BlockEntityType.class.cast(this);
        if ($this == ACEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get()) {
            if (state.is(ACBlocks.getDyedDecoratedPot(ModDyeColor.VERMILION.getId()))) {
                cir.setReturnValue(true);
            } else if (state.is(ACBlocks.getDyedDecoratedPot(ModDyeColor.MINT.getId()))) {
                cir.setReturnValue(true);
            }
        }
    }
}
