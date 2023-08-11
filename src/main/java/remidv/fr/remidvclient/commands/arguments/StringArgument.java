package remidv.fr.remidvclient.commands.arguments;

import remidv.fr.remidvclient.commands.Argument;

public class StringArgument extends Argument {
    @Override
    public String TryParse(String parameter){
        String result = parameter;
        return result;
    }
}
