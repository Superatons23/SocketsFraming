/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;


import java.util.ArrayList;
import java.util.List;
import dominio.Mensaje;
import Server.Interpreter.CadenaExpression;
import Server.Interpreter.DelimiterToCadena;
import Server.Interpreter.DelimiterToJson;
import Server.Interpreter.Expression;
import Server.Interpreter.JSONExpression;
import Server.Interpreter.JSONtoFijaExpression;

/**
 *
 * @author javie
 */
public class Protocol {

    /**
     *
     * @param persona
     */
    Expression expression;
public Protocol(){


}
  
  

    public String processInput(String cadena,String to,String from) {
       
        if(to.equals("Longitud Fija")&&from.equals("delimiter"))
        { System.out.println("convirtiendo delimiter to Longitud fisica");
             expression = new DelimiterToCadena();
            return expression.interpret(cadena);
        }else if(to.equals("JSON")&&from.equals("delimiter")){
             System.out.println("convirtiendo delimiter to JSON");
            expression = new DelimiterToJson();
            return expression.interpret(cadena);
        }else if (to.equals("Longitud Fija")&&from.equals("JSON")){
            System.out.println("convirtiendo JSON to Longitud fija");
             expression = new  JSONtoFijaExpression();
             return expression.interpret(cadena);
        }else if(to.equals("JSON")&&from.equals("Longitud Fija")){
             System.out.println("convirtiendo Longitud fija  to JSON ");
                 expression = new  CadenaExpression();
             return expression.interpret(cadena);
            
        }
        //el mensaje es de json  y selo kiere enviar a cadena
        //return jsontocade.interprete(cadena)
         
         
        return  null;
    
}
}