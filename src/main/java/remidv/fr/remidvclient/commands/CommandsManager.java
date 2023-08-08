package remidv.fr.remidvclient.commands;

import remidv.fr.remidvclient.RemiDvClient;

public class CommandsManager {
    public static boolean clientSendMessage(String playerMessage) {
        //RemiDvClient.minecraftClient.cameraEntity.setYaw(0);
        //RemiDvClient.minecraftClient.cameraEntity.setPitch(0);
        //RemiDvClient.minecraftClient.player.setPos(
        //        Math.round(RemiDvClient.minecraftClient.player.getX()),
        //        Math.round(RemiDvClient.minecraftClient.player.getY()),
        //        Math.round(RemiDvClient.minecraftClient.player.getZ())
        //);

        if (playerMessage.startsWith(".")) {
            return true;
        }
        return false;
    }
}
