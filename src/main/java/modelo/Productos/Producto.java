package modelo.Productos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jair1
 */
public class Producto {
    /*Todo los atributos*/
    public int id_P;
    public int id_V;
    public String nombre;
    public String tipo;
    public String descripcion;
    public int precio;
    public String stock;
    private byte[] foto;
    public int cantidad;
    public int total;
    
    public Producto(){}
    
    public Producto(int id_V, String nombre, String descripcion, int cantidad, int precio, int total){
        this.id_V = id_V;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

/*Todo los codigos get*/
    public int getId_P(){
        return id_P;
    }
    public int getId_V(){
        return id_V;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTipo(){
        return tipo;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public int getPrecio(){
        return precio;
    }
    public String getStock(){
        return stock;
    }
    public int getCantidad(){
        return cantidad;
    }
    public int getTotal(){
        return total;
    }


/*Todo los codigos set*/
    public void setId_P(int id_P){
        this.id_P = id_P;
    }
    public void setId_V(int id_V){
        this.id_V = id_V;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setPrecio(int precio){
        this.precio = precio;
    }
    public void setStock(String stock){
        this.stock = stock;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public void setTotal(int total){
        this.total = total;
    }

    /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
}
