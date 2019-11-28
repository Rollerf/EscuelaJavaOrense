package com.vn.appusuarios.modelo.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.vn.appusuarios.modelo.logica.ServicioUsuarios;
import com.vn.appusuarios.modelo.Usuario;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestServicioUsuarios {
    
    private ServicioUsuarios srvUsu;
    
    public TestServicioUsuarios() {
        srvUsu = new ServicioUsuarios();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void crearUsuariosInvalidos() {
        Usuario u1 = srvUsu.crear(null, "", null, "");
        Usuario u2 = srvUsu.crear("", "a1", "Nom", "");
        Usuario u3 = srvUsu.crear("b@a.a", "a1", "", "");
        Usuario u4 = srvUsu.crear("b@a.a", "1234", "Nom 2", "SIN EDAD");
        Usuario u5 = srvUsu.crear("b@a.a", "1234", "Nom 2", "10");
        assertNull(u1);
        assertNull(u2);
        assertNull(u3);
        assertNull(u4);
        assertNull(u5);
        assertNull(srvUsu.leerUno("b@a.a"));
    }
    @Test
    public void crearUsuariosValidos() {
        Usuario u1 = srvUsu.crear("arrr@a.a", "1234", "Nom A", "20");
        Usuario u2 = srvUsu.crear("a@a.a2", "1234", "Nom B", "30");
        Usuario u3 = srvUsu.crear("a@ee.a2", "e1234", "Nom C", "40");
        
        assertTrue(srvUsu.leerUno("arrr@a.a").getId() > 0);
        assertEquals("Nom B", srvUsu.leerUno("a@a.a2").getNombre());
        assertEquals("Nom C", srvUsu.leerUno("a@ee.a2").getNombre());
        
        srvUsu.eliminar(u1.getId());
        srvUsu.eliminar(u2.getId());
        srvUsu.eliminar(u3.getId());
    }
    @Test
    public void modificacionesInvalidasDeUsuarios() {
        Usuario u1 = srvUsu.crear("a@a.aaa", "1234", "Nom A", "20");
        Usuario u2 = srvUsu.crear("a@a.a2", "1234", "Nom B", "30");
        
        srvUsu.modificar(u1.getId(), "@dfdf", u1.getPassword(), u1.getNombre(), "25");
        assertEquals(20, srvUsu.leerUno("a@a.aaa").getEdad());
        
        srvUsu.modificar(u2.getId(), "psdee.dd", u2.getPassword(), u2.getNombre(), "30");
        assertEquals("a@a.a2", srvUsu.leerUno(u2.getId()).getEmail());
        srvUsu.eliminar(u1.getId());
        srvUsu.eliminar(u2.getId());
   }
    @Test
    public void modificarUsuariosValidos() {
        Usuario u1 = srvUsu.crear("arrr@a.a", "1234", "Nom A", "20");
        Usuario u2 = srvUsu.crear("a@a.a2", "1234", "Nom B", "30");
        Usuario u3 = srvUsu.crear("a@ee.a2", "e1234", "Nom C", "40");
        
        srvUsu.modificar(u1.getId(), u1.getEmail(), u1.getPassword(), u1.getNombre(), "25");
        assertEquals(25, srvUsu.leerUno("arrr@a.a").getEdad());
        srvUsu.modificar(u2.getId(), "psd@dd.ee", u2.getPassword(), u2.getNombre(), "30");
        assertEquals(u2.getId(), srvUsu.leerUno("psd@dd.ee").getId());
        
        srvUsu.modificar(u3.getId(), "a@ee.a2", "666uu", "Otro nombre", "40");
        assertEquals("666uu", srvUsu.leerUno(u3.getId()).getPassword());
        assertEquals("Otro nombre", srvUsu.leerUno("a@ee.a2").getNombre());
        
        srvUsu.eliminar(u1.getId());
        srvUsu.eliminar(u2.getId());
        srvUsu.eliminar(u3.getId());
    }
    @Test
    public void eliminarUsuarios() {
        Usuario u1 = srvUsu.crear("a@a.a3", "1234", "Nom A", "20");
        Usuario u2 = srvUsu.crear("a@a.a2", "1234", "Nom B", "30");
        Usuario u3 = srvUsu.crear("a@ee.a2", "e1234", "Nom C", "40");
        
        boolean b1 = srvUsu.eliminar(u1.getId());        
        boolean b2 = srvUsu.eliminar(u2.getId());        
        boolean b3 = srvUsu.eliminar(u3.getId());
        
        assertNull(srvUsu.leerUno("a@a.a3"));
        assertNull(srvUsu.leerUno(u2.getId()));
        assertNull(srvUsu.leerUno("a@ee.a2"));
        assertTrue(b1 && b2 && b3); //, "Alguno eliminarUsuarios ha fallado");
    }
    
    @Test 
    public void listarTodos() {
        ArrayList<Usuario> listaCreados = new ArrayList<>();
        
        listaCreados.add(srvUsu.crear("a@a.ab", "1234", "Nom A", "20"));
        listaCreados.add(srvUsu.crear("a@a.a2", "1234", "Nom B", "30"));
        listaCreados.add(srvUsu.crear("a@ee.a2", "e1234", "Nom C", "40"));
        
        ArrayList<Usuario> listaTotal = srvUsu.leerTodos();
        
        for (Usuario usuario1 : listaCreados) {            
            if (usuario1 != null && listaTotal.contains(usuario1)) {
                srvUsu.eliminar(usuario1.getId());            
            } else {
                fail("No se ha añadido o no se ha encontrado en listaTotal");
            }
        }
    }
}
