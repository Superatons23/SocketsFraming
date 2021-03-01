/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Interpreter;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author javie
 */
public class JSONExpression  implements Expression
{

   @Override
    public String interpret(String context) {
     //code
    final JSONObject obj = new JSONObject(context);
    final JSONArray geodata = obj.getJSONArray("Mensaje");
    final int n = geodata.length();
    for (int i = 0; i < n; ++i) {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
      final JSONObject person = geodata.getJSONObject(i);
      System.out.println(person.getString("mensaje"));
      System.out.println(person.getString("from"));
      System.out.println(person.getString("to"));
      
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
         
        return "probando";
    }


    
}
