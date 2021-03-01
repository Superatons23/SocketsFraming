/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Interpreter;

import org.json.JSONArray;
import org.json.JSONObject;
import dominio.Mensaje;

/**
 *
 * @author jesus
 */
public class JSONtoFijaExpression  implements Expression
{

   @Override
    public String interpret(String context) {
     //code
     Mensaje m;
    final JSONObject obj = new JSONObject(context);
      System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
      System.out.println(obj.getString("mensaje"));
      System.out.println(obj.getString("from"));
      System.out.println(obj.getString("to"));
      System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
      m=new Mensaje(obj.getString("to"), obj.getString("from"), obj.getString("mensaje"));
      
    
         
        return m.toString();
    }


    
}
