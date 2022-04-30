/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Carrito;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Carrito.Carrito;
import modelo.Carrito.Carrito_DAO;
import modelo.ConexionBD;
import modelo.VisualizarProducto.Render;
import vista.Productos.PantallaCarrito;
import vista.Productos.VisualizarProductos;

/**
 *
 * @author jair1
 */
public class ControladorCarrito {
      
    private VisualizarProductos vp;
    private PantallaCarrito pc;
    public int filaExiste;
    Carrito_DAO carrito_dao;
    ConexionBD c = new ConexionBD();
    DefaultTableModel model = new DefaultTableModel();
    
    public ControladorCarrito(VisualizarProductos vp, Carrito_DAO carrito_dao){
        this.vp = vp;
        this.carrito_dao = carrito_dao;
    }
    
    public ControladorCarrito(PantallaCarrito pc){
        this.pc = pc;
    }
    
    public ControladorCarrito(){
        
    }
    
    public String crearCarrito(){
        String nombreUsuario = vp.l_usuario.getText();
        String sql = "CREATE TABLE `tianquiztli`.`"+nombreUsuario+"`"+"( `id` INT(11) AUTO_INCREMENT, `producto` VARCHAR(50) NULL , `cantidad` INT(5) NULL , `precio` INT(5) NULL, `total` INT(5) NULL, PRIMARY KEY (`id`)) ENGINE = InnoDB;";
        PreparedStatement ps = null;
        
        try{
            ps = c.getConnection().prepareStatement(sql);
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
        return nombreUsuario;
    }
    
    public void agregarArticulo(){
        
        String nombreUsuario = vp.l_usuario.getText();
        String producto = vp.tf2_nombre.getText();
        int cantidadSeleccionada = (Integer) vp.spinnerCantidadProductos.getValue();
        String stock = vp.tf5_stock.getText();
        int precio = Integer.parseInt(vp.tf4_precio.getText());
        int total = cantidadSeleccionada*precio;

        if (stock.equals("Agotado")){
            JOptionPane.showMessageDialog(null, "El producto no esta disponible por el momento", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            carrito_dao.agregarProductoCarrito(nombreUsuario, producto, cantidadSeleccionada, precio, total);
             
        }
    }
    
    public void visualizar_ProductosCarrito(JTable tabla, String nombreUsuario){
        
        String usuario = nombreUsuario;
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("ID");
        dt.addColumn("NOMBRE");
        dt.addColumn("CANTIDAD");
        dt.addColumn("PRECIO");
        dt.addColumn("TOTAL");

        carrito_dao = new Carrito_DAO();
        Carrito ca = new Carrito();
        ArrayList<Carrito> list = carrito_dao.Listar_ProductosCarrito(usuario);  //Aqui elegimos la tabla
        int totalCompra = 0;
        ArrayList<String> listaProductos = new ArrayList<>();
        
        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[7];
                ca = list.get(i);
                fila[0] = ca.getId();
                fila[1] = ca.getProducto();
                fila[2] = ca.getCantidad();
                fila[3] = ca.getPrecio();
                fila[4] = ca.getTotal();
                //fila[5] = vo.getCantidad();
                
                dt.addRow(fila);
                
                listaProductos.add(ca.getProducto());
                totalCompra = totalCompra +ca.getTotal();
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
            String arrayToString = listaProductos.toString();
            pc.l_listaProductos.setText(arrayToString);
            pc.l_totalCompra.setText(String.valueOf(totalCompra));
        }
    }
    
    public void delete(String nombreUsuario){         
        
         String usuario = nombreUsuario;
         
         int fila = pc.tablaCarrito.getSelectedRow();
         int pid = Integer.parseInt((String)pc.tablaCarrito.getValueAt(fila,0).toString());         
         if(fila==-1){
             JOptionPane.showMessageDialog(pc,"Debe tener productos en su carrito para realizar esta operaci+on.");
         }else{
             //daopc.delete(pid);
             carrito_dao.delete(pid, usuario);
             JOptionPane.showMessageDialog(pc,"El producto ha sido eliminado de su compra.");
             this.visualizar_ProductosCarrito(pc.tablaCarrito, nombreUsuario);
         }
    }
    
    public void actualizar(String nombreUsuario){
        String usuario = nombreUsuario;
        this.visualizar_ProductosCarrito(pc.tablaCarrito, usuario);
    }
    
    public void realizarCompra(int id, int id_R, String estado, String direccion, String productos, int totalCompra){
        int idC = id;
        int idR = id_R;
        String estadoC = estado;
        String direccionC = direccion;
        String productosC = productos;
        int totalCompraC = totalCompra;
        
        carrito_dao.agregarPedido(idC, idR, estadoC, direccionC, productosC, totalCompraC);
    }
    
    public void eliminarCarrito(String nombreUsuario){
        String usuario = nombreUsuario;
        
        carrito_dao.eliminarCarrito(usuario);
    }
    
}

