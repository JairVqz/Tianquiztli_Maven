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

public class ProductoDAO_Comprador {
    
    public ArrayList<Productos_Comprador> Listar_ProductoVO(){
        
        
        ArrayList<Productos_Comprador> list = new ArrayList<Productos_Comprador>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT id_V, nombre, id_P, tipo, descripcion, precio, stock, foto FROM `productos`;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos_Comprador vo = new Productos_Comprador();
                vo.setIdV(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setId(rs.getInt(3));
                vo.setTipo(rs.getString(4));
                vo.setDescripcion(rs.getString(5));
                vo.setPrecio(rs.getInt(6));
                vo.setStock(rs.getString(7));
                vo.setImagen(rs.getBytes(8));
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
    
    public ArrayList<Productos_Comprador> Listar_Artesanias(){
        
        
        ArrayList<Productos_Comprador> list = new ArrayList<Productos_Comprador>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT id_V, nombre, id_P, tipo, descripcion, precio, stock, foto FROM `productos` WHERE `tipo`=\"Artesanía\"";
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos_Comprador vo = new Productos_Comprador();
                vo.setIdV(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setId(rs.getInt(3));
                vo.setTipo(rs.getString(4));
                vo.setDescripcion(rs.getString(5));
                vo.setPrecio(rs.getInt(6));
                vo.setStock(rs.getString(7));
                vo.setImagen(rs.getBytes(8));
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
    
    public ArrayList<Productos_Comprador> Listar_Accesorios(){
        
        
        ArrayList<Productos_Comprador> list = new ArrayList<Productos_Comprador>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT id_V, nombre, id_P, tipo, descripcion, precio, stock, foto FROM `productos` WHERE `tipo`=\"Accesorio\"";
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos_Comprador vo = new Productos_Comprador();
                vo.setIdV(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setId(rs.getInt(3));
                vo.setTipo(rs.getString(4));
                vo.setDescripcion(rs.getString(5));
                vo.setPrecio(rs.getInt(6));
                vo.setStock(rs.getString(7));
                vo.setImagen(rs.getBytes(8));
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
    
    public ArrayList<Productos_Comprador> Listar_Comida(){
        
        
        ArrayList<Productos_Comprador> list = new ArrayList<Productos_Comprador>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT id_V, nombre, id_P, tipo, descripcion, precio, stock, foto FROM `productos` WHERE `tipo`=\"Comida\"";
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos_Comprador vo = new Productos_Comprador();
                vo.setIdV(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setId(rs.getInt(3));
                vo.setTipo(rs.getString(4));
                vo.setDescripcion(rs.getString(5));
                vo.setPrecio(rs.getInt(6));
                vo.setStock(rs.getString(7));
                vo.setImagen(rs.getBytes(8));
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
    
    public ArrayList<Productos_Comprador> Listar_Bebidas(){
        
        
        ArrayList<Productos_Comprador> list = new ArrayList<Productos_Comprador>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT id_V, nombre, id_P, tipo, descripcion, precio, stock, foto FROM `productos` WHERE `tipo`=\"Bebida\"";
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos_Comprador vo = new Productos_Comprador();
                vo.setIdV(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setId(rs.getInt(3));
                vo.setTipo(rs.getString(4));
                vo.setDescripcion(rs.getString(5));
                vo.setPrecio(rs.getInt(6));
                vo.setStock(rs.getString(7));
                vo.setImagen(rs.getBytes(8));
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
   
    
}

    
