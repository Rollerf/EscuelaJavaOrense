/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.modelo.dao;

import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface IGenericDao<T> {
    
    public abstract T crear(T  objetoNuevo)  throws Exception ;
    
    T obtenerPorId(int id)  throws Exception ;
    
    ArrayList<T> obtenerTodos()  throws Exception ;
    
    T modificar(T objConDatosNuevo) throws Exception ;
    
    boolean eliminar(int id) throws Exception ;
}
