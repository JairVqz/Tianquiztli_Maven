package tianquiztli;

import controlador.Productos.ControladorP;
import controlador.PedidoR.TablaPedidoR;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConexionBD;
import vista.Productos.VisualizarProductos;
import vista.Productos.VisualizarProductosVendedor;
import vista.Repartidor.VisualizarPedidoR;

public class VentanaLogin extends javax.swing.JFrame {
    
    ConexionBD conectar = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public VentanaLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        userTxt = new javax.swing.JTextField();
        ISbtn = new javax.swing.JButton();
        Regisbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        passF = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        userTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        ISbtn.setBackground(new java.awt.Color(0, 153, 153));
        ISbtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        ISbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder-home-4341294_120570.png"))); // NOI18N
        ISbtn.setText("Iniciar Sesión");
        ISbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISbtnActionPerformed(evt);
            }
        });

        Regisbtn.setBackground(new java.awt.Color(66, 187, 25));
        Regisbtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Regisbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder-inbox-4341297_120539.png"))); // NOI18N
        Regisbtn.setText("Registrarse");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoTian.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setText("¡Mah cualli xihualacan!");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder-key-4341299_120569.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder-lock-4341303_120563.png"))); // NOI18N

        passF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(passF, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(ISbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Regisbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(75, 75, 75))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(userTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(passF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(ISbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Regisbtn)
                        .addGap(48, 48, 48))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ISbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISbtnActionPerformed
           validarUsuario();
    }//GEN-LAST:event_ISbtnActionPerformed

        public void validarUsuario(){
        
        int resultado= 0;
        String usuario=userTxt.getText();
        String contraseña=passF.getText();
        String SQL="select * from comprador where nombreC= '"+usuario+"' and contraseñaC= '"+contraseña + "'";
        
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
               
            }else{
                ps=con.prepareStatement("select * from vendedor where nombreV= '"+usuario+"' and contraseñaV= '"+contraseña+ "'");
                rs=ps.executeQuery();
                
                if(rs.next()){
                    
                    VisualizarProductosVendedor vpv = new VisualizarProductosVendedor();
               
               ControladorP cpz = new ControladorP(vpv);
               this.setVisible(false);
               vpv.setVisible(true);
               vpv.setLocationRelativeTo(null);

                }else{
                   JOptionPane.showMessageDialog(null,"Datos incorrectos");  
                }
            }
                ps=con.prepareStatement("select * from repartidor where nombreR='"+usuario+"' and contraseñaR='"+contraseña+"'");
                rs=ps.executeQuery();
            if(rs.next()){
                VisualizarPedidoR vpr = new VisualizarPedidoR();
               
               TablaPedidoR tp = new TablaPedidoR(vpr);
               this.setVisible(false);
               vpr.setVisible(true);
               vpr.setLocationRelativeTo(null);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(VentanaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       /* try{
            
            con=conectar.getConnection();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            
            if (rs.next()) {
                resultado=1;
                
                if(resultado==1 && rs.getString("tipUser").equals("comprador")){
                    VentanPedidosCom vntpc = new VentanPedidosCom();
                    controladorPC cpc = new controladorPC(vntpc);
                    this.setVisible(false);
                    vntpc.setVisible(true);
                    vntpc.setLocationRelativeTo(null);
                }
                
                if(resultado==1 && rs.getString("tipUser").equals("vendedor")){
                    VentanaVendedorPrueba vvp = new VentanaVendedorPrueba();
                    Controlador pc = new Controlador(cped);
                    this.setVisible(false);
                    vvp.setVisible(true);
                    vvp.setLocationRelativeTo(null);
                }
            }else{
                JOptionPane.showMessageDialog(null,"ACCESO DENEGADO");
            }
            
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null,"Error de conexion " + e.getMessage());
        } */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ISbtn;
    public javax.swing.JButton Regisbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPasswordField passF;
    public javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
