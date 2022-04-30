/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Carrito;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ConexionBD;

/**
 *
 * @author jair1
 */
public class Carrito_DAO {
    
    public void agregarProductoCarrito(String nombreUsuario, String producto, int cantidad, int precio, int total) {
        ConexionBD c = new ConexionBD();
        String usuario = nombreUsuario;
        String nombreProducto = producto;
        int cantidadProducto = cantidad;
        int precioProducto = precio;
        int totalProducto = total;
        
        String sql = "INSERT INTO `"+usuario+"` (id, producto, cantidad, precio, total)\n" + "VALUES (NULL,?,?,?,?);";
        PreparedStatement ps = null;
        try{
            ps = c.getConnection().prepareStatement(sql);
            ps.setString(1, nombreProducto);
            ps.setInt(2, cantidadProducto);
            ps.setInt(3, precioProducto);
            ps.setInt(4, totalProducto);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El Producto ha sido agregado al carrito", "Operación exitosa ", JOptionPane.INFORMATION_MESSAGE);
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
    
    public ArrayList<Carrito> Listar_ProductosCarrito(String usuario){
        
        String nombreUsuario = usuario;
        ArrayList<Carrito> list = new ArrayList<Carrito>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT * FROM `"+nombreUsuario+"`;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Carrito ca = new Carrito();
                ca.setId(rs.getInt(1));
                ca.setProducto(rs.getString(2));
                ca.setCantidad(rs.getInt(3));
                ca.setPrecio(rs.getInt(4));
                ca.setTotal(rs.getInt(5));
                
                list.add(ca);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
            }catch(Exception ex){}
        }
        return list;
    }
    
    
    public void delete(int idpe, String usuario){
        
        String nombreUsuario = usuario;
        String sql="delete from `"+nombreUsuario+"` where id="+idpe;
        ConexionBD c = new ConexionBD();
        PreparedStatement ps = null;
        
         try{
            ps = c.getConnection().prepareStatement(sql);
            ps.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                
            }catch(Exception ex){}
        }
    }
    
    public void agregarPedido(int idC, int idR, String estadoC, String direccionC, String productosC, int totalCompraC) {
        ConexionBD c = new ConexionBD();
        int id = idC;
        int id_R = idR;
        String estado = estadoC;
        String direccion = direccionC;
        String productos = productosC;
        int totalCompra = totalCompraC;
        
        String sql = "INSERT INTO pedidos (id_Pe, id_C, id_R, estado, direccion, productos, total)\n" + "VALUES (NULL,?,?,?,?,?,?);";
        PreparedStatement ps = null;
        try{
            ps = c.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id_R);
            ps.setString(3, estado);
            ps.setString(4, direccion);
            ps.setString(5, productos);
            ps.setInt(6, totalCompra);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "La compra ha sido registrada", "Operación exitosa ", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void eliminarCarrito(String usuario){
        
        ConexionBD c = new ConexionBD();
        String nombreUsuario = usuario;
        String sql = "DROP TABLE `"+usuario+"`";
        PreparedStatement ps = null;
        try{
            ps = c.getConnection().prepareStatement(sql);
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("A "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("B "+ex.getMessage());
        }finally{
            try{
                ps.close();
            }catch(Exception ex){}
        }
        
    }
    
    
}