package controlador.RegistrarCompradorControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.RegistrarCompradorModelo.Comprador;
import modelo.RegistrarCompradorModelo.CompradorDAO;
import vista.RegistrarCompradorVista.RegistrarComprador;

public class CompradorControlador{
    private Comprador comprador;
    private CompradorDAO compradorDAO;
    private RegistrarComprador pantallaRegistro;
    
    public CompradorControlador(CompradorDAO compradorDAO, RegistrarComprador pantallaRegistro){
        this.compradorDAO=compradorDAO;
        this.pantallaRegistro=pantallaRegistro;
    }
    
    public void recibirDatos(){
        Comprador comprador = new Comprador();
        
        if(campoVacioNombre() && campoVacioContraseña() && campoVacioDireccion()){
            String nombre = pantallaRegistro.txtNuser.getText();
            String contra = pantallaRegistro.txtNPss.getText();
            String direc = pantallaRegistro.txtDir.getText();
            
            this.agregar(nombre, contra, direc);
        }
    }
    
    public void agregar(String nombre, String contra, String direc){
        Comprador comp = new Comprador();
        CompradorDAO cdao = new CompradorDAO();
        
        comp.setNombreC(nombre);
        comp.setContraseñaC(contra);
        comp.setDirección(direc);
        compradorDAO.agregarComprador(comp);
    }
    
    private boolean campoVacioNombre(){
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
    
    private boolean campoVacioContraseña(){
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
    
    private boolean campoVacioDireccion(){
        String errorMessage = "";
        if(pantallaRegistro.txtDir.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "No agregaste una direccion, verifica el campo", "Error", JOptionPane.WARNING_MESSAGE);
        }
        if(errorMessage.length() == 0){
            return true;
        }else{
            return false;
        }
    }
}
