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
        if (!hasCorrectNumberOfArguments(splittedCommand)){
            RemiDvClient.minecraftClient.player.sendMessage(Text.literal("Invalid number of arguments"), false);
            return false;
        }
        if (!areArgumentsCorrect(splittedCommand)){
            RemiDvClient.minecraftClient.player.sendMessage(Text.literal("Incorrect Argument(s)"), false);
            return false;
        }
        
        return true;
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
