/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package communication;

import java.io.*;
import java.net.*;

// el cliente se conecta al servidor por edio del socket, el cual va
// al IP del server y al puerto del server
public class Client {
    // es el socket del cliente, el cual el servidor obtiene
    // cuando el cliente se conecta por medio de la instrucción
    // accept() del Servidor (ServerSocket)
    Socket socket;
    
    public Client(int portNum)
     {
         try
         {
             //Se crea el socket cliente "192.168.21.103" 
             //127.0.0.1 es igual al localhost
             
             socket = new Socket ("localhost", portNum);
             System.out.println ("conectado");
             
             /* Se obtiene un stream de lectura para leer tipos simples de java */
             DataInputStream buffer = new DataInputStream 
                     (socket.getInputStream());


             /**Se lee un entero y un String que nos envía el servidor, 
              escribiendo el resultado en pantalla */
             System.out.println("Recibido " + buffer.readInt());
             System.out.println ("Recibido " + buffer.readUTF());
             System.out.println ("Recibido " + buffer.readBoolean());
//             
//
//
//             
//////             /* Se obtiene un stream de lectura para leer objetos */
               ObjectInputStream bufferObjetos =
                new ObjectInputStream (socket.getInputStream());
//////
//////             /* Se lee un Datosocket que nos envía el servidor y se muestra
//////              * en pantalla */
//////
////
             POJO dato = (POJO)bufferObjetos.readObject();
             System.out.println ("Recibido " + dato.d+ "  "+dato.c);
////
////
////             //Respuesta
             DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
             salida.writeUTF("Recibidos los datos ... Cerramos la conexión");
             System.out.println("Enviado mensaje al server");
////             
             
         }
         catch (Exception e)
         {
             System.out.println("EXCEP:"+e.getMessage());      }
     }
     
     private void initSocket(int portNum) {
         
     }


}
