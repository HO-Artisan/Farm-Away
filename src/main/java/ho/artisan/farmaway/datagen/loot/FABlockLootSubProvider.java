package ho.artisan.farmaway.datagen.loot;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.block.*;
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
		add(FABlocks.EMPTY_ROOT.get(), noDrop());
		add(FABlocks.EXPLOSION_POTATOES.get(), this.createCropDrops(FABlocks.EXPLOSION_POTATOES.get(), FAItems.EXPLOSION_POTATO.get(), FAItems.EXPLOSION_POTATO.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(FABlocks.EXPLOSION_POTATOES.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ExplosionPotatoBlock.AGE, 7))));
		add(FABlocks.SOFT_POTATOES.get(), this.createCropDrops(FABlocks.SOFT_POTATOES.get(), FAItems.SOFT_POTATO.get(), FAItems.SOFT_POTATO.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(FABlocks.SOFT_POTATOES.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SoftPotatoBlock.AGE, 7))));
		add(FABlocks.GERBERA_POTATOES.get(), this.createCropDrops(FABlocks.GERBERA_POTATOES.get(), FAItems.GERBERA_POTATO.get(), FAItems.GERBERA_POTATO.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(FABlocks.GERBERA_POTATOES.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GerberaPotatoBlock.AGE, 7))));
		add(FABlocks.ROSE_POTATOES.get(), this.createCropDrops(FABlocks.ROSE_POTATOES.get(), FAItems.ROSE_POTATO.get(), FAItems.ROSE_POTATO.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(FABlocks.ROSE_POTATOES.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RosePotatoBlock.AGE, 7))));
		add(FABlocks.PHANTOM_BEETROOTS.get(), this.createCropDrops(FABlocks.PHANTOM_BEETROOTS.get(), FAItems.ROSE_POTATO.get(), FAItems.ROSE_POTATO.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(FABlocks.PHANTOM_BEETROOTS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PhantomBeetrootBlock.AGE, 7))));
		add(FABlocks.BLUES_CARROTS.get(), this.createCropDrops(FABlocks.BLUES_CARROTS.get(), FAItems.BLUES_CARROT.get(), FAItems.BLUES_CARROT.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(FABlocks.BLUES_CARROTS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BluesCarrotBlock.AGE, 15))));
		add(FABlocks.PHANTOM_POTATOES.get(), this.createCropDrops(FABlocks.PHANTOM_POTATOES.get(), FAItems.PHANTOM_POTATO.get(), FAItems.PHANTOM_POTATO.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(FABlocks.PHANTOM_POTATOES.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PhantomPotatoBlock.AGE, 7))));
		add(FABlocks.STRONG_CARROTS.get(), this.createCropDrops(FABlocks.STRONG_CARROTS.get(), FAItems.STRONG_CARROT.get(), FAItems.STRONG_CARROT.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(FABlocks.STRONG_CARROTS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrongCarrotBlock.AGE, 3))));
		add(FABlocks.MELON_ROCKET.get(), this.createCropDrops(FABlocks.MELON_ROCKET.get(), FAItems.MELON_ROCKET.get(), FAItems.MELON_ROCKET.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(FABlocks.MELON_ROCKET.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MelonRocketBlock.AGE, 7))));
		dropSelf(FABlocks.PHANTOM_DIRT.get());
		dropSelf(FABlocks.SOLID_CLOUD.get());
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return BuiltInRegistries.BLOCK.stream().filter(block -> BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals(FarmAway.MOD_ID)).collect(Collectors.toList());
	}
}
