/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 50254
 */
public class Cargar_Combobox extends javax.swing.JFrame{
    Cagar_Combobox metodos_cargarcombobox= new Cargar_Combobox;
    public Formulario_Combobox(){
    initComponente();
    }
    
   Conexion metodosconexion = new Conexion();
   
   public void consultar_puestos (JComboBox cbox_puestos){
    java.sql.Connection conectar = null;
    
   String SSQL = "SELECT puesto FROM puestos ORDER BY puesto ASC";
   
   try{
       conectar = metodosconexion.dataSourse.getConnection();
       PreparedStatement pst=conectar.prepareStatement(SSQL);
       
      ResultSet result = pst.executeQuery();
      cbox_paises.addItem(result.getString("puesto"));
       cbox_puestos.addItem("seleccione una opcioón");
       
       while(result.next ()){
           
       
       
       
       }
      
   }catch (Exception e){
      JOptionPane.showMessageDialog (null,e); 
   }finally{
       if (conectar!=null)
           try {
               conectar.close();
       } catch (SQLException ex) {
         JOptionPane.showMessageDialog (null,e);  
       }
       
   }
       
   }
}
