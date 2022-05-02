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
import javax.swing.JOptionPane;

/**
 *
 * @author Aridai
 */
public class PedidoRDAO {
    public ArrayList<PedidoR> Listar_ProductoVO(){
        ArrayList<PedidoR> list = new ArrayList<>();
        ConexionBD conec = new ConexionBD();
        String sql = "SELECT * FROM pedidos;";
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
                vo.setEstado(rs.getString(4));
                vo.setDireccion(rs.getString(5));
                vo.setProductos(rs.getString(6));
               
                list.add(vo);
            }
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
        return list;
    }
    
}
