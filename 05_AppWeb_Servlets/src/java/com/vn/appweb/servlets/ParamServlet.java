/** Creando un formulario y reciviendo sus campos como parametros
 * 
 */
package com.vn.appweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "ParamServlet", urlPatterns = {"/Formulario"})
public class ParamServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     */

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param peticionHttp servlet peticionHttp
     * @param respuestaHttp servlet respuestaHttp
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest peticionHttp, HttpServletResponse respuestaHttp)
            throws ServletException, IOException {

        try (PrintWriter out = respuestaHttp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Form y Param</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParamServlet at " + peticionHttp.getContextPath() + "</h1>");
            out.println("<h2>Formulario de registro</h2>");
            //Canpos a enviar: nombre e email, obligatorios y con su validacion HTML5
            out.println("<form name='formDatos' action='./Formulario' method='POST'>");
            
            out.println("   <label>Nombre: </label>");
            out.println("   <input id='nombre' name='nombre' type='text' required/>");
            
            out.println(" <br/>  <label>Email: </label>");
            out.println("   <input id='email' name='email' type='email' required/>");
            
            out.println(" <br/>  <input type='submit' value='Envia parametros' />");
            out.println("</form>");            
            out.println("</body>");
            out.println("</html>");
    }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest peticionHttp, HttpServletResponse respuestaHttp)
            throws ServletException, IOException {
        try (PrintWriter out = respuestaHttp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Form y Param</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParamServlet at " + peticionHttp.getContextPath() + "</h1>");
            out.println("<h2>Formulario de registro</h2>");
            //Campos a recibir: nombre e email, obligatorios y con su validacion HTML5
            String valorNombre = peticionHttp.getParameter("nombre");
            String valorEmail = peticionHttp.getParameter("email");
            if("".equals(valorNombre)|| valorNombre == "null" ||"".equals(valorEmail)|| valorEmail == "null"){
                out.println("<p style = 'color: red'>Los parametros no son correctos</p>");
            }else{
                out.println("<p style = 'color: green'> nombre: " + valorNombre.toUpperCase() + "</p> ");
                out.println("<p style = 'color: green'> email: " + valorEmail.toUpperCase() + "</p> ");
            }
            
            //Vamos a insertar los datos recibidos
            //jdbc:derby://localhost:1527/db_prueba
            try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            } catch (Exception ex) {
                Logger.getLogger(ParamServlet.class.getName()).log(Level.SEVERE, null, ex);
                out.println("<p style='color: red> No se ha cargado DerbyDB</p> ");
            }
            
            try(Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/db_prueba",
                     "root" , "1234")){
                
                String sqlQuery = "INSERT INTO persona (nombre, email) VALUES ('"  + valorNombre +  "', '"  + valorEmail +  "')";
                Statement sentenciaSQL = con.createStatement();
                sentenciaSQL.executeUpdate(sqlQuery);
                
            }catch(SQLException ex){
                out.println("<p style='color:red'>Error SQL: " + ex.getMessage()+"</p> ");
            }
            
            out.println("</body>");
            out.println("</html>");
    }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet que envia formulario y recibe los parametros.";
    }// </editor-fold>

}
