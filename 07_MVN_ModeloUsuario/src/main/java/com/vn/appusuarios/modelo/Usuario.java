/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.modelo;

import java.io.Serializable;

/**
 *Ahora el usuario puede ser un bean
 *
 * @author pc
 */
public class Usuario implements Serializable{
    
    private int id;
    private String email;
    private String password;
    private String nombre;
    private int edad;

    public Usuario(int id, String email, String password, String nombre, int edad) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public boolean equals(Object obj) {
        if ( super.equals(obj)) //To change body of generated methods, choose Tools | Templates.
            return true;
        else {
            if (obj == null)    
                return false;
            Usuario usu = (Usuario) obj;
            return usu.getId() == this.getId() && 
                    (usu.getEmail() == null ? this.getEmail() == null 
                    : usu.getEmail().equals(this.getEmail()));
        }
    }
    


    /**
     * Get the value of edad
     *
     * @return the value of edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Set the value of edad
     *
     * @param edad new value of edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
