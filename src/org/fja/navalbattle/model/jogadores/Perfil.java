package org.fja.navalbattle.model.jogadores;

/**
 * Contém informações estatística sobre o jogador
 * @author Diego Fleury
 */
public class Perfil {

    /**
     * Número de vitórias do jogador
     */
	private int vitorias;

    /**
     * Número de derrotas do jogador
     */
	private int derrotas;

    /**
     * Número de partidas do jogador
     */
	private int partidas;

    /**
     * Cria instância de Perfil
     */
    public Perfil() {
        vitorias = 0;
        derrotas = 0;
        partidas = 0;
    }

    /**
     * Incrementa 1 no número de vitórias
     */
    public void incrementaVitorias() {
        vitorias++;
        incrementaPartidas();
    }

    /**
     * Incrementa 1 no número de derrotas
     */
    public void incrementaDerrotas() {
        derrotas++;
        incrementaPartidas();
    }

    /**
     * Incrementa 1 no número de partidas
     */
    private void incrementaPartidas() {
        partidas++;
    }

    /**
     * Retorna número de vitórias
     */
    public int getVitorias() {
        return vitorias;
    }

    /**
     * Retorna número de derrotas
     */
    public int getDerrotas() {
        return derrotas;
    }

    /**
     * Retorna número de partidas
     */
    public int getPartidas() {
        return partidas;
    }
	 
}
 
