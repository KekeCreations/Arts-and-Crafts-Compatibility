package com.kekecreations.arts_and_crafts_compatibility.core.mixin;

import com.kekecreations.arts_and_crafts.common.util.CreativeCategoryUtils;
import net.leafenzo.mint.util.ModDyeColor;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.ArrayList;

import static com.kekecreations.arts_and_crafts.common.util.CreativeCategoryUtils.colourOrder;

@Mixin(CreativeCategoryUtils.class)
public class CreativeCategoryUtilsMixin {

    @Shadow public static ArrayList<DyeColor> colourOrder;

    /**
     * @author KekeCreations
     * @reason It is a method from my mod.
     */
    @Overwrite(remap = false)
    public static void addVanillaDyesToColourOrder() {
        colourOrder.add(DyeColor.PINK);
        colourOrder.add(ModDyeColor.FUCHSIA);
        colourOrder.add(ModDyeColor.MAUVE);
        colourOrder.add(ModDyeColor.VELVET);
        colourOrder.add(DyeColor.MAGENTA);
        colourOrder.add(ModDyeColor.INDIGO);
        colourOrder.add(DyeColor.PURPLE);
        colourOrder.add(ModDyeColor.GRAPE);
        colourOrder.add(ModDyeColor.PERIWINKLE);
        colourOrder.add(DyeColor.BLUE);
        colourOrder.add(ModDyeColor.NAVY);
        colourOrder.add(DyeColor.LIGHT_BLUE);
        colourOrder.add(ModDyeColor.CERULEAN);
        colourOrder.add(DyeColor.CYAN);
        colourOrder.add(ModDyeColor.MINT);
        colourOrder.add(ModDyeColor.SHAMROCK);
        colourOrder.add(ModDyeColor.SAGE);
        colourOrder.add(DyeColor.GREEN);
        colourOrder.add(ModDyeColor.SAP);
        colourOrder.add(DyeColor.LIME);
        colourOrder.add(ModDyeColor.ARTICHOKE);
        colourOrder.add(ModDyeColor.BANANA);
        colourOrder.add(DyeColor.YELLOW);
        colourOrder.add(ModDyeColor.AMBER);
        colourOrder.add(DyeColor.ORANGE);
        colourOrder.add(ModDyeColor.VERMILION);
        colourOrder.add(ModDyeColor.PEACH);
        colourOrder.add(DyeColor.RED);
        colourOrder.add(ModDyeColor.MAROON);
        colourOrder.add(ModDyeColor.MOLD);
        colourOrder.add(DyeColor.BROWN);
        colourOrder.add(ModDyeColor.ACORN);
        colourOrder.add(DyeColor.BLACK);
        colourOrder.add(DyeColor.GRAY);
        colourOrder.add(DyeColor.LIGHT_GRAY);
        colourOrder.add(DyeColor.WHITE);
    }
}
