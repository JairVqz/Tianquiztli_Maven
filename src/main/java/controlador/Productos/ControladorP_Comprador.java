package controlador.Productos;

import modelo.VisualizarProducto.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.Productos.VisualizarProductos;
import vista.Productos.VisualizarProductosVendedor;
public class ControladorP_Comprador {
    ProductoDAO_Comprador dao;
     VisualizarProductos vp;
     VisualizarProductosVendedor vpv;

    public ControladorP_Comprador(VisualizarProductos vp) {
        this.vp = vp;
    }
    
    public ControladorP_Comprador(VisualizarProductosVendedor vpv) {
        this.vpv = vpv;
    }

    public ControladorP_Comprador() {
    }
     
     
     public void visualizar_ProductoCompradorVO(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("ID VENDEDOR");
        dt.addColumn("NOMBRE");
        dt.addColumn("ID PRODUCTO");
        dt.addColumn("TIPO");
        dt.addColumn("DESCRIPCION");
        dt.addColumn("PRECIO");
        dt.addColumn("STOCK");
        dt.addColumn("IMAGEN");

        dao = new ProductoDAO_Comprador();
        Productos_Comprador vo = new Productos_Comprador();
        ArrayList<Productos_Comprador> list = dao.Listar_ProductoVO();  //Aqui elegimos la tabla

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[8];
                vo = list.get(i);
                fila[0] = vo.getIdV();
                fila[1] = vo.getNombre();
                fila[2] = vo.getId();
                fila[3] = vo.getTipo();
                fila[4] = vo.getDescripcion();
                fila[5] = vo.getPrecio();
                fila[6] = vo.getStock();
                try{
                    byte[] bi = vo.getImagen();
                    BufferedImage img = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    img = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(img);
                    fila[7] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[7] = new JLabel("No hay imagen");
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
    }
     
     
     
    
     public void vArtesania(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("ID VENDEDOR");
        dt.addColumn("NOMBRE");
        dt.addColumn("ID PRODUCTO");
        dt.addColumn("TIPO");
        dt.addColumn("DESCRIPCION");
        dt.addColumn("PRECIO");
        dt.addColumn("STOCK");
        dt.addColumn("IMAGEN");

        dao = new ProductoDAO_Comprador();
        Productos_Comprador vo = new Productos_Comprador();
        ArrayList<Productos_Comprador> list = dao.Listar_Artesanias();  //Aqui elegimos la tabla

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[7];
                vo = list.get(i);
                fila[0] = vo.getIdV();
                fila[1] = vo.getNombre();
                fila[2] = vo.getId();
                fila[3] = vo.getTipo();
                fila[4] = vo.getDescripcion();
                fila[5] = vo.getPrecio();
                fila[6] = vo.getStock();
                try{
                    byte[] bi = vo.getImagen();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    fila[7] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[7] = new JLabel("No imagen");
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
    }
    
     
     
     
     public void vAccesorio(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("ID VENDEDOR");
        dt.addColumn("NOMBRE");
        dt.addColumn("ID PRODUCTO");
        dt.addColumn("TIPO");
        dt.addColumn("DESCRIPCION");
        dt.addColumn("PRECIO");
        dt.addColumn("STOCK");
        dt.addColumn("IMAGEN");;

        dao = new ProductoDAO_Comprador();
        Productos_Comprador vo = new Productos_Comprador();
        ArrayList<Productos_Comprador> list = dao.Listar_Accesorios();  //Aqui elegimos la tabla

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[7];
                vo = list.get(i);
                fila[0] = vo.getIdV();
                fila[1] = vo.getNombre();
                fila[2] = vo.getId();
                fila[3] = vo.getTipo();
                fila[4] = vo.getDescripcion();
                fila[5] = vo.getPrecio();
                fila[6] = vo.getStock();
                try{
                    byte[] bi = vo.getImagen();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    fila[7] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[7] = new JLabel("No imagen");
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
    }
     
     
     
     public void vComida(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("ID VENDEDOR");
        dt.addColumn("NOMBRE");
        dt.addColumn("ID PRODUCTO");
        dt.addColumn("TIPO");
        dt.addColumn("DESCRIPCION");
        dt.addColumn("PRECIO");
        dt.addColumn("STOCK");
        dt.addColumn("IMAGEN");

        dao = new ProductoDAO_Comprador();
        Productos_Comprador vo = new Productos_Comprador();
        ArrayList<Productos_Comprador> list = dao.Listar_Comida();  //Aqui elegimos la tabla

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[7];
                vo = list.get(i);
                fila[0] = vo.getIdV();
                fila[1] = vo.getNombre();
                fila[2] = vo.getId();
                fila[3] = vo.getTipo();
                fila[4] = vo.getDescripcion();
                fila[5] = vo.getPrecio();
                fila[6] = vo.getStock();
                try{
                    byte[] bi = vo.getImagen();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    fila[7] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[7] = new JLabel("No imagen");
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
    }
     
     
     public void vBebida(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        dt.addColumn("ID VENDEDOR");
        dt.addColumn("NOMBRE");
        dt.addColumn("ID PRODUCTO");
        dt.addColumn("TIPO");
        dt.addColumn("DESCRIPCION");
        dt.addColumn("PRECIO");
        dt.addColumn("STOCK");
        dt.addColumn("IMAGEN");

        dao = new ProductoDAO_Comprador();
        Productos_Comprador vo = new Productos_Comprador();
        ArrayList<Productos_Comprador> list = dao.Listar_Bebidas();  //Aqui elegimos la tabla

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[7];
                vo = list.get(i);
                fila[0] = vo.getIdV();
                fila[1] = vo.getNombre();
                fila[2] = vo.getId();
                fila[3] = vo.getTipo();
                fila[4] = vo.getDescripcion();
                fila[5] = vo.getPrecio();
                fila[6] = vo.getStock();
                try{
                    byte[] bi = vo.getImagen();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    fila[7] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[7] = new JLabel("No imagen");
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
    }
}
