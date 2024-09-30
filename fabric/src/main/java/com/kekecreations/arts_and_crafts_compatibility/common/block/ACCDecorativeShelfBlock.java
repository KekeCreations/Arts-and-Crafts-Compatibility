package com.kekecreations.arts_and_crafts_compatibility.common.block;

import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.util.ExcessiveBuildingUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ACCDecorativeShelfBlock extends Block {
    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 6);

    public ACCDecorativeShelfBlock(BlockBehaviour.Properties settings) {
        super(settings);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(VARIANT, 0));
    }


    public void appendHoverText(ItemStack stack, @Nullable BlockGetter context, List<Component> tooltip, TooltipFlag options) {
        if (ExcessiveBuildingUtils.customTooltips()) {
            super.appendHoverText(stack, context, tooltip, options);
            tooltip.add(CommonComponents.EMPTY);
            tooltip.add(Component.translatable("tooltip.block.interact").withStyle(ChatFormatting.GRAY));
            tooltip.add(CommonComponents.space().append(Component.translatable("tooltip.block.variant").withStyle(ChatFormatting.BLUE)));
        }

    }

    public @NotNull InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide() && hand == InteractionHand.MAIN_HAND && !player.hasItemInSlot(EquipmentSlot.MAINHAND)) {
            world.setBlockAndUpdate(pos, (BlockState)state.cycle(VARIANT));
            world.playSound((Player)null, pos, SoundEvents.CHISELED_BOOKSHELF_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{VARIANT});
    }

    public boolean isEnabled(FeatureFlagSet enable) {
        if (Services.PLATFORM.isModLoaded(CompatUtils.EXCESSIVE_BUILDING)) {
            return ExcessiveBuildingUtils.decorativeShelves();
        }
        return false;
    }
}
