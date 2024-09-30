package com.kekecreations.arts_and_crafts_compatibility.core.util;


import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;

//Original file is from https://github.com/lilypuree/Decorative-Blocks/blob/1.20/Common/src/main/java/lilypuree/decorative_blocks/blocks/types/VanillaWoodTypes.java
public enum ACCDecorativeBlocksWoodTypes implements IWoodType {

    CORK("cork") {
        @Override
        public MapColor getMapColor() {
            return MapColor.COLOR_BROWN;
        }
    };

    private final String name;

    private ACCDecorativeBlocksWoodTypes(String name) {
        this.name = name;
    }

    public String toString() {
        return this.getName();
    }

    @Override
    public String namespace() {
        return "minecraft";
    }

    public String getName() {
        return this.name;
    }


    public static ACCDecorativeBlocksWoodTypes withName(String name) {
        if (name.equalsIgnoreCase("cork")) return CORK;
        return CORK;
    }

    public static ACCDecorativeBlocksWoodTypes fromPath(String path) {
        String[] paths = path.split("_");
        return withName(paths[0]);
    }

    public Block getLog() {
        switch (this) {
            case CORK:
                return ACBlocks.CORK_LOG.get();
        }
        return Blocks.OAK_LOG;
    }

    public Block getStrippedLog() {
        switch (this) {
            case CORK:
                return ACBlocks.STRIPPED_CORK_LOG.get();
        }
        return Blocks.STRIPPED_OAK_LOG;
    }

    public Block getSlab() {
        switch (this) {
            case CORK:
                return ACBlocks.CORK_SLAB.get();
        }
        return Blocks.OAK_SLAB;
    }

    public Block getFence() {
        switch (this) {
            case CORK:
                return ACBlocks.CORK_FENCE.get();
        }
        return Blocks.OAK_FENCE;
    }

    public Block getPlanks() {
        switch (this) {
            case CORK:
                return ACBlocks.CORK_PLANKS.get();
        }
        return Blocks.OAK_PLANKS;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public boolean isFlammable() {
        return true;
    }


}
