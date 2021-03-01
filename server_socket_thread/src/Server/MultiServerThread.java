/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author javie
 */
public class MultiServerThread extends Thread {

    private Socket socket = null;
    private String cadena;
    private ObjectOutputStream output;
    private  ObjectInputStream in=null;

    
    public static final ArrayList<ClienteServer> clientes = new ArrayList<>();

    public MultiServerThread(Socket socket) throws IOException {
        super("patolliServer");
        System.out.println("se ha conectado un cliente");
        this.socket = socket;
        this.output= new ObjectOutputStream(socket.getOutputStream());
      
  
    }

    @Override
    public void run() {
        
        
        try {

          
            String input = null;
            Protocol kkp = new Protocol();
           boolean isListening=true;
           
                
               
                   //recibir bbos
             this.in = new ObjectInputStream(socket.getInputStream());
             
              //agrega al cliente
              
              input = (String) in.readObject(); 
              clientes.add(new ClienteServer(this.socket, this.output,input));
           
             
                while (( input = (String) in.readObject())!=null) {
                   
                System.out.println("reciviendo data from cliente");
                this.cadena = kkp.processInput(input);
               
                transmitirATodos();
                
              
            }
                System.out.println("se ha ido un cliente");
                this.output.close();
                 this.in.close();
                this.socket.close();
               
                
                
            
          

         
              
              
        } catch (SocketException | ClassNotFoundException ex) {
            Logger.getLogger(MultiServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MultiServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void transmitirATodos() {
       
        for (ClienteServer sockets : clientes) 
        {
              System.out.println("enviando data to client");
            sockets.setClienteBBO(this.cadena);
            sockets.run();

        }
         
    }

  
    
    
  
    
    
    

}
