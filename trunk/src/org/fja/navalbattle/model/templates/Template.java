package org.fja.navalbattle.model.templates;

import java.io.Serializable;
import org.fja.navalbattle.model.navios.Navio;

/**
 * Define disposição pré-definida de navios em um tabuleiro
 * @author Diego Fleury
 */
public class Template implements Serializable {

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
     * Incrementa um no número de vitórias
     * @return Incrementa 1 ao total de partidas ganhas com este template
     */
    public void incrementaVitorias() {
        vitorias++;
        incrementaPartidas();
    }

    /**
     * Incrementa um no número de derrotas
     * @return Incrementa 1 ao total de partidas perdidas com este template
     */
    public void incrementaDerrotas() {
        derrotas++;
        incrementaPartidas();
    }

    /**
     * Incrementa um no número de partidas
     * @return Incrementa 1 ao total de partidas jogadas com este template
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
	 
}
 
