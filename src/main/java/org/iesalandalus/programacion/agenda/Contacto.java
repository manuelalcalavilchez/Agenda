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
private String nombre;
private String telefono;
private String correo;
final static String ER_TELEFONO="^[6|9]([0|9]{8})$";
final static String ER_CORREO="^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@" + "[a-zA-Z0-9-]+(\\.[a-za-Z0-9-]+)*(\\.[a-zA-Z]{2,4})$";
    //creo setters y getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(!nombre.equals(null) || !nombre.equals("")){
        this.nombre = nombre;
            } throw new IllegalArgumentException("ERROR: El nombre está vacio");
    }    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        Pattern p=Pattern.compile(ER_TELEFONO);
        Matcher m=p.matcher(telefono);
          if (m.find()){
            this.telefono = telefono;
            } throw new IllegalArgumentException("ERROR: El teléfono no tiene el formato correcto");
    }    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        Pattern p = Pattern.compile(ER_CORREO);
        Matcher m = p.matcher(correo);
        if (m.find()){
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
    
    public String getIniciales(StringTokenizer iniciales){
    iniciales = new StringTokenizer(nombre); 
    while(iniciales.hasMoreTokens()) {
        System.out.println((iniciales.nextToken().charAt(0)));
    }
    return (iniciales.nextToken().charAt(0));
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
		} else if (!nombre.equalsIgnoreCase(other.nombre)) {
			return false;
		}
		return true;
	}


     
             
     





}






