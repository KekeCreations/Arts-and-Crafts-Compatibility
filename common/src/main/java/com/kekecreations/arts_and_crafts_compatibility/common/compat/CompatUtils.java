package com.kekecreations.arts_and_crafts_compatibility.common.compat;

import com.kekecreations.arts_and_crafts.common.block.ACFlowerPotBlock;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

public class CompatUtils {
    public static final String ARTS_AND_CRAFTS = "arts_and_crafts";
    public static final String GILDED_SHERDS = "gildedsherds";
    public static final String OH_MY_SHERD = "ohmysherd";
    public static final String BUILT = "built";
    public static final String FARMERS_DELIGHT = "farmersdelight";
    public static final String TWIGS = "twigs";
    public static final String CAFFEINATED = "caffeinated";
    public static final String DECORATIVE_BLOCKS = "decorative_blocks";
    public static final String NEAPOLITAN = "neapolitan";
    public static final String SPAWN = "spawn";
    public static final String BIOME_MAKEOVER = "biomemakeover";
    public static final String ALEX_CAVES = "alexscaves";



    public static ACFlowerPotBlock flowerPot(Block block, DyeColor dyeColor) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        return new ACFlowerPotBlock(block, dyeColor, properties);
    }
}
