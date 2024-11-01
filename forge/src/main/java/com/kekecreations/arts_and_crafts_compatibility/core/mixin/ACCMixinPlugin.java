package com.kekecreations.arts_and_crafts_compatibility.core.mixin;

import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;

public abstract class ACCMixinPlugin implements IMixinConfigPlugin {
    public static final String DECORATIVE_BLOCKS = "decorative_blocks";
    public static final String GILDED_SHERDS = "gildedsherds";

    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.contains("DecoratedPotPatternsMixin")) {
            return isModLoaded(GILDED_SHERDS);
        }
        if (mixinClassName.contains("PalisadeBlockMixin")) {
            return isModLoaded(DECORATIVE_BLOCKS);
        }
        return true;
    }

    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

}
