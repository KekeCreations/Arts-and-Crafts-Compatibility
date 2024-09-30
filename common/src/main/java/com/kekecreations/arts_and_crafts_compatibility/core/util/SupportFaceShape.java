package com.kekecreations.arts_and_crafts_compatibility.core.util;

import net.minecraft.util.StringRepresentable;

//Original file is from https://github.com/lilypuree/Decorative-Blocks/blob/1.20/Common/src/main/java/lilypuree/decorative_blocks/blocks/state/SupportFaceShape.java
public enum SupportFaceShape implements StringRepresentable {
    BIG("big"), SMALL("small"), HIDDEN("hidden");

    private final String name;

    private SupportFaceShape(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }

    public boolean isHidden() {
        return this == HIDDEN;
    }

    public SupportFaceShape getSwitched() {
        switch (this) {
            case HIDDEN:
                return HIDDEN;
            case SMALL:
                return BIG;
            case BIG:
                return SMALL;
        }
        return BIG;
    }
}
