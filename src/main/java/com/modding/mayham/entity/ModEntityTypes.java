package com.modding.mayham.entity;

import com.modding.mayham.Mayham;
import com.modding.mayham.entity.custom.MiningMachineEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Mayham.MOD_ID);
    public static final RegistryObject<EntityType<MiningMachineEntity>> MININGMACHINE =
            ENTITY_TYPES.register("miningmachine", () -> EntityType.Builder.of(MiningMachineEntity::new, MobCategory.CREATURE)
                    .sized(1f, 1f).build("miningmachine"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
