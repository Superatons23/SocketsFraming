/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felimframer;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javie
 */
public class DeliFramer implements Framer{
    
    private InputStream in;
    private static final byte DELIMITER = '\n';

    @Override
    public void frameMsg(String message, ObjectOutputStream out,String to) {
       
        try {
         //   for (byte b: message){
                
          //      if(b==DELIMITER){
                    
         //      }
               
                
          //  }
             System.out.println("enviado data to server");
            out.writeObject(to);
            out.writeObject(message);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(DeliFramer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String nextMsg(String send) throws IOException {
        ByteArrayOutputStream messageBuffer = new ByteArrayOutputStream();
        int nextByte;
        
      //  while((nextByte=in.read())!=DELIMITER){
      //      if(nextByte==-1){
      //          if(messageBuffer.size()==0){
      //              return null;
      //          }else{
       //             throw new EOFException("Non-Empy message without delimiter");
      //          }
      //      }
      //      messageBuffer.write(nextByte);
      //  }
        return send;
    }

  
    
}
