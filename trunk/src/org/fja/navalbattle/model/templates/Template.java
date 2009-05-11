package org.fja.navalbattle.model.templates;

/**
 * Define disposição pré-definida de navios em um tabuleiro
 * @author Diego Fleury
 */
public class Template {

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
     * Cria uma instância de template
     */
    public Template() {
        vitorias = 0;
        derrotas = 0;
        partidas = 0;
    }

    /**
     * Incrementa um no número de vitórias
     */
    public void incrementaVitorias() {
        vitorias++;
        incrementaPartidas();
    }

    /**
     * Incrementa um no número de derrotas
     */
    public void incrementaDerrotas() {
        derrotas++;
        incrementaPartidas();
    }

    /**
     * Incrementa um no número de partidas
     */
    private void incrementaPartidas() {
        partidas++;
    }

    /**
     * Retorna o número de vitórias
     */
    public int getVitorias() {
        return vitorias;
    }

    /**
     * Retorna o número de derrotas
     */
    public int getDerrotas() {
        return derrotas;
    }

    /**
     * Retorna o número de partidas
     */
    public int getPartidas() {
        return partidas;
    }
	 
}
 
