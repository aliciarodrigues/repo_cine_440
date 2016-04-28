
package br.com.cine_440.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    public static Connection getConnection() throws ClassNotFoundException{
    String url ="jdbc:mysql://localhost/cine_440";
        String uid = "root";
        String pass = "Senac/321";
        String driver = "com.mysql.jdbc.Driver";
        
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, uid, pass);
        }catch(SQLException e){
            System.out.println("Falha na conexão ao DB");
        }
        return null;
    }  
}
