package remidv.fr.remidvclient.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;
import remidv.fr.remidvclient.ModConfig;
import remidv.fr.remidvclient.UI.GUIManager;

@Environment(EnvType.CLIENT)
@Mixin(MinecraftClient.class)
public class MixinMinecraft
{
    @Inject(method = "tick", at = @At("HEAD"))
    public void onTick(CallbackInfo ci)
    {
        if (ModConfig.openMenuKeyBinding.wasPressed()) {
            GUIManager.toggleModMenu();
        }
    }
}