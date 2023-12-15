package me.vaguevocab.nerdmod.item

import net.minecraft.entity.EntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World


class GunItem : Item {
    constructor(settings: Settings?) : super(settings)
    override fun use(world: World?, player: PlayerEntity, hand: Hand?): TypedActionResult<ItemStack> {
        if (world != null && hand != null) {
            val stack = player.getStackInHand(hand)
            val entity = EntityType.SNOWBALL.create(world)?.apply {
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
