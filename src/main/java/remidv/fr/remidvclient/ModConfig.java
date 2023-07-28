package remidv.fr.remidvclient;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import javax.swing.text.JTextComponent;

public class ModConfig {
    public static KeyBinding openMenuKeyBinding;

    public static void InitializeKeyBinds()
    {
        openMenuKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Open Mods Menu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "RemiDvClient"
        ));
    }
}
