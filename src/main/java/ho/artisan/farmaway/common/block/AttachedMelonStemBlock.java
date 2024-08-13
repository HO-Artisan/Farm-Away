package ho.artisan.farmaway.common.block;

import net.minecraft.world.level.block.AttachedStemBlock;

import static ho.artisan.farmaway.common.registry.FABlocks.blockKey;
import static ho.artisan.farmaway.common.registry.FABlocks.itemKey;

public class AttachedMelonStemBlock extends AttachedStemBlock {
	public AttachedMelonStemBlock(String name, Properties properties) {
		super(blockKey(name+"_melon_stem"), blockKey(name+"_melon"), itemKey(name+"_melon_seed"), properties);
	}
}
