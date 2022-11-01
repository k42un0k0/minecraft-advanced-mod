package com.k42un0k0.advancedmod.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasHead;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)

public class SpriteLayer<T extends LivingEntity, M extends EntityModel<T> & IHasHead> extends LayerRenderer<T, M> {
    private final float scaleX;
    private final float scaleY;
    private final float scaleZ;

    GameRenderer gameRenderer;
    public SpriteLayer(IEntityRenderer<T, M> p_i50946_1_,GameRenderer gameRenderer) {
        this(p_i50946_1_, 1.0F, 1.0F, 1.0F);
        this.gameRenderer= gameRenderer;
    }

    public SpriteLayer(IEntityRenderer<T, M> p_i232475_1_, float p_i232475_2_, float p_i232475_3_, float p_i232475_4_) {
        super(p_i232475_1_);
        this.scaleX = p_i232475_2_;
        this.scaleY = p_i232475_3_;
        this.scaleZ = p_i232475_4_;
    }

    public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, T p_225628_4_,
                       float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_,
                       float p_225628_10_) {
        p_225628_1_.pushPose();
        ActiveRenderInfo info = this.gameRenderer.getMainCamera();

        Quaternion rot = info.rotation();
//        p_225628_1_.mulPose(rot);
        p_225628_1_.scale(this.scaleX, this.scaleY, this.scaleZ);
        this.getParentModel().getHead().translateAndRotate(p_225628_1_);

        p_225628_1_.translate(0.0D, -0.25D, 0.0D);
        p_225628_1_.mulPose(Vector3f.YP.rotationDegrees(180.0F));
        p_225628_1_.scale(0.625F, -0.625F, -0.625F);

        Minecraft.getInstance().getItemInHandRenderer().renderItem(p_225628_4_, new ItemStack(Items.EGG),
                ItemCameraTransforms.TransformType.HEAD, false, p_225628_1_, p_225628_2_, p_225628_3_);

        p_225628_1_.popPose();
    }
}