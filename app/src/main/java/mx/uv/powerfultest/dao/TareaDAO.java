package mx.uv.powerfultest.dao;

import mx.uv.powerfultest.conexion.ConexionBD;
import mx.uv.powerfultest.objeto.Tarea;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO {
    private static final String TABLA="tareas";

    public static boolean registrarTarea(Tarea tar){
        boolean exito=false;
        try{
            String query =  " insert into "+TABLA+" (id_tareas, descripcion, imagen, id_usuario, titulo)"
                            + " values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = ConexionBD.conectar().prepareStatement(query);
            preparedStmt.setInt(1, tar.getId());
            preparedStmt.setString(2, tar.getDescripcion());
            preparedStmt.setBlob(3, tar.getImagen());
            preparedStmt.setInt(4, tar.getId_usuario());
            preparedStmt.setString(5, tar.getTitulo());
            preparedStmt.execute();
            System.out.println("Tarea registrada.");
            exito=true;
        }catch(SQLException e){
            System.out.println("Estado SQL: "+e.getSQLState());
            System.out.println("Código de error: "+e.getErrorCode());
            System.out.println(e.getMessage());
        }
        return exito;
    }

    public static List <Tarea> getTareabyUsuario(int idUsuario){
        List <Tarea> tareas=new ArrayList<>();
        Statement statement;

        try{
            statement = ConexionBD.conectar().createStatement();
            ResultSet rs=statement.executeQuery("select * from "+ TABLA + " where id_usuario = " + idUsuario);

            if(!rs.next()){
                System.out.println("no hay coincidencia con la base de datos");
                return null;
            }else{
                Tarea aux= new Tarea(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBlob(4), rs.getInt(5));
                tareas.add(aux);
                System.out.println(aux.getTitulo());
                while(rs.next()){
                    aux= new Tarea(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBlob(4), rs.getInt(5));
                    tareas.add(aux);
                    System.out.println(aux.getTitulo());
                }
            }
        }catch(SQLException e){
            System.out.println("estado SQL:" + e.getSQLState());
            System.out.println("codigo de error:" + e.getErrorCode());
            System.out.println(e.getMessage());
        }
        return tareas;
    }
}
