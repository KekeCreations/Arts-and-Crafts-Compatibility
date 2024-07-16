package com.kekecreations.arts_and_crafts_compatibility.core.compat.gildedsherds;

import com.kekecreations.arts_and_crafts_compatibility.ArtsAndCraftsCompatibility;
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

    public static void register() {
    }
}
