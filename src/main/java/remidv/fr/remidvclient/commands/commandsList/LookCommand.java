package remidv.fr.remidvclient.commands.commandsList;

import remidv.fr.remidvclient.commands.Argument;
import remidv.fr.remidvclient.commands.Command;
import remidv.fr.remidvclient.commands.arguments.IntArgument;

import java.util.ArrayList;

public class LookCommand extends Command {
    public LookCommand(){
        commandName = "look";
        arguments = new Argument[]{
                new IntArgument(),
                new IntArgument()
        };
    }

    @Override
    public void executeCommand(String commandText) {

    }
}
