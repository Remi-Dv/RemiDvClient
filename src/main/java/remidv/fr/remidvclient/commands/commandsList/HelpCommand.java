package remidv.fr.remidvclient.commands.commandsList;

import net.minecraft.text.Text;
import remidv.fr.remidvclient.RemiDvClient;
import remidv.fr.remidvclient.commands.Argument;
import remidv.fr.remidvclient.commands.Command;
import remidv.fr.remidvclient.commands.CommandsManager;

public class HelpCommand extends Command {
    public HelpCommand(){
        commandName = "help";
        description = "show every commands and description";
        arguments = new Argument[]{};
    }

    @Override
    public void executeCommand(String commandText) {
        if (!isCommandCorrect(commandText)){
            return;
        }

        RemiDvClient.minecraftClient.player.sendMessage(Text.literal("§l§6Help:"), false);
        for (Command command: CommandsManager.commandsList){
            RemiDvClient.minecraftClient.player.sendMessage(Text.literal("§l§e" + command.commandName + "§k§f : §b"
                    + command.description), false);
        }

        CommandExecuted();
    }
}
