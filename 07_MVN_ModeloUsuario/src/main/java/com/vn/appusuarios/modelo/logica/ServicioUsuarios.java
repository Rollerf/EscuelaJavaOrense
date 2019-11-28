/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.modelo.logica;

import com.vn.appusuarios.modelo.Usuario;
import com.vn.appusuarios.modelo.dao.UsuariosDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pc
 */
public class ServicioUsuarios {
    
    UsuariosDAO daoUsu;
    ChivatoServicios chivato;
    
    public ServicioUsuarios() {
        daoUsu = new UsuariosDAO();
    }

    public void setChivatoListener(ChivatoServicios chivato) {
        this.chivato = chivato;
    }

    /**
     * Método que comprueba primero si los campos son válidos de la siguiente
     * manera: Primero que ningún valor es nulo, segundo que no haya campos
     * vacíos. La edad debe ser un número y por último que el email y el nombre
     * sean correctos mediante expresiones regulares.
     *
     * @param email
     * @param password
     * @param nombre
     * @param edad Debe ser mayor de 12
     * @return El objeto Usuario ya creado o nulo si está mal
     */
    public Usuario crearUsuarioValido(String email, String password, String nombre, String edad) {
        
        if (email != null
                && password != null
                && nombre != null
                && edad != null) {
            if (email.length() >= 3
                    && nombre.length() > 1
                    && password.length() >= 4
                    && !"".equals(edad)) {
                try {
                    int iEdad = Integer.parseInt(edad);
                    if (iEdad >= 12) {
                        if (validarEmailNombre(email, nombre)) {                            
                            Usuario usuario = new Usuario(-1, email, password, nombre, iEdad);
                            return usuario;
                        } else {
                            notificarError("crearUsuarioValido: El nombre o el email no cumplen RegExp: "
                                    + nombre + ", " + password);
                        }
                    } else {
                        notificarError("crearUsuarioValido: La edad es menor de 12: "
                                + edad);
                    }
                } catch (NumberFormatException e) {
                    notificarError("crearUsuarioValido: La edad no se puede parsear a int: " + edad
                            + " error: " + e.getMessage());
                } catch (Exception e) {
                    notificarError("crearUsuarioValido: Error al crear el objeto usuario: " + e.getMessage());
                }
            } else {
                notificarError("crearUsuarioValido: Hay un campo que no cumple la longitud");
            }
        } else {
            notificarError("crearUsuarioValido: No admite NULOS");
        }
        return null;
    }

    void notificarError(String mensajeError) {
        
        System.out.println("Error ServicioUsuario:  " + mensajeError);
        if (chivato != null) {
            chivato.notificarError(mensajeError);
        }
    }

    boolean validarEmailNombre(String email, String nombre) {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            regex = "^[A-Z][a-z]+ ?[A-Za-z]*$";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(nombre);
            
            if (matcher.find()) {
                return true;
            } else {
                notificarError("El nombre no cumple Expr Reg. ");
            }
        } else {
            notificarError("El email no cumple Expr Reg. ");
        }
        return false;
    }
    
    public Usuario crear(String email, String password, String nombre, String edad) {
        Usuario nuevoUsu = crearUsuarioValido(email, password, nombre, edad);
        if (nuevoUsu != null) {
            try {
                nuevoUsu = daoUsu.crear(nuevoUsu);
            } catch (ClassNotFoundException ex) {
                notificarError("crear: No se ha encontrado el driver: " + ex.getMessage());
            } catch (SQLException ex) {
                notificarError("crear: Error en bb.dd.: " + ex.getMessage());
            } catch (Exception ex) {
                Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                notificarError(ex.getMessage());
            }
            return nuevoUsu;
        }
        return null;
    }
    
    public Usuario leerUno(int id) {
        try {
            return daoUsu.obtenerPorId(id);
        } catch (Exception ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("Leer uno: " + ex.getMessage());
        }
        return null;
    }
    
    public Usuario leerUno(String email) {
        try {
            return daoUsu.obtenerPorEmail(email);
        } catch (Exception ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("Leer uno: " + ex.getMessage());
        } 
        return null;
    }
    
    public Usuario modificar(int id, String email, String password, String nombre, String edad) {
        
        Usuario usuModif = crearUsuarioValido(email, password, nombre, edad);
        if (usuModif != null) {
            usuModif.setId(id);
            try {
                daoUsu.modificar(usuModif);
            } catch (Exception ex) {
                Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                notificarError("modificar: " + ex.getMessage());
            }
            return usuModif;
        }
        return null;
    }
    
    public boolean eliminar(int id) {
        try {
            return daoUsu.eliminar(id);
        } catch (Exception ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("eliminar: " + ex.getMessage());
        }
        return false;
    }

    public ArrayList<Usuario> leerTodos() {
        try {
            return daoUsu.obtenerTodos();
        } catch (Exception ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("leerTodos: " + ex.getMessage());
        }
        return null;
    }
}
