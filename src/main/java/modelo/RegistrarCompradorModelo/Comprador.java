package modelo.RegistrarCompradorModelo;

public class Comprador {
    int id_C;
    String nombreC;
    String contraseñaC;
    String dirección;

    public Comprador() {
    }

    public Comprador(int id_C, String nombreC, String contraseñaC, String dirección) {
        this.id_C = id_C;
        this.nombreC = nombreC;
        this.contraseñaC = contraseñaC;
        this.dirección = dirección;
    }

    public int getId_C() {
        return id_C;
    }

    public String getNombreC() {
        return nombreC;
    }

    public String getContraseñaC() {
        return contraseñaC;
    }

    public String getDirección() {
        return dirección;
    }

    public void setId_C(int id_C) {
        this.id_C = id_C;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public void setContraseñaC(String contarseñaC) {
        this.contraseñaC = contarseñaC;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }
}
