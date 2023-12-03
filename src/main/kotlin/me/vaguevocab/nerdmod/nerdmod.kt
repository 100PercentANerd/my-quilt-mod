package me.vaguevocab.nerdmod


import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer
import me.vaguevocab.nerdmod.registry.NerdmodItem
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry

object nerdmod : ModInitializer {


    override fun onInitialize(mod: ModContainer) {
        // Instantiate registries
        var item_reg = NerdmodItem()
//        var block_reg = NerdmodBlockRegistry()

        // Registers
        item_reg.register(mod)
//        block_reg.register(mod)
    }
}

