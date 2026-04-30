package net.blockysphere.naturesfeast.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.blockysphere.naturesfeast.NaturesFeast;
import net.blockysphere.naturesfeast.blockentities.custom.NaturesFeastBannerBlockEntity;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.WallBannerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class NaturesFeastBannerRenderer implements BlockEntityRenderer<NaturesFeastBannerBlockEntity> {
    private final ModelPart flag;
    private final ModelPart pole;
    private final ModelPart bar;
    public static final Material CUSTOM_BASE_SPRITE = new Material(Sheets.BANNER_SHEET, new ResourceLocation(NaturesFeast.MOD_ID, "entity/banner/natures_feast_banner"));

    public NaturesFeastBannerRenderer(BlockEntityRendererProvider.Context context) {
        ModelPart modelPart = context.bakeLayer(ModelLayers.BANNER);
        this.flag = modelPart.getChild("flag");
        this.pole = modelPart.getChild("pole");
        this.bar = modelPart.getChild("bar");
    }

    @Override
    public void render(NaturesFeastBannerBlockEntity entity, float tickDelta, PoseStack poseStack, MultiBufferSource bufferSource, int light, int overlay) {
        poseStack.pushPose();
        BlockState blockState = entity.getBlockState();
        boolean isStanding = blockState.getBlock() instanceof BannerBlock;

        if (isStanding) {
            poseStack.translate(0.5, 0.5, 0.5);
            float rotation = -((float)(blockState.getValue(BannerBlock.ROTATION) * 360) / 16.0F);
            poseStack.mulPose(Axis.YP.rotationDegrees(rotation));
        } else {
            poseStack.translate(0.5, -0.16666667, 0.5);
            float rotation = -blockState.getValue(WallBannerBlock.FACING).toYRot();
            poseStack.mulPose(Axis.YP.rotationDegrees(rotation));
            poseStack.translate(0.0, -0.3125, -0.4375);
        }

        poseStack.pushPose();
        poseStack.scale(0.6666667F, -0.6666667F, -0.6666667F);

        // 渲染旗杆
        VertexConsumer solidConsumer = CUSTOM_BASE_SPRITE.buffer(bufferSource, RenderType::entitySolid);
        this.pole.visible = isStanding;
        this.pole.render(poseStack, solidConsumer, light, overlay);
        this.bar.render(poseStack, solidConsumer, light, overlay);

        // 旗帜动画
        this.flag.xRot = (-0.0125F + 0.01F * Mth.cos((float)Math.PI * 2.0F * getWaveOffset(entity, tickDelta))) * (float)Math.PI;
        this.flag.y = -32.0F;

        // 渲染旗面
        VertexConsumer cutoutConsumer = CUSTOM_BASE_SPRITE.buffer(bufferSource, RenderType::entityCutoutNoCull);
        this.flag.render(poseStack, cutoutConsumer, light, overlay);

        poseStack.popPose();
        poseStack.popPose();
    }

    private float getWaveOffset(NaturesFeastBannerBlockEntity entity, float tickDelta) {
        Level level = entity.getLevel();
        if (level != null) {
            BlockPos pos = entity.getBlockPos();
            return ((float)(level.getGameTime() + (long)(pos.getX() + pos.getY() + pos.getZ())) + tickDelta) / 100.0F;
        }
        return 0.0F;
    }
}