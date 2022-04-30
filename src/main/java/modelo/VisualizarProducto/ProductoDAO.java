package modelo.VisualizarProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.ConexionBD;
//import vista.VisualizarProductos;
import vista.Productos.VisualizarProductos;

public class ProductoDAO {
    
    public ArrayList<Productos> Listar_ProductoVO(){
        
        
        ArrayList<Productos> list = new ArrayList<Productos>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT id_P, nombre, tipo, descripcion, precio, stock, foto FROM `productos`;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos vo = new Productos();
                vo.setId(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setTipo(rs.getString(3));
                vo.setDescripcion(rs.getString(4));
                vo.setPrecio(rs.getInt(5));
                vo.setCantidad(rs.getString(6));
                vo.setImagen(rs.getBytes(7));
                list.add(vo);
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
    
    public ArrayList<Productos> Listar_Artesanias(){
        
        
        ArrayList<Productos> list = new ArrayList<Productos>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT id_P, nombre, tipo, descripcion, precio, cantidad, foto `productos` WHERE `tipo`=\"Artesanía\"";
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos vo = new Productos();
                vo.setId(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setTipo(rs.getString(3));
                vo.setDescripcion(rs.getString(4));
                vo.setPrecio(rs.getInt(5));
                vo.setCantidad(rs.getString(6));
                vo.setImagen(rs.getBytes(7));
                list.add(vo);
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
    
    public ArrayList<Productos> Listar_Accesorios(){
        
        
        ArrayList<Productos> list = new ArrayList<Productos>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT * FROM 'productos' WHERE `tipo`=\"Accesorios\"";
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos vo = new Productos();
                vo.setId(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setTipo(rs.getString(3));
                vo.setDescripcion(rs.getString(4));
                vo.setPrecio(rs.getInt(5));
                vo.setCantidad(rs.getString(6));
                vo.setImagen(rs.getBytes(7));
                list.add(vo);
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
    
    public ArrayList<Productos> Listar_Comida(){
        
        
        ArrayList<Productos> list = new ArrayList<Productos>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT * FROM 'productos' WHERE `tipo`=\"Comida\"";
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos vo = new Productos();
                vo.setId(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setTipo(rs.getString(3));
                vo.setDescripcion(rs.getString(4));
                vo.setPrecio(rs.getInt(5));
                vo.setCantidad(rs.getString(6));
                vo.setImagen(rs.getBytes(7));
                list.add(vo);
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
    
    public ArrayList<Productos> Listar_Bebidas(){
        
        
        ArrayList<Productos> list = new ArrayList<Productos>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT * FROM 'productos' WHERE `tipo`=\"Bebidas\"";
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos vo = new Productos();
                vo.setId(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setTipo(rs.getString(3));
                vo.setDescripcion(rs.getString(4));
                vo.setPrecio(rs.getInt(5));
                vo.setCantidad(rs.getString(6));
                vo.setImagen(rs.getBytes(7));
                list.add(vo);
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
    
    public void Modificar_ProductoVO2(modelo.VisualizarProducto.Productos vo){
        ConexionBD conec = new ConexionBD();
        String sql = "UPDATE productos SET nombre = ?, tipo = ?, descripcion = ?, precio = ?, stock = ?\n" +
"WHERE id_P = ?;";
        PreparedStatement ps = null;
        try{
            int input = JOptionPane.showConfirmDialog(null, 
                "Se modificará el producto, ¿Está seguro?", "Selecciona una opción.",JOptionPane.YES_NO_CANCEL_OPTION);
            
            if(input==0){
                ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setString(2, vo.getTipo());
            ps.setString(3, vo.getDescripcion());
            ps.setInt(4, vo.getPrecio());
            ps.setString(5, vo.getCantidad());
            ps.setInt(6, vo.getId());
            ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "El Producto ha sido modificado", "Operación exitosa ", JOptionPane.INFORMATION_MESSAGE);
            }else{
                System.out.println(input);
            JOptionPane.showMessageDialog(null, "Operación cancelada", "No se realizará ninguna edición", JOptionPane.INFORMATION_MESSAGE);
            }
            
        // 0=ok

            //JOptionPane.showMessageDialog(null, "El Producto ha sido actualizado", "Operación exitosa ", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void Modificar_ProductoVO(modelo.VisualizarProducto.Productos vo){
        ConexionBD conec = new ConexionBD();
        String sql = "UPDATE productos SET nombre = ?, tipo = ?, descripcion = ?, precio = ?, stock = ?, foto = ?\n" +
"WHERE id_P = ?;";
        PreparedStatement ps = null;
 
        try{
            int input = JOptionPane.showConfirmDialog(null, 
                "Se modificará la imágen, ¿Está seguro?", "Selecciona una opción.",JOptionPane.YES_NO_CANCEL_OPTION);
            
            if (input == 0){
                ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setString(2, vo.getTipo());
            ps.setString(3, vo.getDescripcion());
            ps.setInt(4, vo.getPrecio());
            ps.setString(5, vo.getCantidad());
            ps.setBytes(6, vo.getImagen());
            ps.setInt(7, vo.getId());
            ps.executeUpdate();
            System.out.println(input);
            JOptionPane.showMessageDialog(null, "La imagen ha sido modificada", "Operación exitosa ", JOptionPane.INFORMATION_MESSAGE);
                
            }else{
                System.out.println(input);
            JOptionPane.showMessageDialog(null, "Operación cancelada", "No se realizará ninguna edición", JOptionPane.INFORMATION_MESSAGE);
            }
               

	// 0=yes, 1=no, 2=cancel
	
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
    
    public void Eliminar_ProductoVO(Productos vo){
        ConexionBD conec = new ConexionBD();
        String sql = "DELETE FROM productos WHERE id_P = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getId());
            ps.executeUpdate();
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

    
