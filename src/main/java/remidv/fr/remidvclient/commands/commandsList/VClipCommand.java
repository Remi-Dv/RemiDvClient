package remidv.fr.remidvclient.commands.commandsList;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.c2s.play.VehicleMoveC2SPacket;
import remidv.fr.remidvclient.RemiDvClient;
import remidv.fr.remidvclient.commands.Argument;
import remidv.fr.remidvclient.commands.Command;
import remidv.fr.remidvclient.commands.arguments.DoubleArgument;
import remidv.fr.remidvclient.commands.arguments.IntArgument;

public class VClipCommand extends Command {
    public VClipCommand(){
        commandName = "vclip";
        description = "clips through blocks vertically";
        arguments = new Argument[]{
                new DoubleArgument(null)
        };
    }

    @Override
    public void executeCommand(String commandText) {
        if (!isCommandCorrect(commandText)){
            return;
        }

        MinecraftClient mc = RemiDvClient.minecraftClient;
        double blocks = (Double) argumentsValue.get(0);

        int packetsRequired = (int) Math.ceil(Math.abs(blocks / 10));

        if (RemiDvClient.minecraftClient.player.hasVehicle()) {
            //vehicle version
            for (int packetNumber = 0; packetNumber < (packetsRequired - 1); packetNumber++) {
                mc.player.networkHandler.sendPacket(new VehicleMoveC2SPacket(mc.player.getVehicle()));
            }
            mc.player.getVehicle().setPosition(mc.player.getVehicle().getX(), mc.player.getVehicle().getY() + blocks, mc.player.getVehicle().getZ());
            mc.player.networkHandler.sendPacket(new VehicleMoveC2SPacket(mc.player.getVehicle()));
        } else {
            //normal version
            for (int packetNumber = 0; packetNumber < (packetsRequired - 1); packetNumber++) {
                mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true));
            }
            mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(mc.player.getX(), mc.player.getY() + blocks, mc.player.getZ(), true));
            mc.player.setPosition(mc.player.getX(), mc.player.getY() + blocks, mc.player.getZ());
        }

        CommandExecuted();
    }
}
