package com.modding.mayham.item;

import com.modding.mayham.Mayham;
import com.modding.mayham.entity.ModEntityTypes;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Mayham.MOD_ID);

    public static final RegistryObject<Item> REINFORCED_GOLD_SWORD = ITEMS.register("reinforced_gold_sword",
            () -> new SwordItem(ModToolTiers.REINFORCED_GOLD, 3, -2.4f,
                    new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_GOLD_PICKAXE = ITEMS.register("reinforced_gold_pickaxe",
            () -> new PickaxeItem(ModToolTiers.REINFORCED_GOLD, 1, -2.8f,
                    new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_GOLD_SHOVEL = ITEMS.register("reinforced_gold_shovel",
            () -> new ShovelItem(ModToolTiers.REINFORCED_GOLD, 1, -3.0f,
                    new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_GOLD_AXE = ITEMS.register("reinforced_gold_axe",
            () -> new AxeItem(ModToolTiers.REINFORCED_GOLD, 6, -3.1f,
                    new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_GOLD_HOE = ITEMS.register("reinforced_gold_hoe",
            () -> new HoeItem(ModToolTiers.REINFORCED_GOLD, -2, -1f,
                    new Item.Properties()));
    public static final RegistryObject<Item> MININGMACHINE_SPANW_EGG = ITEMS.register("miningmachine_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MININGMACHINE, 0x7e9680, 0xc5d1c5, new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
