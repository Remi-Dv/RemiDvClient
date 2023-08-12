package remidv.fr.remidvclient.mixin;

import net.minecraft.client.Keyboard;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import remidv.fr.remidvclient.ModConfig;

@Mixin(Keyboard.class)
public class MixinKeyboard {
    @Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
    public void onKey(long window, int keyCode, int scancode, int action, int modifiers, CallbackInfo info) {
        if (keyCode != GLFW.GLFW_KEY_UNKNOWN) {
            if (action == GLFW.GLFW_PRESS && ModConfig.openMenuKeyBinding.matchesKey(keyCode, scancode)){
                System.out.println("KEY just PRESSED");
            }
        }
    }
}
