package org.fja.navalbattle.model.jogadores;

import java.io.Serializable;
import org.fja.exceptions.AtribuicaoUnicaException;
import org.fja.navalbattle.model.BatalhaNaval;
import org.fja.navalbattle.model.cenario.Disparo;
import org.fja.navalbattle.model.cenario.Tabuleiro;
import org.fja.navalbattle.model.partida.Partida;
import org.fja.navalbattle.model.templates.Template;

/**
 * Abstração de jogador. Forne interface para criação de jogadores
 * @author Diego Fleury
 */
public abstract class Jogador implements Serializable {

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
	 * Template do tabuleiro do jogador
	 */
	private Template template;

	/**
	 * Informa se o jogador já posicionou todas as peças ou não
	 */
	private boolean estaPosicionado = false;

    /**
     * Inicializa o tabuleiro
     */
	protected void inicializaTabuleiro()
			throws AtribuicaoUnicaException {
        if (tabuleiroJogador == null) {
            tabuleiroJogador = new Tabuleiro();
        } else {
			throw new AtribuicaoUnicaException("Um tabuleiro só pode ser inicializado uma única vez");
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
			
			StringBuilder output = new StringBuilder("Jogador ");
				output.append(this.getNome());
				output.append(" atirou na posicao (");
				output.append(disparo.getX());
				output.append(", ");
				output.append(disparo.getY());
				output.append(")");
			
			System.out.print(output.toString());

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

	/**
	 * Libera para que o jogador posicione seus navios no template
	 */
	public abstract void posicionarArsenal();

	/**
	 * Retorna o template do jogador
	 * @return Template do jogador
	 */
	public Template getTemplate() {
		return template;
	}

	/**
	 * Inicia o jogador com um template montado
	 * @param template Template montado
	 * @throws org.fja.exceptions.AtribuicaoUnicaException
	 */
	public void inicializaTemplate(Template template) throws AtribuicaoUnicaException {
		if (this.template == null) {
			this.template = template;
		} else {
			throw new AtribuicaoUnicaException("Um template só pode ser inicializado uma única vez");
		}
	}

	/**
	 * Determina que o jogador já está pronto para iniciar a partida
	 */
	protected void jogadorPronto() {
		estaPosicionado = true;
		BatalhaNaval.getInstance().travarPosicoes();
	}

	/**
	 * Informa se o jogador já posicionou seu navios
	 * @return Se o jogador já posicionou seu navios
	 */
	public boolean estaPosicionado() {
		return estaPosicionado;
	}
	 
}