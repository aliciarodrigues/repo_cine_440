package br.com.projeto_cine440.dao;

import br.com.projeto_cine440.factory.ConnectionFactory;
import br.com.projeto_cine440.model.Cadastro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastroDAO {
    public void salvar(Cadastro f) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO cadastro (nome,email,senha,endereco,cpf) VALUES(?,?,?,?,?)";
        Connection connection = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getEmail());
            stmt.setString(3, f.getSenha());
            stmt.setString(4,f.getEndereco());
            stmt.setString(5, f.getCpf());
            stmt.execute();
        }
    }

    public void excluir(Cadastro f) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM cadastro  WHERE id = ?";
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, f.getId());
        stmt.execute();
        stmt.close();
    }

    public void editar(Cadastro f) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE cadastro SET email = ?,senha = ? WHERE id = ?";
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, f.getEmail());
        stmt.setString(2, f.getSenha());
        stmt.setInt(3, f.getId());
        stmt.execute();
        stmt.close();
    }

    public Cadastro pesquisar(Cadastro f) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM cadastro WHERE id = ? ";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, f.getId());

        ResultSet rs = stmt.executeQuery();
        Cadastro retorno = null;

        if (rs.next()) {
            retorno = new Cadastro();
            retorno.setId(rs.getInt("id"));
            retorno.setNome(rs.getString("nome"));
            retorno.setEmail(rs.getString("email"));
            retorno.setSenha(rs.getString("senha"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setSenha(rs.getString("cpf"));
        }
        return retorno;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Editora f1 = new Editora();
//        f1.setDescricao("Descrição 1");
//        Fabricante f2 = new Fabricante();
//        f2.setDescricao("Descrição 2");
//        
//        FabricanteDAO fdao = new FabricanteDAO();
//        try{
//            fdao.salvar(f1);
//            fdao.salvar(f2);
//            System.out.println("Fabricante cadastrado com suscesso");
//        }catch(SQLException e){
//            System.out.println("Erro ao tentar salvar o fabricante");
//            e.printStackTrace();
//        }
//       
//        Fabricante f1 = new Fabricante();
//        f1.setCod(2);
//        f1.setDescricao("Descricao 3");
//
//        FabricanteDAO fdao = new FabricanteDAO();
//        try {
//            fdao.editar(f1);
//            System.out.println("Fabricante alterado co sucesso!");
//        } catch (SQLException e) {
//            System.out.println("Erro ao editar o fabricante!");
//            e.printStackTrace();
//        }
        Cadastro f1 = new Cadastro();
        f1.setId(3);
        Cadastro f2 = new Cadastro();
        f2.setId(2);

        CadastroDAO fdao = new CadastroDAO();
        try {
            Cadastro f3 = fdao.pesquisar(f1);
            Cadastro f4 = fdao.pesquisar(f2);
            System.out.println("Resultado 1: " + f3);
            System.out.println("Resultado 2: " + f4);
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar a editora.");
            e.printStackTrace();
        }
    }

    public ArrayList<Cadastro> listar()
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Cadastro";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Cadastro> lista = new ArrayList<Cadastro>();
        while (rs.next()) {
            Cadastro e = new Cadastro();
            e.setId(rs.getInt("id"));
            e.setNome(rs.getString("nome"));
            e.setEmail(rs.getString("email"));
            e.setSenha(rs.getString("senha"));
            e.setEndereco(rs.getString("endereco"));
            e.setCpf(rs.getString("senha"));
            lista.add(e);
        }
        return lista;
    }
}
