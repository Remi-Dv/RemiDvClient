package remidv.fr.remidvclient.UI;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import remidv.fr.remidvclient.RemiDvClient;

public class TitleScreenCredits {
    public static void renderCredits(DrawContext drawContext) {
        drawContext.drawTextWithShadow(RemiDvClient.minecraftClient.textRenderer, "§6RemiDvClient§f made by §eRemiDv", 2,2, 0xffffff);
    }
}
