package br.com.cine_440.dao;

import br.com.cine_440.factory.ConnectionFactory;
import br.com.cine_440.model.Sessoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SessaoDao {
    public void salvar(Sessoes f) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO sessoes (filmes,hora,precos) VALUES(?,?,?)";
        Connection connection = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, f.getFilmes());
            stmt.setString(2, f.getHora());
            stmt.setDouble(3, f.getPrecos());
            stmt.execute();
        }
    }

    public void excluir(Sessoes f) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM sessoes  WHERE id_filmes = ?";
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, f.getId_filmes());
        stmt.execute();
        stmt.close();
    }

    public void editar(Sessoes f) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE sessoes SET filmes = ?,hora = ?,precos = ? WHERE id_filmes = ?";
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, f.getFilmes());
        stmt.setString(2, f.getHora());
        stmt.setDouble(3, f.getPrecos());
        stmt.setInt(4, f.getId_filmes());
        stmt.execute();
        stmt.close();
    }

    public Sessoes pesquisar(Sessoes f) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM sessoes WHERE id_filmes = ? ";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, f.getId_filmes());

        ResultSet rs = stmt.executeQuery();
        Sessoes retorno = null;

        if (rs.next()) {
            retorno = new Sessoes();
            retorno.setId_filmes(rs.getInt("id_ed"));
            retorno.setFilmes(rs.getString("filmes"));
            retorno.setHora(rs.getString("hora"));
            retorno.setPrecos(rs.getDouble("precos"));
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
        Sessoes f1 = new Sessoes();
        f1.setId_filmes(3);
        Sessoes f2 = new Sessoes();
        f2.setId_filmes(2);

        SessaoDao fdao = new SessaoDao();
        try {
            Sessoes f3 = fdao.pesquisar(f1);
            Sessoes f4 = fdao.pesquisar(f2);
            System.out.println("Resultado 1: " + f3);
            System.out.println("Resultado 2: " + f4);
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar a editora.");
            e.printStackTrace();
        }
    }

    public ArrayList<Sessoes> listar()
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM sessoes";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Sessoes> lista = new ArrayList<Sessoes>();
        while (rs.next()) {
            Sessoes e = new Sessoes();
            e.setId_filmes(rs.getInt("id_filmes"));
            e.setFilmes(rs.getString("filmes"));
            e.setHora(rs.getString("hora"));
            e.setPrecos(rs.getDouble("precos"));
            lista.add(e);
        }
        return lista;
    }
}
