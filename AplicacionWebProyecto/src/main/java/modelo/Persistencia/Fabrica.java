
package modelo.Persistencia;

import java.util.ArrayList;
import modelo.Negocio.Comentario;
import modelo.Negocio.Publicacion;
import modelo.Negocio.Usuario;


public interface Fabrica {
    
    //Dao para usuario
    void CrearUsuario(Usuario usuario);
    boolean AutenticarUsuario(String correo, String contraseña);
    boolean ValidarUsuario(String correo);
    Usuario obtenerUsuario(String correo);
    ArrayList<Usuario> obtenerUsuarios();
    
    //Dao para publicacion
    void CrearPublicacion(Publicacion publicacion);
    ArrayList<Publicacion> obtenerPublicaciones();
    
    //Dao para comentario
    void CrearComentario(Comentario comentario);
    ArrayList<Comentario> obtenerComentarios();
    
}
