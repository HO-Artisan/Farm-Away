package ho.artisan.farmaway.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import ho.artisan.farmaway.common.entity.MelonRocketEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MelonRocketRenderer extends EntityRenderer<MelonRocketEntity> {
	private final ItemRenderer itemRenderer;

	public MelonRocketRenderer(EntityRendererProvider.Context context) {
		super(context);
		this.itemRenderer = context.getItemRenderer();
	}

	@Override
	public void render(MelonRocketEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
		poseStack.pushPose();
		poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());

		this.itemRenderer.renderStatic(
			Items.MELON.getDefaultInstance(),
			ItemDisplayContext.GROUND,
			packedLight,
			OverlayTexture.NO_OVERLAY,
			poseStack,
			buffer,
			entity.level(),
			entity.getId()
		);
		poseStack.popPose();
		super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
	}

	@Override
	public ResourceLocation getTextureLocation(MelonRocketEntity entity) {
		return TextureAtlas.LOCATION_BLOCKS;
	}
}
