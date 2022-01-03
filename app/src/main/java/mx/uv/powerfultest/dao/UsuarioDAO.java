package mx.uv.powerfultest.dao;

import mx.uv.powerfultest.conexion.ConexionBD;
import mx.uv.powerfultest.objeto.Usuario;
import java.sql.*;

public class UsuarioDAO {
    private static final String TABLA="usuarios";

    public static boolean registrarUsuario(Usuario usuario){
        boolean exito=false;
        try{
            String query =  " insert into "+TABLA+" (id_usuario, nombre, correo_electronico, clave)"
                            + " values (?, ?, ?, ?)";
            PreparedStatement preparedStmt = ConexionBD.conectar().prepareStatement(query);
            preparedStmt.setInt(1, usuario.getId());
            preparedStmt.setString(2, usuario.getNombre());
            preparedStmt.setString(3, usuario.getCorreo_e());
            preparedStmt.setString(4, usuario.getClave());
            preparedStmt.execute();
            System.out.println("Usuario creado.");
            exito=true;
        }catch(SQLException e){
            System.out.println("Estado SQL: "+e.getSQLState());
            System.out.println("Código de error: "+e.getErrorCode());
            System.out.println(e.getMessage());
        }
        return exito;
    }

    public static Usuario accesodeUsuario(String correo, String clave){
        Statement statement;
        Usuario usuario = null;
        try{
            statement = ConexionBD.conectar().createStatement();
            ResultSet rs=statement.executeQuery("select * from "+ TABLA + " where correo_electronico='"
            +correo+"' and clave='"+clave+"';");
            if(!rs.next()){
                System.out.println("No hay correo " + correo
                +" o contraseña erronea "+clave);
                return null;
            }else{
                usuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre"), rs.getString("correo_electronico"), rs.getString("clave"));
            }
        }catch(SQLException e){
            System.out.println("Estado SQL: "+e.getSQLState());
            System.out.println("Código de error: "+e.getErrorCode());
            System.out.println(e.getMessage());
        }
        return usuario;
    }

    public static Usuario usuarioCorreo(String correo){
        Statement statement;
        Usuario usuario = null;
        try{
            statement = ConexionBD.conectar().createStatement();
            ResultSet rs=statement.executeQuery("select * from "+ TABLA + " where correo_electronico='"
            +correo+"';");
            if(!rs.next()){
                System.out.println("No hay correo " + correo);
                return null;
            }else{
                usuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre"), rs.getString("correo_electronico"), rs.getString("clave"));
            }
        }catch(SQLException e){
            System.out.println("Estado SQL: "+e.getSQLState());
            System.out.println("Código de error: "+e.getErrorCode());
            System.out.println(e.getMessage());
        }
        return usuario;
    }
}
