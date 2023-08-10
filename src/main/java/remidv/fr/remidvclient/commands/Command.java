package remidv.fr.remidvclient.commands;

import java.util.concurrent.ExecutionException;

public class Command {
    public String commandName;
    public Argument[] arguments;

    public String getCommandName() {
        return commandName;
    }

    public void executeCommand(String commandText) {
        System.out.println("Executing generic command: " + commandName);
    }

    public boolean hasCorrectNumberOfArguments(String[] commandText){
        if (commandText.length >= arguments.length){
            return true;
        }
        return false;
    }

    public boolean areArgumentsCorrect(String[] commandText){
        //fuse last elements
        for (int i = arguments.length; i < commandText.length - 1; i++){ // 2  <4 i++
            commandText[arguments.length] += " "; //".look" "1" "2"
            //".look" "1 2"
            commandText[arguments.length] += commandText[i+1];
        }

        for (int i = 1; i < arguments.length + 1; i++){
            try{
                arguments[i-1].TryParse(commandText[i]);
            } catch (NumberFormatException e){
                return false;
            }
        }
        return true;
    }
}
