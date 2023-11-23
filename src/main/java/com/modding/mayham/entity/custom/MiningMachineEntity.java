package com.modding.mayham.entity.custom;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.ContainerListener;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Markings;
import net.minecraft.world.entity.animal.horse.Variant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;

import javax.annotation.Nullable;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class MiningMachineEntity extends Animal{
    private float rotationYaw;

    public MiningMachineEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    private static final Logger LOGGER = LogManager.getLogger();

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.ATTACK_DAMAGE, 10.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.003f).build();
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!this.isVehicle()) {
            player.startRiding(this);

            return super.mobInteract(player, hand);
        }

        return super.mobInteract(player, hand);
    }

    // Turn off step sounds since it's a bike
    @Override
    protected void playStepSound(BlockPos pos, BlockState block) {}

    // Apply player-controlled movement
    @Override
    public void travel(Vec3 pos) {
        if (this.isAlive()) {
            if (this.isVehicle()) {
                LivingEntity passenger = (LivingEntity)getControllingPassenger();
                this.yRotO = getYRot();
                this.xRotO = getXRot();

                setYRot(passenger.getYRot());
                setXRot(passenger.getXRot() * 0.5f);
                setRot(getYRot(), getXRot());

                this.yBodyRot = this.getYRot();
                this.yHeadRot = this.yBodyRot;
                float x = passenger.xxa * 0.5F;
                float z = passenger.zza;

                if (z <= 0)
                    z *= 0.25f;

                this.setSpeed(0.03f);
                super.travel(new Vec3(x, pos.y, z));
            }
            BlockPos pos1 = new BlockPos((int) ((int) this.getX()-1), (int) ((int) this.getY()+2), (int) ((int) this.getZ()));
            BlockPos pos2 = new BlockPos((int) ((int) this.getX()), (int) ((int) this.getY()+2), (int) ((int) this.getZ()));
            BlockPos pos3 = new BlockPos((int) ((int) this.getX()+1), (int) ((int) this.getY()+2), (int) ((int) this.getZ()));
            BlockPos pos4 = new BlockPos((int) ((int) this.getX()-1), (int) ((int) this.getY()+1), (int) ((int) this.getZ()));
            BlockPos pos5 = new BlockPos((int) ((int) this.getX()), (int) ((int) this.getY()+1), (int) ((int) this.getZ()));
            BlockPos pos6 = new BlockPos((int) ((int) this.getX()+1), (int) ((int) this.getY()+1), (int) ((int) this.getZ()));
            BlockPos pos7 = new BlockPos((int) ((int) this.getX()-1), (int) ((int) this.getY()), (int) ((int) this.getZ()));
            BlockPos pos8 = new BlockPos((int) ((int) this.getX()), (int) ((int) this.getY()), (int) ((int) this.getZ()));
            BlockPos pos9 = new BlockPos((int) ((int) this.getX()+1), (int) ((int) this.getY()), (int) ((int) this.getZ()));
            BlockPos pos10 = new BlockPos((int) ((int) this.getX()-1), (int) ((int) this.getY()+2), (int) ((int) this.getZ())+1);
            BlockPos pos11 = new BlockPos((int) ((int) this.getX()), (int) ((int) this.getY()+2), (int) ((int) this.getZ())+1);
            BlockPos pos12 = new BlockPos((int) ((int) this.getX()+1), (int) ((int) this.getY()+2), (int) ((int) this.getZ())+1);
            BlockPos pos13 = new BlockPos((int) ((int) this.getX()-1), (int) ((int) this.getY()+1), (int) ((int) this.getZ())+1);
            BlockPos pos14 = new BlockPos((int) ((int) this.getX()), (int) ((int) this.getY()+1), (int) ((int) this.getZ())+1);
            BlockPos pos15 = new BlockPos((int) ((int) this.getX()+1), (int) ((int) this.getY()+1), (int) ((int) this.getZ())+1);
            BlockPos pos16 = new BlockPos((int) ((int) this.getX()-1), (int) ((int) this.getY()), (int) ((int) this.getZ())+1);
            BlockPos pos17 = new BlockPos((int) ((int) this.getX()), (int) ((int) this.getY()), (int) ((int) this.getZ())+1);
            BlockPos pos18 = new BlockPos((int) ((int) this.getX()+1), (int) ((int) this.getY()), (int) ((int) this.getZ())+1);
            BlockPos pos19 = new BlockPos((int) ((int) this.getX()-1), (int) ((int) this.getY()+2), (int) ((int) this.getZ())-1);
            BlockPos pos20 = new BlockPos((int) ((int) this.getX()), (int) ((int) this.getY()+2), (int) ((int) this.getZ())-1);
            BlockPos pos21 = new BlockPos((int) ((int) this.getX()+1), (int) ((int) this.getY()+2), (int) ((int) this.getZ())-1);
            BlockPos pos22 = new BlockPos((int) ((int) this.getX()-1), (int) ((int) this.getY()+1), (int) ((int) this.getZ())-1);
            BlockPos pos23 = new BlockPos((int) ((int) this.getX()), (int) ((int) this.getY()+1), (int) ((int) this.getZ())-1);
            BlockPos pos24 = new BlockPos((int) ((int) this.getX()+1), (int) ((int) this.getY()+1), (int) ((int) this.getZ())-1);
            BlockPos pos25 = new BlockPos((int) ((int) this.getX()-1), (int) ((int) this.getY()), (int) ((int) this.getZ())-1);
            BlockPos pos26 = new BlockPos((int) ((int) this.getX()), (int) ((int) this.getY()), (int) ((int) this.getZ())-1);
            BlockPos pos27 = new BlockPos((int) ((int) this.getX()+1), (int) ((int) this.getY()), (int) ((int) this.getZ())-1);
            if (!this.level().getBlockState(pos1).isAir() && !this.level().getBlockState(pos1).is(Blocks.BEDROCK) && !this.level().getBlockState(pos1).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos1, true);}
            if (!this.level().getBlockState(pos2).isAir() && !this.level().getBlockState(pos2).is(Blocks.BEDROCK) && !this.level().getBlockState(pos2).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos2, true);}
            if (!this.level().getBlockState(pos3).isAir() && !this.level().getBlockState(pos3).is(Blocks.BEDROCK) && !this.level().getBlockState(pos3).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos3, true);}
            if (!this.level().getBlockState(pos4).isAir() && !this.level().getBlockState(pos4).is(Blocks.BEDROCK) && !this.level().getBlockState(pos4).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos4, true);}
            if (!this.level().getBlockState(pos5).isAir() && !this.level().getBlockState(pos5).is(Blocks.BEDROCK) && !this.level().getBlockState(pos5).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos5, true);}
            if (!this.level().getBlockState(pos6).isAir() && !this.level().getBlockState(pos6).is(Blocks.BEDROCK) && !this.level().getBlockState(pos6).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos6, true);}
            if (!this.level().getBlockState(pos7).isAir() && !this.level().getBlockState(pos7).is(Blocks.BEDROCK) && !this.level().getBlockState(pos7).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos7, true);}
            if (!this.level().getBlockState(pos8).isAir() && !this.level().getBlockState(pos8).is(Blocks.BEDROCK) && !this.level().getBlockState(pos8).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos8, true);}
            if (!this.level().getBlockState(pos9).isAir() && !this.level().getBlockState(pos9).is(Blocks.BEDROCK) && !this.level().getBlockState(pos9).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos9, true);}

            if (!this.level().getBlockState(pos10).isAir() && !this.level().getBlockState(pos10).is(Blocks.BEDROCK) && !this.level().getBlockState(pos10).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos10, true);}
            if (!this.level().getBlockState(pos11).isAir() && !this.level().getBlockState(pos11).is(Blocks.BEDROCK) && !this.level().getBlockState(pos11).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos11, true);}
            if (!this.level().getBlockState(pos12).isAir() && !this.level().getBlockState(pos12).is(Blocks.BEDROCK) && !this.level().getBlockState(pos12).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos12, true);}
            if (!this.level().getBlockState(pos13).isAir() && !this.level().getBlockState(pos13).is(Blocks.BEDROCK) && !this.level().getBlockState(pos13).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos13, true);}
            if (!this.level().getBlockState(pos14).isAir() && !this.level().getBlockState(pos14).is(Blocks.BEDROCK) && !this.level().getBlockState(pos14).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos14, true);}
            if (!this.level().getBlockState(pos15).isAir() && !this.level().getBlockState(pos15).is(Blocks.BEDROCK) && !this.level().getBlockState(pos15).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos15, true);}
            if (!this.level().getBlockState(pos16).isAir() && !this.level().getBlockState(pos16).is(Blocks.BEDROCK) && !this.level().getBlockState(pos16).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos16, true);}
            if (!this.level().getBlockState(pos17).isAir() && !this.level().getBlockState(pos17).is(Blocks.BEDROCK) && !this.level().getBlockState(pos17).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos17, true);}
            if (!this.level().getBlockState(pos18).isAir() && !this.level().getBlockState(pos18).is(Blocks.BEDROCK) && !this.level().getBlockState(pos18).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos18, true);}

            if (!this.level().getBlockState(pos19).isAir() && !this.level().getBlockState(pos19).is(Blocks.BEDROCK) && !this.level().getBlockState(pos19).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos19, true);}
            if (!this.level().getBlockState(pos20).isAir() && !this.level().getBlockState(pos20).is(Blocks.BEDROCK) && !this.level().getBlockState(pos20).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos20, true);}
            if (!this.level().getBlockState(pos21).isAir() && !this.level().getBlockState(pos21).is(Blocks.BEDROCK) && !this.level().getBlockState(pos21).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos21, true);}
            if (!this.level().getBlockState(pos22).isAir() && !this.level().getBlockState(pos22).is(Blocks.BEDROCK) && !this.level().getBlockState(pos22).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos22, true);}
            if (!this.level().getBlockState(pos23).isAir() && !this.level().getBlockState(pos23).is(Blocks.BEDROCK) && !this.level().getBlockState(pos23).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos23, true);}
            if (!this.level().getBlockState(pos24).isAir() && !this.level().getBlockState(pos24).is(Blocks.BEDROCK) && !this.level().getBlockState(pos24).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos24, true);}
            if (!this.level().getBlockState(pos25).isAir() && !this.level().getBlockState(pos25).is(Blocks.BEDROCK) && !this.level().getBlockState(pos25).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos25, true);}
            if (!this.level().getBlockState(pos26).isAir() && !this.level().getBlockState(pos26).is(Blocks.BEDROCK) && !this.level().getBlockState(pos26).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos26, true);}
            if (!this.level().getBlockState(pos27).isAir() && !this.level().getBlockState(pos27).is(Blocks.BEDROCK) && !this.level().getBlockState(pos27).is(Blocks.SPAWNER)) {this.level().destroyBlock(pos27, true);}

        }
    }

    // Get the controlling passenger
    @Nullable
    @Override
    public LivingEntity getControllingPassenger() {
        return getFirstPassenger() instanceof LivingEntity entity ? entity : null;
    }

    @Override
    public boolean isControlledByLocalInstance() {
        return true;
    }

    // Adjust the rider's position while riding
    @Override
    public void positionRider(Entity entity, MoveFunction moveFunction) {
        if (entity instanceof LivingEntity passenger) {
            moveFunction.accept(entity, getX(), getY() - 0.1f, getZ());

            this.xRotO = passenger.xRotO;
        }
    }
    @Override
    protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {
        return 0.5F;
    }


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLAZE_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.BLAZE_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLAZE_DEATH;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            setupAnimationStates();
        }
    }
    private void setupAnimationStates() {
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }



}
