<%-- 
    Document   : index
    Created on : 21-feb-2019, 20:42:40
    Author     : IEUser
--%>
<%@include file="head.jsp" %>
<html>
    <%= head()%>

    <body>
        <%@include file="header.jsp" %>
        <h1>Formulario JSP de registro</h1> 
        <%
            Object mensajeDeError = request.getSession().getAttribute("mensajeError");
            if (mensajeDeError != null) {%>
        <p><%= (String) mensajeDeError%></p>
        <%request.getSession().removeAttribute("mensajeError");%>
        }
        <%}%>
        <form name="form1" action="usuarios.do" method="POST">

            <table border="1">
                <tr><td>Nombre:</td><td>
                        <input type="text" name="nombre" id="nombre" size="25" value="" 
                               placeholder="Introduzca nombre" 
                               required="required"/>  </td></tr>
                <tr><td>Edad:</td><td>
                        <input type="number" name="edad" id="edad" value="" 
                               placeholder="Edad" 
                               min="12"
                               required="required"/>  </td></tr> 
                <tr><td>Email</td><td>
                        <input type="email" name="email" id="email" value=""
                               placeholder="Email" 
                               pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                               required="required"/>  </td></tr> 
                <tr><td>Contrase�a</td><td>
                        <input type="password" name="password" id="password" value="" 
                               placeholder="Password" 
                               required="required"/>  </td></tr> 
            </table>
            <input type="submit" value="Registrar"/>
        </form>
    </body>
</html>