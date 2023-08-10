package remidv.fr.remidvclient.commands;

import java.util.List;

public class Command {
    public String commandName;
    public Argument[] arguments;

    public String getCommandName() {
        return commandName;
    }

    public void executeCommand(String commandText) {
        System.out.println("Executing generic command: " + commandName);
    }
}
