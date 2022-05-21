/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.io.Serializable;

/**
 *
 * @author diemo
 */
public abstract class BaseCommand implements iCommand, Serializable{
    private String[] args;
    private boolean isBroadcast;
    private String commandName;

    public BaseCommand(String commandName, String[] args, boolean isBroadcast) {
        this.args = args;
        this.isBroadcast = isBroadcast;
        this.commandName = commandName;
    }
    
    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public String getCommandName(){
        return this.commandName;
    }
    
    public boolean isBroadcast(){
        return isBroadcast;
    }
    
    
    public abstract String executeOnServer();
    public abstract String executeOnClient(); 
    
    
    
    
    
    
}
