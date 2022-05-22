/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import Commands.BaseCommand;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.GameMaster;
import models.Message;

/**
 *
 * @author diemo
 */
public class ThreadClient extends Thread{
    private ObjectOutputStream writer;
    private ObjectInputStream reader;
    private boolean isRunning = true;

    public ThreadClient() {
        try {
            writer = new ObjectOutputStream(GameMaster.getGM().getClient().socket.getOutputStream());
            reader = new ObjectInputStream(GameMaster.getGM().getClient().socket.getInputStream());
            GameMaster.getGM().setThreadClient(this);
        } catch (IOException ex) {
            //Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObjectOutputStream getWriter() {
        return writer;
    }

    public void setWriter(ObjectOutputStream writer) {
        this.writer = writer;
    }

    public ObjectInputStream getReader() {
        return reader;
    }

    public void setReader(ObjectInputStream reader) {
        this.reader = reader;
    }
    
    

    public void run(){
        BaseCommand readMessage = null;
        while (isRunning) {
            
            try {
                readMessage = (BaseCommand)this.reader.readObject();
                System.out.println("port: " + GameMaster.getGM().getClient().socket.getPort());
            } catch (IOException ex) {    
            } catch (ClassNotFoundException ex) {}
            
            
            GameMaster.getGM().getMainScreen().showClientMessage(readMessage.executeOnClient());
            
//            if (readMessage.getName().toUpperCase().equals("CHAT")){
//                System.out.println("recibido " + readMessage.toString());
//                client.screenRef.showClientMessage("Recibido: " + readMessage.toString());
//            }else if (readMessage.getName().toUpperCase().equals("ATTACK")){
//                client.screenRef.showClientMessage("ATAQUE: " + readMessage.toString());
//            }
        }
    }
}
