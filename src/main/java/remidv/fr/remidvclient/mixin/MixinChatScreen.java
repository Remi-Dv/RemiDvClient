package remidv.fr.remidvclient.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(ChatScreen.class)
public class MixinChatScreen
{
    @Inject(method = "sendMessage", at = @At("HEAD"), cancellable = true)
    public void onClientSendMessage(String chatText, boolean addToHistory, CallbackInfoReturnable<Boolean> ci) {
        System.out.println(chatText);
        ci.cancel();
    }
}