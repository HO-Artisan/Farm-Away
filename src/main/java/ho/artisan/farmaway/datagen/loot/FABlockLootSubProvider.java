package ho.artisan.farmaway.datagen.loot;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.block.BluesCarrotBlock;
import ho.artisan.farmaway.common.block.ExplosionPotatoBlock;
import ho.artisan.farmaway.common.block.StrongCarrotBlock;
import ho.artisan.farmaway.common.registry.FABlocks;
import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;

import java.util.Set;
import java.util.stream.Collectors;

public class FABlockLootSubProvider extends BlockLootSubProvider {
	public FABlockLootSubProvider(HolderLookup.Provider lookup) {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookup);
	}

	@Override
	protected void generate() {
		dropOther(FABlocks.STONE_FARMLAND.get(), Blocks.STONE);
		dropOther(FABlocks.NETHERRACK_FARMLAND.get(), Blocks.NETHERRACK);
		dropOther(FABlocks.END_STONE_FARMLAND.get(), Blocks.END_STONE);
		dropOther(FABlocks.GRANITE_FARMLAND.get(), Blocks.GRANITE);
		dropOther(FABlocks.ANDESITE_FARMLAND.get(), Blocks.ANDESITE);
		dropOther(FABlocks.DIORITE_FARMLAND.get(), Blocks.DIORITE);
		add(FABlocks.EXPLOSION_POTATO.get(), this.createCropDrops(FABlocks.EXPLOSION_POTATO.get(), FAItems.EXPLOSION_POTATO.get(), FAItems.EXPLOSION_POTATO.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(FABlocks.EXPLOSION_POTATO.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ExplosionPotatoBlock.AGE, 7))));
		add(FABlocks.BLUES_CARROT.get(), this.createCropDrops(FABlocks.BLUES_CARROT.get(), FAItems.BLUES_CARROT.get(), FAItems.BLUES_CARROT.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(FABlocks.BLUES_CARROT.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BluesCarrotBlock.AGE, 15))));
		add(FABlocks.STRONG_CARROT.get(), this.createCropDrops(FABlocks.STRONG_CARROT.get(), FAItems.STRONG_CARROT.get(), FAItems.STRONG_CARROT.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(FABlocks.STRONG_CARROT.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrongCarrotBlock.AGE, 3))));
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return BuiltInRegistries.BLOCK.stream().filter(block -> BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals(FarmAway.MOD_ID)).collect(Collectors.toList());
	}
}
