package com.modding.mayham.item;

import com.modding.mayham.Mayham;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static Tier REINFORCED_GOLD;
    static {
        REINFORCED_GOLD = TierSortingRegistry.registerTier(new ForgeTier(2, 282, 15.0F, 2.0F, 36,
                        Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(Items.GOLD_INGOT)),
                new ResourceLocation(Mayham.MOD_ID, "reinforced_gold"), List.of(Tiers.IRON), List.of());
    }
}
