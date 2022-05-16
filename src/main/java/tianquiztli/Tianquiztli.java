/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package tianquiztli;

import controlador.Productos.ControladorPantallaRegistrarProductos;
import modelo.Productos.Producto_DAO;
import vista.Productos.PantallaRegistrarProductos;
import vista.Productos.VisualizarProductos;

/**
 *
 * @author jair1
 */
public class Tianquiztli {
    
    public static void main(String[] args) {

        /*VisualizarProductos vp = new VisualizarProductos();
        vp.setVisible(true);
        vp.setLocationRelativeTo(null);*/
        VentanaLogin log = new VentanaLogin();
        log.setVisible(true);
        log.setLocationRelativeTo(null);
        
        /*PantallaRegistrarProductos pantallaRegistro = new PantallaRegistrarProductos();
        Producto_DAO producto_dao = new Producto_DAO();
        ControladorPantallaRegistrarProductos rpc = new ControladorPantallaRegistrarProductos(producto_dao, pantallaRegistro);
        //
        pantallaRegistro.setTitle("Tianquiztli");
        pantallaRegistro.setLocationRelativeTo(null);


        pantallaRegistro.setVisible(true);*/
    }
}
