package com.kekecreations.arts_and_crafts_compatibility.core.util;

import com.fizzware.dramaticdoors.forge.compat.Compats;
import com.fizzware.dramaticdoors.forge.compat.registries.SupplementariesCompat;
import net.minecraft.world.level.block.Block;

public class DramaticDoorsUtils {

    public static Block supplementariesShortSilverDoor() {
        return SupplementariesCompat.SHORT_SILVER_DOOR;
    }

    public static Block supplementariesShortGoldDoor() {
        return SupplementariesCompat.SHORT_GOLD_DOOR;
    }

    public static Block supplementariesTallSilverDoor() {
        return SupplementariesCompat.TALL_SILVER_DOOR;
    }

    public static Block supplementariesTallGoldDoor() {
        return SupplementariesCompat.TALL_GOLD_DOOR;
    }

    public static boolean supplementariesInstalled() {
        return Compats.SUPPLEMENTARIES_INSTALLED;
    }

    public static boolean blueprintInstalled() {
        return Compats.BLUEPRINT_INSTALLED;
    }

    public static boolean doubleDoorsInstalled() {
        return Compats.DOUBLE_DOORS_INSTALLED;
    }

    public static boolean quarkInstalled() {
        return Compats.QUARK_INSTALLED;
    }

    public static boolean couplingsInstalled() {
        return Compats.COUPLINGS_INSTALLED;
    }
}
