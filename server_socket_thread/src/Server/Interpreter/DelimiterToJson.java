/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Interpreter;

import dominio.Mensaje;
import org.json.JSONObject;

/**
 *
 * @author javie
 */
public class DelimiterToJson implements Expression {

    @Override
    public String interpret(String context) {
        String[] arrSplit = context.split(",");
        for (int i = 0; i < arrSplit.length; i++) {
            System.out.println(arrSplit[i]);
        }

        Mensaje m = new Mensaje(arrSplit[0], arrSplit[1], arrSplit[2]);
        JSONObject jsonObject = new JSONObject(m);
        String json = jsonObject.toString();
        return json;
    }

}
