package remidv.fr.remidvclient.commands.arguments;

import remidv.fr.remidvclient.commands.Argument;
import remidv.fr.remidvclient.commands.Command;
import remidv.fr.remidvclient.commands.CommandsManager;

public class CommandNameArgument extends Argument {
    public CommandNameArgument(String value){
        defaultValue = value;
        typeName = "Double";
    }
    @Override
    public String TryParse(String parameter){
        for (Command command: CommandsManager.commandsList){
            if (parameter.equals(command.commandName)){
                return parameter;
            }
        }
        return null;
    }
}
