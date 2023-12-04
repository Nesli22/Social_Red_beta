package modelo.Negocio;

import java.time.LocalDateTime;
import org.bson.types.ObjectId;

public class Comentario {
    
    private ObjectId ID;
    private String contenido;
    private LocalDateTime fecha;
    private String idUsuario;
    private String nombreUsuario;
    private String idPublicacion;
   
    public Comentario() {
    }

    public Comentario(String contenido, LocalDateTime fecha, String idUsuario, String nombreUsuario, String idPublicacion) {
        this.contenido = contenido;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idPublicacion = idPublicacion;
    }

    public ObjectId getID() {
        return ID;
    }

    public void setID(ObjectId ID) {
        this.ID = ID;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(String idPublicacion) {
        this.idPublicacion = idPublicacion;
    }
    
    
}
