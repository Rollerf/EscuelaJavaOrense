/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.modelo.logica;

import com.vn.appusuarios.modelo.dao.DAOUsuarios;
import com.vn.appusuarios.modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jose Clase que llama al DAO en sus metodos para realizar acciones
 * BBDD
 */
public class ServicioUsuarios {

    DAOUsuarios daoUser;
    ChivatoServicios chivato;
    private String mensajeError;

    public ServicioUsuarios() {
        daoUser = new DAOUsuarios();

    }

    void setChivatoListener(ChivatoServicios chivato) {
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

    void notificarError(String error) {

        System.out.println("Error servicioUsuario" + mensajeError);
        if (chivato != null) {
            chivato.notificarError(mensajeError);
        }
    }

    public Usuario crear(String email, String password, String nombre, String edad) throws Exception {
        Usuario nuevoUsu = validarDatos(email, password, nombre, edad);
        if (nuevoUsu != null) {

            return daoUser.crear(nuevoUsu);
        }
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
        return daoUser.eliminar(id);

    }

    public Usuario leerUno(int id) {
        return daoUser.obtenerPorId(id);
    }

    public Usuario leerUno(String email) {
        return daoUser.obtenerPorEmail(email);
    }

    public List<Usuario> leerTodos() throws SQLException {

        return daoUser.obtenerTodos();
    }
}
