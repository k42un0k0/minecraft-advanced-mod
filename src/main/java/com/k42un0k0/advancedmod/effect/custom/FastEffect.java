package com.k42un0k0.advancedmod.effect.custom;

import com.k42un0k0.advancedmod.effect.AdvancedAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class FastEffect extends Effect {
    public FastEffect(EffectType p_i50391_1_, int p_i50391_2_) {
        super(p_i50391_1_, p_i50391_2_);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "55C0291B-154A-408D-99B8-B05207C849B1", 0.2F,
                AttributeModifier.Operation.MULTIPLY_TOTAL);
        this.addAttributeModifier(AdvancedAttributes.MY_ATTR.get(), "55C0291B-154A-408D-99B8-B05207C849B1", 1F,
                AttributeModifier.Operation.ADDITION);
    }
}
