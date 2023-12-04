package modelo.Negocio;

import java.time.LocalDateTime;
import org.bson.types.ObjectId;

public class Publicacion {
    
    private ObjectId id;
    private String titulo;
    private String contenido;
    private LocalDateTime fechaCreacion;
    private String idUsuario;
    private String nombreUsuario;

    public Publicacion() {
    }

    public Publicacion(String titulo, String contenido, LocalDateTime fechaCreacion, String idUsuario) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.idUsuario = idUsuario;
    }

    public Publicacion(String titulo, String contenido, LocalDateTime fechaCreacion, String idUsuario, String nombreUsuario) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
