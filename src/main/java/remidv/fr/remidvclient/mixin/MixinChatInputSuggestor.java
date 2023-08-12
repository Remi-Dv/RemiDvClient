package remidv.fr.remidvclient.mixin;

import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.suggestion.Suggestion;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.client.gui.screen.ChatInputSuggestor;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.command.CommandSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import remidv.fr.remidvclient.commands.CommandsManager;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Mixin(ChatInputSuggestor.class)
public class MixinChatInputSuggestor {
    @Shadow @Final TextFieldWidget textField;
    @Shadow private CompletableFuture<Suggestions> pendingSuggestions;
    @Shadow private ChatInputSuggestor.SuggestionWindow window;
    @Inject(method = "refresh",
            at = @At(value = "INVOKE", target = "Lcom/mojang/brigadier/StringReader;canRead()Z", remap = false),
            cancellable = true,
            locals = LocalCapture.CAPTURE_FAILHARD)
    public void onRefresh(CallbackInfo ci, String string, StringReader reader) {
        String prefix = String.valueOf(CommandsManager.commandPrefix);

        if (reader.canRead(1) && reader.getString().startsWith(prefix, reader.getCursor())){
            CompletableFuture<Suggestions> suggestions = CommandsManager.getCompletionSuggestions(reader.getString(), reader.getCursor());

            this.pendingSuggestions = suggestions;
            ci.cancel();
        }
    }
}
