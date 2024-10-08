package ho.artisan.farmaway.common.item;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import ho.artisan.farmaway.common.registry.FABlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EnhancedHoeItem extends HoeItem {
	protected static final Map<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> TILLING_ACTIONS = Maps.newHashMap(
		ImmutableMap.of(
			Blocks.STONE,
			Pair.of(HoeItem::onlyIfAirAbove, successful(FABlocks.STONE_FARMLAND.get().defaultBlockState())),
			Blocks.NETHERRACK,
			Pair.of(HoeItem::onlyIfAirAbove, successful(FABlocks.NETHERRACK_FARMLAND.get().defaultBlockState())),
			Blocks.END_STONE,
			Pair.of(HoeItem::onlyIfAirAbove, successful(FABlocks.END_STONE_FARMLAND.get().defaultBlockState())),
			Blocks.GRANITE,
			Pair.of(HoeItem::onlyIfAirAbove, successful(FABlocks.GRANITE_FARMLAND.get().defaultBlockState())),
			Blocks.ANDESITE,
			Pair.of(HoeItem::onlyIfAirAbove, successful(FABlocks.ANDESITE_FARMLAND.get().defaultBlockState())),
			Blocks.DIORITE,
			Pair.of(HoeItem::onlyIfAirAbove, successful(FABlocks.DIORITE_FARMLAND.get().defaultBlockState()))
		)
	);
	protected static final Map<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> VANILLA_TILLING_ACTIONS = Maps.newHashMap(
		ImmutableMap.of(
			Blocks.GRASS_BLOCK,
			Pair.of(HoeItem::onlyIfAirAbove, fail()),
			Blocks.DIRT_PATH,
			Pair.of(HoeItem::onlyIfAirAbove, fail()),
			Blocks.DIRT,
			Pair.of(HoeItem::onlyIfAirAbove, fail())
		)
	);

	public EnhancedHoeItem(Tier tier, Properties properties) {
		super(tier, properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Map<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> map = Maps.newHashMap(TILLING_ACTIONS);
		map.putAll(VANILLA_TILLING_ACTIONS);
		Level level = context.getLevel();
		BlockPos blockPos = context.getClickedPos();
		Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = map.get(level.getBlockState(blockPos).getBlock());
		if (pair == null) {
			return InteractionResult.PASS;
		} else {
			Predicate<UseOnContext> predicate = pair.getFirst();
			Consumer<UseOnContext> consumer = pair.getSecond();
			if (predicate.test(context)) {
				consumer.accept(context);
				return InteractionResult.sidedSuccess(level.isClientSide);
			} else {
				return InteractionResult.PASS;
			}
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
		tooltipComponents.add(Component.translatable(getDescriptionId() + ".tooltip").withStyle(ChatFormatting.YELLOW));
		for (Block block : TILLING_ACTIONS.keySet()) {
			tooltipComponents.add(Component.translatable(block.getDescriptionId()).withStyle(ChatFormatting.DARK_GREEN));
		}
	}

	public static Consumer<UseOnContext> successful(BlockState blockState) {
		return useOnContext -> {
			Level level = useOnContext.getLevel();
			BlockPos blockPos = useOnContext.getClickedPos();
			Player player = useOnContext.getPlayer();
			level.playSound(player, blockPos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
			if (level.isClientSide) {
				return;
			}
			level.setBlock(blockPos, blockState, 11);
			level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, blockState));
			if (player != null) {
				useOnContext.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(useOnContext.getHand()));
			}
		};
	}

	public static Consumer<UseOnContext> fail() {
		return useOnContext -> {
			Level level = useOnContext.getLevel();
			BlockPos blockPos = useOnContext.getClickedPos();
			BlockState blockState = level.getBlockState(blockPos);
			Player player = useOnContext.getPlayer();
			if (level.isClientSide) {
				level.levelEvent(player, 2001, blockPos, Block.getId(blockState));
				return;
			}
			level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 11);
			level.gameEvent(GameEvent.BLOCK_DESTROY, blockPos, GameEvent.Context.of(player, blockState));
			if (player != null) {
				useOnContext.getItemInHand().hurtAndBreak(3, player, LivingEntity.getSlotForHand(useOnContext.getHand()));
			}
		};
	}
}
