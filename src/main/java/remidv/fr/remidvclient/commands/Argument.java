package remidv.fr.remidvclient.commands;

import java.util.ArrayList;
import java.util.List;

public class Argument {
    public String defaultValue;
    public String typeName;
    public Object TryParse(String parameter){
        return null;
    }

    public List<String> GetSuggestions(String playerInput){
        return new ArrayList<>();
    }
}
