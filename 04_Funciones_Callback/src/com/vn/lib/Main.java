/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.lib;
import com.vn.liboperaarrays.OperarArrays;
import com.vn.liboperaarrays.OperarArraysObject.*;
import java.io.PrintStream;

/**
 *
 * @author PC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double[] array_A={1,2,3,4,5};
        double[] array_B={2,3,4,5,6};
        double[] arraySumaAB=OperarArrays.operarArrays(array_A, array_B, Main::suma);
        arrayEnTabla(System.out, arraySumaAB);
        
        FunCallbackOperarArrays divide = (double x, double y) -> { return x/y;};
        
        double[] arrayDivAB=OperarArrays.operarArrays(array_A, array_B, divide);
        arrayEnTabla(System.out, arrayDivAB);
        
        double[] arrayRestaAB=OperarArrays.operarArrays(array_A, array_B, Main::resta);
        arrayEnTabla(System.out, arrayRestaAB);
        
        String[] arrayComas=OperarArrays.operarArrays(array_A, array_B, Main::comas);
        arrayEnTabla(System.out, arrayComas);
        
    }
    public static String comas(String x, String y){
        return x+","+y;
    }
    
    public static double suma(double x, double y){
        return x+y;
    }
    
    public static double resta(double x, double y){
        return x-y;
    }
    
    
    public static void arrayEnTabla(PrintStream salida, Object[] array){
        String tabla = "<table border=2><tr>";
        for(int index = 0; index<array.length; index++){
            final Object element = array[index];
            tabla += "<td>&nbsp; " + element + " &nbsp;</td>\n";
        }
        salida.println(tabla + "</tr></table>");
    }
    
}
