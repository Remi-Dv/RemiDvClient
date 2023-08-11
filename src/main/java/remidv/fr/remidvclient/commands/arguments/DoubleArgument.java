package remidv.fr.remidvclient.commands.arguments;

import remidv.fr.remidvclient.commands.Argument;

public class DoubleArgument extends Argument {
    public DoubleArgument(String value){
        defaultValue = value;
        typeName = "Double";
    }
    @Override
    public Double TryParse(String parameter){
        double result = Double.parseDouble(parameter);
        return result;
    }
}
