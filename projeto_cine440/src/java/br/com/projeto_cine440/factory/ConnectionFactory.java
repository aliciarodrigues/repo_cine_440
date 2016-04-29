
package br.com.projeto_cine440.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    public static Connection getConnection() throws ClassNotFoundException{
    String url ="jdbc:mysql://localhost/projeto_cine440";
        String uid = "root";
        String pass = "0890";
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
