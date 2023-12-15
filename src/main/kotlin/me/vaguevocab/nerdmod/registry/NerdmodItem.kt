package me.vaguevocab.nerdmod.registry

import me.vaguevocab.nerdmod.item.GunItem
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import me.vaguevocab.nerdmod.nerdmod
import net.minecraft.item.ItemGroups
import net.minecraft.potion.Potion
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings

// For Items - BlockItems are in NerdmodBlockRegistry

class NerdmodItem {

    val FISH_FINGER_CUSTARD: Item = Item(
        QuiltItemSettings().food(
        FoodComponent.Builder()
            .hunger(200)
            .saturationModifier(35F)
            .snack()
            .alwaysEdible()
            .meat()
            .statusEffect(StatusEffectInstance(StatusEffects.STRENGTH, 1000), 1f)
            .build()
    ))
    val FISH_FINGER_CUSTARD_BOWL: Item = Item(
        QuiltItemSettings().food(
        FoodComponent.Builder()
            .hunger(400)
            .saturationModifier(70F)
            .snack()
            .alwaysEdible()
            .meat()
            .statusEffect(StatusEffectInstance(StatusEffects.STRENGTH, 2000), 1f)
            .build()
    ))
    // Igi's item
    val CHILD: Item = Item(
        QuiltItemSettings().food(
        FoodComponent.Builder()
            .hunger(1000)
            .saturationModifier(10F)
            .meat()
            .statusEffect(StatusEffectInstance(StatusEffects.SLOWNESS, 60000), 1f)
            .build()
    ))

    val GUN: Item = GunItem(Item.Settings())
    fun register() {

        val modid = nerdmod.MODID

        // Register Items
        Registry.register(Registries.ITEM, Identifier(nerdmod.MODID, "fish_finger_custard"), FISH_FINGER_CUSTARD)
        Registry.register(Registries.ITEM, Identifier(nerdmod.MODID, "fish_finger_custard_bowl"), FISH_FINGER_CUSTARD_BOWL)
        Registry.register(Registries.ITEM, Identifier(nerdmod.MODID, "child"), CHILD)
        Registry.register(Registries.ITEM, Identifier(nerdmod.MODID, "gun"), GUN)

        // Add to item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINKS).register(ItemGroupEvents.ModifyEntries { entries: FabricItemGroupEntries ->
            entries.addItem(FISH_FINGER_CUSTARD)
            entries.addItem(FISH_FINGER_CUSTARD_BOWL)
            entries.addItem(CHILD)
        })
    }

}
