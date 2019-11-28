<%-- 
    Document   : header
    Created on : 21-feb-2019, 20:43:31
    Author     : IEUser
--%>
<%@page import="com.vn.appusuarios.modelo.Usuario"%>
<%
	Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<header>
	<h2>Aplicación Gestión MVC JSP</h2>
	<nav>
		<a href="index.jsp">Inicio</a>
		<%
			if (usuario != null && usuario.getId() >= 0) {
		%>
		<a href="listar.jsp">Listar</a> <a href="eliminar.jsp">Eliminar</a>

		<%
			}
		%>
		<a href="login.jsp">Login</a> <a href="registrarse.jsp">Registrarse</a>
	</nav>
	<h3 style="color: red"></h3>
</header>