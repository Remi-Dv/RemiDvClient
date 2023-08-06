package remidv.fr.remidvclient.UI.HUD;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class HUDInfo {
    private MinecraftClient minecraftClient;
    private TextRenderer textRenderer;

    private int fontColor = 0xffffff;
    public HUDInfo(MinecraftClient client) {
        minecraftClient = client;
        textRenderer = minecraftClient.textRenderer;
    }

    public void draw(DrawContext drawContext) {

        double playerX = minecraftClient.player.getX();
        double playerY = minecraftClient.player.getY();
        double playerZ = minecraftClient.player.getZ();

        RegistryKey<World> dimensionKey = minecraftClient.world.getRegistryKey();

        String overworldCoordsText;
        String netherCoordsText;

        if (dimensionKey == World.OVERWORLD) {
            overworldCoordsText = String.format("Overworld: %s %s %s", (int) playerX, (int) playerY, (int) playerZ);
            netherCoordsText = String.format("Nether: %s %s %s", (int) (playerX / 8d), (int) playerY, (int) (playerZ / 8d));
        } else if (dimensionKey == World.NETHER) {
            overworldCoordsText = String.format("Overworld: %s %s %s", (int) (playerX * 8d), (int) playerY, (int) (playerZ * 8d));
            netherCoordsText = String.format("Nether: %s %s %s", (int) playerX, (int) playerY, (int) playerZ);
        } else {
            overworldCoordsText = String.format("End: %s %s %s", (int) playerX, (int) playerY, (int) playerZ);
            netherCoordsText = String.format("Nether: %s %s %s", (int) (playerX / 8d), (int) playerY, (int) (playerZ / 8d));
        }

        int x = 2;
        int y = 2;

        drawContext.drawTextWithShadow(this.textRenderer, overworldCoordsText, x, y, this.fontColor);
        y += textRenderer.fontHeight + 2;
        drawContext.drawTextWithShadow(this.textRenderer, netherCoordsText, x, y, this.fontColor);
    }
}
