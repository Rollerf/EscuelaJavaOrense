package com.vn.concurrencia.sincronia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * El sistema de bloque lo tiene que gestionar el recurso compartido.
 *
 * @author PC
 */
public class Contenedor {

    // Normalmente será un array, lista, bb.dd., 
    // mapa, fichero, DAO, servicio web, cualquier recurso compartido...
    int dato;
    //Semaforo: false no se peude usar el recurso
    //          true si se puede usar
    boolean hayDato = false;
    //synchronized preapara el metodo para el bloqueo
    public synchronized int get() {

        //System.out.println("Antes del GET: " + hayDato);
        while (!hayDato) {
            //System.out.println("GET: Esperando, hayDato = " + hayDato);    //Esperamos a que se produzca algun dato
            try {
                this.wait();    //Le decimos al hilo que espere hasta que el productor
                                //produzca el dato
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        hayDato = false;    //Marcamos para bloquear el recurso antes de devolver

        //System.out.println("Despues del GET: " + hayDato);
        this.notifyAll();   //Indicar al hilo que avise a los otros hilos
                            //De que el recurso ha sido consumido
        return dato;        //Devolver el dato

    }

    public synchronized void put(int valor) {
        //System.out.println("Antes del PUT: " + hayDato);
        

        while (hayDato) {
            //System.out.println("PUT: Esperando, hayDato = " + hayDato);
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dato = valor;       //Almacenar el dato
        //Esperar a que alguien consuma el dato
        //Mientras hay dato, nadie lo ha consumido

        hayDato = true;     //Marcamos para des-bloquear/liberar el recurso
        this.notifyAll();   //Indicar al hilo que avise a los otros hilos
        //System.out.println("Despues del PUT: " + hayDato);
    }
}
