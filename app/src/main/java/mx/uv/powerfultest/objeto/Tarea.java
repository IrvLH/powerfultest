package mx.uv.powerfultest.objeto;

import java.sql.Blob;

public class Tarea {
    private int id;
    private String titulo;
    private String descripcion;
    private Blob imagen;
    private int id_usuario;
    public Tarea(int id, String titulo, String descripcion, Blob imagen, int id_usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.id_usuario = id_usuario;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getId() {
        return id;
    }
    public Blob getImagen() {
        return imagen;
    }
    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setId(int id) {
        this.id = id;
    }

}
