package org.fja.navalbattle.model.jogadores.estrategia;

import org.fja.navalbattle.model.cenario.Coordenada;
import org.fja.navalbattle.model.cenario.Tabuleiro;

public interface Estrategia {
 
	public abstract Coordenada pensar(boolean[][] tabuleiro, boolean matrizGuia[][]);
}
 
