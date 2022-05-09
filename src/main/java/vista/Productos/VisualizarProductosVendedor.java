
package vista.Productos;

import modelo.ConexionBD;
//import ProductoV.modelo.ProductoDAO;
import modelo.VisualizarProducto.*;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import ProductoV.controlador.ControladorP;
import controlador.Productos.ControladorP;
import controlador.Productos.ControladorPantallaEditarProductos;
import controlador.Productos.ControladorPantallaRegistrarProductos;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import vista.Productos.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Productos.Productos_DAO;
import tianquiztli.VentanaLogin;

public class VisualizarProductosVendedor extends javax.swing.JFrame {
    
    private ImageIcon imagen, ima;
    private Icon icono;
    int codigo = 0;
    ConexionBD c ;
    ProductoDAO dao;
    ControladorP t = new ControladorP();
    
    
    public VisualizarProductosVendedor() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.logoImagen(this.logo, "src/main/java/Imagenes/logo.png");   
        t.visualizar_ProductoVO(tabla);    
    }
    
    public void limpiar(){
        tf1_id.setText("");
        tf2_nombre.setText("");
        tf3_tipo.setText("");
        tf4_precio.setText("");
        ta1.setText("");
        txtfoto.setText("");
        tf5_cantidad.setText("");
        codigo = 0;
        t.visualizar_ProductoVO(tabla);
    }
    
    public void obtenerDatos(){
        
        int id = Integer.parseInt(tf1_id.getText());
        String nombre = tf2_nombre.getText();
        String tipo = (String) tf3_tipo.getText();
        String descripcion = ta1.getText();
        int precio = Integer.parseInt(tf4_precio.getText());
        String cantidad = (String) tf5_cantidad.getText();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        descripcion = new javax.swing.JLabel();
        costo = new javax.swing.JLabel();
        cantidad = new javax.swing.JLabel();
        producto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tf1_id = new javax.swing.JLabel();
        tf2_nombre = new javax.swing.JLabel();
        tf3_tipo = new javax.swing.JLabel();
        ta1 = new javax.swing.JLabel();
        tf4_precio = new javax.swing.JLabel();
        tf5_cantidad = new javax.swing.JLabel();
        txtfoto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(250, 199, 199));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "TIPO", "DESCRIPCION", "PRECIO", "CANTIDAD"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        id.setFont(new java.awt.Font("Heiti TC", 0, 14)); // NOI18N
        id.setText("ID:");

        nombre.setFont(new java.awt.Font("Heiti TC", 0, 14)); // NOI18N
        nombre.setText("NOMBRE:");

        tipo.setFont(new java.awt.Font("Heiti TC", 0, 14)); // NOI18N
        tipo.setText("TIPO:");

        descripcion.setFont(new java.awt.Font("Heiti TC", 0, 14)); // NOI18N
        descripcion.setText("DESCRIPCION:");

        costo.setFont(new java.awt.Font("Heiti TC", 0, 14)); // NOI18N
        costo.setText("PRECIO: $");

        cantidad.setFont(new java.awt.Font("Heiti TC", 0, 14)); // NOI18N
        cantidad.setText("STOCK:");

        producto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("FOTO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipo)
                            .addComponent(id))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf1_id, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf3_tipo))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantidad)
                                    .addComponent(costo)
                                    .addComponent(txtfoto)))
                            .addComponent(tf2_nombre)))
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(descripcion)
                        .addGap(7, 7, 7)
                        .addComponent(ta1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf4_precio)
                    .addComponent(tf5_cantidad)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(32, 32, 32)
                .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id)
                            .addComponent(costo)
                            .addComponent(tf1_id)
                            .addComponent(tf4_precio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre)
                            .addComponent(tf2_nombre)
                            .addComponent(cantidad)
                            .addComponent(tf5_cantidad))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf3_tipo)
                            .addComponent(tipo)
                            .addComponent(jButton1)
                            .addComponent(txtfoto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descripcion)
                            .addComponent(ta1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        b2.setFont(new java.awt.Font("Heiti TC", 0, 14)); // NOI18N
        b2.setText("ARTESANIAS");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b3.setFont(new java.awt.Font("Heiti TC", 0, 14)); // NOI18N
        b3.setText("ACCESORIOS");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b4.setFont(new java.awt.Font("Heiti TC", 0, 14)); // NOI18N
        b4.setText("COMIDA");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b5.setFont(new java.awt.Font("Heiti TC", 0, 14)); // NOI18N
        b5.setText("BEBIDAS");
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b1.setText("Cerrar Sesión");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(b4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(b1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b2)
                .addGap(18, 18, 18)
                .addComponent(b3)
                .addGap(18, 18, 18)
                .addComponent(b4)
                .addGap(18, 18, 18)
                .addComponent(b5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(b1)
                .addContainerGap())
        );

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Limpiar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(75, 75, 75))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(97, 97, 97))))
        );

        jTabbedPane1.addTab("PRODUCTOS", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        /* c = new Conexion();
        Connection regreso = c.getConnection();*/
        VentanaLogin log = new VentanaLogin();
        log.setVisible(true);
        this.setVisible(false);
        log.setLocationRelativeTo(null);
        //AQUI VA LA PAGINA EN LA QUE ESTABA
    }//GEN-LAST:event_b1ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        t.vBebida(tabla);
    }//GEN-LAST:event_b5ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        t.vComida(tabla);
    }//GEN-LAST:event_b4ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        t.vAccesorio(tabla);
    }//GEN-LAST:event_b3ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        t.vArtesania(tabla);
    }//GEN-LAST:event_b2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        j.setFileFilter(fil);

        int s = j.showOpenDialog(this);
        if(s == JFileChooser.APPROVE_OPTION){
            String ruta = j.getSelectedFile().getAbsolutePath();
            txtfoto.setText(ruta);
        }

        int id = Integer.parseInt(tf1_id.getText());
        String nombre = tf2_nombre.getText();
        String tipo =  tf3_tipo.getText();
        //String tipo = (String) pantallaRegistro.tipoProducto.getSelectedItem();
        String descripcion = ta1.getText();
        int precio = Integer.parseInt(tf4_precio.getText());
        
        String cantidad = tf5_cantidad.getText();
        File ruta = new File(txtfoto.getText());

        this.modificar(nombre, tipo,descripcion,precio ,ruta,id,cantidad);
        t.visualizar_ProductoVO(tabla);
        limpiar();
        /*if(txtfoto==null){
            this.modificar(nombre, tipo,descripcion,precio ,ruta,id,cantidad);
            t.visualizar_ProductoVO(tabla);
            limpiar();
        }else{
            System.out.println("Entré");
            this.modificar2(nombre, tipo,descripcion,precio ,id,cantidad);
            t.visualizar_ProductoVO(tabla);
            limpiar();
        }*/

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        Productos vo = new Productos();
        int filaSeleccionada = tabla.rowAtPoint(evt.getPoint());

        tf1_id.setText(tabla.getValueAt(filaSeleccionada, 0).toString());
        tf2_nombre.setText(tabla.getValueAt(filaSeleccionada, 1).toString());
        
        //tf3_tipo.setText(tabla.getValueAt(filaSeleccionada, 2).toString());
        tf3_tipo.setText(tabla.getValueAt(filaSeleccionada, 2).toString());
        ta1.setText(tabla.getValueAt(filaSeleccionada, 3).toString());
        tf4_precio.setText(tabla.getValueAt(filaSeleccionada, 4).toString());
        tf5_cantidad.setText(tabla.getValueAt(filaSeleccionada, 5).toString());
        //tf5_cantidad.setText(tabla.getValueAt(filaSeleccionada, 5).toString());
        //txtfoto.setText(tabla.getValueAt(filaSeleccionada, 6).toString());

        // se muestra la imagen en el jlabel
        JLabel prod = (JLabel) (tabla.getValueAt(filaSeleccionada, 6));
        //producto.setIcon(prod.getIcon());
        
        

        ImageIcon imaicon = (ImageIcon) prod.getIcon();
        Image imgEscalada = imaicon.getImage().getScaledInstance(producto.getWidth(), producto.getHeight(),Image.SCALE_DEFAULT);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        producto.setIcon(iconoEscalado);
    }//GEN-LAST:event_tablaMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

                    t.visualizar_ProductoVO(tabla);
        /*int id = Integer.parseInt(tf1_id.getText());
        String nombre = tf2_nombre.getText();
        String tipo = tf3_tipo.getText();
        String descripcion = ta1.getText();
        int precio = Integer.parseInt(tf4_precio.getText());
        String cantidad = tf5_cantidad.getText();
        //File ruta = new File(txtfoto.getText());

        System.out.println("Entré");
        this.modificar2(nombre, tipo,descripcion,precio ,id,cantidad);
        t.visualizar_ProductoVO(tabla);
        limpiar();*/

        /*if(txtfoto==null){
            this.modificar(nombre, tipo,descripcion,precio ,ruta,id,cantidad);
            t.visualizar_ProductoVO(tabla);
            limpiar();
        }else{
            System.out.println("Entré");
            this.modificar2(nombre, tipo,descripcion,precio ,id,cantidad);
            t.visualizar_ProductoVO(tabla);
            limpiar();
        }*/
        
 
        int id = Integer.parseInt(tf1_id.getText());
        String nombre = tf2_nombre.getText();
        String tipo = (String) tf3_tipo.getText();
        String descripcion = ta1.getText();
        int precio = Integer.parseInt(tf4_precio.getText());
        String cantidad = (String) tf5_cantidad.getText();
        
        PantallaEditarProductos pantallaEditar = new PantallaEditarProductos();
        ProductoDAO producto_dao = new ProductoDAO();
        ControladorP vpv = new ControladorP();
        //ControladorPantallaEditarProductos rpc = new ControladorPantallaEditarProductos(producto_dao, pantallaEditar);
        ControladorPantallaEditarProductos rpcr = new ControladorPantallaEditarProductos(producto_dao, pantallaEditar,id,nombre,tipo,descripcion,precio,cantidad);
        //
        pantallaEditar.setTitle("Tianquiztli");
        pantallaEditar.setLocationRelativeTo(null);
        pantallaEditar.setVisible(true);
        pantallaEditar.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            //Hacer lo que yo quiero
            System.out.println("Estoy cerrando");
            t.visualizar_ProductoVO(tabla);
        }
 });
          /* this.recibirDatos();
        t.visualizar_ProductoVO(tabla);
        limpiar();*/
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Método Eliminar
        int id = Integer.parseInt(tf1_id.getText());
        int a = JOptionPane.showConfirmDialog(null, "Desea eliminar este producto","Mensaje",JOptionPane.OK_CANCEL_OPTION);
        if(a == 0){
            this.eliminar(id);
            limpiar();
        }
        t.visualizar_ProductoVO(tabla);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PantallaRegistrarProductos pantallaRegistro = new PantallaRegistrarProductos();
        Productos_DAO producto_dao = new Productos_DAO();
        ControladorPantallaRegistrarProductos rpc = new ControladorPantallaRegistrarProductos(producto_dao, pantallaRegistro);
        //
        pantallaRegistro.setTitle("Tianquiztli");
        pantallaRegistro.setLocationRelativeTo(null);
        pantallaRegistro.setVisible(true);
        //Método agregar
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButton3MouseClicked

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarProductosVendedor().setVisible(true);
               
            }
        });
    }
    
    public void logoImagen(JLabel logo, String ruta){
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(this.imagen.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
        logo.setIcon(this.icono);
        this.repaint();
    }
    
    
    public void modificar(String nombre, String tipo, String descripcion, int precio, File foto, int id, String cantidad){
        Productos vo = new Productos();
        dao = new ProductoDAO();
        
        vo.setNombre(nombre);
        vo.setTipo(tipo);
        vo.setDescripcion(descripcion);
        vo.setPrecio(precio);
        vo.setId(id);
        vo.setCantidad(cantidad);
        
        try{
            byte[] icono = new byte[(int) foto.length()];
            InputStream input = new FileInputStream(foto);
            input.read(icono);
            vo.setImagen(icono);
        }catch(Exception ex){
            vo.setImagen(null);
        }
        dao.Modificar_ProductoVO(vo);
    }
    
    public void eliminar(int id){
        Productos vo = new Productos();
        dao = new ProductoDAO();
        
        vo.setId(id);
        
        dao.Eliminar_ProductoVO(vo);
    }
    
    public void modificar2(String nombre, String tipo, String descripcion, int precio, int id, String cantidad){
        Productos vo = new Productos();
        dao = new ProductoDAO();
        
        vo.setNombre(nombre);
        vo.setTipo(tipo);
        vo.setDescripcion(descripcion);
        vo.setPrecio(precio);
        vo.setId(id);
        vo.setCantidad(cantidad);
        
        dao.Modificar_ProductoVO2(vo);
     
    
   
    }
    
    
    
    public void recibirDatos(){
        Productos producto = new Productos();
        System.out.println("No Entró if");
        if(campoVacioId_V() && campoVacioNombre() && campoVacioDescripcion()  && campoVacioPrecio() && campoNumericoValidoPrecio() ){
        System.out.println("Entró if");
        int id = Integer.parseInt(tf1_id.getText());
        String nombre = tf2_nombre.getText();
        String tipo = (String) tf3_tipo.getText();
        String descripcion = ta1.getText();
        int precio = Integer.parseInt(tf4_precio.getText());
        String cantidad = (String) tf5_cantidad.getText();
            //File ruta = new File (vpv.txtRuta.getText());
            //this.agregarProducto(id_V, nombre, tipo, descripcion, precio, stock, ruta);
            this.modificar2(nombre, tipo,descripcion,precio ,id,cantidad);
        }
    }
    
    private boolean campoVacioId_V(){
        String errorMessage = "";
        if(tf1_id.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo Id está vacío, verifica el campo", "Error", JOptionPane.WARNING_MESSAGE);
        }
                
        if(errorMessage.length() == 0){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean campoVacioNombre(){
        String errorMessage = "";
        if(tf2_nombre.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo Id está vacío, verifica el campo", "Error", JOptionPane.WARNING_MESSAGE);
        }
                
        if(errorMessage.length() == 0){
            return true;
        }else{
            return false;
        }
    }
    
    /*private boolean tipo(){
        String errorMessage = "";
        if(tf3_tipo.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo tipo está vacío, verifica el campo", "Error", JOptionPane.WARNING_MESSAGE);
        }
                
        if(errorMessage.length() == 0){
            return true;
        }else{
            return false;
        }
    }*/
     
     /*private boolean stock(){
        String errorMessage = "";
        if(tf5_cantidad.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo Stock está vacío, verifica el campo", "Error", JOptionPane.WARNING_MESSAGE);
        }
                
        if(errorMessage.length() == 0){
            return true;
        }else{
            return false;
        }
    }*/
     
    private boolean campoVacioDescripcion(){
        String errorMessage = "";
        if(ta1.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo descripción está vacío, verifica el campo", "Error", JOptionPane.WARNING_MESSAGE);
        }
                
        if(errorMessage.length() == 0){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean campoVacioPrecio(){
        String errorMessage = "";
        if(tf4_precio.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo precio está vacío, verifica el campo", "Error", JOptionPane.WARNING_MESSAGE);
        }
                
        if(errorMessage.length() == 0){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean campoNumericoPrecio(){
        boolean numero = false;
        String precio = tf4_precio.getText();
        for(int i = 0;i<precio.length();i++){
            if(precio.charAt(i) == '1' || precio.charAt(i) == '2'|| precio.charAt(i) == '3' ||
                    precio.charAt(i) == '4' || precio.charAt(i) == '5' || precio.charAt(i) == '6' ||
                    precio.charAt(i) == '7' || precio.charAt(i) == '8' || precio.charAt(i) == '9'){
                numero = true;
                break;
            }
        }
        return numero;
    }
    
    private boolean campoNumericoValidoPrecio(){
        String errorMessage = "";
        if(this.campoNumericoPrecio() == false){
            JOptionPane.showMessageDialog(null, "El campo precio solo debe tener numeros, verifica el campo", "Error", JOptionPane.WARNING_MESSAGE);
        }      
        if(errorMessage.length() == 0){
            return true;
        }else{
            return false;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton b1;
    public javax.swing.JButton b2;
    public javax.swing.JButton b3;
    public javax.swing.JButton b4;
    public javax.swing.JButton b5;
    private javax.swing.JLabel cantidad;
    private javax.swing.JLabel costo;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JLabel logo;
    private javax.swing.JLabel nombre;
    public javax.swing.JLabel producto;
    private javax.swing.JLabel ta1;
    public javax.swing.JTable tabla;
    private javax.swing.JLabel tf1_id;
    private javax.swing.JLabel tf2_nombre;
    private javax.swing.JLabel tf3_tipo;
    private javax.swing.JLabel tf4_precio;
    private javax.swing.JLabel tf5_cantidad;
    private javax.swing.JLabel tipo;
    private javax.swing.JLabel txtfoto;
    // End of variables declaration//GEN-END:variables

   
}
