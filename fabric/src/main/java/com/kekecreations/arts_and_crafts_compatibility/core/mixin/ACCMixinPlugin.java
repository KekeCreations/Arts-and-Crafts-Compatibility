package com.kekecreations.arts_and_crafts_compatibility.core.mixin;

import net.fabricmc.loader.api.FabricLoader;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;

public abstract class ACCMixinPlugin implements IMixinConfigPlugin {
    public static final String ARTS_AND_CRAFTS = "arts_and_crafts";
    public static final String GILDED_SHERDS = "gildedsherds";
    public static final String MINT = "mint";
    public static final String DECORATIVE_BLOCKS = "decorative_blocks";
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.contains("DecoratedPotPatternsMixin")) {
            return isModLoaded(GILDED_SHERDS);
        }
        if (mixinClassName.contains("PalisadeBlockMixin")) {
            return isModLoaded(DECORATIVE_BLOCKS);
        }
        if (mixinClassName.contains("BlockEntityTypeMixin")) {
            return isModLoaded(MINT);
        }
        if (mixinClassName.contains("CreativeCategoryUtilsMixin")) {
            return isModLoaded(MINT) && FabricLoader.getInstance().isModLoaded(ARTS_AND_CRAFTS);
        }
        return true;
    }

    private boolean isModLoaded(String modID) {
        return FabricLoader.getInstance().isModLoaded(modID);
    }
}
