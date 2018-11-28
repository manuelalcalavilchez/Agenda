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
     public static void anadir(String nombre, String telefono, String correo) throws OperationNotSupportedException
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
    //Metodo para buscar contacto por nombre
    public static void buscar() throws OperationNotSupportedException
    {
        String nombre;
        int i;
        
        System.out.println("Introduce el nombre del contacto a buscar");
        nombre=Entrada.cadena();        
        
        //Creamos el contacto con los restantes atributos inventados
        Contacto contacto=new Contacto(nombre,"950231111" ,"ies@alandaluz.org");
        
        i=buscarIndiceCliente(contacto);
        
        if (i==-1)
            throw new OperationNotSupportedException("El contacto buscado no se encuentra en la agenda");
        else
            System.out.println("El contacto se encuentra en la posición "+i);
    }
        private static int buscarIndiceCliente(Contacto contacto)
    {
        int indice=-1;
        
        for(int i=0;i<numContactos.length;i++)
        {
            if (numContactos[i]!=null && numContactos[i].equals(contacto))
                return indice=i;            
        }
        
        return indice;
    }
        //metodo para borrar contactos
         private static void borrar() throws OperationNotSupportedException
    {
        String nombre;
        int i;
                
        System.out.println("Introduce el nombre del contacto a buscar");
        nombre=Entrada.cadena();        
        
        //Creamos el contacto con los restantes atributos inventados
        Contacto contacto=new Contacto(nombre,"950231111" ,"ies@alandaluz.org");
        
        i=buscarIndiceCliente(contacto);
        
        if (i==-1)
            throw new OperationNotSupportedException("El contacto a borrar no existe.");
        else
            desplazarUnaPosicionHaciaIzquierda(i);
    }

        private static void desplazarUnaPosicionHaciaIzquierda(int indice) 
        {
            for (int i = indice; i < numContactos.length - 1 && numContactos[i] != null; i++) 
        {
            numContactos[i] = numContactos[i+1];
	}
    }
}
