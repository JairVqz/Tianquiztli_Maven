package controlador.RegistrarVendedorControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.RegistrarVendedorModelo.Vendedor;
import modelo.RegistrarVendedorModelo.VendedorDAO;
import vista.RegistrarVendedorVista.RegistrarVendedor;

public class VendedorControlador{
    private Vendedor vendedor;
    private VendedorDAO vendedorDAO;
    private RegistrarVendedor pantallaRegistro;
    
        
    public VendedorControlador(VendedorDAO vendedorDAO, RegistrarVendedor pantallaRegistro){
        this.vendedorDAO=vendedorDAO;
        this.pantallaRegistro=pantallaRegistro;
    }
    
        public void recibirDatos(){
        Vendedor vendedor = new Vendedor();
        
        if(campoVacioNombreV() && campoVacioContraseñaV() && campoVacioCiudad() && campoVacioNGocio()){
            String nombreV = pantallaRegistro.txtNuser.getText();
            String contraV = pantallaRegistro.txtNPss.getText();
            String ciudad = pantallaRegistro.txtCity.getText();
            String nomGocio = pantallaRegistro.txtNGocio.getText();
            
            this.agregar(nombreV, contraV, ciudad, nomGocio);
        }
    }
   
    public void agregar(String nombreV, String contraV, String ciudad, String nomGocio){
        Vendedor vndr = new Vendedor();
        VendedorDAO vdao = new VendedorDAO();
        
        vndr.setNombreV(nombreV);
        vndr.setContraseñaV(contraV);
        vndr.setCiudad(ciudad);
        vndr.setNombre_negocio(nomGocio);
        vendedorDAO.agregarVendedor(vndr);
    }
    
    private boolean campoVacioNombreV(){
        String errorMessage = "";
        if(pantallaRegistro.txtNuser.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "No agregaste un nombre, verifica el campo", "Error", JOptionPane.WARNING_MESSAGE);
        }
        if(errorMessage.length() == 0){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean campoVacioContraseñaV(){
        String errorMessage = "";
        if(pantallaRegistro.txtNPss.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "No agregaste una contraseña, verifica el campo", "Error", JOptionPane.WARNING_MESSAGE);
        }
        if(errorMessage.length() == 0){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean campoVacioCiudad(){
        String errorMessage = "";
        if(pantallaRegistro.txtCity.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "No agregaste una ciudad, verifica el campo", "Error", JOptionPane.WARNING_MESSAGE);
        }
        if(errorMessage.length() == 0){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean campoVacioNGocio(){
        String errorMessage = "";
        if(pantallaRegistro.txtNGocio.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "No agregaste el nombre del negocio, verifica el campo", "Error", JOptionPane.WARNING_MESSAGE);
        }
        if(errorMessage.length() == 0){
            return true;
        }else{
            return false;
        }
    }
}
