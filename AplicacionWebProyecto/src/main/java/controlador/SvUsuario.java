package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import modelo.Persistencia.Fabrica;
import modelo.Persistencia.FabricaImplementacion;
import modelo.Negocio.Usuario;


/**
 *
 * @author Rodrigo Gtz
 */
@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {

    Fabrica fabrica = new FabricaImplementacion();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();

            String nombre = request.getParameter("nombre");
            Long telefono = Long.valueOf(request.getParameter("telefono"));
            LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
            String correo = request.getParameter("correo");
            String contraseña = request.getParameter("contraseña");
            String genero = request.getParameter("genero");
            String avatar = request.getParameter("avatar");
            String tipoUsuario = request.getParameter("tipoUsuario");
            Usuario user = new Usuario(nombre, telefono, fechaNacimiento, correo, contraseña, genero, avatar,tipoUsuario);
            if (this.fabrica.ValidarUsuario(correo)) {
                 response.sendRedirect("Registro.jsp");
                 session.setAttribute("nombre", nombre);
                 session.setAttribute("telefono", telefono);
                 session.setAttribute("fechaNacimiento", fechaNacimiento);
                 session.setAttribute("contraseña", contraseña);            
                 session.setAttribute("mensajeRegistroIncorrecto", "El correo ya está registrado. Por favor, ingresa otro correo.");
                 session.setAttribute("mensajeRegistroCorrecto", "");
            }else{
                 this.fabrica.CrearUsuario(user);
                 response.sendRedirect("Registro.jsp");
                 session.setAttribute("nombre", "");
                 session.setAttribute("telefono", "");
                 session.setAttribute("fechaNacimiento", "");
                 session.setAttribute("contraseña", "");
                 session.setAttribute("mensajeRegistroIncorrecto", "");
                 session.setAttribute("mensajeRegistroCorrecto", "Registrado correctamente.");
            }                            
    }
}
