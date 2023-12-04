/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import jakarta.jms.Session;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import modelo.Persistencia.Fabrica;
import modelo.Persistencia.FabricaImplementacion;
import modelo.Negocio.Comentario;
import modelo.Negocio.Publicacion;
import modelo.Negocio.Usuario;

/**
 *
 * @author Rodrigo Gtz
 */
@WebServlet(name = "SvPrincipal", urlPatterns = {"/SvPrincipal"})
public class SvPrincipal extends HttpServlet {

    Fabrica fabrica = new FabricaImplementacion();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
           if (request.getParameter("btnCerrarSesion").isEmpty()) {
            session.setAttribute("Usuario", null);
            response.sendRedirect("Inicio.jsp");
        } else {
            session.setAttribute("Usuario", null);
            response.sendRedirect("Inicio.jsp");
        }

    
           
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("seleccion").equalsIgnoreCase("Publicar")) {
            HttpSession session = request.getSession();
            String titulo = request.getParameter("titulo");
            String contenido = request.getParameter("contenido");
            LocalDateTime fechaCreacion = LocalDateTime.now();
            Usuario usuario = (Usuario) session.getAttribute("Usuario");
            Publicacion publicacion = new Publicacion(titulo, contenido, fechaCreacion, usuario.getId().toString(), usuario.getNombre());
            session.setAttribute("Publicacion", publicacion);
            this.fabrica.CrearPublicacion(publicacion);
            response.sendRedirect("Principal.jsp");
            session.setAttribute("Publicaciones", this.fabrica.obtenerPublicaciones());
            session.setAttribute("Usuarios", this.fabrica.obtenerUsuarios());
            session.setAttribute("mensajeCorrecto", "Se ha publicado correctamente.");
        }
        if (request.getParameter("seleccion").equalsIgnoreCase("Comentar")) {
            HttpSession session = request.getSession();
            String contenido = request.getParameter("comentario");
            LocalDateTime fechaCreacion = LocalDateTime.now();
            Publicacion publicacion = (Publicacion) session.getAttribute("Publicacion");
            Usuario usuario = (Usuario) session.getAttribute("Usuario");           
            Comentario comentario = new Comentario(contenido, fechaCreacion, usuario.getId().toString(), usuario.getNombre(), publicacion.getId().toString());
            this.fabrica.CrearComentario(comentario);
            session.setAttribute("Comentario", comentario);
            session.setAttribute("Comentarios", this.fabrica.obtenerComentarios());
            response.sendRedirect("Principal.jsp");
            session.setAttribute("Comentarios", this.fabrica.obtenerComentarios());
        }
            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   
}
