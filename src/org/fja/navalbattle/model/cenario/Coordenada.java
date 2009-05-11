package org.fja.navalbattle.model.cenario;

/**
 * Tem como função especificar um ponto no tabuleiro de jogo
 * @author Diego Fleury
 */
public class Coordenada {

    /**
     * Refere-se a posição horizontal
     */
	private int x;

    /**
     * Refere-se a posição vertical
     */
	private int y;

    /**
     * Cria instância de Coordenada
     * @param x posição horizontal
     * @param y posição vertical
     */
	public Coordenada(int x, int y) {
        setX(x);
        setY(y);
	}

    /**
     * Retorna posição horizontal
     * @return posição horizontal
     */
    public int getX() {
        return x;
    }

    /**
     * Retorna posição vertical
     * @return posição vertical
     */
    public int getY() {
        return y;
    }

    /**
     * Determina posição horizontal
     * @param x posição horizontal
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Determina posição vertical
     * @param y posição vertical
     */
    public void setY(int y) {
        this.y = y;
    }
}
 
