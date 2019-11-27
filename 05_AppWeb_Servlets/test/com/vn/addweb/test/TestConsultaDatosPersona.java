/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.addweb.test;

import com.vn.appweb.modelo.ConsultaSQL;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class TestConsultaDatosPersona {
    
    public TestConsultaDatosPersona() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testSelectSQL() {
        ConsultaSQL conSQL = new ConsultaSQL();
        //Se asegura que el tamanho del array que devuelve el metodo es 0 al ser la consulta incorrecta
        assertEquals(0, conSQL.leerTabla("Nomb****eba").size());
        
        assertEquals("Nombre de Prueba", conSQL.leerTabla("Nombre de Prueba").get(0).getNombre());
        
        assertEquals("rock.gs@gfas.com", conSQL.leerTabla("add").get(0).getEmail());
        
        assertEquals(1, conSQL.leerTabla("adf").size());
    }
}
