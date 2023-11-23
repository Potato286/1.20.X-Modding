package com.modding.mayham.entity.client;

import com.modding.mayham.Mayham;
import com.modding.mayham.entity.custom.MiningMachineEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;

public class MiningMachineRenderer extends MobRenderer<MiningMachineEntity, MiningMachineModel<MiningMachineEntity>> {
    public MiningMachineRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MiningMachineModel<>(pContext.bakeLayer(ModModelLayers.MININGMACHINE_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(MiningMachineEntity pEntity) {
        return new ResourceLocation(Mayham.MOD_ID, "textures/entity/miningmachine.png");
    }

    @Override
    public void render(MiningMachineEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.scale(2f, 2f, 2f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}