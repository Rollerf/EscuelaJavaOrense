/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.modelo.logica;

import com.vn.appusuarios.modelo.Usuario;
import com.vn.appusuarios.modelo.dao.DAOUsuariosMySQL;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jose Clase que llama al DAO en sus metodos para realizar acciones
 * BBDD
 */
public class ServicioUsuarios implements ChivatoServicios {

    DAOUsuariosMySQL daoUser;
    ChivatoServicios chivato;
    private String mensajeError;

    public ServicioUsuarios() {
        try {
            daoUser = new DAOUsuariosMySQL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("Crear DAOUsuarios: " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("Abrir Conexion: " + ex.getMessage());
        }catch (Exception ex) {
        	
        }

    }

    public void setChivatoListener(ChivatoServicios chivato) {
        this.chivato = chivato;
    }

    public Usuario validarDatos(String email, String password, String nombre, String edad) {
        if (email != null && password != null && nombre != null && edad != null) {
            if (email.length() >= 3 && nombre.length() > 1 && password.length() >= 4 && !"".equals(edad)) {
                // Patrón para validar el email
                Pattern pattern = Pattern
                        .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

                // El email a validar
                Matcher mather = pattern.matcher(email);

                if (mather.find() == true) {
                    try {
                        int iEdad = Integer.parseInt(edad);
                        if (iEdad > 12) {
                            Usuario usuario = new Usuario(email, password, nombre, iEdad);
                            return usuario;
                        } else {
                            notificarError("Edad menor a 12 Conexion: ");
                            return null;
                        }
                    } catch (NumberFormatException e) {
                        notificarError("La edad no se puede parsear a int: " + edad);
                        return null;
                    }
                } else {
                    notificarError("El email ingresado es inválido.");
                }

            } else {
                notificarError("Hay un campo que no cumple la longitud");
                return null;
            }
        } else {
            notificarError("No admite NULOS");
            return null;
        }
        return null;
    }

    @Override
    public void notificarError(String error) {

        System.out.println("Error servicioUsuario: " + mensajeError);
        if (chivato != null) {
            chivato.notificarError(mensajeError);
        }
    }

    public Usuario crear(String email, String password, String nombre, String edad) throws Exception {
        Usuario nuevoUsu = validarDatos(email, password, nombre, edad);
        if (daoUser.validarEmail(email)) {
            if (nuevoUsu != null) {

                return daoUser.crear(nuevoUsu);
            }
        }
        notificarError("Crear: " + "No se ha podido crear el usuario, email probablemente en uso");
        return null;

    }

    public Usuario modificar(int Id, String email, String password, String nombre, String edad) throws Exception {
        Usuario user = validarDatos(email, password, nombre, edad);
        user.setId(Id);
        return daoUser.modificar(user);
    }

    public Usuario modificar(Usuario usuDatosNuevos) throws Exception {
        return daoUser.modificar(usuDatosNuevos);

    }

    public boolean eliminar(int id) {
        try {
            return daoUser.eliminar(id);
        } catch (SQLException ex) {
            notificarError("Eliminar: " + ex.getMessage());
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Usuario leerUno(int id) {
        try {
            return daoUser.obtenerPorId(id);
        } catch (SQLException ex) {
            notificarError("Leer uno por id: " + ex.getMessage());
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Usuario leerUno(String email) {
        try {
            return daoUser.obtenerPorEmail(email);
        } catch (SQLException ex) {
            notificarError("Leer uno por email: " + ex.getMessage());
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Usuario> leerTodos() {

        try {
            return daoUser.obtenerTodos();
        } catch (SQLException ex) {
            notificarError("Leer todos: " + ex.getMessage());
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
