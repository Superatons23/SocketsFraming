/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientelongitudfija;

import InterfazGrafica.FrmMain;
import InterfazGrafica.FrmMain;

/**
 *
 * @author javie
 */
public class ClienteLongitudFija {

    /**
     * @param args the command line argumentsW
     */
    public static void main(String[] args) {
   FrmMain i = new FrmMain();
   i.startThread();
    i.setVisible(true);
   try
        {
            Thread.sleep(1000);
            i.registrarNombre();
        }catch(InterruptedException e){}
    
     
     
    }
    
}
