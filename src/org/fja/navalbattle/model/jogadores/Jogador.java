package org.fja.navalbattle.model.jogadores;

import org.fja.navalbattle.model.cenario.Disparo;
import org.fja.navalbattle.model.cenario.Tabuleiro;
import org.fja.navalbattle.model.partida.Partida;
import org.fja.navalbattle.model.templates.Template;

public abstract class Jogador {
 
	private String nome;
	 
	private Tabuleiro tabuleiroOponente;
	 
	private Tabuleiro tabuleiroJogador;

    protected boolean[][] matrizGuia;

    private Partida partida;

	public Jogador(String nome, Template template) {
        tabuleiroJogador = new Tabuleiro();
        tabuleiroJogador.aplicarTemplate(template);
        setNome(nome);
        matrizGuia = new boolean[10][10];
	}
	 
	public abstract void jogar();
	 
	public Tabuleiro getTabuleiro() {
		return tabuleiroJogador;
	}
	 
	public void setTabuleiroOponente(Tabuleiro tabuleiroOponente) {
        this.tabuleiroOponente = tabuleiroOponente;
	}

    public Tabuleiro getTabuleiroOponente() {
        return tabuleiroOponente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void jogar(int x, int y) {

        Disparo disparo = new Disparo(x, y);

        if (matrizGuia[x][y] != true) {
            Disparo resultadoDisparo = getTabuleiroOponente().recebeDisparo(disparo);

            matrizGuia[x][y] = true;

            notificaJogada();
        }
    }

    public void registraPartida(Partida partida) {
        this.partida = partida;
    }

    public void notificaJogada() {
        partida.notificaJogada();
    }
	 
}
 
