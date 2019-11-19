/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.liboperaarrays;

/**
 *
 * @author PC
 */
public class OperarArrays {

    //Equivale a decir que estructura tendran las funciones callback
    @FunctionalInterface
    public interface FunCallbackOperarArrays {

        //Solo podemos declarar (que luego implementar) un metodo
        double operar(double x, double y);

    }

    public static double[] operarArrays(
            double[] arrX,
            double[] arrY,
            FunCallbackOperarArrays operaCllbk) 
    {
        
        double[] arrayResult = null;
        if (arrX.length == arrY.length) {
            arrayResult = new double[arrX.length];
            for (int i = 0; i < arrX.length; i++) {
                arrayResult[i] = operaCllbk.operar(arrX[i], arrY[i]);
            }
            
        }
        return arrayResult;
    }
    }
        
    
