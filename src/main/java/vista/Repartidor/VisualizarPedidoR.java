
package vista.Repartidor;

import modelo.PedidoR.PedidoRDAO;
import controlador.PedidoR.TablaPedidoR;
import controlador.Productos.ControladorP;
import java.awt.HeadlessException;
import modelo.PedidoR.PedidoR;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.VisualizarProducto.Productos;
import tianquiztli.Conexion;
import tianquiztli.VentanaLogin;
import vista.Productos.VisualizarProductos;


public class VisualizarPedidoR extends javax.swing.JFrame {
    
    private ImageIcon imagen, ima;
    private Icon icono;
    PedidoRDAO dao;
    PedidoR vo = new PedidoR();
    TablaPedidoR t = new TablaPedidoR();
    
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    int codigo = 0;
    //String idR;
    int idR;
    public VisualizarPedidoR() {
        initComponents();
        this.logoImagen(this.logo, "src/main/java/Imagenes/Tianquiztli (6).png");
        this.logoImagen(this.iconPersona, "src/main/java/Imagenes/iconR.png");
        setLocationRelativeTo(null);
        System.out.println("Llego");
        //l_idR.setText("1");
        //idR = l_idRepartidor.getText();
       t.visualizar_PedidoVO(tabla,idR);
        
        
    }
    public VisualizarPedidoR(int id) {
        initComponents();
        this.logoImagen(this.logo, "src/main/java/Imagenes/Tianquiztli (6).png");
        this.logoImagen(this.iconPersona, "src/main/java/Imagenes/iconR.png");
        this.setLocationRelativeTo(this);
        l_idR.setText(String.valueOf(id));
        idR = Integer.parseInt(l_idR.getText());
        //System.out.println("HOLISSS  " + id + "   " + Integer.parseInt(l_idRepartidor.getText()));
        
        t.visualizar_PedidoVO(tabla,idR); 
    
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        logo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jt1 = new javax.swing.JTextField();
        jt2 = new javax.swing.JTextField();
        jt4 = new javax.swing.JTextField();
        jt5 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jta1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jt3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jt6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jt7 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        cancelar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        entregado = new javax.swing.JButton();
        l_repartidor = new javax.swing.JLabel();
        l_idRepartidor = new javax.swing.JLabel();
        iconPersona = new javax.swing.JLabel();
        l_idR = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_Pe", "ID_C", "ID_R", "Nombre Comprador", "Estado", "Dirección", "Productos", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setText("ID Pedido:");

        jLabel3.setText("ID Comprador:");

        jLabel4.setText("Estado:");

        jLabel5.setText("Dirección:");

        jLabel6.setText("Productos:");

        jt1.setEditable(false);

        jt2.setEditable(false);

        jt4.setEditable(false);

        jt5.setEditable(false);

        jta1.setEditable(false);
        jta1.setColumns(20);
        jta1.setRows(5);
        jScrollPane3.setViewportView(jta1);

        jLabel1.setText("ID Repartidor:");

        jt3.setEditable(false);

        jLabel7.setText("Total:");

        jt6.setEditable(false);

        jLabel8.setText("Nombre Comprador:");

        jt7.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(jt3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt5)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jt4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jt6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jt2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jt5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jt3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(19, 19, 19))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        entregado.setText("Entregar");
        entregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entregadoActionPerformed(evt);
            }
        });

        jLabel9.setText("ID:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(aceptar)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(entregado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(iconPersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(l_repartidor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(l_idR, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_idRepartidor)))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(l_idRepartidor, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(iconPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(l_idR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_repartidor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addComponent(aceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entregado)
                .addGap(28, 28, 28))
        );

        salir.setText("Cerrar Sesión");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(salir)
                                .addGap(81, 81, 81)
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salir)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        
        Productos vo = new Productos();
        int filaSeleccionada = tabla.rowAtPoint(evt.getPoint());
        
        
        jt1.setText(tabla.getValueAt(filaSeleccionada, 0).toString());
        jt2.setText(tabla.getValueAt(filaSeleccionada, 1).toString());
        jt3.setText(tabla.getValueAt(filaSeleccionada, 2).toString());
        jt7.setText(tabla.getValueAt(filaSeleccionada, 3).toString());
        jt4.setText(tabla.getValueAt(filaSeleccionada, 4).toString());
        jt5.setText(tabla.getValueAt(filaSeleccionada, 5).toString());
        jta1.setText(tabla.getValueAt(filaSeleccionada, 6).toString());
        jt6.setText(tabla.getValueAt(filaSeleccionada, 7).toString());
      
        System.out.print(jt1.getText());
        
    }//GEN-LAST:event_tablaMouseClicked

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        
        int filaSeleccionada = tabla.getSelectedRow();
        String v = "cancelado";
        String f = "aceptado";
        String n = "entregado";
        if(filaSeleccionada < 0){
            JOptionPane.showMessageDialog(null, "Selecciona el pedido a cancelar");
        }else{

             if(jt4.getText().equals(v)){
                 JOptionPane.showMessageDialog(null, "El pedido ya esta cancelado");
             }else{
                 if(jt4.getText().equals(f)){
                    JOptionPane.showMessageDialog(null, "El pedido ya esta aceptado");
                 }else{
                     if(jt4.getText().equals(n)){
                        JOptionPane.showMessageDialog(null, "El pedido ya esta entregado");
                     }else{
                         cerrarCancelar();
                     }
                 }  
             }
             
        }
       
    }//GEN-LAST:event_cancelarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        
        int filaSeleccionadaA = tabla.getSelectedRow();
        String v = "cancelado";
        String f = "aceptado";
        String n = "entregado";

        if(filaSeleccionadaA < 0){
            JOptionPane.showMessageDialog(null, "Selecciona el pedido que desea aceptar");
        }else{

             if(jt4.getText().equals(v)){
                 JOptionPane.showMessageDialog(null, "El pedido ya esta cancelado");
             }else{
                 if(jt4.getText().equals(f)){
                    JOptionPane.showMessageDialog(null, "El pedido ya esta aceptado");
                 }else{
                     if(jt4.getText().equals(n)){
                        JOptionPane.showMessageDialog(null, "El pedido ya esta entregado");
                     }else{
                         cerrarAceptar();
                     }
                 }  
             }
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void entregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entregadoActionPerformed
        
        int filaSeleccionadaE = tabla.getSelectedRow();
        String v = "cancelado";
        String f = "pendiente";
        String n = "entregado";
        if(filaSeleccionadaE < 0){
            JOptionPane.showMessageDialog(null, "Selecciona el pedido a entregar");
        }else{
            //JOptionPane.showMessageDialog(null, "Seguro que desea cancelar");
             //t.cancelar_PedidoVO();
             if(jt4.getText().equals(v)){
                 JOptionPane.showMessageDialog(null, "El pedido ya esta cancelado");
             }else{
                 if(jt4.getText().equals(f)){
                     JOptionPane.showMessageDialog(null, "El pedido aun no esta aceptado");
                 }else{
                    if(jt4.getText().equals(n)){
                        JOptionPane.showMessageDialog(null, "El pedido ya esta entregado");
                    }else{
                        cerrarEntregado();  
                     }
                 }
             }
            
        }
    }//GEN-LAST:event_entregadoActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.setVisible(false);
        VentanaLogin vl = new VentanaLogin();
        vl.setVisible(true);
        vl.setLocationRelativeTo(null);
    }//GEN-LAST:event_salirActionPerformed
   
    
