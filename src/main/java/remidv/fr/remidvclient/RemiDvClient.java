package remidv.fr.remidvclient;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;

public class RemiDvClient implements ModInitializer {
    public static MinecraftClient minecraftClient;
    @Override
    public void onInitialize() {
        minecraftClient = MinecraftClient.getInstance();
        System.out.println("Mod initialisé");
    }
}
