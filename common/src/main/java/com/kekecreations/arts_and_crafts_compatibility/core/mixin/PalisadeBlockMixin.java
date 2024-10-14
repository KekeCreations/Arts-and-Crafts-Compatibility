package com.kekecreations.arts_and_crafts_compatibility.core.mixin;

import com.kekecreations.arts_and_crafts_compatibility.common.block.ACCPalisadeBlock;
import lilypuree.decorative_blocks.blocks.PalisadeBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PalisadeBlock.class)
public class PalisadeBlockMixin {
    
    @Inject(method = "canConnect(Lnet/minecraft/world/level/block/state/BlockState;ZLnet/minecraft/core/Direction;)Z", at = @At(value = "HEAD"), cancellable = true)
    public void arts_and_crafts_compat_canConnect(BlockState state, boolean flag0, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        Block block = state.getBlock();
        if (block instanceof ACCPalisadeBlock) {
            cir.setReturnValue(true);
        }
        
    }
}
