<<<<<<< HEAD:projeto_cine440/src/java/br/com/projeto_cine440/factory/TesteConexao.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_cine440.factory;
=======
package br.com.cine_440.factory;
>>>>>>> 99b1d6e2b0843d03b7b20f01e2cf2bfeb1ef9b71:cine_440/src/java/br/com/cine_440/factory/TesteConexao.java

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão Aberta!");
        connection.close();
    }
}
