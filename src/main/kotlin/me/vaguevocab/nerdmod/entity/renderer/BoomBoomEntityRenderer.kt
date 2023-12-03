package me.vaguevocab.nerdmod.entity.renderer

import com.mojang.blaze3d.vertex.VertexConsumers
import me.vaguevocab.nerdmod.entity.BoomBoomEntity
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.OverlayTexture
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRenderDispatcher
import net.minecraft.client.render.entity.EntityRenderer
import net.minecraft.client.render.model.json.ModelTransformation
import net.minecraft.client.render.model.json.ModelTransformationMode
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier


class BoomBoomEntityRenderer : EntityRenderer<BoomBoomEntity> {

    val STACK: ItemStack = ItemStack(Items.TNT)
    constructor(dispatcher: EntityRenderDispatcher) : super(dispatcher)

    override fun render(entity: BoomBoomEntity?, yaw: Float, tickDelta: Float, matrices: MatrixStack, vertexConsumers: VertexConsumerProvider, light: Int) {
        MinecraftClient.getInstance().itemRenderer.renderItem(
            STACK,
            ModelTransformationMode.FIXED,
            light,
            OverlayTexture.DEFAULT_UV,
            matrices,
            vertexConsumers
        )
        super(entity, yaw, tickDelta, matrices, vertexConsumers, light)
    }

    override fun getTexture(entity: BoomBoomEntity?): Identifier {
        TODO("Not yet implemented")
    }


}
