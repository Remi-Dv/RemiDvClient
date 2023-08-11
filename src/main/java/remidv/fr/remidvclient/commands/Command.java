package remidv.fr.remidvclient.commands;

import net.minecraft.text.Text;
import remidv.fr.remidvclient.RemiDvClient;

import java.util.ArrayList;
import java.util.List;

public class Command {
    public String commandName;
    public String description;
    public Argument[] arguments;

    public List<Object> argumentsValue;

    public String getCommandName() {
        return commandName;
    }

    public void executeCommand(String commandText) {
        System.out.println("Executing generic command: " + commandName);
    }
    public boolean isCommandCorrect(String commandText){
        String[] splittedCommand = commandText.split(" ");
        splittedCommand = hasCorrectNumberOfArguments(splittedCommand);
        if (splittedCommand == null){
            RemiDvClient.minecraftClient.player.sendMessage(Text.literal("Invalid number of arguments"), false);
            return false;
        }
        if (!areArgumentsCorrect(splittedCommand)){
            RemiDvClient.minecraftClient.player.sendMessage(Text.literal("Incorrect Argument(s)"), false);
            return false;
        }
        
        return true;
    }
    public String[] hasCorrectNumberOfArguments(String[] commandText){
        for (int i = 0; i < arguments.length; i++){
            if (commandText.length - 1 < arguments.length){
                if (arguments[i].defaultValue == null){
                    return null;
                } else {
                    String[] newCommandText = new String[commandText.length + 1];
                    System.arraycopy(commandText, 0, newCommandText, 0, commandText.length);
                    newCommandText[newCommandText.length - 1] = arguments[i].defaultValue;
                    commandText = newCommandText;
                }
            }
        }
        if (commandText.length >= arguments.length){
            return commandText;
        }
        return null;
    }
    public boolean areArgumentsCorrect(String[] commandText){
        //fuse last elements
        for (int i = arguments.length; i < commandText.length - 1; i++){
            commandText[arguments.length] += " ";
            commandText[arguments.length] += commandText[i+1];
        }

        argumentsValue = new ArrayList<>();
        for (int i = 1; i < arguments.length + 1; i++){
            try{
                Object newArgument = arguments[i-1].TryParse(commandText[i]);
                argumentsValue.add(newArgument);
            } catch (NumberFormatException e){
                return false;
            }
        }
        return true;
    }

    public void CommandExecuted(){
        argumentsValue = null;
    }
}
