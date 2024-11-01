package com.kekecreations.arts_and_crafts_compatibility.core.mixin;

import net.minecraftforge.fml.ModList;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class ACCMixinPlugin implements IMixinConfigPlugin {
    public static final String DECORATIVE_BLOCKS = "decorative_blocks";
    public static final String GILDED_SHERDS = "gildedsherds";

    public void onLoad(String s) {

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
        return true;
    }

    public void acceptTargets(Set<String> set, Set<String> set1) {

    }

    public List<String> getMixins() {
        return List.of();
    }

    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }

    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }

    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

}
