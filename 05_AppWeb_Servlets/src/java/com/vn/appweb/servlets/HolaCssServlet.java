/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class HolaCssServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest peticionHttp,
            HttpServletResponse respuestaHttp) throws IOException {
        //definiamos el tiempo de contenido segun los tipos mime
        // formatos conocidos de ficheros para emails
        respuestaHttp.setContentType("text/css;");
        try (PrintWriter salida = respuestaHttp.getWriter()) {
            salida.print("body{");
            salida.print("color:red;}");
            for(int i=0; i<10; i++){
                salida.println(".fuente-1" + i + "{");
                salida.println("font-size: " + ((float) 10 + i * 2) / 10 + "em;");
                salida.println("color:red; }");
            }
            
        }
    }
    
}
