/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.awt.HeadlessException;
import modelo.cliente;
import javax.swing.JOptionPane;
import modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 50254
 */
public class cliente extends persona {
    private String nit;
    Conexion cn;
    public cliente(String nit, String nombre, String apellido, String direccion, String telefono, String fecha_nacimiento) {
        super(nombre, apellido, direccion, telefono, fecha_nacimiento);
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    


 @Override
 public void agregar (){
   try{
       PreparedStatement parametro;
       String query = "INSERT INTO clientes (nit,nombres,apellidos,direccion,telefono,fecha_nacimiento)VALUES(?,?,?,?,?,?);";
   cn = new Conexion();
   cn.abrir_conexion();
   parametro=(PreparedStatement) cn.conexionBD.prepareStatement(query);
   parametro.setString(1, this.getNit());
   parametro.setString(2, this.getNombre());
   parametro.setString(3, this.getApellido());
   parametro.setString(4, this.getDireccion());
   parametro.setString(5, this.getTelefono());
   parametro.setString(6, this.getFecha_nacimiento());
    
   
   
    int executar = parametro.executeUpdate();
    cn.cerrar_conexion();
   JOptionPane.showMessageDialog(null,Integer.toString(executar)+ "Registro ingresado","Agregar", JOptionPane.INFORMATION_MESSAGE); 
   }
    catch (HeadlessException | SQLException ex){
         System.out.println("error"+ ex.getMessage());
        }
 }


    
}
