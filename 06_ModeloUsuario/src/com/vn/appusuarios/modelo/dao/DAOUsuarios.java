/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.modelo.dao;

import com.vn.appusuarios.modelo.Usuario;
import static java.lang.System.out;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class DAOUsuarios implements IGenericDao<Usuario> {

    static Connection con;

    public DAOUsuarios() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (Exception ex) {
            System.out.println("No se ha cargado DerbyDB");
        }
    }

    public static boolean abrirConexion() {

        try {
            if (con != null) {
                if (con.isClosed()) {
                    con = DriverManager.getConnection("jdbc:derby://localhost:1527/UsuarioDB",
                            "root", "1234");
                }
            } else {
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/UsuarioDB",
                        "root", "1234");
            }
            return true;
        } catch (SQLException ex) {
            out.println("<p style='color:red'>Error SQL: " + "No se ha podido conectar a la base de datos" + "</p> ");
            return false;
        }
    }

    public static boolean cerrarConexion() {
        try {
            con.close();
            if (con.isClosed()) {
                return true;
            }
        } catch (SQLException ex) {
            out.println("<p style='color:red'>Error SQL: " + "No se ha cerrado conexion con la base de datos" + "</p> ");
            return false;
        }
        return false;
    }

    /**
     * Comprueba si el email esta en uso y si no lo esta crea un nuevo usuario
     *
     * @autor chema
     * @param usuarioNuevo
     * @return
     * @throws Exception
     */
    @Override
    public Usuario crear(Usuario usuarioNuevo) throws Exception {
        if (validarEmail(usuarioNuevo.getEmail())) {
            if (abrirConexion()) {//Abro conexion y compruebo que este abierta
                String sqlQuery = "INSERT INTO usuario (EMAIL, PASSWORD, NOMBRE, AGE) VALUES ('" + usuarioNuevo.getEmail() + "', '"
                        + usuarioNuevo.getPassword() + "', '" + usuarioNuevo.getNombre() + "', " + usuarioNuevo.getEdad() + ")";
                //System.out.println(sqlQuery);
                Statement sentenciaSQL = con.createStatement();
                sentenciaSQL.executeUpdate(sqlQuery);
                
            }            
            cerrarConexion();
            usuarioNuevo = obtenerPorEmail(usuarioNuevo.getEmail());
            return usuarioNuevo;
        }

        return null;
    }

    public static boolean validarEmail(String email) {
        try {
            if (abrirConexion()) {
                String sqlQuery = "SELECT EMAIL FROM usuario WHERE EMAIL = ?";
                PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
                sentenciaSQL.setString(1, email);
                ResultSet resultado = sentenciaSQL.executeQuery();
                if (resultado.next()) {
                    cerrarConexion();
                    System.out.println("Ese email esta en uso");
                    return false;
                }
                cerrarConexion();
                return true;
            }
            cerrarConexion();
            return false;
        } catch (Exception e) {
            System.out.println("Problema al crear el usuario");
            cerrarConexion();
            return true;
        }

    }

    @Override
    public Usuario obtenerPorId(int id) {
        if (abrirConexion()) {
            try {
                String sqlQuery = "SELECT ID, EMAIL, PASSWORD, NOMBRE, AGE  FROM USUARIO WHERE ID = ? ";
                // Sentencia preparada para evitar SQL injection
                PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
                sentenciaSQL.setInt(1, id);
                ResultSet resultado = sentenciaSQL.executeQuery();
                if (resultado.next()) {
                    Usuario usu = new Usuario(
                            resultado.getString(2),
                            resultado.getString(3),
                            resultado.getString(4),
                            resultado.getInt(5));
                    usu.setId(resultado.getInt(1));
                    cerrarConexion();
                    return usu;
                }

            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return null;

    }

    @Override
    public Usuario obtenerPorEmail(String email) {
        if (abrirConexion()) {
            try {
                String sqlQuery = "SELECT ID, EMAIL, PASSWORD, NOMBRE, AGE  FROM USUARIO WHERE EMAIL = ? ";
                // Sentencia preparada para evitar SQL injection
                PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
                sentenciaSQL.setString(1, email);
                ResultSet resultado = sentenciaSQL.executeQuery();
                if (resultado.next()) {
                    Usuario usu = new Usuario(
                            resultado.getString(2),
                            resultado.getString(3),
                            resultado.getString(4),
                            resultado.getInt(5));
                    usu.setId(resultado.getInt(1));
                    return usu;
                }

            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        cerrarConexion();

        return null;
    }

    public ArrayList<Usuario> obtenerTodos() throws SQLException {
        if (abrirConexion()) {
            String sqlQuery = "SELECT ID, EMAIL, PASSWORD, NOMBRE, AGE FROM usuario ";
            // Sentencia preparada para evitar SQL injection
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            ResultSet resultado = sentenciaSQL.executeQuery();
            ArrayList<Usuario> lista = new ArrayList<>();
            while (resultado.next()) {
                Usuario usu = new Usuario(
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getInt(5));
                usu.setId(resultado.getInt(1));
                lista.add(usu);
            }
            cerrarConexion();
            return lista;
        }
        return null;
    }

    @Override
    public Usuario modificar(Usuario userNuevo) throws Exception {

        if (abrirConexion()) {
            try {
                String sqlQuery = "UPDATE usuario SET email=?, password=?, nombre=?, age=? WHERE id=?";
                // Sentencia preparada para evitar SQL injection
                PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
                sentenciaSQL.setString(1, userNuevo.getEmail());
                sentenciaSQL.setString(2, userNuevo.getPassword());
                sentenciaSQL.setString(3, userNuevo.getNombre());
                sentenciaSQL.setInt(4, userNuevo.getEdad());
                sentenciaSQL.setInt(5, userNuevo.getId());
                sentenciaSQL.executeUpdate();

                cerrarConexion();

                return userNuevo;

            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                cerrarConexion();
                return null;
            }

        }

        cerrarConexion();

        return null;
    }

    @Override
    public boolean eliminar(int id) {

        if (abrirConexion()) {
            try {
                String sqlQuery = "DELETE FROM USUARIO WHERE ID = ? ";
                // Sentencia preparada para evitar SQL injection
                PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
                sentenciaSQL.setInt(1, id);
                sentenciaSQL.executeUpdate();
                cerrarConexion();
                return true;

            } catch (SQLException ex) {
                Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                cerrarConexion();
                return false;
            }

        }

        cerrarConexion();
        return false;

    }

}
