package com.k42un0k0.advancedmod.enchantment.custom;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.MathHelper;

public class SaitamaEnchantment extends Enchantment {
    public SaitamaEnchantment(Enchantment.Rarity p_i46735_1_, EquipmentSlotType... p_i46735_2_) {
        super(p_i46735_1_, EnchantmentType.BOW, p_i46735_2_);
    }

    public int getMinCost(int p_77321_1_) {
        return 12 + (p_77321_1_ - 1) * 20;
    }

    public int getMaxCost(int p_223551_1_) {
        return this.getMinCost(p_223551_1_) + 25;
    }

    public int getMaxLevel() {
        return 2;
    }

    @Override
    public float getDamageBonus(int p_152376_1_, CreatureAttribute p_152376_2_) {
        return p_152376_1_ * 9;
    }

    @Override
    public void doPostAttack(LivingEntity p_151368_1_, Entity p_151368_2_, int p_151368_3_) {
        if (p_151368_2_ instanceof LivingEntity) {
            ((LivingEntity) p_151368_2_).knockback((float) p_151368_3_,
                    MathHelper.sin(p_151368_1_.yRot * ((float) Math.PI / 180F)),
                    -MathHelper.cos(p_151368_1_.yRot * ((float) Math.PI / 180F)));
        }
    }
}