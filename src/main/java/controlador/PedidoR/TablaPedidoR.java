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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Aridai
 */
public class TablaPedidoR {
    
    String id;
    PedidoRDAO dao = null;
    VisualizarPedidoR vpr;
    PedidoR r;

    public TablaPedidoR(VisualizarPedidoR vpr) {
        this.vpr = vpr;
    }

    public TablaPedidoR() {
    }
    
    
    
    


    public void visualizar_PedidoVO(JTable tabla, int id){

        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("ID_Pe");
        dt.addColumn("ID_C");
        dt.addColumn("ID_R");
        dt.addColumn("NombreC");
        dt.addColumn("Estado");
        dt.addColumn("Direccion");
        dt.addColumn("Productos");
        dt.addColumn("Total");
        
        

        dao = new PedidoRDAO();
        PedidoR vo = new PedidoR();
        ArrayList<PedidoR> list = dao.Listar_PedidoVO(id);

        if(list.size() > 0){
            
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[8];
                vo = list.get(i);
                fila[0] = vo.getIdP();
                fila[1] = vo.getIdC();
                fila[2] = vo.getIdR();
                fila[3] = vo.getNombre();
                fila[4] = vo.getEstado();
                fila[5] = vo.getDireccion();
                fila[6] = vo.getProductos();
                fila[7] = vo.getTotal();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
    }
    
    
    
    public void cancelar_PedidoVO(String id ){
        
        //System.out.print("Paso aqui");
        System.out.print(id);
      
        int r1 = dao.Cancelar_PedidoVO(id);
        if(r1==1){
            JOptionPane.showMessageDialog(vpr, "Pedido cancelado!!");
        }else{
            JOptionPane.showMessageDialog(vpr, "Error");
        }

    }
    
    public void aceptar_PedidoVO(String id ){
        
        //System.out.print("Paso aqui");
        System.out.print(id);
      
        int r1 = dao.Aceptar_PedidoVO(id);
        if(r1==1){
            JOptionPane.showMessageDialog(vpr, "Pedido aceptado!!");
        }else{
            JOptionPane.showMessageDialog(vpr, "Error");
        }

    }
    
    public void entregado_PedidoVO(String id ){
        
        //System.out.print("Paso aqui");
        System.out.print(id);
      
        int r1 = dao.Entregado_PedidoVO(id);
        if(r1==1){
            JOptionPane.showMessageDialog(vpr, "Pedido entregado!!");
        }else{
            JOptionPane.showMessageDialog(vpr, "Error");
        }

    }
}
