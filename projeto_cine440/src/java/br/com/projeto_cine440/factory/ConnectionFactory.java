<<<<<<< HEAD:projeto_cine440/src/java/br/com/projeto_cine440/factory/ConnectionFactory.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_cine440.factory;
=======

package br.com.cine_440.factory;
>>>>>>> 99b1d6e2b0843d03b7b20f01e2cf2bfeb1ef9b71:cine_440/src/java/br/com/cine_440/factory/ConnectionFactory.java

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
