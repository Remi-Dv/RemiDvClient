package remidv.fr.remidvclient.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;
import org.w3c.dom.Text;
import remidv.fr.remidvclient.UI.HUD.HUDInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraft
{
    @Inject(method = "tick", at = @At("HEAD"))
    public void onTick(CallbackInfo ci)
    {

    }
}