/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia;


/**
 *
 * @author pc
 */
public class HilosSencillosArrays {
    
    HiloA [] listaHilos;
    
    static int contCompartido = 0;

    public HilosSencillosArrays() {
        //this.hilo = new HiloA();
        listaHilos = new HiloA[50];

    }

    class HiloA implements Runnable {

        @Override
        public void run() {
            for (long i = 0; i < 500; i++) {
                contCompartido++;
                if (i % 100000 == 0) {
                    System.out.println("Instrucción A:    " + i
                            + " - contador = " + contCompartido);
                }
            }
        }
    }

    class HiloB implements Runnable {

        @Override
        public void run() {
            // El contador principal, j, en variable local
            for (long j = 0; j < 800; j++) {
                contCompartido++;
                if (j % 100000 == 0) {
                    System.out.println("->Ins B:" + j
                            + " ,c=" + contCompartido);
                }
            }
        }
    }

    public void ejecutarHilosStartABenParalelo() {
        System.out.println("\n**** THREAD - START ****\n");

        for(int i=0; i<listaHilos.length; i++){
            new Thread(listaHilos[i]).start();
        }
        System.out.println("\n**** end - START ****\n");
    }

    public void ejecturarHilosRunABenSerie() {
        System.out.println("\n---- THREAD - RUN ----\n");
        // SIN HILOS, ejecutamos uno detrás de otro
        
        for(int i=0; i<listaHilos.length; i++){
            new Thread(listaHilos[i]).run();
        }
        
        System.out.println("\n---- end - RUN ----\n");
    }

}
