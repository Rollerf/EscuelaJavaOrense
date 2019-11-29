<%-- 
    Document   : index
    Created on : 21-feb-2019, 20:42:40
    Author     : IEUser
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.vn.appusuarios.modelo.logica.ServicioUsuarios"%>
<%@page import="com.vn.appusuarios.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@include file="head.jsp"%>
<%! ArrayList<Usuario> todosUsuarios; %>
<%
	ServicioUsuarios srvUsu = new ServicioUsuarios();
	todosUsuarios = srvUsu.leerTodos();
%>
<html>
<%= head() %>
    <body>
     <%@include file="header.jsp" %>
        <h1>Todos los usuarios</h1>
        <div border="2">    
		
			<% for(Usuario usu : todosUsuarios){ %>
			
                <form action="usuarios.do" method="post" name="form">                 
                    <input id="id" name="id" type="text"  size="4" readonly="true" value="<%= usu.getId() %>"/>
                    <input id="nombre" name="nombre" type="text" required="true" value="<%= usu.getNombre() %>"/>
                    <input id="edad" name="edad" type="number" required="true"  size="4" value="<%= usu.getEdad() %>"/>
                    <input id="email" name="email" type="email" required="true" value=""/>
                    <input id="password" name="password" type="password" required="true" value=""/>
                    <input class="method" id="method" name="method" type="text" size="4" readonly="true" value="PUT"/>
                    
                    <input type="submit" value="EDIT" 
                           onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='PUT'; })"/>
                    <input type="submit" value="ELIM"                           
                           onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='DELETE'; })"/><br/>
                </form>
                <% } %>
        </div>
    </body>
</html>