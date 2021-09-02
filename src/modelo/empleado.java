/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.awt.HeadlessException;
import modelo.empleado;
import javax.swing.JOptionPane;
import modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author 50254
 */
public class empleado extends persona {
    private String codigo_empleado, puesto;
    Conexion cn;
    public empleado(String codigo_empleado, String puesto, String nombre, String apellido, String direccion, String telefono, String fecha_nacimiento) {
        super(nombre, apellido, direccion, telefono, fecha_nacimiento);
        this.codigo_empleado = codigo_empleado;
        this.puesto = puesto;
    }
    

    public String getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(String codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    @Override
   public void agregar (){
   try{
       PreparedStatement parametro;
       String query = "INSERT INTO empleados (codigo,nombres,apellidos,direccion,telefono,fecha_nacimiento,id_puesto)VALUES(?,?,?,?,?,?,?);";
   cn = new Conexion();
   cn.abrir_conexion();
   parametro=(PreparedStatement) cn.conexionBD.prepareStatement(query);
   parametro.setString(1, this.getCodigo_empleado());
   parametro.setString(2, this.getPuesto());
   parametro.setString(3, this.getNombre());
   parametro.setString(4, this.getApellido());
   parametro.setString(5, this.getDireccion());
   parametro.setString(6, this.getTelefono());
   parametro.setString(7, this.getFecha_nacimiento());
    
   
   
    int executa = parametro.executeUpdate();
    cn.cerrar_conexion();
   JOptionPane.showMessageDialog(null,Integer.toString(executa)+ " Registro ingresado","Agregar", JOptionPane.INFORMATION_MESSAGE); 
   }
    catch (HeadlessException | SQLException ex){
         System.out.println("error"+ ex.getMessage());
        }
 }
 
}
