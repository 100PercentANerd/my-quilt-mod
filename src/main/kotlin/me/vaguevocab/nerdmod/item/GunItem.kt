package me.vaguevocab.nerdmod.item

import net.minecraft.entity.EntityType
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.projectile.thrown.SnowballEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World
import me.vaguevocab.nerdmod.entity.BoomBoomEntity
import me.vaguevocab.nerdmod.registry.NerdmodEntities


class GunItem : Item {
    constructor(settings: Settings?) : super(settings)
    val entity_reg = NerdmodEntities()
    override fun use(world: World?, player: PlayerEntity, hand: Hand?): TypedActionResult<ItemStack> {
        if (world != null && hand != null) {
            val stack = player.getStackInHand(hand)
            val entity = entity_reg.BOOMBOOMENTITY.create(world)?.apply {
                refreshPositionAndAngles(player.x, player.y + 1.0, player.z, player.yaw, player.pitch)
                velocity = player.getRotationVec(2.0f)
            }
            world.spawnEntity(entity)
            return TypedActionResult.success(stack)
        } else {
            val stack = player.getStackInHand(hand)
            return TypedActionResult.pass(stack)
        }
    }
}
