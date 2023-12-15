package me.vaguevocab.nerdmod.registry

import me.vaguevocab.nerdmod.enchantment.MoreDamageEnchantment
import me.vaguevocab.nerdmod.nerdmod
import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentTarget
import net.minecraft.entity.EquipmentSlot
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import org.quiltmc.loader.api.ModContainer

class NerdmodEnchantments {


        fun register() {
            System.out.println("Registering Enchants (${nerdmod.MODID})")
            val MORE_DAMAGE: Enchantment = registerEnch("more_damage", MoreDamageEnchantment(Enchantment.Rarity.COMMON, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND))
        }

    fun registerEnch(name: String, enchantment: Enchantment, ): Enchantment {
        return Registry.register(Registries.ENCHANTMENT, Identifier(nerdmod.MODID, name), enchantment)
    }

}
