/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.Productos;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Productos.Producto;
import modelo.Venta.Venta_DAO;

/**
 *
 * @author jair1
 */
public class PantallaCarrito extends javax.swing.JFrame {

    /**
     * Creates new form PantallaCarrito
     */
    DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<Producto> listaProductos = new ArrayList<>();
    
    
    //ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    //VisualizarProductos vp;

    
    public PantallaCarrito() {
        initComponents();
        modelo.addColumn("ID VENDEDOR");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("ID");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO");
        modelo.addColumn("TOTAL");
        
        this.l_idComprador.setVisible(false);
        this.lb_idv.setVisible(false);
        this.lb_nombre.setVisible(false);
        this.lb_descripcion.setVisible(false);
        this.lb_cantidad.setVisible(false);
        this.lb_idProducto.setVisible(false);
        this.lb_precio.setVisible(false);
        this.lb_direccionComprador.setVisible(false);
        this.listaProductosCarrito.setVisible(false);
        
        
        actualizarTabla();
        
    }
    
    public void obtenerValores(){
        
        int idv = Integer.parseInt(this.lb_idv.getText());
        
        String nombreProducto = this.lb_nombre.getText();
        int idp = Integer.parseInt(this.lb_idProducto.getText());
        String descripcion = this.lb_descripcion.getText();
        int cantidad = Integer.parseInt(this.lb_cantidad.getText());
        int precio = Integer.parseInt(this.lb_precio.getText());
        int total = cantidad*precio;
        
        Producto p = new Producto();
        p.setId_V(idv);
        p.setNombre(nombreProducto);
        p.setId_P(idp);
        p.setDescripcion(descripcion);
        p.setCantidad(cantidad);
        p.setPrecio(precio);
        p.setTotal(total);

         if(!buscarProducto(p)){
            listaProductos.add(p);
        }
        //String arrayToString = listaProductos.toString();
        //System.out.println(arrayToString);
        actualizarTabla();

    }
    
    
    public void actualizarTabla(){
        //Producto v = new Producto();
        //ArrayList<Producto> listaProductos = cpc.Listar_Carrito();
        
        int totalCompra = 0;
        ArrayList<String> productos = new ArrayList<>();
        
        while(modelo.getRowCount()>0){
            modelo.removeRow(0);
        }
        
            //for(int i=0;i<listaProductos.size();i++){
            for(Producto v : listaProductos){
                
                Object fila[] = new Object[7];
                //v = listaProductos.get(i);
                fila[0] = v.getId_V();
                fila[1] = v.getNombre();
                fila[2] = v.getId_P();
                fila[3] = v.getDescripcion();
                fila[4] = v.getCantidad();
                fila[5] = v.getPrecio();
                fila[6] = v.getTotal();
                modelo.addRow(fila);
                productos.add(v.getNombre()+" (id vendedor: "+v.getId_V()+")");
                totalCompra = totalCompra+v.getTotal();
            }
            tablaCarrito.setModel(modelo);
            String arrayToString = productos.toString();
            this.listaProductosCarrito.setText(arrayToString);
            this.totalCompra.setText(String.valueOf(totalCompra));
        
    }
    
    public boolean buscarProducto(Producto nueva){
        for (Producto v : listaProductos){
            if(v.getDescripcion().equals(nueva.getDescripcion())){
                int nuevaCantidad=v.getCantidad()+nueva.getCantidad();
                v.setCantidad(nuevaCantidad);
                v.setTotal(v.getPrecio()*nuevaCantidad);
                return true;
            }
        }
        return false;
    }
    
