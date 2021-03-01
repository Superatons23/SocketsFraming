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
      
        
        if(to.equals("CADENA")&&from.equals("delimiter"))
        {
             expression = new DelimiterToCadena();
            return expression.interpret(cadena);
        }else if(to.equals("JSON")&&from.equals("delimiter")){
            expression = new DelimiterToJson();
            return expression.interpret(cadena);
        }else if (to.equals("fijo")&&from.equals("JSON")){
             expression = new  JSONtoFijaExpression();
             return expression.interpret(cadena);
        }
        //el mensaje es de json  y selo kiere enviar a cadena
        //return jsontocade.interprete(cadena)
         
         
        return  null;
    
}
}