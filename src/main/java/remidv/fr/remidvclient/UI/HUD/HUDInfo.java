package remidv.fr.remidvclient.UI.HUD;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.impl.lib.sat4j.core.Vec;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
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

        Vector3f coordsWaypoint = GetProjection(new Vector3f(0,100,0), drawContext);

        System.out.println(coordsWaypoint.x + " " + coordsWaypoint.y + " " + coordsWaypoint.z);
        drawContext.drawText(textRenderer, "X", (int) coordsWaypoint.x, (int) coordsWaypoint.y, color, false);

        drawContext.draw();
    }

    private static Vector3f GetProjection(Vector3f coords, DrawContext drawContext) {
        Vector3f projection = coords.mulPosition(drawContext.getMatrices().peek().getPositionMatrix());
        return projection;
    }
}
