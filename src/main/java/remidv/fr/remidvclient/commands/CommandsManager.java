package remidv.fr.remidvclient.commands;

import com.mojang.brigadier.context.CommandContextBuilder;
import com.mojang.brigadier.context.SuggestionContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.mojang.brigadier.tree.CommandNode;
import net.minecraft.text.Text;
import remidv.fr.remidvclient.RemiDvClient;
import remidv.fr.remidvclient.commands.commandsList.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

public class CommandsManager {
    public static char commandPrefix = '.';
    public static List<Command> commandsList;
    public static boolean clientSendMessage(String playerMessage) {
        if (playerMessage.startsWith(String.valueOf(commandPrefix))) {
            String targetCommandName = playerMessage.split(" ")[0];
            targetCommandName = targetCommandName.substring(1);
            System.out.println(targetCommandName);
            Command targetCommand = getCommandByCommandName(targetCommandName);
            if (targetCommand == null){
                RemiDvClient.minecraftClient.player.sendMessage(Text.literal("Invalid command"), false);
            } else {
                targetCommand.executeCommand(playerMessage);
            }
            return true;
        }
        return false;
    }

    public static Command getCommandByCommandName(String commandName) {
        for (Command command : commandsList) {
            System.out.println(command.getCommandName());
            if (command.getCommandName().equals(commandName)) {
                return command;
            }
        }
        return null; // Si aucune instance ne correspond à commandName
    }

    public static CompletableFuture<Suggestions> getCompletionSuggestions(String chatInput, int cursor) {
        SuggestionsBuilder suggestionsBuilder = new SuggestionsBuilder(chatInput, cursor);

        String targetCommandName = chatInput.substring(1);
        String[] splittedCommand = targetCommandName.split(" ", -1);

        if (splittedCommand.length == 1){
            for (Command command: commandsList){
                if (command.commandName.startsWith(splittedCommand[0])){
                    suggestionsBuilder.suggest(commandPrefix + command.commandName);
                }
            }
        } else if (splittedCommand.length > 1){
            for (Command command: commandsList){
                if (command.commandName.equals(splittedCommand[0])){
                    String completeSuggestion = String.valueOf(commandPrefix);
                    for (int i = 0; i < splittedCommand.length - 1; i++){
                        if (i != 0){
                            completeSuggestion += " ";
                        }
                        completeSuggestion += splittedCommand[i];
                    }
                    completeSuggestion += " ";

                    if (command.arguments.length >= splittedCommand.length - 1){
                        List<String> suggestions = command.arguments[splittedCommand.length-2]
                                .GetSuggestions(splittedCommand[splittedCommand.length-1]);
                        for (String possibleSuggestions: suggestions){
                            suggestionsBuilder.suggest(completeSuggestion+possibleSuggestions);
                        }
                        break;
                    }
                }
            }
        }

        // Build and return the suggestions
        Suggestions suggestions = suggestionsBuilder.build();
        return CompletableFuture.completedFuture(suggestions);
    }

    public static void InitializeCommands() {
        commandsList = new ArrayList<>();

        commandsList.add(new HelpCommand());
        commandsList.add(new LookAtCommand());
        commandsList.add(new LookCommand());
        commandsList.add(new SayCommand());
        commandsList.add(new SetOrientationCommand());
    }
}
