package com.kotakotik.createautomated.content.processing.spongeFrame;

import com.kotakotik.createautomated.api.ISpongeFrame;
import com.simibubi.create.content.contraptions.processing.InWorldProcessing;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class SpongeFrameBlock extends DirectionalBlock implements ISpongeFrame {
	@Nullable
	public final InWorldProcessing.Type type;

	public SpongeFrameBlock(Properties p_i48415_1_, @Nullable InWorldProcessing.Type type) {
		super(p_i48415_1_);
		this.type = type;
		registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH));
	}

	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> b) {
		b.add(FACING);
		super.createBlockStateDefinition(b);
	}

	@Override
	public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
		return super.use(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext ctx) {
		return super.getStateForPlacement(ctx).setValue(FACING, ctx.getNearestLookingDirection());
	}

	@Nullable
	@Override
	public InWorldProcessing.Type getType() {
		return type;
	}
}
