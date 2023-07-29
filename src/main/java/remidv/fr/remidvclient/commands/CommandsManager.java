package remidv.fr.remidvclient.commands;

public class CommandsManager {
    public static boolean clientSendMessage(String playerMessage)
    {
        if (playerMessage.startsWith(".")) {
            return true;
        }
        return false;
    }
}
