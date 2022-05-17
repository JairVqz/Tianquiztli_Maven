/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Venta;
    
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ConexionBD;
import modelo.Productos.Producto;

    

public class Venta_DAO {
    int r;
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    ConexionBD c = new ConexionBD();
    Producto p;
    
    public int actualizarStock(int cantidad, int idp){
        String sql="UPDATE productos SET cantidad=? WHERE id_P=?";
        try{
            con = c.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, idp);
            ps.executeUpdate();
        }catch (Exception e){
            
        }
    
    return r; 
    }
    
    public Producto listarID(int id){
        Producto p = new Producto();
        int idp = id;
        String sql = "SELECT * FROM productos WHERE id_P="+idp;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = c.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            //con = c.getConnection();
            //ps = con.prepareStatement(sql);
            //rs = ps.executeQuery();
            while (rs.next()){
                p.setId_P(rs.getInt(1));
                p.setId_V(rs.getInt(2));
                p.setNombre(rs.getString(3));
                p.setTipo(rs.getString(4));
                p.setDescripcion(rs.getString(5));
                p.setPrecio(rs.getInt(6));
                p.setStock(rs.getString(7));
                p.setFoto(rs.getBytes(8));
                p.setCantidad(rs.getInt(9));
            }
        }catch (Exception e){
            
        }finally{
            try{
                ps.close();
                rs.close();
            }catch(Exception ex){}
        }
           //System.out.println(p.getId_P());
        return p;
     
    }
    
    public void guardarVentaEnPedidos(int idc, int idr, String nombreComprador, String estado, String direccion, String productos, int totalCompra){
        ConexionBD c = new ConexionBD();
        String sql = "INSERT INTO pedidos (id_Pe, id_C, id_R, nombreC, estado, direccion, productos, total)\n" + "VALUES (NULL,?,?,?,?,?,?,?);";
        PreparedStatement ps = null;
        
        try{
            ps = c.getConnection().prepareStatement(sql);
            ps.setInt(1, idc);
            ps.setInt(2, idr);
            ps.setString(3, nombreComprador);
            ps.setString(4, estado);
            ps.setString(5, direccion);
            ps.setString(6, productos);
            ps.setInt(7, totalCompra);
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
    
}
