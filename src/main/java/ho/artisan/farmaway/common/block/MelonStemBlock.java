package ho.artisan.farmaway.common.block;

import net.minecraft.world.level.block.StemBlock;

import static ho.artisan.farmaway.common.registry.FABlocks.blockKey;
import static ho.artisan.farmaway.common.registry.FABlocks.itemKey;

public class MelonStemBlock extends StemBlock {
	public MelonStemBlock(String name, Properties properties) {
		super(blockKey(name+"_melon"), blockKey("attached_"+name+"_melon_stem"), itemKey(name+"_melon_seed"), properties);
	}
}
