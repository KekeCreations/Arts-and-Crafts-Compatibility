package com.kekecreations.arts_and_crafts_compatibility.common.compat.gildedsherds;

import com.kekecreations.arts_and_crafts_compatibility.ArtsAndCraftsCompatibility;
import com.kekecreations.arts_and_crafts_compatibility.common.compat.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;

public class GildedSherdsPatterns {

    public static final ResourceKey<String> GILDED_ROLL_POTTERY_PATTERN = create("gilded_roll_pottery_pattern");
    public static final ResourceKey<String> GILDED_RUINED_POTTERY_PATTERN = create("gilded_ruined_pottery_pattern");
    public static final ResourceKey<String> GILDED_FINALE_POTTERY_PATTERN = create("gilded_finale_pottery_pattern");
    public static final ResourceKey<String> GILDED_GATEWAY_POTTERY_PATTERN = create("gilded_gateway_pottery_pattern");

    private static ResourceKey<String> create(String string) {
        return ResourceKey.create(Registries.DECORATED_POT_PATTERNS, ArtsAndCraftsCompatibility.id(string));
    }

    public static void registerPatterns(Registry<String> registry) {
        if (Services.PLATFORM.isModLoaded(CompatUtils.GILDED_SHERDS)) {
            Registry.register(registry, GildedSherdsPatterns.GILDED_ROLL_POTTERY_PATTERN, "gilded_roll_pottery_pattern");
            Registry.register(registry, GildedSherdsPatterns.GILDED_RUINED_POTTERY_PATTERN, "gilded_ruined_pottery_pattern");
            Registry.register(registry, GildedSherdsPatterns.GILDED_FINALE_POTTERY_PATTERN, "gilded_finale_pottery_pattern");
            Registry.register(registry, GildedSherdsPatterns.GILDED_GATEWAY_POTTERY_PATTERN, "gilded_gateway_pottery_pattern");
        }
    }

    public static void register() {
    }
}
