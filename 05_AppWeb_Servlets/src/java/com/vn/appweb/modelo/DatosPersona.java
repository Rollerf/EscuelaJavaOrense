/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appweb.modelo;

/**
 *
 * @author PC
 */
public class DatosPersona {// POJO: Plain Old Java Object
    
    private String nombre;

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String email;

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    private int[] fibonacci;

    /**
     * Get the value of fibonacci
     *
     * @return the value of fibonacci
     */
    public int[] getFibonacci() {
        return fibonacci;
    }

    /**
     * Set the value of fibonacci
     *
     * @param fibonacci new value of fibonacci
     */
    public void setFibonacci(int[] fibonacci) {
        this.fibonacci = fibonacci;
    }

}
