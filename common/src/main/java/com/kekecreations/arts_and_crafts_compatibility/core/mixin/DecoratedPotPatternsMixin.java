package com.kekecreations.arts_and_crafts_compatibility.core.mixin;

import com.kekecreations.arts_and_crafts_compatibility.common.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.gildedsherds.GildedSherdsItems;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.gildedsherds.GildedSherdsPatterns;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DecoratedPotPatterns.class)
public class DecoratedPotPatternsMixin {

    @Inject(method = "getResourceKey", at = @At("RETURN"), cancellable = true)
    private static void arts_and_crafts_addedPatterns(Item item, CallbackInfoReturnable<ResourceKey<String>> cir) {

        if (Services.PLATFORM.isModLoaded(CompatUtils.GILDED_SHERDS)) {
            if (item == GildedSherdsItems.GILDED_ROLL_POTTERY_SHERD.get()) {
                cir.setReturnValue(GildedSherdsPatterns.GILDED_ROLL_POTTERY_PATTERN);
            }
            if (item == GildedSherdsItems.GILDED_RUINED_POTTERY_SHERD.get()) {
                cir.setReturnValue(GildedSherdsPatterns.GILDED_RUINED_POTTERY_PATTERN);
            }
            if (item == GildedSherdsItems.GILDED_FINALE_POTTERY_SHERD.get()) {
                cir.setReturnValue(GildedSherdsPatterns.GILDED_FINALE_POTTERY_PATTERN);
            }
            if (item == GildedSherdsItems.GILDED_GATEWAY_POTTERY_SHERD.get()) {
                cir.setReturnValue(GildedSherdsPatterns.GILDED_GATEWAY_POTTERY_PATTERN);
            }
        }
    }

    @Inject(method = "bootstrap", at = @At("TAIL"))
    private static void arts_and_crafts_bootstrap(Registry<String> registry, CallbackInfoReturnable<String> cir) {
        Registry.register(registry, GildedSherdsPatterns.GILDED_ROLL_POTTERY_PATTERN, "gilded_roll_pottery_pattern");
        Registry.register(registry, GildedSherdsPatterns.GILDED_RUINED_POTTERY_PATTERN, "gilded_ruined_pottery_pattern");
        Registry.register(registry, GildedSherdsPatterns.GILDED_FINALE_POTTERY_PATTERN, "gilded_finale_pottery_pattern");
        Registry.register(registry, GildedSherdsPatterns.GILDED_GATEWAY_POTTERY_PATTERN, "gilded_gateway_pottery_pattern");
    }
}
