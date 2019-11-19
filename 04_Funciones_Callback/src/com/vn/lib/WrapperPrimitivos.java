/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.lib;

/**
 *
 * @author PC
 */
public class WrapperPrimitivos {
    
    public static void EjemploInteger(){
        int varPrimitiva=10;
        Integer varInteger = new Integer(10);
        System.out.println("varInteger = " + varInteger.toString());
    }
    
    public static void EjemploDouble(){
        double varPrimitiva=10;
        Object varDouble = new Double(varPrimitiva);
        System.out.println("varDouble = " + varDouble.toString());
    }
    public static void EjemploString(){
        String varStr = "Cadena string";
        Object varString = new String(varStr);
        System.out.println("varDouble = " + varStr.toString());
    }    
    
    
}
