package remidv.fr.remidvclient.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import remidv.fr.remidvclient.RemiDvClient;
import remidv.fr.remidvclient.UI.Chat.ChatControl;
import remidv.fr.remidvclient.commands.CommandsManager;

@Environment(EnvType.CLIENT)
@Mixin(ChatScreen.class)
public class MixinChatScreen
{
    @Inject(method = "sendMessage", at = @At("HEAD"), cancellable = true)
    public void onClientSendMessage(String chatText, boolean addToHistory, CallbackInfoReturnable<Boolean> ci) {
        boolean messageIsCommand = CommandsManager.clientSendMessage(chatText);
        if (messageIsCommand){
            
            ci.cancel();
            RemiDvClient.minecraftClient.currentScreen = null;
            RemiDvClient.minecraftClient.mouse.lockCursor();
        }
    }
}