package com.kekecreations.arts_and_crafts_compatibility.core.util;

import net.minecraft.util.StringRepresentable;

//Original file is from https://github.com/Kitteh6660/DramaticDoors/blob/1.20.1-quifabrge/common/src/main/java/com/fizzware/dramaticdoors/state/properties/TripleBlockPart.java
public enum TripleBlockPart implements StringRepresentable {
    UPPER,
    MIDDLE,
    LOWER;

    public String toString() { return this.getSerializedName(); }

    public String getSerializedName() {
        return this == UPPER ? "upper" : this == MIDDLE ? "middle" : "lower";
    }

}
