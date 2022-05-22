/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Utils.CommandUtils;
import java.io.Serializable;

/**
 *
 * @author diemo
 */
public class ChatCommand extends BaseCommand implements Serializable{

    public ChatCommand(String commandName, String[] args) {
        super(commandName, args, true);
    }

    // Hola como estan
    @Override
    public String executeOnServer() {
        return "Enviado: " + CommandUtils.concatArray(getArgs());
    }

    @Override
    public String executeOnClient() {
        String[] newArgs = new String[getArgs().length-1];
        for (int i = 0; i < newArgs.length; i++)
            newArgs[i] = getArgs()[i+1];
        return this.getPlayerExcecuting() + ": " + CommandUtils.concatArray(newArgs);
    }
    
    
    
}
