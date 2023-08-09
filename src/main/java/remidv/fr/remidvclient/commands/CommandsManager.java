package remidv.fr.remidvclient.commands;

import net.minecraft.text.Text;
import remidv.fr.remidvclient.RemiDvClient;
import remidv.fr.remidvclient.commands.commandsList.LookCommand;
import remidv.fr.remidvclient.commands.commandsList.SetOrientationCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandsManager {
    public static List<Command> commandsList;
    public static boolean clientSendMessage(String playerMessage) {
        //RemiDvClient.minecraftClient.cameraEntity.setYaw(0);
        //RemiDvClient.minecraftClient.cameraEntity.setPitch(0);
        //RemiDvClient.minecraftClient.player.setPos(
        //        Math.round(RemiDvClient.minecraftClient.player.getX()),
        //        Math.round(RemiDvClient.minecraftClient.player.getY()),
        //        Math.round(RemiDvClient.minecraftClient.player.getZ())
        //);

        if (playerMessage.startsWith(".")) {
            String targetCommandName = playerMessage.split(" ")[0];
            targetCommandName = targetCommandName.substring(1);
            Command targetCommand = getCommandByCommandName(targetCommandName);
            if (targetCommand == null){
                RemiDvClient.minecraftClient.player.sendMessage(Text.literal("Invalid command"), false);
            } else {
                //executer la fonction
            }
            return true;
        }
        return false;
    }

    public static Command getCommandByCommandName(String commandName) {
        for (Command command : commandsList) {
            if (command.getCommandName().equals(commandName)) {
                return command;
            }
        }
        return null; // Si aucune instance ne correspond à commandName
    }

    public static void InitializeCommands() {
        commandsList = new ArrayList<>();

        commandsList.add(new LookCommand());
        commandsList.add(new SetOrientationCommand());
    }
}
