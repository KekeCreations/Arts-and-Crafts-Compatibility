package com.kekecreations.arts_and_crafts_compatibility.common.block;

import com.google.common.collect.ImmutableMap;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import lilypuree.decorative_blocks.blocks.state.ModBlockProperties;
import lilypuree.decorative_blocks.blocks.state.SupportFaceShape;
import lilypuree.decorative_blocks.items.SwitchableBlockItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.Plane;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;


/*
    Hi I copied this code from a mod called Decorative Blocks, so I can add compat for it for Arts & Crafts, you can check out that file here :
    https://github.com/lilypuree/Decorative-Blocks/blob/1.20/Common/src/main/java/lilypuree/decorative_blocks/blocks/SupportBlock.java
*/
public class SupportBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    private static final double d0 = 3.0;
    private static final double d1 = 13.0;
    private static final double d2 = 4.0;
    private static final double d3 = 12.0;
    private static final VoxelShape TOP_LARGE = Block.box(0.0, 13.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape TOP_SMALL_NS = Block.box(4.0, 13.0, 0.0, 12.0, 16.0, 16.0);
    private static final VoxelShape TOP_SMALL_EW = Block.box(0.0, 13.0, 4.0, 16.0, 16.0, 12.0);
    private static final VoxelShape BOTTOM_LARGE = Block.box(0.0, 0.0, 0.0, 16.0, 3.0, 16.0);
    private static final VoxelShape BOTTOM_SMALL_NS = Block.box(4.0, 0.0, 0.0, 12.0, 3.0, 16.0);
    private static final VoxelShape BOTTOM_SMALL_EW = Block.box(0.0, 0.0, 4.0, 16.0, 3.0, 12.0);
    private static final Map<Direction, VoxelShape> verticalLarge;
    private static final Map<Direction, VoxelShape> verticalSmall;
    public static final BooleanProperty WATERLOGGED;
    public static final BooleanProperty UP;
    public static final EnumProperty<SupportFaceShape> HORIZONTAL_SHAPE;
    public static final EnumProperty<SupportFaceShape> VERTICAL_SHAPE;
    private final ImmutableMap<BlockState, VoxelShape> stateToShapeMap = getStateToShapeMap(this.getStateDefinition());

    public SupportBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(WATERLOGGED, Boolean.FALSE)).setValue(UP, Boolean.TRUE)).setValue(HORIZONTAL_SHAPE, SupportFaceShape.BIG)).setValue(VERTICAL_SHAPE, SupportFaceShape.SMALL));
    }

    @Override
    public boolean isEnabled(FeatureFlagSet $$0) {
        return Services.PLATFORM.isModLoaded(CompatUtils.DECORATIVE_BLOCKS);
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return (VoxelShape)this.stateToShapeMap.get(state);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
        boolean flag = ifluidstate.is(FluidTags.WATER) && ifluidstate.getAmount() == 8;
        BlockState blockstate = (BlockState)((BlockState)this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())).setValue(WATERLOGGED, flag);
        ItemStack stack = context.getItemInHand();
        if (stack.getItem() instanceof SwitchableBlockItem) {
            blockstate = ((SwitchableBlockItem)stack.getItem()).getSwitchedState(blockstate, stack);
        }

        if (!(Boolean)blockstate.getValue(UP)) {
            blockstate = (BlockState)blockstate.setValue(HORIZONTAL_SHAPE, SupportFaceShape.SMALL);
        }

        return blockstate;
    }

    public static void onSupportActivation(BlockState state, Level worldIn, BlockPos pos, Player player, Vec3 hitPos) {
        double hitHeight = hitPos.y() - (double)pos.getY();
        boolean hitVertical;
        if (((SupportFaceShape)state.getValue(HORIZONTAL_SHAPE)).isHidden()) {
            hitVertical = true;
        } else if (((SupportFaceShape)state.getValue(VERTICAL_SHAPE)).isHidden()) {
            hitVertical = false;
        } else if ((Boolean)state.getValue(UP)) {
            hitVertical = hitHeight < 0.8125;
        } else {
            hitVertical = hitHeight > 0.1875;
        }

        if (player.isShiftKeyDown()) {
            if (hitVertical) {
                if (!((SupportFaceShape)state.getValue(HORIZONTAL_SHAPE)).isHidden()) {
                    worldIn.setBlockAndUpdate(pos, (BlockState)state.setValue(VERTICAL_SHAPE, SupportFaceShape.HIDDEN));
                } else {
                    worldIn.setBlockAndUpdate(pos, (BlockState)state.setValue(HORIZONTAL_SHAPE, SupportFaceShape.BIG));
                }
            } else if (!((SupportFaceShape)state.getValue(VERTICAL_SHAPE)).isHidden()) {
                worldIn.setBlockAndUpdate(pos, (BlockState)state.setValue(HORIZONTAL_SHAPE, SupportFaceShape.HIDDEN));
            } else {
                worldIn.setBlockAndUpdate(pos, (BlockState)state.setValue(VERTICAL_SHAPE, SupportFaceShape.SMALL));
            }
        } else if (hitVertical) {
            worldIn.setBlockAndUpdate(pos, (BlockState)state.setValue(VERTICAL_SHAPE, ((SupportFaceShape)state.getValue(VERTICAL_SHAPE)).getSwitched()));
        } else {
            worldIn.setBlockAndUpdate(pos, (BlockState)state.setValue(HORIZONTAL_SHAPE, ((SupportFaceShape)state.getValue(HORIZONTAL_SHAPE)).getSwitched()));
        }

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, WATERLOGGED, UP, HORIZONTAL_SHAPE, VERTICAL_SHAPE});
    }

    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return !(Boolean)state.getValue(WATERLOGGED);
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public boolean isPathfindable(BlockState p_196266_1_, BlockGetter p_196266_2_, BlockPos p_196266_3_, PathComputationType p_196266_4_) {
        return false;
    }

    private static ImmutableMap<BlockState, VoxelShape> getStateToShapeMap(StateDefinition<Block, BlockState> stateManager) {
        Map<BlockState, VoxelShape> map = (Map)stateManager.getPossibleStates().stream().collect(Collectors.toMap(Function.identity(), SupportBlock::getShapeForState));
        return ImmutableMap.copyOf(map);
    }

    private static VoxelShape getShapeForState(BlockState blockState) {
        boolean up = (Boolean)blockState.getValue(UP);
        Direction dir = (Direction)blockState.getValue(FACING);
        boolean ns = dir.getAxis() == Axis.Z;
        VoxelShape horizontal = Shapes.empty();
        VoxelShape vertical = Shapes.empty();
        switch ((SupportFaceShape)blockState.getValue(HORIZONTAL_SHAPE)) {
            case BIG:
                horizontal = up ? TOP_LARGE : BOTTOM_LARGE;
                break;
            case SMALL:
                horizontal = up ? (ns ? TOP_SMALL_NS : TOP_SMALL_EW) : (ns ? BOTTOM_SMALL_NS : BOTTOM_SMALL_EW);
        }

        switch ((SupportFaceShape)blockState.getValue(VERTICAL_SHAPE)) {
            case BIG:
                vertical = (VoxelShape)verticalLarge.get(dir);
                break;
            case SMALL:
                vertical = (VoxelShape)verticalSmall.get(dir);
                break;
            case HIDDEN:
                if (horizontal == Shapes.empty()) {
                    return Shapes.block();
                }
        }

        return Shapes.or(horizontal, vertical);
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        UP = BlockStateProperties.UP;
        HORIZONTAL_SHAPE = ModBlockProperties.HORIZONTAL_SHAPE;
        VERTICAL_SHAPE = ModBlockProperties.VERTICAL_SHAPE;
        verticalSmall = new EnumMap(Direction.class);
        verticalLarge = new EnumMap(Direction.class);
        Plane.HORIZONTAL.stream().forEach((dir) -> {
            int x = dir.getStepX();
            int z = dir.getStepZ();
            verticalLarge.put(dir, Block.box((double)((1 - x * x) * 0) + (double)(x * x) * (6.5 - 6.5 * (double)x), 0.0, (double)((1 - z * z) * 0) + (double)(z * z) * (6.5 - 6.5 * (double)z), (double)((1 - x * x) * 16) + (double)(x * x) * (9.5 + -6.5 * (double)x), 16.0, (double)((1 - z * z) * 16) + (double)(z * z) * (9.5 + -6.5 * (double)z)));
            verticalSmall.put(dir, Block.box((double)(1 - x * x) * 4.0 + (double)(x * x) * (6.5 - 6.5 * (double)x), 0.0, (double)(1 - z * z) * 4.0 + (double)(z * z) * (6.5 - 6.5 * (double)z), (double)(1 - x * x) * 12.0 + (double)(x * x) * (9.5 + -6.5 * (double)x), 16.0, (double)(1 - z * z) * 12.0 + (double)(z * z) * (9.5 + -6.5 * (double)z)));
        });
    }
}
