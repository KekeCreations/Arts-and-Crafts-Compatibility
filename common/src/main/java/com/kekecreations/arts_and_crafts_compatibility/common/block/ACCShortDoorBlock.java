package com.kekecreations.arts_and_crafts_compatibility.common.block;

import com.kekecreations.arts_and_crafts_compatibility.core.registry.ACCTags;
import com.kekecreations.arts_and_crafts_compatibility.core.util.CompatUtils;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.util.DramaticDoorsUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
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

//Original file is from https://github.com/Kitteh6660/DramaticDoors/blob/master/common/src/main/java/com/fizzware/dramaticdoors/blocks/ShortDoorBlock.java
//I'm using their code for compat!
public class ACCShortDoorBlock extends Block implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING;
    public static final BooleanProperty OPEN;
    public static final EnumProperty<DoorHingeSide> HINGE;
    public static final BooleanProperty POWERED;
    public static final BooleanProperty WATERLOGGED;
    protected static final VoxelShape SOUTH_AABB;
    protected static final VoxelShape NORTH_AABB;
    protected static final VoxelShape WEST_AABB;
    protected static final VoxelShape EAST_AABB;
    private final BlockSetType type;
    public static final ResourceLocation TOOTH_DOOR_RES;

    public ACCShortDoorBlock(Block from, BlockSetType blockset) {
        this(from, blockset, (FeatureFlag) null);
    }

    public ACCShortDoorBlock(Block from, BlockSetType blockset, @Nullable FeatureFlag flag) {
        super(flag != null ? Properties.copy(from).requiredFeatures(new FeatureFlag[]{flag}) : Properties.copy(from));
        this.registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(OPEN, Boolean.FALSE)).setValue(HINGE, DoorHingeSide.LEFT)).setValue(POWERED, Boolean.FALSE)).setValue(WATERLOGGED, Boolean.FALSE));
        this.type = blockset;
    }

    public ACCShortDoorBlock(BlockBehaviour.Properties properties, BlockSetType blockset) {
        super(properties);
        this.registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(OPEN, Boolean.FALSE)).setValue(HINGE, DoorHingeSide.LEFT)).setValue(POWERED, Boolean.FALSE)).setValue(WATERLOGGED, Boolean.FALSE));
        this.type = blockset;
    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return !this.canSurvive(stateIn, level, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, level, currentPos, facingPos);
    }

    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        super.playerWillDestroy(level, pos, state, player);
    }

    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        if (blockpos.getY() < context.getLevel().getMaxBuildHeight() && context.getLevel().getBlockState(blockpos).canBeReplaced(context)) {
            Level level = context.getLevel();
            Direction face = context.getHorizontalDirection();
            DoorHingeSide hinge = this.getHinge(context);
            boolean flag = level.hasNeighborSignal(blockpos) || level.hasNeighborSignal(blockpos.above());
            boolean waterfilled = level.getFluidState(blockpos).getType() == Fluids.WATER;
            if (context.getClickedFace() == context.getHorizontalDirection().getOpposite() && context.getClickedFace().getAxis().isHorizontal()) {
                face = face.getOpposite();
                hinge = hinge == DoorHingeSide.LEFT ? DoorHingeSide.RIGHT : DoorHingeSide.LEFT;
            }

            return (BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) this.defaultBlockState().setValue(FACING, face)).setValue(HINGE, hinge)).setValue(POWERED, flag)).setValue(OPEN, flag)).setValue(WATERLOGGED, waterfilled);
        } else {
            return null;
        }
    }

    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
    }

    protected DoorHingeSide getHinge(BlockPlaceContext context) {
        BlockGetter BlockGetter = context.getLevel();
        BlockPos placePos = context.getClickedPos();
        Direction behindDir = context.getHorizontalDirection();
        Direction leftDir = behindDir.getCounterClockWise();
        BlockPos leftPos = placePos.relative(leftDir);
        BlockState leftBlockstate = BlockGetter.getBlockState(leftPos);
        Direction rightDir = behindDir.getClockWise();
        BlockPos rightPos = placePos.relative(rightDir);
        BlockState rightBlockstate = BlockGetter.getBlockState(rightPos);
        int i = (leftBlockstate.isCollisionShapeFullBlock(BlockGetter, leftPos) ? -1 : 0) + (rightBlockstate.isCollisionShapeFullBlock(BlockGetter, rightPos) ? 1 : 0);
        boolean leftIsLowerOfSameType = leftBlockstate.getBlock() == this;
        boolean rightIsLowerOfSameType = rightBlockstate.getBlock() == this;
        if ((!leftIsLowerOfSameType || rightIsLowerOfSameType) && i <= 0) {
            if ((!rightIsLowerOfSameType || leftIsLowerOfSameType) && i >= 0) {
                int j = behindDir.getStepX();
                int k = behindDir.getStepZ();
                Vec3 vec3d = context.getClickLocation();
                double d0 = vec3d.x - (double) placePos.getX();
                double d1 = vec3d.z - (double) placePos.getZ();
                return j < 0 && d1 < 0.5 || j > 0 && d1 > 0.5 || k < 0 && d0 > 0.5 || k > 0 && d0 < 0.5 ? DoorHingeSide.RIGHT : DoorHingeSide.LEFT;
            } else {
                return DoorHingeSide.LEFT;
            }
        } else {
            return DoorHingeSide.RIGHT;
        }
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (Services.PLATFORM.isModLoaded(CompatUtils.DRAMATIC_DOORS)) {
            if (!this.type.canOpenByHand() && !state.is(ACCTags.MOB_INTERACTABLE_SHORT_DOORS)) {
                return InteractionResult.PASS;
            } else if ((!DramaticDoorsUtils.supplementariesInstalled() || this != DramaticDoorsUtils.supplementariesShortGoldDoor() || !(Boolean) state.getValue(POWERED)) && (this != DramaticDoorsUtils.supplementariesShortSilverDoor() || (Boolean) state.getValue(POWERED))) {
                tryOpenDoubleDoor(level, state, pos);
                state = (BlockState) state.cycle(OPEN);
                level.setBlock(pos, state, 10);
                this.playSound(player, level, pos, (Boolean) state.getValue(OPEN));
                level.gameEvent(player, (Boolean) state.getValue(OPEN) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
                if ((Boolean) state.getValue(WATERLOGGED)) {
                    level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
                }

                if (DramaticDoorsUtils.blueprintInstalled() && this == BuiltInRegistries.BLOCK.get(TOOTH_DOOR_RES)) {
                    level.scheduleTick(pos, this, 20);
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }
        return InteractionResult.PASS;
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (Services.PLATFORM.isModLoaded(CompatUtils.DRAMATIC_DOORS)) {
            if (DramaticDoorsUtils.blueprintInstalled()) {
                if (this == BuiltInRegistries.BLOCK.get(TOOTH_DOOR_RES)) {
                    if (!level.isClientSide) {
                        state = (BlockState) state.cycle(OPEN);
                        level.setBlock(pos, state, 10);
                        this.playSound((Entity) null, level, pos, (Boolean) state.getValue(OPEN));
                    }

                }
            }
        }
    }

    public void toggleDoor(Level level, BlockPos pos, boolean open) {
        BlockState blockstate = level.getBlockState(pos);
        if (blockstate.getBlock() == this && (Boolean) blockstate.getValue(OPEN) != open) {
            level.setBlock(pos, (BlockState) blockstate.setValue(OPEN, open), 10);
            this.playSound((Entity) null, level, pos, open);
        }

    }

    public boolean isOpen(BlockState state) {
        return (Boolean) state.getValue(OPEN);
    }

    public void setOpen(@Nullable Entity entity, Level level, BlockState state, BlockPos pos, boolean open) {
        if (state.is(this) && (Boolean) state.getValue(OPEN) != open) {
            level.setBlock(pos, (BlockState) state.setValue(OPEN, open), 10);
            this.playSound(entity, level, pos, open);
            level.gameEvent(entity, open ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            tryOpenDoubleDoor(level, state, pos);
            BlockState stateAbove = level.getBlockState(pos.above(1));
            if (stateAbove.is(ACCTags.SHORT_WOODEN_DOORS) && (level.isNight() && (open || (Boolean) stateAbove.getValue(OPEN)) || level.isDay() && !(Boolean) stateAbove.getValue(OPEN))) {
                level.setBlock(pos.above(), (BlockState) stateAbove.setValue(OPEN, open), 10);
            }
        }

    }

    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (Services.PLATFORM.isModLoaded(CompatUtils.DRAMATIC_DOORS)) {
            boolean flag = level.hasNeighborSignal(pos);
            if (blockIn != this && flag != (Boolean) state.getValue(POWERED)) {
                if ((!DramaticDoorsUtils.supplementariesInstalled() || this != DramaticDoorsUtils.supplementariesShortGoldDoor()) && this != DramaticDoorsUtils.supplementariesShortSilverDoor()) {
                    if (flag != (Boolean) state.getValue(OPEN)) {
                        this.playSound((Entity) null, level, pos, flag);
                    }

                    tryOpenDoubleDoor(level, state, pos);
                    level.setBlock(pos, (BlockState) ((BlockState) state.setValue(POWERED, flag)).setValue(OPEN, flag), 2);
                    if ((Boolean) state.getValue(WATERLOGGED)) {
                        level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
                    }
                } else {
                    level.setBlock(pos, (BlockState) state.setValue(POWERED, flag), 2);
                }
            }
        }
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return true;
    }

    protected void playSound(@Nullable Entity entity, Level level, BlockPos pos, boolean isOpen) {
        level.playSound(entity, pos, isOpen ? this.type.doorOpen() : this.type.doorClose(), SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    public long getSeed(BlockState state, BlockPos pos) {
        return Mth.getSeed(pos.getX(), pos.getY(), pos.getZ());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, OPEN, HINGE, POWERED, WATERLOGGED});
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean) state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = (Direction) state.getValue(FACING);
        boolean flag = !(Boolean) state.getValue(OPEN);
        boolean flag1 = state.getValue(HINGE) == DoorHingeSide.RIGHT;
        switch (direction) {
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
        switch (type) {
            case WALKABLE -> {
                return (Boolean) state.getValue(OPEN);
            }
            case WATER -> {
                return false;
            }
            case OPEN -> {
                return (Boolean) state.getValue(OPEN);
            }
            default -> {
                return false;
            }
        }
    }

    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return (BlockState) state.setValue(FACING, rot.rotate((Direction) state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return mirrorIn == Mirror.NONE ? state : (BlockState) state.rotate(mirrorIn.getRotation((Direction) state.getValue(FACING))).cycle(HINGE);
    }

    public static boolean isWoodenDoor(Level level, BlockPos pos) {
        return isWoodenDoor(level.getBlockState(pos));
    }

    public static boolean isWoodenDoor(BlockState state) {
        return state.is(ACCTags.SHORT_WOODEN_DOORS);
    }

    public static void tryOpenDoubleDoor(Level world, BlockState state, BlockPos pos) {
        if (Services.PLATFORM.isModLoaded(CompatUtils.DRAMATIC_DOORS)) {
            if (DramaticDoorsUtils.doubleDoorsInstalled() || DramaticDoorsUtils.couplingsInstalled()) {
                Direction direction = (Direction) state.getValue(FACING);
                boolean isOpen = (Boolean) state.getValue(OPEN);
                DoorHingeSide isMirrored = (DoorHingeSide) state.getValue(HINGE);
                BlockPos mirrorPos = pos.relative(isMirrored == DoorHingeSide.RIGHT ? direction.getCounterClockWise() : direction.getClockWise());
                BlockPos doorPos = mirrorPos;
                BlockState other = world.getBlockState(doorPos);
                if (other.getBlock() == state.getBlock() && other.getValue(FACING) == direction && !(Boolean) other.getValue(POWERED) && (Boolean) other.getValue(OPEN) == isOpen && other.getValue(HINGE) != isMirrored) {
                    BlockState newState = (BlockState) other.cycle(OPEN);
                    world.setBlock(doorPos, newState, 10);
                }
            }
        }
    }

    public BlockSetType type() {
        return this.type;
    }


    @Override
    public boolean isEnabled(FeatureFlagSet featureFlagSet) {
        return Services.PLATFORM.isModLoaded(CompatUtils.DRAMATIC_DOORS);
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        OPEN = BlockStateProperties.OPEN;
        HINGE = BlockStateProperties.DOOR_HINGE;
        POWERED = BlockStateProperties.POWERED;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
        NORTH_AABB = Block.box(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
        WEST_AABB = Block.box(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        EAST_AABB = Block.box(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
        TOOTH_DOOR_RES = new ResourceLocation("dramaticdoors", "short_tooth_door");
    }
}
