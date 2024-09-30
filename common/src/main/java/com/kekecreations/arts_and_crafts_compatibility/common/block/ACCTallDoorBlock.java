package com.kekecreations.arts_and_crafts_compatibility.common.block;

import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCTags;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.util.DramaticDoorsProperties;
import com.kekecreations.arts_and_crafts_compatibility.core.util.DramaticDoorsUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.util.TripleBlockPart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.*;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;


//Original file is from https://github.com/Kitteh6660/DramaticDoors/blob/1.20.1-quifabrge/common/src/main/java/com/fizzware/dramaticdoors/blocks/TallDoorBlock.java
//I am using this code for compat! All credit to original owners!
@SuppressWarnings("deprecation")
public class ACCTallDoorBlock extends Block implements SimpleWaterloggedBlock {

    public static final EnumProperty<TripleBlockPart> THIRD = DramaticDoorsProperties.TRIPLE_BLOCK_THIRD;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final EnumProperty<DoorHingeSide> HINGE = BlockStateProperties.DOOR_HINGE;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
    protected static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape WEST_AABB = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
    private final BlockSetType type;

    public static final ResourceLocation TOOTH_DOOR_RES = new ResourceLocation(CompatUtils.DRAMATIC_DOORS, "tall_tooth_door");

    public ACCTallDoorBlock(Block from, BlockSetType blockset) {
        this(from, blockset, null);
    }

