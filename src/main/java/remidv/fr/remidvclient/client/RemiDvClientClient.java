package remidv.fr.remidvclient.client;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import remidv.fr.remidvclient.ModConfig;
import remidv.fr.remidvclient.UI.HUD.HUDInfo;

@Environment(EnvType.CLIENT)
public class RemiDvClientClient implements ClientModInitializer
{
    public void onInitializeClient()
    {
        System.out.println("Client Initialized");


        ModConfig.InitializeKeyBinds();

        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            HUDInfo.DisplayCoordinates(drawContext);
        });
    }
}
