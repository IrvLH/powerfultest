package mx.uv.powerfultest.objeto;

public class Usuario {
    private int id;
    private String nombre;
    private String correo_e;
    private String clave;
    public Usuario(int id, String nombre, String correo_e, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.correo_e = correo_e;
        this.clave = clave;
    }
    public String getClave() {
        return clave;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo_e() {
        return correo_e;
    }
    public void setCorreo_e(String correo_e) {
        this.correo_e = correo_e;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }

}
