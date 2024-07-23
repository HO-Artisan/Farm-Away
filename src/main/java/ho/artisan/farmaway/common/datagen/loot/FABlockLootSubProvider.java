package ho.artisan.farmaway.common.datagen.loot;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FABlocks;
import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

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
		dropOther(FABlocks.EXPLOSION_POTATO.get(), FAItems.EXPLOSION_POTATO);
		dropOther(FABlocks.BLUE_CARROT.get(), FAItems.EXPLOSION_POTATO);// todo
		dropOther(FABlocks.STRONG_CARROT.get(), FAItems.STRONG_CARROT);
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return BuiltInRegistries.BLOCK.stream().filter(block -> BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals(FarmAway.MOD_ID)).collect(Collectors.toList());
	}
}
