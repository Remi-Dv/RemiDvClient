package remidv.fr.remidvclient.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import remidv.fr.remidvclient.ModConfig;

@Mixin(Screen.class)
public class MixinScreen {
    @Inject(method = "keyPressed", at = @At("HEAD"), cancellable = true)
    private void onKeyPressed(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable ci) {
        KeyBinding openMenuKeyBinding = ModConfig.openMenuKeyBinding;  // Récupérer la touche personnalisée

        if (openMenuKeyBinding.matchesKey(keyCode, scanCode)) {
            System.out.println("salut");
        }
    }
}
