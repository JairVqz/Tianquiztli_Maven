package modelo.RegistrarVendedorModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ConexionBD;

public class VendedorDAO {
    
    public void agregarVendedor(Vendedor vend){
        ConexionBD c = new ConexionBD();
        String sql = "INSERT INTO vendedor (nombreV, contraseñaV, ciudad, nombre_negocio)\n" +
"VALUES (?,?,?,?);";
        PreparedStatement ps = null;
        try{
            ps = c.getConnection().prepareStatement(sql);
            ps.setString(1, vend.getNombreV());
            ps.setString(2, vend.getContraseñaV());
            ps.setString(3, vend.getCiudad());
            ps.setString(4, vend.getNombre_negocio());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario registrado", "Operación exitosa ", JOptionPane.INFORMATION_MESSAGE);
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
