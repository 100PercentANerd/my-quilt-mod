package me.vaguevocab.nerdmod.registry

import me.vaguevocab.nerdmod.entity.BoomBoomEntity
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder

class NerdmodEntities {
    val BOOMBOOMENTITY: EntityType<BoomBoomEntity> = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier("nerdmod", "boom_boom_entity"),
        QuiltEntityTypeBuilder
            .create(SpawnGroup.MISC, ::BoomBoomEntity)
            .setDimensions(EntityDimensions
                .fixed(.25f, .25f)
            ).build()
    )
}
