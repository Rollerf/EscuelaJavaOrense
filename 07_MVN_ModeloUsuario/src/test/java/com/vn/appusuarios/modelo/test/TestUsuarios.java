/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.modelo.test;

import com.vn.appusuarios.modelo.logica.ServicioUsuarios;
import com.vn.appusuarios.modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jose Test de usuarios, crear usuario inválido al pasar datos en orden
 * incorrecto, no puede insertarlo en BBDD y crear usuario valido insertando de
 * manera correcta los parámetros que lo crea en BBDD
 */
public class TestUsuarios {

    private ServicioUsuarios servUser;

    public TestUsuarios() {
        servUser = new ServicioUsuarios();
    }

    @Test
    public void crearUsuariosInvalidos() throws Exception {
        Usuario user1 = servUser.crear("", "", null, "90");
        Usuario user2 = servUser.crear("a@a.c", "", "a", "");
        Usuario user3 = servUser.crear("rrrr@rrrr.c", "pas", "", "90");
        Usuario user4 = servUser.crear("ttt@ttt.c", "hola", "pepe", "10");
        Usuario user5 = servUser.crear(null, null, null, null);

        assertNull(user1);
        assertNull(user2);
        assertNull(user3);
        assertNull(user4);
        assertNull(user5);

    }

    @Test
    public void crearUsuariosValidos() throws Exception {

        servUser.crear("aaaa@aaaa.com", "password", "Luis", "20");
        servUser.crear("dddd@dddd.com", "password", "Pepe", "30");
        servUser.crear("bbbb@bbbb.com", "password", "Juan", "25");
        servUser.crear("cccc@cccc.com", "password", "Ana", "40");
        servUser.crear("eeee@eee.com", "password", "Paco", "33");

        assertEquals("Luis", servUser.leerUno("aaaa@aaaa.com").getNombre());
        assertEquals(30, servUser.leerUno("dddd@dddd.com").getEdad());
        assertTrue(servUser.leerUno("bbbb@bbbb.com").getId() > 0);
        assertEquals("Ana", servUser.leerUno("cccc@cccc.com").getNombre());
        assertTrue(servUser.leerUno("eeee@eee.com").getNombre().equals("Paco"));

    }

    @Test
    public void modificarUsuarios() throws Exception {

        servUser.modificar(120, "zzzz@zzzz.com", "password", "nombre", "45");
    }

    @Test
    public void eliminarUsuarios() {

        servUser.eliminar(servUser.leerUno("aaaa@aaaa.com").getId());
        servUser.eliminar(servUser.leerUno("dddd@dddd.com").getId());
        servUser.eliminar(servUser.leerUno("bbbb@bbbb.com").getId());
        servUser.eliminar(servUser.leerUno("cccc@cccc.com").getId());
        servUser.eliminar(servUser.leerUno("eeee@eee.com").getId());

    }

    @Test
    public void obtenerListaUsuario() throws SQLException, Exception {
        ArrayList<Usuario> lista = (ArrayList<Usuario>) servUser.leerTodos();

        lista.add(servUser.crear("aaaa@aaaa.com", "password", "Luis", "20"));
        lista.add(servUser.crear("aaab@aaab.com", "password", "Paco", "30"));
        lista.add(servUser.crear("aaac@aaac.com", "password", "Ana", "50"));
        
        

    }

}
