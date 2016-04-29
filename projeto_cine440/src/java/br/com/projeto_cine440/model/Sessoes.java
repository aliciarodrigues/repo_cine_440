package br.com.projeto_cine440.model;

import java.sql.Time;

public class Sessoes {
    private int id_sessao;
    private String filmes;
    private double preco;
    private Time horario;

    public int getId_sessao() {
        return id_sessao;
    }

    public void setId_sessao(int id_sessao) {
        this.id_sessao = id_sessao;
    }

    public String getFilmes() {
        return filmes;
    }

    public void setFilmes(String filmes) {
        this.filmes = filmes;
    }
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Time getHorario() {
        return horario;
    }

  
    public void setHorario(Time horario) {
        this.horario = horario;
    }
    
    
}
