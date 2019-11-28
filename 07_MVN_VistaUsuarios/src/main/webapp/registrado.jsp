<%-- 
    Document   : registrado
    Created on : 21-feb-2019, 23:21:10
    Author     : IEUser
--%>
<%@include file="head.jsp" %>
<%@page import="com.vn.appusuarios.modelo.Usuario"%>
<%@page import="com.vn.appusuarios.modelo.logica.ServicioUsuarios"%>
<%
	//ServicioUsuarios servicioU = (ServicioUsuarios) request.getAttribute("servicioUsu");
%>
<html>
<%= head() %>
<body>
 <%@include file="header.jsp" %>
	<h1>Registrado correctamente</h1>
	<!-- 	 <h2 style="color: green"> -->
	<!-- 		ID: -->
	<%-- 		<%=servicioU.leerUno(usuario.getEmail()).getId()%> --%>
	<!-- 		<br> Nombre: -->
	<%-- 		<%=servicioU.leerUno(usuario.getEmail()).getNombre()%> --%>
	<!-- 	</h2> -->
	<h2 style="color: green">
		ID:
		<%=usuario.getId()%>
		<br> Nombre:
		<%=usuario.getNombre()%>
	</h2>
</body>
</html>
