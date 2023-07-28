package remidv.fr.remidvclient.commands;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;

public class CommandsManager {
    public static boolean clientSendMessage(String playerMessage)
    {
        if (playerMessage.startsWith(".")) {
            return true;
        }
        return false;
    }
}
