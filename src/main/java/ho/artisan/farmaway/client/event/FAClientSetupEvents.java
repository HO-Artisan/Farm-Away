package ho.artisan.farmaway.client.event;

import com.mojang.blaze3d.vertex.PoseStack;
import ho.artisan.farmaway.FarmAway;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.model.BakedModelWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = FarmAway.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class FAClientSetupEvents {
	public static final Map<ModelResourceLocation, Map<ItemDisplayContext, ModelResourceLocation>> ITEMS_WITH_SPECIAL_MODELS = new HashMap<>(Map.ofEntries(
		Map.entry(ModelResourceLocation.inventory(FarmAway.getResourceLocation("enhanced_hoe")), Map.of(
			ItemDisplayContext.HEAD, ModelResourceLocation.standalone(FarmAway.getResourceLocation("item/enhanced_hoe_inventory")),
			ItemDisplayContext.GUI, ModelResourceLocation.standalone(FarmAway.getResourceLocation("item/enhanced_hoe_inventory")),
			ItemDisplayContext.GROUND, ModelResourceLocation.standalone(FarmAway.getResourceLocation("item/enhanced_hoe_inventory")),
			ItemDisplayContext.FIXED, ModelResourceLocation.standalone(FarmAway.getResourceLocation("item/enhanced_hoe_inventory"))
		))
	));

	public static final Map<ModelResourceLocation, BakedModel> BAKED_MODELS = new HashMap<>();

	@SubscribeEvent
	private static void onRegisterAdditionalModels(ModelEvent.RegisterAdditional event) {
		for (Map.Entry<ModelResourceLocation, Map<ItemDisplayContext, ModelResourceLocation>> entry : ITEMS_WITH_SPECIAL_MODELS.entrySet()) {
			for (Map.Entry<ItemDisplayContext, ModelResourceLocation> entry1 : entry.getValue().entrySet()) {
				event.register(entry1.getValue());
			}
		}
	}

	@SubscribeEvent
	private static void onModifyBakingResult(ModelEvent.ModifyBakingResult event) {
		BAKED_MODELS.clear();
		BAKED_MODELS.putAll(event.getModels());
		for (ModelResourceLocation location : event.getModels().keySet()) {
			if (ITEMS_WITH_SPECIAL_MODELS.containsKey(location)) {
				BakedModel model = event.getModels().get(location);
				List<ItemOverrides.BakedOverride> overrides = new ArrayList<>();
				for (ItemOverrides.BakedOverride bakedOverride : model.getOverrides().getOverrides()) {
					if (bakedOverride.model != null) {
						overrides.add(new ItemOverrides.BakedOverride(bakedOverride.matchers, new BakedModelWrapper<>(bakedOverride.model) {
							@Override
							public BakedModel applyTransform(ItemDisplayContext cameraTransformType, PoseStack poseStack, boolean applyLeftHandTransform) {
								if (ITEMS_WITH_SPECIAL_MODELS.get(location).containsKey(cameraTransformType)) {
									return BAKED_MODELS.get(ITEMS_WITH_SPECIAL_MODELS.get(location).get(cameraTransformType)).applyTransform(cameraTransformType, poseStack, applyLeftHandTransform);
								}
								return super.applyTransform(cameraTransformType, poseStack, applyLeftHandTransform);
							}
						}));
					}
				}
				event.getModels().put(location, new BakedModelWrapper<>(model) {
					@Override
					public BakedModel applyTransform(ItemDisplayContext cameraTransformType, PoseStack poseStack, boolean applyLeftHandTransform) {
						if (ITEMS_WITH_SPECIAL_MODELS.get(location).containsKey(cameraTransformType)) {
							return BAKED_MODELS.get(ITEMS_WITH_SPECIAL_MODELS.get(location).get(cameraTransformType)).applyTransform(cameraTransformType, poseStack, applyLeftHandTransform);
						}
						return super.applyTransform(cameraTransformType, poseStack, applyLeftHandTransform);
					}

					@Override
					public ItemOverrides getOverrides() {
						ItemOverrides itemOverrides = super.getOverrides();
						itemOverrides.overrides = overrides.toArray(new ItemOverrides.BakedOverride[itemOverrides.overrides.length]);
						return itemOverrides;
					}
				});
			}
		}
	}
}
