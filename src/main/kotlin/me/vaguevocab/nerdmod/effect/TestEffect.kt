package me.vaguevocab.nerdmod.effect

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectType
import net.minecraft.entity.player.PlayerEntity


class TestEffect(type: StatusEffectType?, color: Int) : StatusEffect(type, color) {

    override fun canApplyUpdateEffect(duration: Int, amplifier: Int): Boolean {
        return true
    }

    override fun applyUpdateEffect(entity: LivingEntity?, amplifier: Int) {
        if (entity is PlayerEntity) {
            entity.addExperience(1 shl amplifier)
        }
    }

}
