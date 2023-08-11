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
        if (!isCommandCorrect(commandText)){
            return;
        }

        RemiDvClient.minecraftClient.cameraEntity.setYaw((Integer) argumentsValue.get(0));
        RemiDvClient.minecraftClient.cameraEntity.setPitch((Integer) argumentsValue.get(1));

        CommandExecuted();
    }
}
