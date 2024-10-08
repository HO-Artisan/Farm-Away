package ho.artisan.farmaway.common.event;

import ho.artisan.farmaway.common.registry.FABlockTags;
import ho.artisan.farmaway.common.registry.FABlocks;
import ho.artisan.farmaway.common.registry.FACropTransformationRegistry;
import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

public class FASetupEvents {
	public static void registerEvents(IEventBus modEventBus) {
		modEventBus.addListener(FASetupEvents::onSetup);
	}

	private static void onSetup(FMLCommonSetupEvent event) {
		DispenserBlock.registerProjectileBehavior(FAItems.EXPLOSION_POTATO.get());
		FACropTransformationRegistry.register(FABlockTags.FLAME_FARMLANDS, Blocks.POTATOES, FABlocks.EXPLOSION_POTATOES.get());
		FACropTransformationRegistry.register(FABlockTags.SHADOW_FARMLANDS, Blocks.CARROTS, FABlocks.BLUES_CARROTS.get());
		FACropTransformationRegistry.register(FABlockTags.FLAME_FARMLANDS, Blocks.CARROTS, FABlocks.STRONG_CARROTS.get());
		FACropTransformationRegistry.register(FABlockTags.WIND_FARMLANDS, Blocks.MELON_STEM, FABlocks.MELON_ROCKET.get());
		FACropTransformationRegistry.register(FABlockTags.SHADOW_FARMLANDS, Blocks.POTATOES, FABlocks.PHANTOM_POTATOES.get());
		FACropTransformationRegistry.register(FABlockTags.FROZEN_FARMLANDS, Blocks.MELON_STEM, FABlocks.FROZEN_MELON_STEM.get());
	}
}
