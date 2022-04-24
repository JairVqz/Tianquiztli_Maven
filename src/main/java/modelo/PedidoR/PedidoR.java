/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PedidoR;

/**
 *
 * @author Aridai
 */
public class PedidoR {
    int idP;
    int idC;
    int idR;
    String estado;
    String direccion;
    String productos;

    public int getIdP() {
        return idP;
    }
    public int getIdC() {
        return idC;
    }
    public int getIdR() {
        return idR;
    }

    public String getEstado() {
        return estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getProductos() {
        return productos;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }
    public void setIdR(int idR) {
        this.idR = idR;
    }
    
    public void setIdC(int idC) {
        this.idC = idC;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

}
