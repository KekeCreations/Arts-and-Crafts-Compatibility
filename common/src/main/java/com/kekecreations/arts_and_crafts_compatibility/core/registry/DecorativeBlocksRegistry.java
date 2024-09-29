package com.kekecreations.arts_and_crafts_compatibility.core.registry;

import com.kekecreations.arts_and_crafts.core.registry.ACSoundTypes;
import com.kekecreations.arts_and_crafts_compatibility.common.block.ACCPalisadeBlock;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import lilypuree.decorative_blocks.blocks.types.VanillaWoodTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

public class DecorativeBlocksRegistry {

    public static final Supplier<Block> CORK_PALISADE = CompatUtils.registerBlockWithItem(CompatUtils.DECORATIVE_BLOCKS, "cork_palisade",
            () -> new ACCPalisadeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 4.0F).sound(ACSoundTypes.CORK).ignitedByLava(), VanillaWoodTypes.OAK));

    public static void registerPalisades() {
    }
}
