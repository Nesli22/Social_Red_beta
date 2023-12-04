
package modelo.Persistencia;

import modelo.Persistencia.Fabrica;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import modelo.Negocio.Comentario;
import modelo.Negocio.Publicacion;
import modelo.Negocio.Usuario;

public class FabricaImplementacion extends ConexionMongo implements Fabrica{

    private MongoCollection<Usuario> coleccionUsuarios;
    private MongoCollection<Publicacion> coleccionPublicaciones;
    private MongoCollection<Comentario> coleccionComentarios;

    public FabricaImplementacion() {
        this.coleccionUsuarios = this.basedatos.getCollection("Usuarios", Usuario.class);  
        this.coleccionPublicaciones = this.basedatos.getCollection("Publicaciones", Publicacion.class);  
        this.coleccionComentarios = this.basedatos.getCollection("Comentarios", Comentario.class);  
    }

    @Override
    public void CrearUsuario(Usuario usuario) {
        coleccionUsuarios.insertOne(usuario);
    }

    @Override
    public boolean AutenticarUsuario(String correo, String contraseña) {
        ArrayList<Usuario> listaUsuarios = this.obtenerUsuarios();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contraseña)) {          
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        coleccionUsuarios.find().into(listaUsuarios);
        return listaUsuarios;
    }

    @Override
    public boolean ValidarUsuario(String correo) {
         ArrayList<Usuario> listaUsuarios = this.obtenerUsuarios();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCorreo().equals(correo)) {          
                return true;
            }
        }
        return false;
    }

    @Override
    public Usuario obtenerUsuario(String correo) {
        ArrayList<Usuario> listaUsuarios = this.obtenerUsuarios();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCorreo().equals(correo)) {          
                return usuario;
            }
        }return null;
    }

    @Override
    public void CrearPublicacion(Publicacion publicacion) {
          coleccionPublicaciones.insertOne(publicacion);
    }

    @Override
    public ArrayList<Publicacion> obtenerPublicaciones() {
        ArrayList<Publicacion> listaPublicaciones = new ArrayList<>();
        coleccionPublicaciones.find().into(listaPublicaciones);
        return listaPublicaciones;
    }

    @Override
    public void CrearComentario(Comentario comentario) {
        coleccionComentarios.insertOne(comentario);
    }

    @Override
    public ArrayList<Comentario> obtenerComentarios() {
        ArrayList<Comentario> listaComentarios = new ArrayList<>();
        coleccionComentarios.find().into(listaComentarios);
        return listaComentarios;
    }


    
}
