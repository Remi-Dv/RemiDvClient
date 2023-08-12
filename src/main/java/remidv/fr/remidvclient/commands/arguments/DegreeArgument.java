package remidv.fr.remidvclient.commands.arguments;

import remidv.fr.remidvclient.commands.Argument;
import remidv.fr.remidvclient.commands.Command;
import remidv.fr.remidvclient.commands.CommandsManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DegreeArgument extends Argument {
    public DegreeArgument(String value){
        defaultValue = value;
        typeName = "Degree";
    }
    @Override
    public Float TryParse(String parameter){
        Float result = Float.parseFloat(parameter);
        return result;
    }

    @Override
    public List<String> GetSuggestions(String playerInput){
        List<String> possibleSuggestions = new ArrayList<>(Arrays.asList("0", "90", "180", "-90", "45", "-45", "135", "-135"));

        List<String> suggestions = new ArrayList<>();

        for (String suggest: possibleSuggestions){
            if (suggest.startsWith(playerInput) || playerInput.equals("")){
                suggestions.add(suggest);
            }
        }

        return suggestions;
    }
}
