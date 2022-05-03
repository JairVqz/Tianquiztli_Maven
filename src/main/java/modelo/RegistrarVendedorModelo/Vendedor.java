package modelo.RegistrarVendedorModelo;

public class Vendedor {
    int id_V;
    String nombreV;
    String contraseñaV;
    String ciudad;
    String nombre_negocio;

    public Vendedor() {
    }

    public Vendedor(int id_V, String nombreV, String contraseñaV, String ciudad, String nombre_negocio) {
        this.id_V = id_V;
        this.nombreV = nombreV;
        this.contraseñaV = contraseñaV;
        this.ciudad = ciudad;
        this.nombre_negocio = nombre_negocio;
    }

    public int getId_V() {
        return id_V;
    }

    public String getNombreV() {
        return nombreV;
    }

    public String getContraseñaV() {
        return contraseñaV;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getNombre_negocio() {
        return nombre_negocio;
    }

    public void setId_V(int id_V) {
        this.id_V = id_V;
    }

    public void setNombreV(String nombreV) {
        this.nombreV = nombreV;
    }

    public void setContraseñaV(String contraseñaV) {
        this.contraseñaV = contraseñaV;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setNombre_negocio(String nombre_negocio) {
        this.nombre_negocio = nombre_negocio;
    }
}
