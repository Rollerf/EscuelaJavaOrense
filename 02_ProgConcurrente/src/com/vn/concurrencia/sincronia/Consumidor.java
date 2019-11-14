package com.vn.concurrencia.sincronia;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread{

    private Contenedor contenedor;

    public Consumidor(Contenedor c) {
        contenedor = c;
    }

    public void run() {

        for (int i = 0; i < 10; i++) {
            int value = i * 10;
            //System.out.println("Antes del GET: " + value);
            value = contenedor.get();
            System.out.println("Despues del GET: " + value);
            
            try {
                Thread.sleep((int)(Math.random() * 3000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
