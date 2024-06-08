package com.kekecreations.arts_and_crafts_compatibility;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod(ArtsAndCraftsCompatibility.MOD_ID)
public class ForgeArtsAndCraftsCompatibility {

    public ForgeArtsAndCraftsCompatibility() {
        ArtsAndCraftsCompatibility.init();
    }
    public static boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

}