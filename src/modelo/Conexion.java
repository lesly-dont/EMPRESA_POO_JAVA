package modelo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lesly Quevedo
 */
public class Conexion {
    public Connection conexionBD;
    private final String puerto = "3306";
    private final String bd = "crud";
    private final String urlConexion = String.format("jdbc:mysql://localhost:%s/%s",puerto,bd);
    private final String usuario = "root";
    private final String contra = "leslyquevedo0016";
    private final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    public void abrir_conexion (){
    try{
    Class.forName(jdbc);
    conexionBD = DriverManager.getConnection(urlConexion,usuario,contra);
   //JOptionPane.showMessageDialog(null, "Conexion Exitosa","Mensaje",JOptionPane.INFORMATION_MESSAGE);
    
    }catch(HeadlessException | ClassNotFoundException | SQLException ex){
    System.out.println("Error " + ex.getMessage());
    }
    }
    public void cerrar_conexion (){
    try{
        conexionBD.close();
    }catch(SQLException ex){
         System.out.println("Error " + ex.getMessage());
    }
    } 
}
