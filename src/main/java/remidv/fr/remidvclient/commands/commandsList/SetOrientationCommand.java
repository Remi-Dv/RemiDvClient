package remidv.fr.remidvclient.commands.commandsList;

import remidv.fr.remidvclient.RemiDvClient;
import remidv.fr.remidvclient.commands.Argument;
import remidv.fr.remidvclient.commands.Command;
import remidv.fr.remidvclient.commands.arguments.DegreeArgument;
import remidv.fr.remidvclient.commands.arguments.IntArgument;

public class SetOrientationCommand extends Command {
    public SetOrientationCommand(){
        commandName = "setOrientation";
        description = "set orientation to certains value";
        arguments = new Argument[]{
                new DegreeArgument("0"),
                new DegreeArgument("0")
        };
    }
    @Override
    public void executeCommand(String commandText) {
        if (!isCommandCorrect(commandText)){
            return;
        }

        RemiDvClient.minecraftClient.cameraEntity.setYaw((Float) argumentsValue.get(0));
        RemiDvClient.minecraftClient.cameraEntity.setPitch((Float) argumentsValue.get(1));

        CommandExecuted();
    }
}
