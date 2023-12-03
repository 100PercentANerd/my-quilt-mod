package me.vaguevocab.nerdmod

import me.vaguevocab.nerdmod.registry.NerdmodEntities
import me.vaguevocab.nerdmod.entity.renderer.BoomBoomEntityRenderer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer

@Environment(EnvType.CLIENT)
class NerdmodClient : ClientModInitializer {

    private val entity_reg = NerdmodEntities()
    override fun onInitializeClient(mod: ModContainer?) {
        EntityRendererRegistry.register(entity_reg.BOOMBOOMENTITY, (EntityRendererDispatcher, context) -> BoomBoomEntityRender)
    }

}
