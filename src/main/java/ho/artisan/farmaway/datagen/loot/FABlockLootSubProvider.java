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
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

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

		dropSelf(FABlocks.PHANTOM_DIRT.get());
		dropSelf(FABlocks.SOLID_CLOUD.get());

		add(FABlocks.EMPTY_ROOT.get(), noDrop());
		//Potato
		dropCrop(FABlocks.EXPLOSION_POTATOES.get(), FAItems.EXPLOSION_POTATO.get(), FAItems.EXPLOSION_POTATO.get(), ageCondition(FABlocks.EXPLOSION_POTATOES.get(), ExplosionPotatoBlock.AGE, 7));
		dropCrop(FABlocks.SOFT_POTATOES.get(), FAItems.SOFT_POTATO.get(), FAItems.SOFT_POTATO.get(), ageCondition(FABlocks.SOFT_POTATOES.get(), SoftPotatoBlock.AGE, 7));
		dropCrop(FABlocks.GERBERA_POTATOES.get(), FAItems.GERBERA_POTATO.get(), FAItems.GERBERA_POTATO.get(),ageCondition(FABlocks.GERBERA_POTATOES.get(), GerberaPotatoBlock.AGE, 7));
		dropCrop(FABlocks.ROSE_POTATOES.get(), FAItems.ROSE_POTATO.get(), FAItems.ROSE_POTATO.get(), ageCondition(FABlocks.ROSE_POTATOES.get(), RosePotatoBlock.AGE, 7));
		dropCrop(FABlocks.PHANTOM_BEETROOTS.get(), FAItems.ROSE_POTATO.get(), FAItems.ROSE_POTATO.get(), ageCondition(FABlocks.PHANTOM_BEETROOTS.get(), PhantomBeetrootBlock.AGE, 7));
		dropCrop(FABlocks.PHANTOM_POTATOES.get(), FAItems.PHANTOM_POTATO.get(), FAItems.PHANTOM_POTATO.get(), ageCondition(FABlocks.PHANTOM_POTATOES.get(), PhantomPotatoBlock.AGE, 7));
		dropCrop(FABlocks.STONATOES.get(), FAItems.STONATO.get(), FAItems.STONATO.get(), ageCondition(FABlocks.STONATOES.get(), StonatoBlock.AGE, 6));
		//Carrot
		dropCrop(FABlocks.BLUES_CARROTS.get(), FAItems.BLUES_CARROT.get(), FAItems.BLUES_CARROT.get(), ageCondition(FABlocks.BLUES_CARROTS.get(), BluesCarrotBlock.AGE, 15));
		dropCrop(FABlocks.STRONG_CARROTS.get(), FAItems.STRONG_CARROT.get(), FAItems.STRONG_CARROT.get(), ageCondition(FABlocks.STRONG_CARROTS.get(), StrongCarrotBlock.AGE, 3));
		dropCrop(FABlocks.RODRIGUES_CARROTS.get(), FAItems.RODRIGUES_CARROT.get(), FAItems.RODRIGUES_CARROT.get(), ageCondition(FABlocks.RODRIGUES_CARROTS.get(), RodriguesCarrotBlock.AGE, 7));
		dropCrop(FABlocks.DRILL_CARROTS.get(), FAItems.DRILL_CARROT.get(), FAItems.DRILL_CARROT.get(), ageCondition(FABlocks.DRILL_CARROTS.get(), DrillCarrotBlock.AGE, 7));
		dropCrop(FABlocks.HOT_CARROTS.get(), FAItems.HOT_CARROT.get(), FAItems.HOT_CARROT.get(), ageCondition(FABlocks.HOT_CARROTS.get(), HotCarrotBlock.AGE, 7));
		dropCrop(FABlocks.DISTORTED_CARROTS.get(), FAItems.DISTORTED_CARROT.get(), FAItems.DISTORTED_CARROT.get(), ageCondition(FABlocks.DISTORTED_CARROTS.get(), DistortedCarrotBlock.AGE, 7));
		//Melon
		dropCrop(FABlocks.MELON_ROCKET.get(), FAItems.MELON_ROCKET.get(), FAItems.MELON_ROCKET.get(), ageCondition(FABlocks.MELON_ROCKET.get(), MelonRocketBlock.AGE, 7));
	}

	private void dropCrop(Block cropBlock, Item grownCropItem, Item seedsItem, LootItemCondition.Builder dropGrownCropCondition) {
		add(cropBlock, this.createCropDrops(cropBlock, grownCropItem, seedsItem, dropGrownCropCondition));
	}

	private static LootItemBlockStatePropertyCondition.Builder ageCondition(Block cropBlock, Property<Integer> property, int age) {
		return LootItemBlockStatePropertyCondition.hasBlockStateProperties(cropBlock).setProperties(intProperties(property, age));
	}

	private static StatePropertiesPredicate.Builder intProperties(Property<Integer> property, int value) {
		return StatePropertiesPredicate.Builder.properties().hasProperty(property, value);
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return BuiltInRegistries.BLOCK.stream().filter(block -> BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals(FarmAway.MOD_ID)).collect(Collectors.toList());
	}
}
