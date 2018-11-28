/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;
/**
 *
 * @author Manuel
 */
public class Agenda {
    //declaracion de variables
    static final int MAX_CONTACTOS=5;
    private static Contacto[] numContactos=new Contacto[MAX_CONTACTOS];
    
    //crear constructor
    
    public Agenda ()
    {        
    }

   //metodo getContactos
    public Contacto getContactos(){
    int i=0;
    for(i=0;i<numContactos.length;i++)
             System.out.println(numContactos[i]);
    
    return numContactos[i];
    }
    //metodo añadir contacto
     public static void anadir(String nombre, String telefono, String correo) //throws OperationNotSupportedException
    {
        int i;
                
        System.out.println("Nuevo contacto");
        System.out.println("===============");
        
        System.out.println("Por favor, introduzca los datos del contacto.");  
        
        System.out.println("Nombre: ");
        nombre=Entrada.cadena();
        System.out.println("Teléfono: ");
        telefono=Entrada.cadena();
        System.out.println("Correo: ");
        correo=Entrada.cadena();
        //Creamos el contacto
        Contacto contacto=new Contacto(nombre, telefono,correo);
        //Buscamos donde insertar el contacto
        try
        {
            i=buscaPrimerIndiceComprobandoExistencia(contacto);
        }
        catch(OperationNotSupportedException e)
        {
            throw new OperationNotSupportedException("Ya existe un contacto con ese nombre.");
        }
        
        if (indiceNoSuperaTamano(i))
            numContactos[i]=contacto;
        else
            throw new OperationNotSupportedException("El array de contactos está lleno.");
        
    }    
     private static int buscaPrimerIndiceComprobandoExistencia(Contacto contacto) throws OperationNotSupportedException
    {
        int indiceLibre=0;
        boolean encontradoContacto=false;
        
        for(int i=0;i<numContactos.length && !encontradoContacto;i++)
        {
            if (numContactos[i]==null)
            {
                encontradoContacto=true;
                indiceLibre=i;
            }
            else if (numContactos[i].equals(contacto))
            {
                throw new OperationNotSupportedException("Ya existe un contacto con ese nombre.");
            }               
        }
        
        return indiceLibre;
    }
    
    
    private static boolean indiceNoSuperaTamano(int j)
    {
        if (j>=numContactos.length)
            return true;
        else
            return false;
    }
    //

}
