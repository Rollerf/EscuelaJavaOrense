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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println(Long.MAX_VALUE);
        System.out.println( (float) Long.MAX_VALUE);
        System.out.println( (double) Long.MAX_VALUE);
        /*
        HilosSencillos hs = new HilosSencillos();
        
        long timeIni = System.currentTimeMillis();
        hs.ejecturarHilosRunABenSerie();
        String m1 = mostrarTiempo(timeIni, "Run en Serie Ha tardado: ");
        
        timeIni = System.currentTimeMillis();
        hs.ejecutarHilosStartABenParalelo();
        String m2 = mostrarTiempo(timeIni, "Start en Paralelo Ha tardado: ");
        System.out.println(m1);
        System.out.println(m2);
*/
        
        HilosSencillosArrays hs = new HilosSencillosArrays();
        
        long timeIni = System.currentTimeMillis();
        hs.ejecturarHilosRunABenSerie();
        String m1 = mostrarTiempo(timeIni, "Run en Serie Ha tardado: ");
        
        timeIni = System.currentTimeMillis();
        hs.ejecutarHilosStartABenParalelo();
        String m2 = mostrarTiempo(timeIni, "Start en Paralelo Ha tardado: ");
        System.out.println(m1);
        System.out.println(m2);
    }
    
    static String mostrarTiempo(long timeInicial, String mensaje) {
        double tiempoTotal = (double)( System.currentTimeMillis() - timeInicial) / 1000.0;
        String mensajeRet = mensaje + tiempoTotal;
        System.out.println( mensajeRet );
        return mensajeRet;
    }
}
