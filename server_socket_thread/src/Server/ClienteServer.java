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
import Dominio.Persona;

/**
 *
 * @author javie
 */
public class ClienteServer implements Runnable {

    private Socket socket;
    private String blackBoardObject;
    private ObjectOutputStream output;
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
            

        } catch (IOException ex) {
            Logger.getLogger(ClienteServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
