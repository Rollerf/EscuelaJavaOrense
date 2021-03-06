/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.modelo;

/**
 *
 * @author Jose Clase Usuario
 */
public class Usuario {

    private String nombre, email, password;
    private int edad, id;

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) //To change body of generated methods, choose Tools | Templates.
        return true;
        else{
            if(obj==null) return false;
            Usuario usu = (Usuario) obj;
            return usu.getId() == this.getId() && 
                    (usu.getEmail() == null ? this.getEmail()==null:
                    usu.getEmail().equals(this.getEmail()));
                }
    }

    public Usuario() {}

    public Usuario(String email, String password, String nombre, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
