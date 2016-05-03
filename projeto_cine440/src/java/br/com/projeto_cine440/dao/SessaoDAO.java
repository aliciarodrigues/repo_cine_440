package br.com.projeto_cine440.dao;

import br.com.projeto_cine440.factory.ConnectionFactory;
import br.com.projeto_cine440.model.Sessoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SessaoDAO {
    
    public void salvar(Sessoes s)
            throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO sessoes (filmes, precos, horario,id_sessao) VALUES (?,?,?,?)";

        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, s.getFilmes());
        stmt.setDouble(2, s.getPreco());
        stmt.setTime(3, s.getHorario());
        stmt.setInt(3, s.getId_sessao());
        stmt.execute();
        stmt.close();
    }

    public void excluir(Sessoes s)
            throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM sessoes WHERE id_sessao = ? ";

        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, s.getId_sessao());
        stmt.execute();
        stmt.close();
    }

    public void editar(Sessoes s)
            throws ClassNotFoundException, SQLException {
        String sql = "UPDATE sessao SET filmes = ?, preco = ?, horario = ?";

        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, s.getFilmes());
        stmt.setDouble(2, s.getPreco());
        stmt.setTime(3, s.getHorario());
        stmt.execute();
        stmt.close();
    }

    public Sessoes pesquisar(Sessoes s)
            throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM sessoes WHERE id_sessao = ? ";

        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, s.getId_sessao());

        ResultSet rs = stmt.executeQuery();

        Sessoes retorno = null;

        if (rs.next()) {
            retorno = new Sessoes();
            retorno.setId_sessao(rs.getInt("id_sesssao"));
        }
        return retorno;
    }

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {
        Sessoes s1 = new Sessoes();
        s1.setId_sessao(1);
        Sessoes s2 = new Sessoes();
        s2.setId_sessao(2);

        SessaoDAO sdao = new SessaoDAO();

        try {
            Sessoes s3 = sdao.pesquisar(s1);
            Sessoes s4 = sdao.pesquisar(s2);

            System.out.println("Resultado 1:" + s3);
            System.out.println("Resultado 2:" + s4);
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar a sessão.");
            e.printStackTrace();
        }
    }

    public ArrayList<Sessoes> listar() throws SQLException, ClassNotFoundException {
        String sql = "select from sessao id_sessao, filmes, preco, horario";

        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = connection.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        ArrayList<Sessoes> lista = new ArrayList<Sessoes>();

        while (rs.next()) {
            Sessoes s = new Sessoes();
            s.setId_sessao(rs.getInt("id_sessao"));
            s.setFilmes(rs.getString("filmes"));
            s.setPreco(rs.getDouble("preco"));
            s.setHorario(rs.getTime("horario"));
            lista.add(s);

        }
        return lista;
    }
}
