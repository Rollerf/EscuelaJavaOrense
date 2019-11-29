package com.vn.appusuarios.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Descriptores de servlets
@WebServlet({"/saludo", "/otraurl"})
public class SaludoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		String nombre = req.getParameter("nombre");
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>" + nombre + "</body>");
		Cookie nombreCookie = new Cookie("nombre_cockie", "Valor de la cookie: " + nombre);
		resp.addCookie(nombreCookie);
		resp.getWriter().println("<div id='divC'></div>");
		resp.getWriter().println("<script>document.getElementById('divC').innerHTML = document.cookie; ");
		resp.getWriter().println("document.cookie='nombre_cookie=\"Modificada en JS: \" ';");
		resp.getWriter().println("</script></body></html>");
	}
	
}
