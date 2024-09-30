package com.kekecreations.arts_and_crafts_compatibility.core.util;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public interface DBProperties {
    public static final BooleanProperty POST = BooleanProperty.create("post");

    public static final EnumProperty<SupportFaceShape> HORIZONTAL_SHAPE = EnumProperty.create("horizontal", SupportFaceShape.class);
    public static final EnumProperty<SupportFaceShape> VERTICAL_SHAPE = EnumProperty.create("vertical", SupportFaceShape.class);
}
