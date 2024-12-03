
package Modelo;
import java.sql.DriverManager;
import java.sql.Connection;

public class Conexion {
    Connection con = null;
    
    String bd = "VENTAS";
    String srv = "jdbc:mysql://localhost:3306/" + bd;
    String user = "root";
    String password = "";
    
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(srv, user, password);
        } catch (Exception e){
            System.err.println(e);
        }
        return con;
    }
    
}
