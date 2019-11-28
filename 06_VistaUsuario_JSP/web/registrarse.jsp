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
            if (mensajeDeError != null) {
        %>
        <p style="color:red"><%= (String) mensajeDeError%>
        </p>
        <%
            request.getSession().removeAttribute("mensajeError");
            }
        %>
        <form name="form1" action="usuarios.do" method="POST">

            <table border="1">
                <tr><td>Nombre:</td><td>
                        <input type="text" name="nombre" id="nombre" size="25" value=""
                               placeholder="Introduzca nobmre" required="required" 
                               />  </td></tr>
                <tr><td>Edad:</td><td>
                        <input type="number" name="edad" id="edad" value="" 
                               placeholder="Introduzca edad" required="required"
                               min="12"/>  </td></tr> 
                <tr><td>Email</td><td>
                        <input type="email" name="email" id="email" value=""
                               placeholder="Introduzca email" required="required"
                               pattern="^[_A-Za-z0-9-\\+]+(\.[_A-Za-z0-9-]+)*@+[A-Za-z0-9-]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$"/>  </td></tr> 
                <tr><td>Contraseña</td><td>
                        <input type="password" name="password" id="password" value=""
                               placeholder="Introduzca password" required="required"
                               minlength="4"/>  </td></tr> 
            </table>
            <input type="submit" value="Registrar"/>
        </form>
    </body>
</html>