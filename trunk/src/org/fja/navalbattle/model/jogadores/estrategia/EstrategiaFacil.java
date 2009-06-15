package org.fja.navalbattle.model.jogadores.estrategia;

import java.util.Random;
import org.fja.navalbattle.model.cenario.Coordenada;

/**
 * Estratégia simples de jogo
 * @author Diego Fleury
 */
public class EstrategiaFacil implements Estrategia {
 
	public Coordenada pensar(boolean[][] tabuleiro, boolean matrizGuia[][]) {
		int x, y;
		Random sorteio = new Random();
		
		// Inicia um loop até que ache uma posição aleatória onde não tenha ocorrido nenhum disparo
		do {
			x = sorteio.nextInt(10);
			y = sorteio.nextInt(10);
		} while(matrizGuia[x][y] == true);
		
        return new Coordenada(x, y);
	}
	 
}
 
