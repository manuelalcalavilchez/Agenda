/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;

import java.util.Objects;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Manuel
 */
public class Contacto {
    //declaro variables
static final String ER_TELEFONO="[6|9]([0|9]{8})";
static final String ER_CORREO="[_a-zA-Z0-9-]+(.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(.[a-za-Z0-9-]+)*(.[a-zA-Z]{2,4})";
private String nombre;
private String telefono;
private String correo;

    //creo setters y getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre.length()>0 && nombre!=null){
        this.nombre = nombre;
            } throw new IllegalArgumentException("ERROR: El nombre está vacio");
    }    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono.matches(ER_TELEFONO)){
            this.telefono = telefono;
            } throw new IllegalArgumentException("ERROR: El teléfono no tiene el formato correcto");
    }    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo.matches(ER_CORREO)){      
           this.correo = correo;
        } throw new IllegalArgumentException("ERROR: El mail no tiene el formato correcto");
    }
    //metodo constructor
    public Contacto(String nombre, String telefono, String correo){
        
      setNombre(nombre);
      setTelefono(telefono);
      setCorreo(correo);
        
    }

    //método getIniciales
    
    public String getIniciales(String nombre){
    String [] iniciales = nombre.split(" ");
    String letras = null;
    for (int i=0; i<iniciales.length;i++) {
        letras = letras + nombre.charAt(0);
    }
    return letras;
       }
    
    
    //método toString
    @Override
    public String toString() {
        return "Contacto " + "nombre=" + getIniciales(nombre) + ",{ telefono=" + telefono + ", correo=" + correo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Contacto)) {
			return false;
		}
		Contacto other = (Contacto) obj;
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!Objects.equals(this.nombre.toUpperCase(), other.nombre.toUpperCase()))  {
			return false;
		}
		return true;
	}


     
             
     





}






