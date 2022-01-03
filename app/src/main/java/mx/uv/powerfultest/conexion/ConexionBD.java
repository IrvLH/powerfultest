package mx.uv.powerfultest.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionBD {
    private static Connection c = null;
    private static String direccion = "jdbc:mysql://localhost/sisweb_tareas?user=root&password=";
    public static Connection conectar(){
        try {
            c = DriverManager.getConnection(direccion);
        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        if(c==null){
            System.out.println("Conexión fallida.");
        }else{
            System.out.println("Conexión establecida (localhost)");
        }
        return c;
    }
    
}
