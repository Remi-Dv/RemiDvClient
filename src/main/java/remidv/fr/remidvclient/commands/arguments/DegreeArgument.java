package remidv.fr.remidvclient.commands.arguments;

import remidv.fr.remidvclient.commands.Argument;
import remidv.fr.remidvclient.commands.Command;
import remidv.fr.remidvclient.commands.CommandsManager;

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
}
