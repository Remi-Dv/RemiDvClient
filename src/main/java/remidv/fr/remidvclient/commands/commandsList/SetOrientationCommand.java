package remidv.fr.remidvclient.commands.commandsList;

import remidv.fr.remidvclient.RemiDvClient;
import remidv.fr.remidvclient.commands.Command;

public class SetOrientationCommand extends Command {
    public SetOrientationCommand(){
        commandName = "setorientation";
    }
    @Override
    public void executeCommand(String commandText) {
        RemiDvClient.minecraftClient.cameraEntity.setYaw(0);
        RemiDvClient.minecraftClient.cameraEntity.setPitch(0);
    }
}
