/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jair1
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    // Librería de MySQL
    public String driver = "com.mysql.cj.jdbc.Driver";
    // Nombre de la base de datos
    public String database = "tianquiztli";
    // Host
    public String hostname = "192.168.64.2";
    // Puerto
    public String port = "3306";
    //Rura a nuestra base de datos
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "";
       
    public ConexionBD() {
        this.hostname = "192.168.64.2";
        this.port = "3306";
        this.database = "tianquiztli";
        this.username = "root";
        this.password = "";

        this.driver = "com.mysql.cj.jdbc.Driver";
        this.url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

    }
    
    public Connection getConnection() throws Exception{
       
        try {
            Class.forName(driver);
            System.out.println("CONECTADO");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            throw new Exception("Error en ConexionDB. La causa es: " + ex.getCause().toString());
        }
        
    }    
}
