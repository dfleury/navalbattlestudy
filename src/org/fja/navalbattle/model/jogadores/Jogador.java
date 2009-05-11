package org.fja.navalbattle.model.jogadores;

import org.fja.navalbattle.model.cenario.Disparo;
import org.fja.navalbattle.model.cenario.Tabuleiro;
import org.fja.navalbattle.model.partida.Partida;
import org.fja.navalbattle.model.templates.Template;

/**
 * Abstração de jogador. Forne interface para criação de jogadores
 * @author Diego Fleury
 */
public abstract class Jogador {

    /**
     * Nome do jogador
     */
	private String nome;

    /**
     * Tabuleiro do jogador
     */
	private Tabuleiro tabuleiroJogador;

    /**
     * Tabuleiro do oponente
     */
	private Tabuleiro tabuleiroOponente;

    /**
     * Matriz com indicação das coordenadas que em que já houve disparo efetuado
     */
    protected boolean[][] matrizGuia;

    /**
     * Referência da partida atual
     */
    private Partida partida;

    /**
     * Inicializa o tabuleiro
     */
	protected void inicializaTabuleiro() {
        if (tabuleiroJogador == null) {
            tabuleiroJogador = new Tabuleiro();
        }
	}

    /**
     * Inicializa a matriz guia
     */
    protected void inicializaMatrizGuia() {
        matrizGuia = new boolean[10][10];
    }

    /**
     * Solicia/aguarda que o jogador faça sua jogada
     */
	public abstract void jogar();

    /**
     * Retorna tabuleiro do jogador
     * @return Tabuleiro do jogador
     */
	public Tabuleiro getTabuleiro() {
		return tabuleiroJogador;
	}

    /**
     * Recebe a referência do tabuleiro do oponente
     * @param tabuleiroOponente Tabuleiro do oponente
     */
	public void setTabuleiroOponente(Tabuleiro tabuleiroOponente) {
        this.tabuleiroOponente = tabuleiroOponente;
	}

    /**
     * Retorna o tabuleiro do oponente
     * @return Tabuleiro do oponente
     */
    public Tabuleiro getTabuleiroOponente() {
        return tabuleiroOponente;
    }

    /**
     * Define o nome do jogador
     * @param nome Nome do jogador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome do jogador
     * @return nome do jogador
     */
    public String getNome() {
        return nome;
    }

    /**
     * Cria um disparo e manda para o tabuleiro do oponente caso seja uma jogada valida.
     * Para ser considerada válida, só pode-se fazer disparos em coordenadas que ainda não foram atacadas
     * @param x Posição horizontal do disparo
     * @param y Posição vertical do disparo
     */
    public void jogar(int x, int y) {

        Disparo disparo = new Disparo(x, y);

        if (matrizGuia[x][y] != true) {
            Disparo resultadoDisparo = getTabuleiroOponente().recebeDisparo(disparo);

            matrizGuia[x][y] = true;

            notificaJogada();
        }
    }

    /**
     * Registra a partida como observador
     * @param partida Partida corrente
     */
    public void registraPartida(Partida partida) {
        this.partida = partida;
    }

    /**
     * Notifica ao observador quem uma jogada foi feita
     */
    public void notificaJogada() {
        partida.notificaJogada();
    }
	 
}