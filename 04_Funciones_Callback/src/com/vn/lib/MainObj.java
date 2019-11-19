/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.lib;
import com.vn.liboperaarrays.OperarArraysObject;
import com.vn.liboperaarrays.OperarArraysObject.FunCallbackOperarArrays;
import java.io.PrintStream;

/**
 *
 * @author PC
 */
public class MainObj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Double[] array_A= new Double[]{1.0,2.0,3.0,4.0,5.0};
        Double[] array_B=new Double[]{2.0,3.0,4.0,5.0,6.0};
        Object[] arraySumaAB=OperarArraysObject.operarArrays(array_A, array_B, MainObj::suma);
        arrayEnTabla(System.out, arraySumaAB);
        
        FunCallbackOperarArrays divide = (Object x, Object y) -> { return (Double)x/(Double)y;};
        
        Object[] arrayDivAB=OperarArraysObject.operarArrays(array_A, array_B, divide);
        arrayEnTabla(System.out, arrayDivAB);
        
        Object[] arrayRestaAB=OperarArraysObject.operarArrays(array_A, array_B, MainObj::resta);
        arrayEnTabla(System.out, arrayRestaAB);
        
        Object[] arrayComas=OperarArraysObject.operarArrays(array_A, array_B, MainObj::hacerPunto);
        arrayEnTabla(System.out, arrayComas);
        
    }
    public static Object hacerPunto(Object x, Object y){
        return x+","+y;
    }
    
    public static Object suma(Object x, Object y){
        return (Double)x+(Double)y;
    }
    
    public static Object resta(Object x, Object y){
        return (Double)x-(Double)y;
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
