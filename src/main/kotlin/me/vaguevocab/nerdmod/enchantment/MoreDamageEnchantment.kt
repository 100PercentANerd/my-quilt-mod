package me.vaguevocab.nerdmod.enchantment

import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentTarget
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.LivingEntity
import net.minecraft.server.world.ServerWorld


class MoreDamageEnchantment(weight: Rarity?, type: EnchantmentTarget?, slotTypes: EquipmentSlot) : Enchantment(weight, type,
    arrayOf(slotTypes)
) {

    override fun getMaxLevel(): Int {
        return 2
    }

    override fun onTargetDamaged(user: LivingEntity?, target: Entity?, level: Int) {
        if(user != null) {
            if (!user.world.isClient()) {
                var world = user.world as ServerWorld
                var BlockPos = target?.blockPos

                if (level == 1) EntityType.CAMEL.spawn(world, BlockPos, null)

                if (level == 2) {
                    EntityType.SNOWBALL.spawn(world, BlockPos, null)
                }

            }
        }

        super.onTargetDamaged(user, target, level)
    }

}
