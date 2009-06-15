package org.fja.navalbattle.model.templates;

import java.io.Serializable;
import org.fja.navalbattle.model.cenario.Coordenada;
import org.fja.navalbattle.model.cenario.Orientacao;
import org.fja.navalbattle.model.navios.Navio;

/**
 * Define disposição pré-definida de navios em um tabuleiro
 * @author Diego Fleury
 */
public class Template implements Serializable, Cloneable {

    /**
     * Marcação do tabuleiro
     */
    private Navio[][] tabuleiro;

    /**
     * Número de vitórias
     */
	private int vitorias;

    /**
     * Número de derrotas
     */
	private int derrotas;

	/**
     * Número de partidas
     */
	private int partidas;

    /**
     * Nome do template
     */
    private String nome;

    /**
     * Cria uma instância de template
     */
    public Template() {
        tabuleiro = new Navio[10][10];
        vitorias = 0;
        derrotas = 0;
        partidas = 0;
        nome = "";
    }

    /**
     * Incrementa 1 ao total de partidas ganhas com este template
     */
    public void incrementaVitorias() {
        vitorias++;
        incrementaPartidas();
    }

    /**
     * Incrementa 1 ao total de partidas perdidas com este template
     */
    public void incrementaDerrotas() {
        derrotas++;
        incrementaPartidas();
    }

    /**
     * Incrementa 1 ao total de partidas jogadas com este template
     */
    private void incrementaPartidas() {
        partidas++;
    }

    /**
     * Define o nome do template
     * @param nome Nome do template
     */
    private void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Recebe uma matriz com posições de navios e sobreescreve a matriz atual
     * @param tabuleiro Matriz com posições de navios
     */
    private void setTabuleiro(Navio[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    /**
     * Retorna o número de vitórias
     * @return Total de vitórias com este template
     */
    public int getVitorias() {
        return vitorias;
    }

    /**
     * Retorna o número de derrotas
     * @return Total de derrotas com este template
     */
    public int getDerrotas() {
        return derrotas;
    }

    /**
     * Retorna o número de partidas
     * @return Total de partidas jogadas com o template
     */
    public int getPartidas() {
        return partidas;
    }

    /**
     * Retorna o nome do template
     * @return Nome do template
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a matriz do tabuleiro
     * @return Matriz do template
     */
    public Navio[][] getTabuleiro() {
        return tabuleiro;
    }

	/**
	 * Verifica se é possível adicionar um navio na posição indicada levando
	 * em consideração seu tamanho, orientação e se está colidindo com outro.
	 * @param navio Navio que será tentará ser adicionado
	 * @param coordenada Coordenada em que o pivô superior esquerdo se encontra
	 * @return Se o navio pode ficar na coordenada indicada
	 */
	public boolean posicaoLegal(Navio navio, Coordenada coordenada) {

		int x, y;

		// Executará enquanto o contador regressivo, comprimento, for maior ou igual que zero
		for (int comprimento = navio.getTamanho(); comprimento >= 0; comprimento--) {

			y = coordenada.getY();
			x = coordenada.getX();

			// Verifica a orientação
			if (navio.getOrientacao() == Orientacao.HORIZONTAL) {

				if (x + comprimento + 1 >= tabuleiro.length) {
					return false;
				}

				if (tabuleiro[x + comprimento][y] != null) {
					return false;
				}

			} else {

				if (y + comprimento + 1 >= tabuleiro[0].length) {
					return false;
				}

				if (tabuleiro[x][y + comprimento] != null) {
					return false;
				}

			}

		}

		return true;
	}

	/**
	 * Adiciona um navio na posição indicada
	 * @param navio Navio a ser adicionado
	 * @param coordenada Coordenada que define sua posição
	 */
	public void adicionaNavio(Navio navio, Coordenada coordenada) {

		int x, y;

		// Executará enquanto o contador regressivo, comprimento, for maior ou igual que zero
		for (int comprimento = navio.getTamanho(); comprimento >= 0; comprimento--) {

			y = coordenada.getY();
			x = coordenada.getX();

			// Verifica a orientação
			if (navio.getOrientacao() == Orientacao.HORIZONTAL) {

				tabuleiro[x + comprimento][y] = navio;

			} else {

				tabuleiro[x][y + comprimento] = navio;

			}

		}

	}

	/**
	 * Cria um clone do objeto
	 * @return Objeto clonado
	 */
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
	 
}
 
