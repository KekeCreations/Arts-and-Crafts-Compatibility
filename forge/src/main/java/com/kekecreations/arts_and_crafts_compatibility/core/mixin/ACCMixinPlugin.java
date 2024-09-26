package com.kekecreations.arts_and_crafts_compatibility.core.mixin;

import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class ACCMixinPlugin implements IMixinConfigPlugin {
    public void onLoad(String mixinPackage) {}

    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.contains("DecoratedPotPatternsMixin")) {
            return Services.PLATFORM.isModLoaded(CompatUtils.GILDED_SHERDS);
        }
        return true;
    }

    public String getRefMapperConfig() { return null; }

    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}
