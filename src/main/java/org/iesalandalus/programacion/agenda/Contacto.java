/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Manuel
 */
public class Contacto {
    
private String nombre;
private String telefono;
private String correo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre !=null || nombre==""){
        this.nombre = nombre;
            } throw new IllegalArgumentException("ERROR: El nombre etá vacio");
    }    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        Pattern p=Pattern.compile("^[6|9]([0|9]{8})$");
        Matcher m=p.matcher(telefono);
          if (m.find()){
            this.telefono = telefono;
            } throw new IllegalArgumentException("ERROR: El teléfono no tiene el formato correcto");
    }    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        Pattern p = Pattern.compile("^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@" + "[a-zA-Z0-9-]+(\\.[a-za-Z0-9-]+)*(\\.[a-zA-Z]{2,4})$");
        Matcher m = p.matcher(correo);
        if (m.find()){
        this.correo = correo;
            } throw new IllegalArgumentException("ERROR: El mail no tiene el formato correcto");
    }
    public Contacto(String nombre, String telefono, String correo){
        
      setNombre(nombre);
      setTelefono(telefono);
      setCorreo(correo);
        
    }







}






