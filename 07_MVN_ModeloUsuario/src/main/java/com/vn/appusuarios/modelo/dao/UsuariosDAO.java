/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.modelo.dao;

import com.vn.appusuarios.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class UsuariosDAO implements IGenericDao<Usuario> {

    
    @Override
    public Usuario crear(Usuario nuevoUsu) throws Exception {
        try (Connection conex = ConexionMySqlDB.obtenerConexion()) { 
            String sqlQuery = "INSERT INTO usuario (email, password, nombre, edad) VALUES (?, ?, ?, ?)";
            PreparedStatement sentenciaSQL = conex.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, nuevoUsu.getEmail());
            sentenciaSQL.setString(2, nuevoUsu.getPassword());
            sentenciaSQL.setString(3, nuevoUsu.getNombre());
            sentenciaSQL.setInt(4, nuevoUsu.getEdad());
            sentenciaSQL.executeUpdate();

            nuevoUsu = obtenerPorEmail(nuevoUsu.getEmail());
            return nuevoUsu;
        }
    }

    @Override
    public Usuario obtenerPorId(int id) throws Exception {
        try (Connection conex = ConexionMySqlDB.obtenerConexion()) {
            String sqlQuery = "SELECT id, email, password, nombre, edad  FROM usuario WHERE id = ? ";
            // Sentencia preparada para evitar SQL injection
            PreparedStatement sentenciaSQL = conex.prepareStatement(sqlQuery);
            sentenciaSQL.setInt(1, id);
            ResultSet resultado = sentenciaSQL.executeQuery();
            if (resultado.next()) {
                Usuario usu = new Usuario(
                        resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getInt(5));
                return usu;
            }
        }
        return null;
    }

    public Usuario obtenerPorEmail(String email) throws Exception {

        try (Connection conex = ConexionMySqlDB.obtenerConexion()) {
            String sqlQuery = "SELECT id, email, password, nombre, edad  FROM usuario WHERE email = ? ";
            // Sentencia preparada para evitar SQL injection
            PreparedStatement sentenciaSQL = conex.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, email);
            ResultSet resultado = sentenciaSQL.executeQuery();
            if (resultado.next()) {
                Usuario usu = new Usuario(
                        resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getInt(5));
                return usu;
            }
        } 
        return null;
    }

    @Override
    public ArrayList<Usuario> obtenerTodos() throws Exception {
        try (Connection conex = ConexionMySqlDB.obtenerConexion()) {
            String sqlQuery = "SELECT id, email, password, nombre, edad  FROM usuario ";
            // Sentencia preparada para evitar SQL injection
            PreparedStatement sentenciaSQL = conex.prepareStatement(sqlQuery);
            ResultSet resultado = sentenciaSQL.executeQuery();
            ArrayList<Usuario> lista = new ArrayList<Usuario>();
            while (resultado.next()) {
                Usuario usu = new Usuario(
                        resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getInt(5));
                lista.add(usu);
            }
            return lista;
        }
    }

    @Override
    public Usuario modificar(Usuario usuModif) throws Exception {

        try (Connection conex = ConexionMySqlDB.obtenerConexion()) {
            String sqlQuery = "UPDATE usuario SET email=?, password=?, nombre=?, edad=? WHERE id=?";
            PreparedStatement sentenciaSQL = conex.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, usuModif.getEmail());
            sentenciaSQL.setString(2, usuModif.getPassword());
            sentenciaSQL.setString(3, usuModif.getNombre());
            sentenciaSQL.setInt(4, usuModif.getEdad());
            sentenciaSQL.setInt(5, usuModif.getId());
            sentenciaSQL.executeUpdate();
        } 
        return null;
    }

    @Override
    public boolean eliminar(int id) throws Exception {
        try (Connection conex = ConexionMySqlDB.obtenerConexion()) {
            String sqlQuery = "DELETE FROM usuario WHERE id=?";
            PreparedStatement sentenciaSQL = conex.prepareStatement(sqlQuery);
            sentenciaSQL.setInt(1, id);
            sentenciaSQL.executeUpdate();
            return true;
        }
    }
//TODO: implements IGenericDao<Usuario> 

}
