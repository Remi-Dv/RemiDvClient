package remidv.fr.remidvclient.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.item.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import remidv.fr.remidvclient.UI.HUD.HUDInfo;

@Environment(EnvType.CLIENT)
@Mixin(value = InGameHud.class)
public class MixinInGameHud {
    private HUDInfo hudInfo;
    private MinecraftClient minecraftClient;

    @Inject(method = "<init>(Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/render/item/ItemRenderer;)V", at = @At(value = "RETURN"))
    private void onInit(MinecraftClient client, ItemRenderer render, CallbackInfo ci) {
        // Start Mixin
        System.out.println("Init Coordinates Mixin");

        minecraftClient = client;
        this.hudInfo = new HUDInfo(client);
    }

    @Inject(method = "render", at = @At("HEAD"))
    private void onDraw(DrawContext context, float esp, CallbackInfo ci) {
        if (!this.minecraftClient.options.debugEnabled) {
            // Draw Game info on every GameHud render
            this.hudInfo.draw(context);
        }
    }
}
