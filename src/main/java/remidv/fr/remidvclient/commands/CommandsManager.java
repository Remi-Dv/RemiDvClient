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
        if (playerMessage.startsWith(".")) {
            String targetCommandName = playerMessage.split(" ")[0];
            targetCommandName = targetCommandName.substring(1);
            System.out.println(targetCommandName);
            Command targetCommand = getCommandByCommandName(targetCommandName);
            if (targetCommand == null){
                RemiDvClient.minecraftClient.player.sendMessage(Text.literal("Invalid command"), false);
            } else {
                targetCommand.executeCommand(playerMessage);
            }
            return true;
        }
        return false;
    }

    public static Command getCommandByCommandName(String commandName) {
        for (Command command : commandsList) {
            System.out.println(command.getCommandName());
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
