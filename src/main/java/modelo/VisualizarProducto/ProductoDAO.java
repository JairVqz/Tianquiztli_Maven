package modelo.VisualizarProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.ConexionBD;
//import vista.VisualizarProductos;
import vista.Productos.VisualizarProductos;

public class ProductoDAO {
    
    public ArrayList<Productos> Listar_ProductoVO(){
        
        
        ArrayList<Productos> list = new ArrayList<Productos>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT * FROM productosP;";
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
                vo.setCantidad(rs.getInt(6));
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
        String sql = "SELECT * FROM `productosP` WHERE `tipo`=\"Artesanía\"";
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
                vo.setCantidad(rs.getInt(6));
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
        String sql = "SELECT * FROM `productosP` WHERE `tipo`=\"Accesorios\"";
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
                vo.setCantidad(rs.getInt(6));
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
        String sql = "SELECT * FROM `productosP` WHERE `tipo`=\"Comida\"";
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
                vo.setCantidad(rs.getInt(6));
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
        String sql = "SELECT * FROM `productosP` WHERE `tipo`=\"Bebidas\"";
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
                vo.setCantidad(rs.getInt(6));
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
    
}

    
