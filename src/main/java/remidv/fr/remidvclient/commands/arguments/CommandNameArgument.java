package remidv.fr.remidvclient.commands.arguments;

import remidv.fr.remidvclient.commands.Argument;
import remidv.fr.remidvclient.commands.Command;
import remidv.fr.remidvclient.commands.CommandsManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandNameArgument extends Argument {
    public CommandNameArgument(String value){
        defaultValue = value;
        typeName = "Double";
    }
    @Override
    public String TryParse(String parameter){
        if (parameter.equals("all")){
            return parameter;
        }
        for (Command command: CommandsManager.commandsList){
            if (parameter.equals(command.commandName)){
                return parameter;
            }
        }
        return null;
    }

    @Override
    public List<String> GetSuggestions(String playerInput){
        List<String> suggestions = new ArrayList<>();

        if ("all".startsWith(playerInput) || playerInput.equals("")){
            suggestions.add("all");
        }
        for (Command command: CommandsManager.commandsList){
            if (command.commandName.startsWith(playerInput) || playerInput.equals("")){
                suggestions.add(command.commandName);
            }
        }

        return suggestions;
    }
}
