package com.k42un0k0.advancedmod.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasHead;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.opengl.GL11;

import static com.k42un0k0.advancedmod.AdvancedMod.MOD_ID;

@OnlyIn(Dist.CLIENT)

public class SpriteLayer<T extends LivingEntity, M extends EntityModel<T> & IHasHead> extends LayerRenderer<T, M> {
    private static final ResourceLocation resNoValue = new ResourceLocation(MOD_ID, "textures/novalue.png");
    private static final RenderType.State stateHidden = RenderType.State.builder()
            .setTextureState(new RenderState.TextureState(
                    resNoValue, // resource
                    false, // blur
                    false // mipmap
            ))
            .setAlphaState(new RenderState.AlphaState(.2f))
            .createCompositeState(true);

    private static final RenderType renderTypeHidden = RenderType.create(
            "render_photobomb", // name
            DefaultVertexFormats.POSITION_TEX, // vertexFormat
            GL11.GL_QUADS, // drawMode
            256, // bufferSize
            true, // useDelegate
            false, // needsSorting
            stateHidden
    );
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
        MatrixStack.Entry entry = p_225628_1_.last();
        p_225628_1_.popPose();
        p_225628_1_.pushPose();
        ActiveRenderInfo info = this.gameRenderer.getMainCamera();


        Quaternion rot = info.rotation();
        Vector3d camPosition = info.getPosition();
        Vector3d playerPosition =p_225628_4_.getEyePosition(p_225628_7_);
        Vector3d sub = camPosition.subtract(playerPosition).normalize().scale(.8);

        Matrix4f matrix = p_225628_1_.last().pose();
        matrix.multiply(Matrix4f.createTranslateMatrix(0f, 1.2f, 0f));
        matrix.multiply(Matrix4f.createTranslateMatrix((float) sub.x, (float) sub.y, (float) sub.z));
        matrix.multiply(rot);
        matrix.multiply(Matrix4f.createScaleMatrix(1.6f, 1.6f, 1.6f));
        p_225628_1_.scale(this.scaleX, this.scaleY, this.scaleZ);

        IVertexBuilder buffer = p_225628_2_.getBuffer(renderTypeHidden);
        buffer.vertex(matrix, -.5f, +.5f, 0f).uv(1f, 0f).endVertex();
        buffer.vertex(matrix, +.5f, +.5f, 0f).uv(0f, 0f).endVertex();
        buffer.vertex(matrix, +.5f, -.5f, 0f).uv(0f, 1f).endVertex();
        buffer.vertex(matrix, -.5f, -.5f, 0f).uv(1f, 1f).endVertex();
        p_225628_1_.popPose();
        p_225628_1_.pushPose();
        p_225628_1_.last().pose().set(entry.pose());
        p_225628_1_.last().normal().load(entry.normal());
    }
}