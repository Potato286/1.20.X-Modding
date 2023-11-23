package com.modding.mayham.entity.client;

import com.modding.mayham.Mayham;
import com.modding.mayham.entity.animations.ModAnimationDefinitions;
import com.modding.mayham.entity.custom.MiningMachineEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;


public class MiningMachineModel<T extends Entity> extends EntityModel<T> {
    private final ModelPart miningmachine;

    public MiningMachineModel(ModelPart root) {
        this.miningmachine = root.getChild("miningmachine");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition miningmachine = partdefinition.addOrReplaceChild("miningmachine", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = miningmachine.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -4.0F, -8.0F, 12.0F, 2.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(20, 50).addBox(-6.0F, -8.0F, -8.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 50).addBox(4.0F, -8.0F, -8.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-4.0F, -8.0F, -8.0F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -16.0F, 12.0F, 8.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(46, 0).addBox(-4.0F, -16.0F, 0.0F, 8.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(32, 24).addBox(-6.0F, -16.0F, 0.0F, 2.0F, 12.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(4.0F, -16.0F, 0.0F, 2.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(18, 24).addBox(-6.0F, -6.5F, -2.0F, 12.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.2974F, -3.4032F, -0.7854F, 0.0F, 0.0F));

        PartDefinition wheels = miningmachine.addOrReplaceChild("wheels", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition frontleft = wheels.addOrReplaceChild("frontleft", CubeListBuilder.create().texOffs(58, 44).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -3.0F, -5.0F));

        PartDefinition frontright = wheels.addOrReplaceChild("frontright", CubeListBuilder.create().texOffs(50, 56).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -3.0F, -5.0F));

        PartDefinition backleft = wheels.addOrReplaceChild("backleft", CubeListBuilder.create().texOffs(0, 62).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -3.0F, 11.0F));

        PartDefinition backright = wheels.addOrReplaceChild("backright", CubeListBuilder.create().texOffs(40, 50).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -3.0F, 11.0F));

        PartDefinition drill = miningmachine.addOrReplaceChild("drill", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(50, 24).addBox(-4.0F, -4.0F, 2.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -12.0F));

        PartDefinition cube_r2 = drill.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(46, 14).addBox(-3.0F, -3.0F, 3.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.7854F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }
    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        miningmachine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}

