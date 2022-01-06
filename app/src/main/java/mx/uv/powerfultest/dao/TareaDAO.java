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
            Blob b = ConexionBD.conectar().createBlob();
            if(tar.getImagen()!=null){
                b.setBytes(1, tar.getImagen().getBytes());
            }else{
                b=null;
            }

            preparedStmt.setInt(1, tar.getId());
            preparedStmt.setString(2, tar.getDescripcion());
            preparedStmt.setString(3, tar.getImagen());
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
                Blob b = rs.getBlob(3);
                String arch64 = "Sin imagen";
                if(b!=null){
                    byte[] datos = b.getBytes(1, (int) b.length());
                    arch64 = new String(datos);
                }
                Tarea aux= new Tarea(rs.getInt(1), rs.getString(2), arch64, rs.getInt(4), rs.getString(5));
                tareas.add(aux);
                System.out.println(aux.getTitulo());
                while(rs.next()){
                    b = rs.getBlob(3);
                    arch64 = "Sin imagen";
                    if(b!=null){
                        byte[] datos = b.getBytes(1, (int) b.length());
                        arch64 = new String(datos);
                    }
                    aux= new Tarea(rs.getInt(1), rs.getString(2), arch64, rs.getInt(4), rs.getString(5));
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
