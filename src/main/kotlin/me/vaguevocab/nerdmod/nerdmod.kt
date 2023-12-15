package me.vaguevocab.nerdmod


import me.vaguevocab.nerdmod.registry.NerdmodEffects
import me.vaguevocab.nerdmod.registry.NerdmodEnchantments
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer
import me.vaguevocab.nerdmod.registry.NerdmodItem

object nerdmod : ModInitializer {

    public val MODID  = "nerdmod"

    override fun onInitialize(mod: ModContainer) {
        // Instantiate registries
        var item_reg = NerdmodItem()
        var ench_reg = NerdmodEnchantments()
        var eff_reg = NerdmodEffects()
//        var block_reg = NerdmodBlockRegistry()

        // Registers
        item_reg.register()
        ench_reg.register()
        eff_reg.register()
//        block_reg.register(mod)
    }

}
