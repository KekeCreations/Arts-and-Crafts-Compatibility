package com.kekecreations.arts_and_crafts_compatibility.core.mixin;

import com.kekecreations.arts_and_crafts.common.util.CreativeCategoryUtils;
import net.leafenzo.mint.util.ElsDyeModDyeColor;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.ArrayList;

@Mixin(CreativeCategoryUtils.class)
public class CreativeCategoryUtilsMixin {

    @Shadow(remap = false) public static ArrayList<DyeColor> colourOrder;


    @Overwrite(remap = false)
    public static void addVanillaDyesToColourOrder() {
        colourOrder.add(DyeColor.PINK);
        colourOrder.add(ElsDyeModDyeColor.FUCHSIA);
        colourOrder.add(ElsDyeModDyeColor.MAUVE);
        colourOrder.add(ElsDyeModDyeColor.VELVET);
        colourOrder.add(DyeColor.MAGENTA);
        colourOrder.add(ElsDyeModDyeColor.INDIGO);
        colourOrder.add(DyeColor.PURPLE);
        colourOrder.add(ElsDyeModDyeColor.GRAPE);
        colourOrder.add(ElsDyeModDyeColor.PERIWINKLE);
        colourOrder.add(DyeColor.BLUE);
        colourOrder.add(ElsDyeModDyeColor.NAVY);
        colourOrder.add(DyeColor.LIGHT_BLUE);
        colourOrder.add(ElsDyeModDyeColor.CERULEAN);
        colourOrder.add(DyeColor.CYAN);
        colourOrder.add(ElsDyeModDyeColor.MINT);
        colourOrder.add(ElsDyeModDyeColor.SHAMROCK);
        colourOrder.add(ElsDyeModDyeColor.SAGE);
        colourOrder.add(DyeColor.GREEN);
        colourOrder.add(ElsDyeModDyeColor.SAP);
        colourOrder.add(DyeColor.LIME);
        colourOrder.add(ElsDyeModDyeColor.ARTICHOKE);
        colourOrder.add(ElsDyeModDyeColor.BANANA);
        colourOrder.add(DyeColor.YELLOW);
        colourOrder.add(ElsDyeModDyeColor.AMBER);
        colourOrder.add(DyeColor.ORANGE);
        colourOrder.add(ElsDyeModDyeColor.VERMILION);
        colourOrder.add(ElsDyeModDyeColor.PEACH);
        colourOrder.add(DyeColor.RED);
        colourOrder.add(ElsDyeModDyeColor.MAROON);
        colourOrder.add(ElsDyeModDyeColor.MOLD);
        colourOrder.add(DyeColor.BROWN);
        colourOrder.add(ElsDyeModDyeColor.ACORN);
        colourOrder.add(DyeColor.BLACK);
        colourOrder.add(DyeColor.GRAY);
        colourOrder.add(DyeColor.LIGHT_GRAY);
        colourOrder.add(DyeColor.WHITE);
    }
}
