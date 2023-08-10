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
        String[] splittedCommand = commandText.split(" ");
        if (!hasCorrectNumberOfArguments(splittedCommand)){
            RemiDvClient.minecraftClient.player.sendMessage(Text.literal("Invalid number of arguments"), false);
            return;
        }
        if (!areArgumentsCorrect(splittedCommand)){
            RemiDvClient.minecraftClient.player.sendMessage(Text.literal("Incorrect Argument(s)"), false);
            return;
        }

        RemiDvClient.minecraftClient.player.networkHandler.sendChatMessage((String) arguments[0].argumentValue);
    }
}
