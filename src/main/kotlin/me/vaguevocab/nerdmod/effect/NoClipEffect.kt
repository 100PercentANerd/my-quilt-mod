package me.vaguevocab.nerdmod.effect

import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.attribute.AttributeContainer
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.Vec3d

class NoClipEffect(type: StatusEffectType?, color: Int) : StatusEffect(type, color) {

    var startingPosition: Vec3d? = null
    var startingInv: DefaultedList<ItemStack>? = null
    var startingHealth: Float = 10f

    override fun canApplyUpdateEffect(duration: Int, amplifier: Int): Boolean {
        return true
    }

    override fun onApplied(entity: LivingEntity?, attributes: AttributeContainer?, amplifier: Int) {
        if(entity != null) {
            if(entity is PlayerEntity)
            startingPosition = entity.pos
            var player: PlayerEntity = entity as PlayerEntity
            startingHealth = player.health
            startingInv = player.inventory.main

        }
    }

    override fun applyUpdateEffect(entity: LivingEntity?, amplifier: Int) {
        if(entity != null) {

            entity.noClip = true

        }
    }

    override fun onRemoved(entity: LivingEntity?, attributes: AttributeContainer?, amplifier: Int) {
        if(entity != null) {
            startingPosition?.let { pos ->
                entity.teleport(pos.x, pos.y, pos.z)
                entity.health = startingHealth
                if(startingInv != null) {
                    var player: PlayerEntity = entity as PlayerEntity
                    for ((index, stack) in startingInv!!.withIndex()) {
                        player.inventory.setStack(index, stack)
                    }
                }

            }
        }
    }

}