public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarPedidoR().setVisible(true);
            }
        });
    }

  public void logoImagen(JLabel logo, String ruta){
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(this.imagen.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
        logo.setIcon(this.icono);
        this.repaint();
  }
    
  public void cerrarCancelar(){
    Object [] opciones ={"Aceptar","Cancelar"};
    int eleccion = JOptionPane.showOptionDialog(rootPane,"Seguro que desea cancelar el pedido","Mensaje de Confirmacion",
    JOptionPane.YES_NO_OPTION,
    JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
    if (eleccion == JOptionPane.YES_OPTION){
        System.out.print(jt1.getText());
        
        String id;
  
        id = jt1.getText();
        t.cancelar_PedidoVO(id);
        
        jt1.setText("");
        jt2.setText("");
        jt3.setText("");
        jt4.setText("");
        jt5.setText("");
        jta1.setText("");
        jt6.setText("");
        jt7.setText("");
        
        t.visualizar_PedidoVO(tabla, idR);
        
    }
    
    
 }
  
  
  public void cerrarAceptar(){
    Object [] opciones ={"Aceptar","Cancelar"};
    int eleccion = JOptionPane.showOptionDialog(rootPane,"Seguro que desea aceptar el pedido","Mensaje de Confirmacion",
    JOptionPane.YES_NO_OPTION,
    JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
    if (eleccion == JOptionPane.YES_OPTION){
        System.out.print(jt1.getText());
        
        String id;
  
        id = jt1.getText();
        t.aceptar_PedidoVO(id);
        
        jt1.setText("");
        jt2.setText("");
        jt3.setText("");
        jt4.setText("");
        jt5.setText("");
        jta1.setText("");
        jt6.setText("");
        jt7.setText("");
        
        t.visualizar_PedidoVO(tabla,idR);
        
    }
    
    
 }
  
  
    public void cerrarEntregado(){
    Object [] opciones ={"Sí","No"};
    int eleccion = JOptionPane.showOptionDialog(rootPane,"¿El pedido fue entregado?","Mensaje de Confirmacion",
    JOptionPane.YES_NO_OPTION,
    JOptionPane.QUESTION_MESSAGE,null,opciones,"Sí");
    if (eleccion == JOptionPane.YES_OPTION){
        System.out.print(jt1.getText());
        
        String id;
  
        id = jt1.getText();
        t.entregado_PedidoVO(id);
        
        jt1.setText("");
        jt2.setText("");
        jt3.setText("");
        jt4.setText("");
        jt5.setText("");
        jta1.setText("");
        jt6.setText("");
        jt7.setText("");
        
        t.visualizar_PedidoVO(tabla,idR);
        
        
    }
    
    
    
    
 }
    public void validarUsuario(){
        
        int resultado= 0;
        String usuario= l_repartidor.getText();
        String SQL="select * from repartidor where nombreR='"+usuario+"'";
        
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            
            if(rs.next()){
               VisualizarProductos vp = new VisualizarProductos();
               
               ControladorP cpz = new ControladorP(vp);
               this.setVisible(false);
               vp.setVisible(true);
               vp.setLocationRelativeTo(null);
               
            } 
            
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null,"Error de conexión " + e.getMessage());
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptar;
    public javax.swing.JButton cancelar;
    public javax.swing.JButton entregado;
    private javax.swing.JLabel iconPersona;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTextField jt1;
    public javax.swing.JTextField jt2;
    public javax.swing.JTextField jt3;
    public javax.swing.JTextField jt4;
    public javax.swing.JTextField jt5;
    public javax.swing.JTextField jt6;
    public javax.swing.JTextField jt7;
    public javax.swing.JTextArea jta1;
    public javax.swing.JLabel l_idR;
    public javax.swing.JLabel l_idRepartidor;
    public javax.swing.JLabel l_repartidor;
    private javax.swing.JLabel logo;
    private javax.swing.JButton salir;
    public javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
