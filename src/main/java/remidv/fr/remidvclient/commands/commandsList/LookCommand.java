package remidv.fr.remidvclient.commands.commandsList;

import net.minecraft.text.Text;
import remidv.fr.remidvclient.RemiDvClient;
import remidv.fr.remidvclient.commands.Argument;
import remidv.fr.remidvclient.commands.Command;
import remidv.fr.remidvclient.commands.arguments.IntArgument;

public class LookCommand extends Command {
    public LookCommand(){
        commandName = "look";
        description = "set orientation to look something";
        arguments = new Argument[]{
                new IntArgument(null),
                new IntArgument(null)
        };
    }

    @Override
    public void executeCommand(String commandText) {
        if (!isCommandCorrect(commandText)){
            return;
        }



        CommandExecuted();
    }
}
