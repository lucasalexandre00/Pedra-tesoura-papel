package br.edu.ifsp.dmo.pedratesourapapel.model;

public class Jogador {
    private String nome;
    private int pontos;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontos = 0;
    }

    public void acumularPontos(){
        this.pontos += 1;
    }
    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }
}
