package com.kekecreations.arts_and_crafts_compatibility.core.util;

import net.yirmiri.excessive_building.EBConfig;

public class ExcessiveBuildingUtils {

    public static boolean shelfVariants() {
        return EBConfig.ENABLE_SHELF_VARIANTS.get();
    }

    public static boolean craftingTableVariants() {
        return EBConfig.ENABLE_CRAFTING_TABLE_VARIANTS.get();
    }

    public static boolean ladderVariants() {
        return EBConfig.ENABLE_LADDER_VARIANTS.get();
    }

    public static boolean verticalStairs() {
        return EBConfig.ENABLE_VERTICAL_STAIRS.get();
    }

    public static boolean decorativeShelves() {
        return EBConfig.ENABLE_DECORATIVE_SHELVES.get();
    }

    public static boolean customTooltips() {
        return EBConfig.ENABLE_CUSTOM_TOOLTIPS.get();
    }
}
