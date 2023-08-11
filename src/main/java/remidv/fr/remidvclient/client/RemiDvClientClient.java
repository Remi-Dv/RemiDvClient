package remidv.fr.remidvclient.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import remidv.fr.remidvclient.ModConfig;
import remidv.fr.remidvclient.commands.CommandsManager;

@Environment(EnvType.CLIENT)
public class RemiDvClientClient implements ClientModInitializer {
    private ModConfig modConfig;
    public void onInitializeClient() {
        System.out.println("Client Initialized!");

        modConfig = new ModConfig();

        CommandsManager.InitializeCommands();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (modConfig.openMenuKeyBinding.wasPressed()) {
                System.out.println("héhéhéh");
                //client.player.sendMessage(Text.literal("Key 1 was pressed!"), false);
            }
        });

        //HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
        //    HUDInfo.DisplayCoordinates(drawContext);
        //});

        //WorldRenderEvents.LAST.register((t) ->{

        //});
    }
}
