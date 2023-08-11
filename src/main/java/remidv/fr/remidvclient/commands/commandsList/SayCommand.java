package remidv.fr.remidvclient.commands.commandsList;

import net.minecraft.text.Text;
import remidv.fr.remidvclient.RemiDvClient;
import remidv.fr.remidvclient.commands.Argument;
import remidv.fr.remidvclient.commands.Command;
import remidv.fr.remidvclient.commands.arguments.IntArgument;
import remidv.fr.remidvclient.commands.arguments.StringArgument;

public class SayCommand extends Command {
    public SayCommand(){
        commandName = "say";
        arguments = new Argument[]{
                new StringArgument()
        };
    }

    @Override
    public void executeCommand(String commandText) {
        if (!isCommandCorrect(commandText)){
            return;
        }

        RemiDvClient.minecraftClient.player.networkHandler.sendChatMessage((String) argumentsValue.get(0));

        CommandExecuted();
    }
}
