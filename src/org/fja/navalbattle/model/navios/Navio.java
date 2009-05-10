package org.fja.navalbattle.model.navios;

import org.fja.navalbattle.model.cenario.Coordenada;
import org.fja.navalbattle.model.cenario.Disparo;
import org.fja.navalbattle.model.cenario.Tabuleiro;
import org.fja.navalbattle.model.*;

public abstract class Navio {
 
	private int tamanho;
	 
	private int danos;
	 
	private Coordenada coordenadas[];
	 
	private Tabuleiro tabuleiro;
	 
	public void Navio() {
	 
	}
	 
	protected void inicializaTamanho(int tamanho) {
	 
	}
	 
	protected void inicializaCoordenadas(Coordenada coordenadas[]) {
	 
	}
	 
	public void recebeDano(Disparo disparo) {
	 
	}
	 
}
 
