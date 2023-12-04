package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import modelo.Persistencia.Fabrica;
import modelo.Persistencia.FabricaImplementacion;
import modelo.Configuracion.LocalDateAdapter;
import modelo.Configuracion.ObjectIdAdapter;
import modelo.Negocio.Usuario;
import org.bson.types.ObjectId;

/**
 *
 * @author Rodrigo Gtz
 */
@WebServlet(name = "SvInicioSesion", urlPatterns = {"/SvInicioSesion"})
public class SvInicioSesion extends HttpServlet{
//    
    private Fabrica fabrica;
    private Gson gson;
    HttpSession session;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.fabrica = new FabricaImplementacion();
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(ObjectId.class, new ObjectIdAdapter())
                .create();

            String usuarioJson;
            Usuario usuario = (Usuario) this.session.getAttribute("Usuario");

            
            response.setContentType("application/json");
     
        if (usuario != null) {
            usuarioJson = gson.toJson(usuario);  
        } else {
            usuarioJson = "{}";
        }

        try (PrintWriter out = response.getWriter()) {
            out.println(usuarioJson);
            out.flush();
        }

    }
    
        
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.fabrica = new FabricaImplementacion();
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(ObjectId.class, new ObjectIdAdapter())
                .create();
        this.session = request.getSession();
        String correo = request.getParameter("correo");
        String contraseña = request.getParameter("contraseña");
        if (this.fabrica.AutenticarUsuario(correo, contraseña)) {
            Usuario usuario = this.fabrica.obtenerUsuario(correo);
            session.setAttribute("Usuario", usuario);
            String usuarioJson = gson.toJson(usuario); 
            response.sendRedirect("Principal.jsp");
//            response.getWriter().println(usuarioJson);
     
        }else {
            response.sendRedirect("Inicio.jsp");
            session.setAttribute("mensajeInicioSesion", "Correo y/o contraseña incorrectos.");
           
        }
    }

}
