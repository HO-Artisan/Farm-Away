package ho.artisan.farm_away.common.item;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import ho.artisan.farm_away.common.registry.FABlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

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
			Blocks.DIORITE,
			Pair.of(HoeItem::onlyIfAirAbove, successful(FABlocks.DIORITE_FARMLAND.get().defaultBlockState())),
			Blocks.ANDESITE,
			Pair.of(HoeItem::onlyIfAirAbove, successful(FABlocks.ANDESITE_FARMLAND.get().defaultBlockState()))
		)
	);
	protected static final Map<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> VANILLA_TILLING_ACTIONS = Maps.newHashMap(
		ImmutableMap.of(
			Blocks.GRASS_BLOCK,
			Pair.of(HoeItem::onlyIfAirAbove, fail()),
			Blocks.DIRT_PATH,
			Pair.of(HoeItem::onlyIfAirAbove, fail()),
			Blocks.DIRT,
			Pair.of(HoeItem::onlyIfAirAbove, fail()),
			Blocks.COARSE_DIRT,
			Pair.of(HoeItem::onlyIfAirAbove, fail())
		)
	);

	public EnhancedHoeItem() {
		super(Tiers.NETHERITE, new Item.Properties().fireResistant().attributes(HoeItem.createAttributes(Tiers.NETHERITE, -4.0F, 0.0F)));
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
			Player player = useOnContext.getPlayer();
			level.playSound(player, blockPos, SoundEvents.GRAVEL_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
			if (level.isClientSide) {
				return;
			}
			level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 11);
			level.gameEvent(GameEvent.BLOCK_DESTROY, blockPos, GameEvent.Context.of(player, level.getBlockState(blockPos)));
			if (player != null) {
				useOnContext.getItemInHand().hurtAndBreak(3, player, LivingEntity.getSlotForHand(useOnContext.getHand()));
			}
		};
	}
}
