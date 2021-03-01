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
import javax.swing.JOptionPane;

/**
 *
 * @author javie
 */
public class MultiServerThread extends Thread {

    private Socket socket = null;
    private String cadena;
    private ObjectOutputStream output;
    private ObjectInputStream in = null;

    public static final ArrayList<ClienteServer> clientes = new ArrayList<>();

    public MultiServerThread(Socket socket) throws IOException {
        super("m");

        this.socket = socket;
        this.output = new ObjectOutputStream(socket.getOutputStream());

    }

    @Override
    public void run() {

        try {
            String from;
            String input = null;
            Protocol kkp = new Protocol();
            boolean isListening = true;

            //recibir bbos
            this.in = new ObjectInputStream(socket.getInputStream());

            //agrega al cliente
            from = (String) in.readObject();
            System.out.println("se ha conectado " + from);
            clientes.add(new ClienteServer(this.socket, this.output, from));

            String to;
            while ((input = (String) in.readObject()) != null) {
                to = input;
                input = (String) in.readObject();
                this.cadena = kkp.processInput(input, to, from);
                transmitirAto(to);

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

    public void transmitirAto(String to) {

        for (ClienteServer sockets : clientes) {
            if (sockets.getNombre().equals(to)) {
                System.out.println("enviando data to client");
                if (sockets.getSocket().isClosed()) {
                    JOptionPane.showMessageDialog(null, "El cliente " + to + " no esta disponible actualmente");
                    System.out.println("este cliente esta cerrado");
                } else {
                    sockets.setData(this.cadena);
                    sockets.run();
                }

            }

        }

    }

}
