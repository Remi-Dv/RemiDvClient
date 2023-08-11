package remidv.fr.remidvclient.commands.commandsList;

import net.minecraft.text.Text;
import remidv.fr.remidvclient.RemiDvClient;
import remidv.fr.remidvclient.commands.Argument;
import remidv.fr.remidvclient.commands.Command;
import remidv.fr.remidvclient.commands.CommandsManager;
import remidv.fr.remidvclient.commands.arguments.StringArgument;

public class HelpCommand extends Command {
    public HelpCommand(){
        commandName = "help";
        description = "show every commands and description";
        arguments = new Argument[]{
                new StringArgument("all")
        };
    }

    @Override
    public void executeCommand(String commandText) {
        if (!isCommandCorrect(commandText)){
            return;
        }

        if (argumentsValue.get(0).equals("all")){
            RemiDvClient.minecraftClient.player.sendMessage(Text.literal("§l§6Help:"), false);
            for (Command command: CommandsManager.commandsList){
                RemiDvClient.minecraftClient.player.sendMessage(Text.literal("§l§e" + command.commandName + "§k§f : §b"
                        + command.description), false);
            }
        } else {
            if (!ShowHelpForSpecificCommand()){
                RemiDvClient.minecraftClient.player.sendMessage(Text.literal("Incorrect command name"),false);
            }
        }

        CommandExecuted();
    }

    private boolean ShowHelpForSpecificCommand(){
        for (Command command: CommandsManager.commandsList){
            if (command.commandName.equals(argumentsValue.get(0))){
                String chatOutput = "§l§e" + command.commandName + "§k§f";
                for (int i = 0; i < command.arguments.length; i++){
                    chatOutput += " " + command.arguments[i].typeName;
                    if (command.arguments[i].defaultValue != null){
                        chatOutput += "(default: " + command.arguments[i].defaultValue + ")";
                    }
                }
                chatOutput += " : §b" + command.description;
                RemiDvClient.minecraftClient.player.sendMessage(Text.literal(chatOutput),false);
                return true;
            }
        }
        return false;
    }
}
