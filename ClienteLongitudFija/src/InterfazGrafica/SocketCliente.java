package InterfazGrafica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import InterfazGrafica.FrmMain;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author javier.barreras
 */
public class SocketCliente extends Thread {

    /**
     * @param args the command line arguments
     */
    Socket kkSocket = null;
    ObjectOutputStream out = null;
    ObjectInputStream in = null;
    boolean isListening = true;

    FrmMain frame;

    public SocketCliente(FrmMain frame) {
        this.frame = frame;
    }

    @Override
    public void run() {

        try {
            System.out.println("conectando con servidor");
            kkSocket = new Socket("localhost", 4444);
            out = new ObjectOutputStream(kkSocket.getOutputStream());
            in = new ObjectInputStream(kkSocket.getInputStream());

            String fromServer;
            String fromUser;

            while (isListening) {
                fromServer = (String) in.readObject();
                System.out.println("Server: " + fromServer);

                invokeToGUI(fromServer);
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

                frame.procesInput(cadena);
            }
        });
    }

    public synchronized void sendRemote(String cadena) {

        System.out.println("cliente send to server:" + cadena);

        try {

            this.out.writeUnshared(cadena);
            
            // writeUnshared() is like writeObject(), but always writes
            // a new copy of the object. The flush (optional) forces the
            // bytes out right now.
        } catch (IOException ex) {
            // Cute use of iterator and exceptions --
            // drop that socket from list if have probs with it

        }

    }

}