    public void eliminarProducto(){
        int fila = this.tablaCarrito.getSelectedRow();
        int pid = Integer.parseInt((String) this.tablaCarrito.getValueAt(fila, 0).toString());
        if(fila==-1){
            JOptionPane.showMessageDialog(null, "No hay productos para eliminar","Error", JOptionPane.ERROR_MESSAGE);
        }else{
            listaProductos = listaProductos;
            listaProductos.remove(pid-1);
            actualizarTabla();
            JOptionPane.showMessageDialog(null, "El Producto ha sido eliminado del carrito", "Operación exitosa ", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public boolean actualizarStock(){
        boolean bandera=false;
        for(int i = 0; i < modelo.getRowCount(); i++){
            Producto pr = new Producto();
            Venta_DAO dao = new Venta_DAO();
            int idp = Integer.parseInt(tablaCarrito.getValueAt(i, 2).toString());
            //System.out.println("Id p: "+idp);
            int cantidad = Integer.parseInt(tablaCarrito.getValueAt(i, 4).toString());
            pr=dao.listarID(idp);
            System.out.println(pr.getCantidad());
            
            if(pr.getCantidad() < cantidad){
                JOptionPane.showMessageDialog(null, "No se pudo realizar la compra, el stock de productos es insuficiente","Error", JOptionPane.ERROR_MESSAGE);
                bandera=false;
            }else{
                int sa = pr.getCantidad() - cantidad;
                dao.actualizarStock(sa, idp);
                bandera=true;
                //guardarCompra();
            }
            
        }
        return bandera;
    }
    
    public void guardarCompra(){
        Venta_DAO dao = new Venta_DAO();
        
        if(listaProductos.size()==0){
             JOptionPane.showMessageDialog(null, "Debe agregar productos a su carrito antes de realizar la compra","Error", JOptionPane.ERROR_MESSAGE);
        }else{
            int idv = Integer.parseInt(this.lb_idv.getText());
            int idc = Integer.parseInt(this.l_idComprador.getText());
            int idr = 0;
            String nombreComprador = this.l_comprador.getText();
            String estado = "pendiente";
            String direccion = this.lb_direccionComprador.getText();
            String productos = this.listaProductosCarrito.getText();
            int totalCompra = Integer.parseInt(this.totalCompra.getText());
        
            if(actualizarStock()==true){
                dao.guardarVentaEnPedidos(idc, idr, nombreComprador, estado, direccion, productos, totalCompra);
            }
        }
       
    }
    
    public void limpiarCarrito(){
        this.totalCompra.setText("");
        listaProductos.clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        l_comprador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCarrito = new javax.swing.JTable();
        l_idComprador = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalCompra = new javax.swing.JLabel();
        lb_idv = new javax.swing.JLabel();
        lb_nombre = new javax.swing.JLabel();
        lb_descripcion = new javax.swing.JLabel();
        lb_cantidad = new javax.swing.JLabel();
        lb_precio = new javax.swing.JLabel();
        btnEliminarArticulo = new javax.swing.JButton();
        listaProductosCarrito = new javax.swing.JLabel();
        btnRealizarCompra = new javax.swing.JButton();
        lb_idProducto = new javax.swing.JLabel();
        lb_direccionComprador = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        l_comprador.setFont(new java.awt.Font("Segoe UI", 2, 22)); // NOI18N
        l_comprador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_comprador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Resumen de tu compra");

        tablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID VENDEDOR", "PRODUCTO", "ID", "DESCRIPCION", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(tablaCarrito);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Total a pagar: $");

        totalCompra.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        btnEliminarArticulo.setText("Eliminar Artículo");
        btnEliminarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarArticuloActionPerformed(evt);
            }
        });

        btnRealizarCompra.setText("Realizar Compra");
        btnRealizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarCompraActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/LogoTian2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(listaProductosCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(totalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lb_idv, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_idProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_direccionComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(l_idComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)
                                        .addComponent(l_comprador, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(392, 392, 392)
                                        .addComponent(btnEliminarArticulo)))))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(btnRealizarCompra)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(l_comprador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(l_idComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_direccionComprador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_idProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_idv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarArticulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(listaProductosCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addComponent(btnRealizarCompra)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarArticuloActionPerformed
        // TODO add your handling code here:
        if(listaProductos.size()<1){
            JOptionPane.showMessageDialog(null, "No hay productos para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            eliminarProducto();
        }
        
    }//GEN-LAST:event_btnEliminarArticuloActionPerformed

    private void btnRealizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarCompraActionPerformed
        // TODO add your handling code here:
        guardarCompra();
        //actualizarStock();
        limpiarCarrito();
        actualizarTabla();
    }//GEN-LAST:event_btnRealizarCompraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaCarrito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminarArticulo;
    private javax.swing.JButton btnRealizarCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel l_comprador;
    public javax.swing.JLabel l_idComprador;
    public javax.swing.JLabel lb_cantidad;
    public javax.swing.JLabel lb_descripcion;
    public javax.swing.JLabel lb_direccionComprador;
    public javax.swing.JLabel lb_idProducto;
    public javax.swing.JLabel lb_idv;
    public javax.swing.JLabel lb_nombre;
    public javax.swing.JLabel lb_precio;
    public javax.swing.JLabel listaProductosCarrito;
    public javax.swing.JTable tablaCarrito;
    private javax.swing.JLabel totalCompra;
    // End of variables declaration//GEN-END:variables
}
