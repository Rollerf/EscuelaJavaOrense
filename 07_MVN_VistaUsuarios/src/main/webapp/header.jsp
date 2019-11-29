<%-- 
    Document   : header
    Created on : 21-feb-2019, 20:43:31
    Author     : IEUser
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.vn.appusuarios.modelo.Usuario"%>

<!--  	Usuario usuario = (Usuario) session.getAttribute("usuario"); -->
<%-- Usar el bean "usuario" en la forma de JSTL --%>
<c:catch var="excepcionUsuario">
	<jsp:useBean id="usuario" type="com.vn.appusuarios.modelo.Usuario"
		scope="session"></jsp:useBean>
	<jsp:getProperty property="*" name="usuario"></jsp:getProperty>
</c:catch>
<header>
	<h2>Aplicación Gestión MVC JSP</h2>
	<nav>
		<a href="index.jsp">Inicio</a>
		<c:if test="${sessionScope.usuario != null}">

			<a href="listar.jsp">Listar</a>
			<a href="eliminar.jsp">Eliminar</a>
			<a href="login.jsp">Login</a>
			<a href="registrarse.jsp">Registrarse</a>
		</c:if>
	</nav>
	<h3 style="color: red"></h3>
</header>