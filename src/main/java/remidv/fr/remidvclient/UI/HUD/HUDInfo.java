package remidv.fr.remidvclient.UI.HUD;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.World;
import org.joml.*;

@Environment(EnvType.CLIENT)
public class HUDInfo {
    private static MinecraftClient client = MinecraftClient.getInstance();
    public static void DisplayCoordinates(DrawContext drawContext) {

        int color = 0xffffff;
        double playerX = client.player.getX();
        double playerY = client.player.getY();
        double playerZ = client.player.getZ();

        RegistryKey<World> dimensionKey = client.world.getRegistryKey();

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

        TextRenderer textRenderer = client.textRenderer;

        drawContext.drawText(textRenderer, overworldCoordsText, x, y, color, false);
        y += textRenderer.fontHeight + 2;
        drawContext.drawText(textRenderer, netherCoordsText, x, y, color, false);
        drawContext.drawHorizontalLine(10, 10, 100, 100);

        drawContext.draw();
    }
    private static Vector2f GetProjection(Vector3f coords, DrawContext drawContext) {
        Vector3f projection = coords.mulPosition(drawContext.getMatrices().peek().getPositionMatrix());
        return new Vector2f(projection.x, projection.y);
    }
}
