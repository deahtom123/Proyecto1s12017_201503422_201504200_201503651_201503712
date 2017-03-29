/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {
            public static String user = "";
            public static String pass = "";
            public static String emp = "";
            public static String dep = "";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            String titulo = "Error";
            String mensaje = "";
            user = request.getParameter("txt_usuario");
            pass = request.getParameter("txt_contra");
            emp = request.getParameter("txt_empresa");
            dep = request.getParameter("txt_departamento");
            boolean entro = false;
            
            if(user.equals("Nombre de Usuario") || user.equals("") || pass.equals("Contraseña") || pass.equals("") || emp.equals("Empresa") || emp.equals("") || dep.equals("") || dep.equals("Departamento"))
            {        
                mensaje = "NO SE LLENARON CORRECTAMENTE TODOS LOS CAMPOS";
            }
            else{
                String respuesta = Servidor.Login(user, emp, dep, pass);
                if(respuesta.equals("Puede entrar")){
                    titulo = "LOGGEADO";
                    mensaje = "USUARIO LOGGEADO EXITOSAMENTE";
                    entro = true;
                }
                
                else if(respuesta.equals("contrasena incorrecta")){
                    mensaje = "CONTRASEÑA INCORRECTA";
                }
                else if(respuesta.equals("no existe")){
                    mensaje = "NO EXISTE EL USUARIO";
                }

            }
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>"+titulo+"</title>");            
                out.println("</head>");
                out.println("<body>");
                
                
                if (entro) {
                out.println("<a href = \"usuariologeado.jsp\">"+mensaje+"</a>");
                }
                else{
                    out.println(mensaje);
                }

                out.println("</body>");
                out.println("</html>");    

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
