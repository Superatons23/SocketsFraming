/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javie
 */
public class Persona  {
    String nombre;
    float estatura;
    float peso;
    float IMC;

    public Persona(String nombre, float estatura, float peso) {
        this.nombre = nombre;
        this.estatura = estatura;
        this.peso = peso;
    }

    public float getIMC() {
        return IMC;
    }

    public void setIMC(float IMC) {
        this.IMC = IMC;
    }

  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    
    
    

  

  
    
    
}
