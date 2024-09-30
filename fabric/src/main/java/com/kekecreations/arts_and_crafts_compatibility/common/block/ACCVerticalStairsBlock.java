package com.kekecreations.arts_and_crafts_compatibility.common.block;

import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.util.ExcessiveBuildingUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

//Original file is from Excessive Building made by Yirmiri
public class ACCVerticalStairsBlock extends Block implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING;
    public static final BooleanProperty WATERLOGGED;
    private static final VoxelShape SHAPE_NORTH;
    private static final VoxelShape SHAPE_EAST;
    private static final VoxelShape SHAPE_WEST;
    private static final VoxelShape SHAPE_SOUTH;

    public ACCVerticalStairsBlock(BlockBehaviour.Properties settings) {
        super(settings);
        this.registerDefaultState((BlockState)((BlockState)this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)).setValue(WATERLOGGED, false));
    }


    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        switch ((Direction)state.getValue(FACING)) {
            case NORTH -> {
                return SHAPE_NORTH;
            }
            case EAST -> {
                return SHAPE_EAST;
            }
            case WEST -> {
                return SHAPE_WEST;
            }
            default -> {
                return SHAPE_SOUTH;
            }
        }
    }

    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return (BlockState)((BlockState)this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite())).setValue(WATERLOGGED, ctx.getLevel().getFluidState(ctx.getClickedPos()).is(Fluids.WATER));
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return (BlockState)state.setValue(FACING, rotation.rotate((Direction)state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, WATERLOGGED});
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if ((Boolean)state.getValue(WATERLOGGED)) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    public boolean isEnabled(FeatureFlagSet enable) {
        if (Services.PLATFORM.isModLoaded(CompatUtils.EXCESSIVE_BUILDING)) {
            return ExcessiveBuildingUtils.verticalStairs();
        }
        return false;
    }

    static {
        FACING = BlockStateProperties.HORIZONTAL_FACING;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        SHAPE_NORTH = (VoxelShape) Stream.of(Block.box(0.0, 0.0, 8.0, 8.0, 16.0, 16.0), Block.box(8.0, 0.0, 0.0, 16.0, 16.0, 16.0)).reduce((v1, v2) -> {
            return Shapes.join(v1, v2, BooleanOp.OR);
        }).get();
        SHAPE_EAST = (VoxelShape)Stream.of(Block.box(0.0, 0.0, 0.0, 8.0, 16.0, 8.0), Block.box(0.0, 0.0, 8.0, 16.0, 16.0, 16.0)).reduce((v1, v2) -> {
            return Shapes.join(v1, v2, BooleanOp.OR);
        }).get();
        SHAPE_WEST = (VoxelShape)Stream.of(Block.box(8.0, 0.0, 8.0, 16.0, 16.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 8.0)).reduce((v1, v2) -> {
            return Shapes.join(v1, v2, BooleanOp.OR);
        }).get();
        SHAPE_SOUTH = (VoxelShape)Stream.of(Block.box(8.0, 0.0, 0.0, 16.0, 16.0, 8.0), Block.box(0.0, 0.0, 0.0, 8.0, 16.0, 16.0)).reduce((v1, v2) -> {
            return Shapes.join(v1, v2, BooleanOp.OR);
        }).get();
    }
}
