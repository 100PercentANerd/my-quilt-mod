package me.vaguevocab.nerdmod.entity

import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.ExplosiveProjectileEntity
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion


class BoomBoomEntity : ExplosiveProjectileEntity {
    constructor(entityType: EntityType<out ExplosiveProjectileEntity?>?, world: World?) : super(entityType, world)
    constructor(
        entityType: EntityType<out ExplosiveProjectileEntity?>?,
        shooter: LivingEntity?,
        accelerationX: Double,
        accelerationY: Double,
        accelerationZ: Double,
        world: World?
    ) : super(entityType, shooter, accelerationX, accelerationY, accelerationZ, world)

    // Additional custom logic or overrides can go here
    override fun onEntityHit(entityHitResult: EntityHitResult) {
        super.onEntityHit(entityHitResult)

        // Logic for impact with an entity
        explode()
    }

    override fun onBlockHit(blockHitResult: BlockHitResult) {
        super.onBlockHit(blockHitResult)

        // Logic for impact with a block
        explode()
    }

    private fun explode() {
        // Your explosion logic goes here
        world.createExplosion(this, this.x, this.y, this.z, 2.0f, World.ExplosionSourceType.BLOCK)
        this.discard() // Remove the entity after exploding
    }
}

