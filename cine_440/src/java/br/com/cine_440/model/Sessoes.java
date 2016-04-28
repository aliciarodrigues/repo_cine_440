package br.com.cine_440.model;
public class Sessoes {
    private int id_filmes;
    private String filmes;
    private String hora;
    private double precos;

    public int getId_filmes() {
        return id_filmes;
    }

    public void setId_filmes(int id_filmes) {
        this.id_filmes = id_filmes;
    }

    public String getFilmes() {
        return filmes;
    }

    public void setFilmes(String filmes) {
        this.filmes = filmes;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getPrecos() {
        return precos;
    }

    public void setPrecos(double precos) {
        this.precos = precos;
    }
}
