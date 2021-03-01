package socketcliente;


/**
 *
 * @author javier.barreras
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author javier.barreras
 */
public class SocketCliente extends java.util.Observable implements Runnable {

    /**
     * @param args the command line arguments
     */
    Socket kkSocket = null;
    ObjectOutputStream out = null;
    ObjectInputStream in = null;
    boolean isListening = true;
    String adress;
    int port;

    JFrame frame;

    public SocketCliente(JFrame frame, String adress, int port) {
        this.frame = frame;
        this.port = port;
        this.adress = adress;
       
    }

    @Override
    public void run() {

        try {
            System.out.println("conectando con servidor");
            kkSocket = new Socket(this.adress, this.port);
            out = new ObjectOutputStream(kkSocket.getOutputStream());
            in = new ObjectInputStream(kkSocket.getInputStream());

            String fromServer;
            String fromUser;

            while (isListening) {
                fromServer = (String) in.readObject();
                System.out.println("Server: " + fromServer);
                this.setChanged();
                this.notifyObservers(fromServer);
                this.clearChanged();
                
                // invokeToGUI(fromServer);
            }
            System.out.println("cerrando conexion ");
            out.close();
            in.close();
            kkSocket.close();

        } catch (IOException | ClassNotFoundException ex) {

            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cerrarConexion() throws IOException {

        out.close();
        in.close();
        kkSocket.close();
    }

    public void invokeToGUI(String cadena) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                //  frame.procesInput(cadena);
            }
        });
    }
    
    public void agregarObserver(Observer observer)
    {
         this.addObserver(observer);
    }

    public synchronized void sendRemote(String cadena) {

        try {
            System.out.println("cliente send to server:" + cadena);

            this.out.writeUnshared(cadena); // Cute use of iterator and exceptions --
            // drop that socket from list if have probs with it
            this.out.flush();
            // writeUnshared() is like writeObject(), but always writes
            // a new copy of the object. The flush (optional) forces the
            // bytes out right now.
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }
    
    

}
