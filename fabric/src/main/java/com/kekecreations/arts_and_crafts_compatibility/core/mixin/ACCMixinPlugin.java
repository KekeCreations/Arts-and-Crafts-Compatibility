package com.kekecreations.arts_and_crafts_compatibility.core.mixin;

import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class ACCMixinPlugin implements IMixinConfigPlugin {
    public static final String ARTS_AND_CRAFTS = "arts_and_crafts";
    public static final String GILDED_SHERDS = "gildedsherds";
    public static final String MINT = "mint";
    public static final String DECORATIVE_BLOCKS = "decorative_blocks";

    public void onLoad(String mixinPackage) {

    }

    public String getRefMapperConfig() {
        return "";
    }

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

    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    public List<String> getMixins() {
        return List.of();
    }

    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    private boolean isModLoaded(String modID) {
        return FabricLoader.getInstance().isModLoaded(modID);
    }
}
