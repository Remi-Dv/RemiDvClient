package remidv.fr.remidvclient.commands.commandsList;

import remidv.fr.remidvclient.RemiDvClient;
import remidv.fr.remidvclient.commands.Argument;
import remidv.fr.remidvclient.commands.Command;
import remidv.fr.remidvclient.commands.arguments.DoubleArgument;
import remidv.fr.remidvclient.commands.arguments.IntArgument;

public class LookAtCommand extends Command {
    public LookAtCommand(){
        commandName = "lookAt";
        description = "look at specified coordinates";
        arguments = new Argument[]{
                new DoubleArgument("0"),
                new DoubleArgument("0"),
                new DoubleArgument("0")
        };
    }

    @Override
    public void executeCommand(String commandText) {
        if (!isCommandCorrect(commandText)){
            return;
        }

        double targetX = (double) argumentsValue.get(0); // Coordonnée X de la cible
        double targetY = (double) argumentsValue.get(1); // Coordonnée Y de la cible
        double targetZ = (double) argumentsValue.get(2); // Coordonnée Z de la cible

        double cameraX = RemiDvClient.minecraftClient.cameraEntity.getX(); // Coordonnée X de la caméra
        double cameraY = RemiDvClient.minecraftClient.cameraEntity.getY(); // Coordonnée Y de la caméra
        double cameraZ = RemiDvClient.minecraftClient.cameraEntity.getZ(); // Coordonnée Z de la caméra

        // Calculer les angles d'azimut (yaw) et d'élévation (pitch)
        double deltaX = targetX - cameraX;
        double deltaY = targetY - cameraY;
        double deltaZ = targetZ - cameraZ;

        double yawRadians = Math.atan2(deltaZ, deltaX);
        double horizontalDistance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);
        double pitchRadians = -Math.atan2(deltaY, horizontalDistance);

        // Convertir les angles en degrés
        double yawDegrees = Math.toDegrees(yawRadians);
        double pitchDegrees = Math.toDegrees(pitchRadians);

        // Orienter la caméra avec les angles en degrés
        RemiDvClient.minecraftClient.cameraEntity.setYaw((float) yawDegrees - 90);
        RemiDvClient.minecraftClient.cameraEntity.setPitch((float) pitchDegrees);

        CommandExecuted();
    }
}
