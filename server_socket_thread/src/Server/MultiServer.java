/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javie
 */
public class MultiServer {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        int portNumber = 4444;
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            
            while (listening) {

                
                new MultiServerThread(serverSocket.accept()).start();
                

            }
            
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);

        }finally{
            System.out.println("hola");
        }

    }

}
