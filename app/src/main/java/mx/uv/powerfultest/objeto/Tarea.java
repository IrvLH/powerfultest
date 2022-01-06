package mx.uv.powerfultest.objeto;

public class Tarea {
    private int id;
    private String titulo;
    private String descripcion;
    private String imagen;
    private int id_usuario;
    public Tarea(int id, String descripcion, String imagen, int id_usuario, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.setImagen(imagen);
        this.id_usuario = id_usuario;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
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