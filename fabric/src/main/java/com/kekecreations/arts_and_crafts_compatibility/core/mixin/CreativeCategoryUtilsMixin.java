package com.kekecreations.arts_and_crafts_compatibility.core.mixin;

import com.kekecreations.jinxedlib.core.util.JinxedCreativeCategoryHelper;
import net.leafenzo.mint.util.ElsDyeModDyeColor;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.ArrayList;

@Mixin(JinxedCreativeCategoryHelper.class)
public class CreativeCategoryUtilsMixin {

    @Shadow(remap = false) public static ArrayList<DyeColor> colourOrderBackToFront;


    @Overwrite(remap = false)
    public static void addVanillaDyesToColourOrderBackToFront() {
        colourOrderBackToFront.add(DyeColor.PINK);
        colourOrderBackToFront.add(ElsDyeModDyeColor.FUCHSIA);
        colourOrderBackToFront.add(ElsDyeModDyeColor.MAUVE);
        colourOrderBackToFront.add(ElsDyeModDyeColor.VELVET);
        colourOrderBackToFront.add(DyeColor.MAGENTA);
        colourOrderBackToFront.add(ElsDyeModDyeColor.INDIGO);
        colourOrderBackToFront.add(DyeColor.PURPLE);
        colourOrderBackToFront.add(ElsDyeModDyeColor.GRAPE);
        colourOrderBackToFront.add(ElsDyeModDyeColor.PERIWINKLE);
        colourOrderBackToFront.add(DyeColor.BLUE);
        colourOrderBackToFront.add(ElsDyeModDyeColor.NAVY);
        colourOrderBackToFront.add(DyeColor.LIGHT_BLUE);
        colourOrderBackToFront.add(ElsDyeModDyeColor.CERULEAN);
        colourOrderBackToFront.add(DyeColor.CYAN);
        colourOrderBackToFront.add(ElsDyeModDyeColor.MINT);
        colourOrderBackToFront.add(ElsDyeModDyeColor.SHAMROCK);
        colourOrderBackToFront.add(ElsDyeModDyeColor.SAGE);
        colourOrderBackToFront.add(DyeColor.GREEN);
        colourOrderBackToFront.add(ElsDyeModDyeColor.SAP);
        colourOrderBackToFront.add(DyeColor.LIME);
        colourOrderBackToFront.add(ElsDyeModDyeColor.ARTICHOKE);
        colourOrderBackToFront.add(ElsDyeModDyeColor.BANANA);
        colourOrderBackToFront.add(DyeColor.YELLOW);
        colourOrderBackToFront.add(ElsDyeModDyeColor.AMBER);
        colourOrderBackToFront.add(DyeColor.ORANGE);
        colourOrderBackToFront.add(ElsDyeModDyeColor.VERMILION);
        colourOrderBackToFront.add(ElsDyeModDyeColor.PEACH);
        colourOrderBackToFront.add(DyeColor.RED);
        colourOrderBackToFront.add(ElsDyeModDyeColor.MAROON);
        colourOrderBackToFront.add(ElsDyeModDyeColor.MOLD);
        colourOrderBackToFront.add(DyeColor.BROWN);
        colourOrderBackToFront.add(ElsDyeModDyeColor.ACORN);
        colourOrderBackToFront.add(DyeColor.BLACK);
        colourOrderBackToFront.add(DyeColor.GRAY);
        colourOrderBackToFront.add(DyeColor.LIGHT_GRAY);
        colourOrderBackToFront.add(DyeColor.WHITE);
    }
}
