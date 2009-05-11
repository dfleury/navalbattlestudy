package org.fja.navalbattle.model.cenario;

/**
 * Especialização de Coordenada. Representa um disparo feito no tabuleiro do Oponente
 * @author Diego Fleury
 */
public class Disparo extends Coordenada {

    /**
     * Diz se o tiro foi efetivo ou não
     */
	private boolean acertou;

    /**
     * Cria uma instância de Disparo
     * @param x posição horizontal
     * @param y posição vertical
     */
    public Disparo(int x, int y) {
        super(x, y);
    }

    /**
     * Determina se o tiro acertou ou não
     * @param acertou Status final de um disparo
     */
    public void setAcertou(boolean acertou) {
        this.acertou = acertou;
    }

    /**
     * Retorna o status final de um disparo
     * @return Se acertou o disparo ou não
     */
    public boolean getAcertou() {
        return acertou;
    }
	 
}
 
