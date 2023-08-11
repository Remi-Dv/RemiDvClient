package remidv.fr.remidvclient.commands.arguments;

import remidv.fr.remidvclient.commands.Argument;

public class StringArgument extends Argument {
    public StringArgument(String value){
        if (value != null){
            defaultValue = value;
        }
    }
    @Override
    public String TryParse(String parameter){
        String result = parameter;
        return result;
    }
}
