package tianquiztli;

import controlador.Productos.ControladorP;
import controlador.PedidoR.TablaPedidoR;
import controlador.RegistrarCompradorControlador.CompradorControlador;
import controlador.RegistrarVendedorControlador.VendedorControlador;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConexionBD;
import modelo.RegistrarCompradorModelo.CompradorDAO;
import modelo.RegistrarVendedorModelo.VendedorDAO;
import vista.Productos.VisualizarProductos;
import vista.Productos.VisualizarProductosVendedor;
import vista.RegistrarCompradorVista.RegistrarComprador;
import vista.RegistrarVendedorVista.RegistrarVendedor;
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbUser = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        userTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        ISbtn.setBackground(new java.awt.Color(0, 153, 153));
        ISbtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        ISbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/iconfinder-home-4341294_120570.png"))); // NOI18N
        ISbtn.setText("Iniciar Sesión");
        ISbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISbtnActionPerformed(evt);
            }
        });

        Regisbtn.setBackground(new java.awt.Color(66, 187, 25));
        Regisbtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Regisbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/iconfinder-inbox-4341297_120539.png"))); // NOI18N
        Regisbtn.setText("Registrarse");
        Regisbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisbtnActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/LogoTian.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setText("¡Mah cualli xihualacan!");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/iconfinder-key-4341299_120569.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/iconfinder-lock-4341303_120563.png"))); // NOI18N

        passF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setText("Contraseña");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setText("Nombre de usuario");

        cbUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Comprador" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(passF, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel4))
                                        .addComponent(ISbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(Regisbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(passF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ISbtn)
                        .addGap(18, 18, 18)
                        .addComponent(Regisbtn)
                        .addGap(18, 18, 18)
                        .addComponent(cbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ISbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISbtnActionPerformed
           validarUsuario();
    }//GEN-LAST:event_ISbtnActionPerformed

    private void RegisbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisbtnActionPerformed
        String userReg;
        userReg = (String)cbUser.getSelectedItem();
        if("Vendedor".equals(userReg)){
            RegistrarVendedor vtnR = new RegistrarVendedor();
            VendedorDAO vendedorDAO = new VendedorDAO();
            VendedorControlador venCon = new VendedorControlador(vendedorDAO, vtnR);
            vtnR.setVisible(true);
            this.setVisible(false);
            vtnR.setLocationRelativeTo(null);
        }else{
            if("Comprador".equals(userReg)){
                RegistrarComprador vtnC = new RegistrarComprador();
                CompradorDAO compradorDAO = new CompradorDAO();
                CompradorControlador cprCtr = new CompradorControlador(compradorDAO, vtnC);
                vtnC.setVisible(true);
                this.setVisible(false);
                vtnC.setLocationRelativeTo(null);
            }
        }
    }//GEN-LAST:event_RegisbtnActionPerformed

        public void validarUsuario(){
        
        int resultado= 0;
        int id = 0;
        int idR = 0;
        String usuario=userTxt.getText();
        String contraseña=passF.getText();
        String SQL="select * from comprador where nombreC= '"+usuario+"' and contraseñaC= '"+contraseña + "'";
        
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            
            if(rs.next()){
               VisualizarProductos vp = new VisualizarProductos();
               vp.l_usuario.setText(usuario);
               
               ControladorP cpz = new ControladorP(vp);
               this.setVisible(false);
               vp.setVisible(true);
               vp.setLocationRelativeTo(null);
               
            }else{
                ps=con.prepareStatement("select * from vendedor where nombreV= '"+usuario+"' and contraseñaV= '"+contraseña+ "'");
                rs=ps.executeQuery();
                
                if(rs.next()){
                    id = rs.getInt("id_V");
                    VisualizarProductosVendedor vpv = new VisualizarProductosVendedor();
                    
                    vpv.l_user.setText(usuario);
                    vpv.l_id.setText(String.valueOf(id));
               
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
                idR = rs.getInt("id_R");
                VisualizarPedidoR vpr = new VisualizarPedidoR();
                
                vpr.l_repartidor.setText(usuario);
                vpr.l_idRepartidor.setText(String.valueOf(idR));
               
               TablaPedidoR tp = new TablaPedidoR(vpr);
               this.setVisible(false);
               vpr.setVisible(true);
               vpr.setLocationRelativeTo(null);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(VentanaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ISbtn;
    public javax.swing.JButton Regisbtn;
    public javax.swing.JComboBox<String> cbUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPasswordField passF;
    public javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
