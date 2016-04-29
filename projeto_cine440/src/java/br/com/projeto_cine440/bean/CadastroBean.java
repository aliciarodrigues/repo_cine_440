package br.com.projeto_cine440.bean;

import br.com.projeto_cine440.dao.CadastroDAO;
import br.com.projeto_cine440.model.Cadastro;
import br.com.projeto_cine440.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBCadastro")
@ViewScoped
public class CadastroBean {
    
    private Cadastro cadastro;
    private ArrayList<Cadastro> itens;

    public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    

    public ArrayList<Cadastro> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Cadastro> itens) {
        this.itens = itens;
    }

    @PostConstruct
    public void prepararPesquisar() {
        try {
            CadastroDAO dao = new CadastroDAO();
            itens = dao.listar();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void prepararCadastro() {
        cadastro = new Cadastro();
    }

    public void novoCadastro() {
        try {
            CadastroDAO dao = new CadastroDAO();
            dao.salvar(cadastro);
            itens = dao.listar();
            JSFUtil.addMsgSucesso("Cadastro salvo com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }
    }

    public void excluirCadastro() {
        try {
            CadastroDAO dao = new CadastroDAO();
            dao.excluir(cadastro);
            itens = dao.listar();
            JSFUtil.addMsgSucesso("Cadastro excluido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }
    }

    public void editarCadastro() {
        try {
            CadastroDAO dao = new CadastroDAO();
            dao.editar(cadastro);
            itens = dao.listar();
            JSFUtil.addMsgSucesso("Cadastro alterado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }
    }
}

