package com.kekecreations.arts_and_crafts_compatibility.common.compat.decorative_blocks;

import com.kekecreations.arts_and_crafts.core.registry.ArtsAndCraftsSoundTypes;
import com.kekecreations.arts_and_crafts_compatibility.common.block.SeatBlock;
import com.kekecreations.arts_and_crafts_compatibility.common.block.SupportBlock;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import lilypuree.decorative_blocks.blocks.PalisadeBlock;
import lilypuree.decorative_blocks.blocks.types.VanillaWoodTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

public class DBBlocks {


    public static final Supplier<Block> CORK_PALISADE = registerBlockWithItem("cork_palisade", () -> new PalisadeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 4.0F).sound(ArtsAndCraftsSoundTypes.CORK).ignitedByLava(), VanillaWoodTypes.OAK));

    public static final Supplier<Block> CORK_SEAT = registerBlockWithItem("cork_seat", () -> new SeatBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(1.2F).sound(ArtsAndCraftsSoundTypes.CORK).ignitedByLava()));
    public static final Supplier<Block> CORK_BEAM = registerBlockWithItem("cork_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(1.2F).sound(ArtsAndCraftsSoundTypes.CORK).ignitedByLava()));

    public static final Supplier<Block> CORK_SUPPORT = registerBlockWithItem("cork_support", () -> new SupportBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(1.2F).sound(ArtsAndCraftsSoundTypes.CORK).ignitedByLava()));

    private static <T extends Block> Supplier<T> registerBlockWithItem(String name, java.util.function.Supplier<T> blockSupplier) {
        return Services.REGISTRY.registerBlockWithItem(name, blockSupplier);
    }

    public static void register() {

    }
}
