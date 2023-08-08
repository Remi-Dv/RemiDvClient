package remidv.fr.remidvclient.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import remidv.fr.remidvclient.UI.TitleScreenCredits;

@Mixin(TitleScreen.class)
public class MixinTitleScreen {
    @Inject(method = "render", at = @At("TAIL"))
    private void onRender(DrawContext drawContext, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        TitleScreenCredits.renderCredits(drawContext);
    }
}
