package br.com.projeto_cine440.bean;

import br.com.projeto_cine440.dao.SessaoDAO;
import br.com.projeto_cine440.model.Sessoes;
import br.com.projeto_cine440.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBsessoes")
@ViewScoped
public class SessoesBean {
    
    private Sessoes sessao;
    private ArrayList<Sessoes> itens;

    public Sessoes getSessao() {
        return sessao;
    }

    public void setSessao(Sessoes sessao) {
        this.sessao = sessao;
    }

    public ArrayList<Sessoes> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Sessoes> itens) {
        this.itens = itens;
    }

    @PostConstruct
    public void prepararPesquisar() {
        try {
            SessaoDAO dao = new SessaoDAO();
            itens = dao.listar();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void prepararSessao() {
        sessao = new Sessoes();
    }

    public void novaSessao() {
        try {
            SessaoDAO dao = new SessaoDAO();
            dao.salvar(sessao);
            itens = dao.listar();
            JSFUtil.addMsgSucesso("Sessão salva com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }
    }

    public void excluirSessao() {
        try {
            SessaoDAO dao = new SessaoDAO();
            dao.excluir(sessao);
            itens = dao.listar();
            JSFUtil.addMsgSucesso("Produto excluido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }
    }

    public void editarSessao() {
        try {
            SessaoDAO dao = new SessaoDAO();
            dao.editar(sessao);
            itens = dao.listar();
            JSFUtil.addMsgSucesso("Sessão alterada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }
    }
}
