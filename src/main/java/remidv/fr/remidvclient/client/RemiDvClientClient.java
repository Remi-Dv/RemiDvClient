package remidv.fr.remidvclient.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.fabricmc.fabric.api.event.EventFactory;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.minecraft.client.util.ChatMessages;
import net.minecraft.network.message.SentMessage;
import net.minecraft.server.command.CommandManager;
import net.minecraft.util.ActionResult;
import remidv.fr.remidvclient.ModConfig;
import remidv.fr.remidvclient.UI.GUIManager;
import remidv.fr.remidvclient.UI.HUD.HUDInfo;

@Environment(EnvType.CLIENT)
public class RemiDvClientClient implements ClientModInitializer
{
    public void onInitializeClient()
    {
        System.out.println("Client Initialized!");

        ModConfig.InitializeKeyBinds();

        //HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
        //    HUDInfo.DisplayCoordinates(drawContext);
        //});

        //WorldRenderEvents.LAST.register((t) ->{

        //});
    }
}
