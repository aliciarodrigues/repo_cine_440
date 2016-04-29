
package br.com.projeto_cine440.factory;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão Aberta!");
        connection.close();
    }
}
