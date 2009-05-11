package org.fja.navalbattle.model.jogadores.estrategia;

import org.fja.navalbattle.model.cenario.Coordenada;

/**
 * Define interface para criação de novas estratégias de batalha
 * @author Diego Fleury
 */
public interface Estrategia {

    /**
     * Usa um algoritmo para definir onde disparar um tiro
     * @param tabuleiro Matriz contendo marcado como true, os locais onde já foram acertados tiros
     * @param matrizGuia Matriz contendo marcado como true, os locais onde já foram disparados tiros
     * @return Nova coordenada de disparo
     */
	public abstract Coordenada pensar(boolean[][] tabuleiro, boolean matrizGuia[][]);

}
 
