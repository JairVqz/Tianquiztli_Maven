package modelo.RegistrarCompradorModelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ConexionBD;

public class CompradorDAO {
    
    public void agregarComprador(Comprador comprador){
        ConexionBD c = new ConexionBD();
        String sql = "INSERT INTO comprador (nombreC, contraseñaC, dirección)\n" +
"VALUES (?,?,?);";
        PreparedStatement ps = null;
        try{
            ps = c.getConnection().prepareStatement(sql);
            ps.setString(1, comprador.getNombreC());
            ps.setString(2, comprador.getContraseñaC());
            ps.setString(3, comprador.getDirección());
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
