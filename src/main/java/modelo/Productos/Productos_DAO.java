/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Productos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ConexionBD;

/**
 *
 * @author jair1
 */
public class Productos_DAO{

    public void agregarProducto(Productos producto) {
        ConexionBD c = new ConexionBD();
        String sql = "INSERT INTO productos (id_P, id_V, nombre, tipo, descripcion, precio, cantidad, foto)\n" +
"VALUES (NULL,?,?,?,?,?,?,?);";
        PreparedStatement ps = null;
        try{
            ps = c.getConnection().prepareStatement(sql);
            ps.setInt(1, producto.getId_V());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getTipo());
            ps.setString(4, producto.getDescripcion());
            ps.setInt(5, producto.getPrecio());
            ps.setInt(6, producto.getCantidad());
            ps.setBytes(7, producto.getFoto());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El Producto ha sido registrado", "Operación exitosa ", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            System.out.println("A "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("B "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "El sistema perdío conexión con la Base de Datos, Por favor intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                ps.close();
            }catch(Exception ex){}
        }
    }
    
}
