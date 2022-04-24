/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.PedidoR;

import modelo.PedidoR.PedidoR;
import modelo.PedidoR.Render;
import modelo.PedidoR.PedidoRDAO;
import vista.Repartidor.VisualizarPedidoR;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aridai
 */
public class TablaPedidoR {
    PedidoRDAO dao = null;
    VisualizarPedidoR vpr;

    public TablaPedidoR(VisualizarPedidoR vpr) {
        this.vpr = vpr;
    }

    public TablaPedidoR() {
    }
    
    
    
    


    public void visualizar_ProductoVO(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("id_Pe");
        dt.addColumn("id_C");
        dt.addColumn("estado");
        dt.addColumn("direccion");
        dt.addColumn("productos");

        dao = new PedidoRDAO();
        PedidoR vo = new PedidoR();
        ArrayList<PedidoR> list = dao.Listar_ProductoVO();

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[5];
                vo = list.get(i);
                fila[0] = vo.getIdP();
                fila[1] = vo.getIdC();
                fila[2] = vo.getEstado();
                fila[3] = vo.getDireccion();
                fila[4] = vo.getProductos();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
    }
}
