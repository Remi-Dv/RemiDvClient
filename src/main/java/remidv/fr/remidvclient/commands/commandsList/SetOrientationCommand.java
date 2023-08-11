package remidv.fr.remidvclient.commands.commandsList;

import remidv.fr.remidvclient.RemiDvClient;
import remidv.fr.remidvclient.commands.Argument;
import remidv.fr.remidvclient.commands.Command;
import remidv.fr.remidvclient.commands.arguments.IntArgument;

public class SetOrientationCommand extends Command {
    public SetOrientationCommand(){
        commandName = "setorientation";
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

        RemiDvClient.minecraftClient.cameraEntity.setYaw(0);
        RemiDvClient.minecraftClient.cameraEntity.setPitch(0);

        CommandExecuted();
    }
}