    public ACCTallDoorBlock(Block from, BlockSetType blockset, @Nullable FeatureFlag flag) {
        super(flag != null ? Properties.copy(from).requiredFeatures(flag) : Properties.copy(from));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, Boolean.FALSE).setValue(HINGE, DoorHingeSide.LEFT).setValue(POWERED, Boolean.FALSE).setValue(WATERLOGGED, Boolean.FALSE).setValue(THIRD, TripleBlockPart.LOWER));
        this.type = blockset;
    }

    public ACCTallDoorBlock(Properties properties, BlockSetType blockset) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, Boolean.FALSE).setValue(HINGE, DoorHingeSide.LEFT).setValue(POWERED, Boolean.FALSE).setValue(WATERLOGGED, Boolean.FALSE).setValue(THIRD, TripleBlockPart.LOWER));
        this.type = blockset;
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        TripleBlockPart tripleblockpart = stateIn.getValue(THIRD);
        if (facing.getAxis() == Direction.Axis.Y && ((tripleblockpart == TripleBlockPart.LOWER == (facing == Direction.UP)) || tripleblockpart == TripleBlockPart.MIDDLE)) {
            if (facingState.getBlock() == this && facingState.getValue(THIRD) != tripleblockpart) {
                return stateIn.setValue(FACING, facingState.getValue(FACING)).setValue(OPEN, facingState.getValue(OPEN)).setValue(HINGE, facingState.getValue(HINGE)).setValue(POWERED, facingState.getValue(POWERED));
            } else {
                return Blocks.AIR.defaultBlockState();
            }
        } else {
            if (tripleblockpart == TripleBlockPart.LOWER && facing == Direction.DOWN && !stateIn.canSurvive(level, currentPos)) {
                return Blocks.AIR.defaultBlockState();
            } else {
                return super.updateShape(stateIn, facing, facingState, level, currentPos, facingPos);
            }
        }
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide && player.isCreative()) {
            BlockPos otherPos1 = pos;
            BlockPos otherPos2 = pos;
            TripleBlockPart tripleblockpart = state.getValue(THIRD);
            switch (tripleblockpart) {
                case LOWER:
                    otherPos1 = pos.above();
                    otherPos2 = pos.above(2);
                    break;
                case MIDDLE:
                    otherPos1 = pos.below();
                    otherPos2 = pos.above();
                    break;
                case UPPER:
                    otherPos1 = pos.below(2);
                    otherPos2 = pos.below();
                    break;
            }
            BlockState blockstate1 = level.getBlockState(otherPos1);
            BlockState blockstate2 = level.getBlockState(otherPos2);
            if (blockstate1.getBlock() == state.getBlock() && blockstate1.getValue(THIRD) == TripleBlockPart.LOWER) {
                level.setBlock(otherPos1, blockstate1.getValue(WATERLOGGED) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState(), 35);
                level.levelEvent(player, 2001, otherPos1, Block.getId(blockstate1));
            }
            if (blockstate2.getBlock() == state.getBlock() && blockstate2.getValue(THIRD) == TripleBlockPart.LOWER) {
                level.setBlock(otherPos2, blockstate2.getValue(WATERLOGGED) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState(), 35);
                level.levelEvent(player, 2001, otherPos1, Block.getId(blockstate1));
            }
        }
        super.playerWillDestroy(level, pos, state, player);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        if (blockpos.getY() < context.getLevel().getMaxBuildHeight() - 2 && context.getLevel().getBlockState(blockpos.above()).canBeReplaced(context) && context.getLevel().getBlockState(blockpos.above(2)).canBeReplaced(context)) {
            Level level = context.getLevel();
            boolean flag = level.hasNeighborSignal(blockpos) || level.hasNeighborSignal(blockpos.above());
            boolean waterfilled = level.getFluidState(blockpos).getType() == Fluids.WATER;
            return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(HINGE, this.getHinge(context)).setValue(POWERED, flag).setValue(OPEN, flag).setValue(THIRD, TripleBlockPart.LOWER).setValue(WATERLOGGED, waterfilled);
        } else {
            return null;
        }
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        boolean waterfilled = level.getFluidState(pos.above(1)).getType() == Fluids.WATER;
        boolean waterfilled2 = level.getFluidState(pos.above(2)).getType() == Fluids.WATER;
        level.setBlock(pos.above(), state.setValue(THIRD, TripleBlockPart.MIDDLE).setValue(WATERLOGGED, waterfilled), 3);
        level.setBlock(pos.above().above(), state.setValue(THIRD, TripleBlockPart.UPPER).setValue(WATERLOGGED, waterfilled2), 3);
    }

    private DoorHingeSide getHinge(BlockPlaceContext context) {
        BlockGetter BlockGetter = context.getLevel();
        BlockPos placePos = context.getClickedPos();
        Direction behindDir = context.getHorizontalDirection(); // Behind
        BlockPos placePosAbove = placePos.above();
        Direction leftDir = behindDir.getCounterClockWise(); // Left
        BlockPos leftPos = placePos.relative(leftDir); // Left Pos
        BlockState leftBlockstate = BlockGetter.getBlockState(leftPos); // Left BlockState
        BlockPos leftPosAbove = placePosAbove.relative(leftDir); // Left Up Pos
        BlockState leftAboveBlockstate = BlockGetter.getBlockState(leftPosAbove); // Left Up BlockState
        Direction rightDir = behindDir.getClockWise(); // Right
        BlockPos rightPos = placePos.relative(rightDir); // Right Pos
        BlockState rightBlockstate = BlockGetter.getBlockState(rightPos); // Right Blockstate
        BlockPos rightPosAbove = placePosAbove.relative(rightDir); // Right Up Pos
        BlockState rightAboveBlockstate = BlockGetter.getBlockState(rightPosAbove); // Right Up Blockstate
        int i = (leftBlockstate.isCollisionShapeFullBlock(BlockGetter, leftPos) ? -1 : 0) + (leftAboveBlockstate.isCollisionShapeFullBlock(BlockGetter, leftPosAbove) ? -1 : 0) + (rightBlockstate.isCollisionShapeFullBlock(BlockGetter, rightPos) ? 1 : 0) + (rightAboveBlockstate.isCollisionShapeFullBlock(BlockGetter, rightPosAbove) ? 1 : 0);
        boolean leftIsLowerOfSameType = leftBlockstate.getBlock() == this && leftBlockstate.getValue(THIRD) == TripleBlockPart.LOWER;
        boolean rightIsLowerOfSameType = rightBlockstate.getBlock() == this && rightBlockstate.getValue(THIRD) == TripleBlockPart.LOWER;
        if ((!leftIsLowerOfSameType || rightIsLowerOfSameType) && i <= 0) {
            if ((!rightIsLowerOfSameType || leftIsLowerOfSameType) && i >= 0) {
                int j = behindDir.getStepX();
                int k = behindDir.getStepZ();
                Vec3 vec3d = context.getClickLocation();
                double d0 = vec3d.x - (double)placePos.getX();
                double d1 = vec3d.z - (double)placePos.getZ();
                return (j >= 0 || !(d1 < 0.5D)) && (j <= 0 || !(d1 > 0.5D)) && (k >= 0 || !(d0 > 0.5D)) && (k <= 0 || !(d0 < 0.5D)) ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT;
            } else {
                return DoorHingeSide.LEFT;
            }
        } else {
            return DoorHingeSide.RIGHT;
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (Services.PLATFORM.isModLoaded(CompatUtils.DRAMATIC_DOORS)) {
            if (!this.type.canOpenByHand() && !state.is(ACCTags.MOB_INTERACTABLE_TALL_DOORS)) {
                return InteractionResult.PASS;
            } else {
                if (DramaticDoorsUtils.supplementariesInstalled() && (this == DramaticDoorsUtils.supplementariesTallGoldDoor() && state.getValue(POWERED)) || (this == DramaticDoorsUtils.supplementariesTallSilverDoor() && !state.getValue(POWERED))) {
                    return InteractionResult.PASS;
                }
                tryOpenDoubleDoor(level, state, pos);
                state = state.cycle(OPEN);
                level.setBlock(pos, state, 10);
                this.playSound(player, level, pos, state.getValue(OPEN));
                level.gameEvent(player, state.getValue(OPEN) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
                if (DramaticDoorsUtils.blueprintInstalled() && this == BuiltInRegistries.BLOCK.get(TOOTH_DOOR_RES)) {
                    level.scheduleTick(pos, this, 20);
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (Services.PLATFORM.isModLoaded(CompatUtils.DRAMATIC_DOORS)) {
            if (!DramaticDoorsUtils.blueprintInstalled()) {
                return;
            }
            if (this != BuiltInRegistries.BLOCK.get(TOOTH_DOOR_RES)) {
                return; // Should stop the 'dancing' doors.
            }
            if (!level.isClientSide) {
                state = state.cycle(OPEN);
                level.setBlock(pos, state, 10);
                this.playSound(null, level, pos, state.getValue(OPEN));
            }
        }
    }

    public void toggleDoor(Level level, BlockPos pos, boolean open) {
        BlockState blockstate = level.getBlockState(pos);
        if (blockstate.getBlock() == this && blockstate.getValue(OPEN) != open) {
            level.setBlock(pos, blockstate.setValue(OPEN, open), 10);
            if (blockstate.getValue(THIRD) == TripleBlockPart.UPPER) {
                BlockState middle = level.getBlockState(pos.below());
                BlockState bottom = level.getBlockState(pos.below(2));
                if (middle.getBlock() == this) {
                    level.setBlock(pos.below(), middle.setValue(OPEN, open), 10);
                }
                if (bottom.getBlock() == this) {
                    level.setBlock(pos.below(2), middle.setValue(OPEN, open), 10);
                }
            }
            this.playSound(null, level, pos, open);
        }
    }

    public boolean isOpen(BlockState state) {
        return state.getValue(OPEN);
    }

    public void setOpen(@Nullable Entity entity, Level level, BlockState state, BlockPos pos, boolean open) {
        if (state.is(this) && state.getValue(OPEN) != open) {
            level.setBlock(pos, state.setValue(OPEN, Boolean.valueOf(open)), 10);
            this.playSound(entity, level, pos, open);
            level.gameEvent(entity, open ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            tryOpenDoubleDoor(level, state, pos);
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        boolean flag = level.hasNeighborSignal(pos);
        if (!flag) {
            switch(state.getValue(THIRD)) {
                case LOWER:
                    flag = level.hasNeighborSignal(pos.relative(Direction.UP)) || level.hasNeighborSignal(pos.relative(Direction.UP, 2));
                    break;
                case MIDDLE:
                    flag = level.hasNeighborSignal(pos.relative(Direction.DOWN)) || level.hasNeighborSignal(pos.relative(Direction.UP));
                    break;
                case UPPER:
                    flag = level.hasNeighborSignal(pos.relative(Direction.DOWN)) || level.hasNeighborSignal(pos.relative(Direction.DOWN, 2));
                    break;
            }
        }
        if (Services.PLATFORM.isModLoaded(CompatUtils.DRAMATIC_DOORS)) {
            if (blockIn != this && flag != state.getValue(POWERED)) {
                if (DramaticDoorsUtils.supplementariesInstalled() && (this == DramaticDoorsUtils.supplementariesTallGoldDoor() || this == DramaticDoorsUtils.supplementariesTallSilverDoor())) {
                    level.setBlock(pos, state.setValue(POWERED, flag), 2);
                } else {
                    this.playSound((Entity) null, level, pos, flag);
                    tryOpenDoubleDoor(level, state, pos);
                    level.setBlock(pos, state.setValue(POWERED, flag).setValue(OPEN, flag), 2);
                }
            }
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        boolean result;
        BlockPos below = pos.below();
        BlockPos below2 = below.below();
        BlockState belowState = level.getBlockState(below);
        BlockState below2State = level.getBlockState(below2);
        if (state.getValue(THIRD) == TripleBlockPart.LOWER) {
            result = belowState.isFaceSturdy(level, below, Direction.UP);
            return result;
        } else if (state.getValue(THIRD) == TripleBlockPart.MIDDLE) {
            result = belowState.getBlock() == this;
            return result;
        } else {
            result = belowState.getBlock() == this && below2State.getBlock() == this;
            return result;
        }
    }

    protected void playSound(@Nullable Entity entity, Level level, BlockPos pos, boolean isOpen) {
        level.playSound(entity, pos, isOpen ? this.type.doorOpen() : this.type.doorClose(), SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    @Override
    public long getSeed(BlockState state, BlockPos pos) {
        return Mth.getSeed(pos.getX(), pos.below(state.getValue(THIRD) == TripleBlockPart.LOWER ? 0 : state.getValue(THIRD) == TripleBlockPart.MIDDLE ? 1 : 2).getY(), pos.getZ());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(THIRD, FACING, OPEN, HINGE, POWERED, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        boolean flag = !state.getValue(OPEN);
        boolean flag1 = state.getValue(HINGE) == DoorHingeSide.RIGHT;
        switch(direction) {
            case EAST:
            default:
                return flag ? EAST_AABB : (flag1 ? NORTH_AABB : SOUTH_AABB);
            case SOUTH:
                return flag ? SOUTH_AABB : (flag1 ? EAST_AABB : WEST_AABB);
            case WEST:
                return flag ? WEST_AABB : (flag1 ? SOUTH_AABB : NORTH_AABB);
            case NORTH:
                return flag ? NORTH_AABB : (flag1 ? WEST_AABB : EAST_AABB);
        }
    }

    public boolean allowsMovement(BlockState state, BlockGetter level, BlockPos pos, BlockPathTypes type) {
        switch(type) {
            case WALKABLE:
                return state.getValue(OPEN);
            case WATER:
                return false;
            case OPEN:
                return state.getValue(OPEN);
            default:
                return false;
        }
    }

    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return mirrorIn == Mirror.NONE ? state : state.rotate(mirrorIn.getRotation(state.getValue(FACING))).cycle(HINGE);
    }

    // TODO: Figure out if Zombie breaking Tall Doors is feasible...
    public static boolean isWoodenDoor(Level level, BlockPos pos) {
        return isWoodenDoor(level.getBlockState(pos));
    }

    public static boolean isWoodenDoor(BlockState state) {
        return state.is(ACCTags.TALL_WOODEN_DOORS);
    }

    //Double Doors Compatibility
    public static void tryOpenDoubleDoor(Level world, BlockState state, BlockPos pos) {
        if (Services.PLATFORM.isModLoaded(CompatUtils.DRAMATIC_DOORS)) {
            if (DramaticDoorsUtils.doubleDoorsInstalled() || DramaticDoorsUtils.couplingsInstalled() || DramaticDoorsUtils.quarkInstalled()) {
                Direction direction = state.getValue(HorizontalDirectionalBlock.FACING);
                boolean isOpen = state.getValue(BlockStateProperties.OPEN);
                DoorHingeSide isMirrored = state.getValue(BlockStateProperties.DOOR_HINGE);
                BlockPos mirrorPos = pos.relative(isMirrored == DoorHingeSide.RIGHT ? direction.getCounterClockWise() : direction.getClockWise());
                BlockPos doorPos = state.getValue(THIRD) == TripleBlockPart.LOWER ? mirrorPos : mirrorPos.below();
                BlockState other = world.getBlockState(doorPos);
                if (other.getBlock() == state.getBlock() && other.getValue(HorizontalDirectionalBlock.FACING) == direction && !other.getValue(BlockStateProperties.POWERED) && other.getValue(BlockStateProperties.OPEN) == isOpen && other.getValue(BlockStateProperties.DOOR_HINGE) != isMirrored) {
                    BlockState newState = other.cycle(BlockStateProperties.OPEN);
                    world.setBlock(doorPos, newState, 10);
                }
            }
        }
    }

    public BlockSetType type() {
        return this.type;
    }
}