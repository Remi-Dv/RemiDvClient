package remidv.fr.remidvclient.commands.commandsList;

import net.minecraft.text.Text;
import remidv.fr.remidvclient.RemiDvClient;
import remidv.fr.remidvclient.commands.Argument;
import remidv.fr.remidvclient.commands.Command;
import remidv.fr.remidvclient.commands.arguments.IntArgument;

public class LookCommand extends Command {
    public LookCommand(){
        commandName = "look";
        arguments = new Argument[]{
                new IntArgument(),
                new IntArgument()
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


        RemiDvClient.minecraftClient.cameraEntity.setYaw((Integer) arguments[0].argumentValue);
        RemiDvClient.minecraftClient.cameraEntity.setPitch((Integer) arguments[1].argumentValue);
    }
}
