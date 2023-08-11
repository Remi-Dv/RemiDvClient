package remidv.fr.remidvclient.commands.commandsList;

import remidv.fr.remidvclient.RemiDvClient;
import remidv.fr.remidvclient.commands.Argument;
import remidv.fr.remidvclient.commands.Command;
import remidv.fr.remidvclient.commands.arguments.IntArgument;

public class SetOrientationCommand extends Command {
    public SetOrientationCommand(){
        commandName = "setorientation";
        description = "set orientation to certains value";
        arguments = new Argument[]{
                new IntArgument("0"),
                new IntArgument("0")
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
