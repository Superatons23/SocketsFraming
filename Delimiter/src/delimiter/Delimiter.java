/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delimiter;

import Vistas.JFrameDelimite;

/**
 *
 * @author javie
 */
public class Delimiter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrameDelimite i = new JFrameDelimite();
        i.startThread();
        i.setVisible(true);
        i.agregarObserver();
        try {
            Thread.sleep(1000);
            i.registrarNombre();

        } catch (InterruptedException e) {
        }
    }

}
