package modelo.PedidoR;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import modelo.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tianquiztli.Conexion;


/**
 *
 * @author Aridai
 */
public class PedidoRDAO {
    

     
    public ArrayList<PedidoR> Listar_PedidoVO(int id){
        //int idEntero = Integer.parseInt (id);
        ArrayList<PedidoR> list = new ArrayList<>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM pedidos WHERE id_R="+id+";";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                PedidoR vo = new PedidoR();
                vo.setIdP(rs.getInt(1));
                vo.setIdC(rs.getInt(2));
                vo.setIdR(rs.getInt(3));
                vo.setNombre(rs.getString(4));
                vo.setEstado(rs.getString(5));
                vo.setDireccion(rs.getString(6));
                vo.setProductos(rs.getString(7));
                vo.setTotal(rs.getInt(8));
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

    
    
    
    public int Cancelar_PedidoVO(String id){
        
        int idEntero = Integer.parseInt (id);
        int r=0;
        Conexion conec = new Conexion();
        String sql = "UPDATE pedidos SET estado='cancelado' WHERE id_Pe="+idEntero+";";
        //String sql="update pedidos set id_Pe=?, id_C=?, id_R=?, estado='cancelado', direccion=?, productos=? where id_Pe=?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
           
            ps = conec.getConnection().prepareStatement(sql); 
            r=ps.executeUpdate();
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        }catch (Exception e){
        }
        return r;
    }
    
    public int Aceptar_PedidoVO(String id){
        
        int idEntero = Integer.parseInt (id);
        int r=0;
        Conexion conec = new Conexion();
        String sql = "UPDATE pedidos SET estado='aceptado' WHERE id_Pe="+idEntero+";";
        String verificador="SELECT * FROM pedidos;";
        ResultSet rs = null;
        PreparedStatement ps = null;

        try{
           
            ps = conec.getConnection().prepareStatement(sql); 
            r=ps.executeUpdate();
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        }catch (Exception e){
        }
        return r;
    }
    
    public int Entregado_PedidoVO(String id){
        
        int idEntero = Integer.parseInt (id);
        int r=0;
        Conexion conec = new Conexion();
        String sql = "UPDATE pedidos SET estado='entregado' WHERE id_Pe="+idEntero+";";
        //String sql="update pedidos set id_Pe=?, id_C=?, id_R=?, estado='cancelado', direccion=?, productos=? where id_Pe=?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
           
            ps = conec.getConnection().prepareStatement(sql); 
            r=ps.executeUpdate();
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        }catch (Exception e){
        }
        return r;
    }
}
