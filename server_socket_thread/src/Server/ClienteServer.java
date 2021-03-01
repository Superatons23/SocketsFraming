/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javie
 */
public class ClienteServer implements Runnable {

    private final Socket socket;
    private String blackBoardObject;
    private final ObjectOutputStream output;
    private String nombre;

    public ClienteServer(Socket socket, ObjectOutputStream output,String nombre) {
        this.output = output;
        this.socket = socket;
        this.nombre=nombre;
    }

    public String getClienteBBO() {
        return blackBoardObject;
    }

    public void setClienteBBO(String persona) {
        this.blackBoardObject = persona;
    }

    @Override
    public void run() {

        try {
          
          
        
           this.output.writeObject(getClienteBBO());
           this.output.flush();
            

        } catch (IOException ex) {
            Logger.getLogger(ClienteServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
