package remidv.fr.remidvclient.commands.arguments;

import remidv.fr.remidvclient.commands.Argument;

public class IntArgument extends Argument {
    public IntArgument(String value){
        defaultValue = value;
    }
    @Override
    public Integer TryParse(String parameter){
        Integer result = Integer.parseInt(parameter);
        return result;
    }
}
