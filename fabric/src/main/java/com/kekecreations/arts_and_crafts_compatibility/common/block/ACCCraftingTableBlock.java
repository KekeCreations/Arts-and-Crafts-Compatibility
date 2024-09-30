package com.kekecreations.arts_and_crafts_compatibility.common.block;

import com.kekecreations.arts_and_crafts_compatibility.common.screen.EBCraftingScreenHandler;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.util.ExcessiveBuildingUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ACCCraftingTableBlock extends CraftingTableBlock {
    private static final Component TITLE = Component.translatable("container.crafting");

    public ACCCraftingTableBlock(Properties settings) {
        super(settings);
    }

    public boolean isEnabled(FeatureFlagSet enable) {
        if (Services.PLATFORM.isModLoaded(CompatUtils.EXCESSIVE_BUILDING)) {
            return ExcessiveBuildingUtils.craftingTableVariants();
        }
        return false;
    }

    public MenuProvider getMenuProvider(BlockState state, Level world, BlockPos pos) {
        return new SimpleMenuProvider((syncId, inventory, player) -> {
            return new EBCraftingScreenHandler(syncId, inventory, ContainerLevelAccess.create(world, pos), this);
        }, TITLE);
    }
}
