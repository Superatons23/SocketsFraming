/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Interpreter;

/**
 *
 * @author javie
 */
public class DelimiterToCadena implements Expression{

    @Override
    public String interpret(String context) {
        System.out.println("convirtiendo data delimiter to cadena");
        System.out.println(context);
        return context;
    }
    
}
