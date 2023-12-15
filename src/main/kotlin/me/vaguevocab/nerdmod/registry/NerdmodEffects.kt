package me.vaguevocab.nerdmod.registry

import me.vaguevocab.nerdmod.effect.NoClipEffect
import me.vaguevocab.nerdmod.effect.TestEffect
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import me.vaguevocab.nerdmod.nerdmod
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.potion.Potion
import net.minecraft.recipe.BrewingRecipeRegistry

class NerdmodEffects {

    fun register() {
        System.out.println("Registering status effects (${nerdmod.MODID})")

        // Effects
        val TESTEFFECT: StatusEffect = registerEffect("test_effect", TestEffect(StatusEffectType.HARMFUL, 66135245))
        val NOCLIPEFFECT: StatusEffect = registerEffect("no_clip", NoClipEffect(StatusEffectType.HARMFUL, 66135245))

        // Potions
        val NOCLIPPOTION: Potion = registerPotion("no_clip_potion", NOCLIPEFFECT, (20*2), 0)
    }

    fun registerEffect(internalName: String, effect: StatusEffect): StatusEffect {
        return Registry.register(Registries.STATUS_EFFECT, Identifier(nerdmod.MODID, internalName), effect)
    }

    fun registerPotion(internalName: String, effect: StatusEffect, duration: Int, amplifier: Int): Potion {
        return Registry.register(Registries.POTION, Identifier(nerdmod.MODID, internalName), Potion(StatusEffectInstance(effect, duration, amplifier)))
    }


}
