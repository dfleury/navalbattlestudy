package org.fja.navalbattle.model.cenario;

import org.fja.navalbattle.model.templates.Template;
import org.fja.navalbattle.model.ferramentas.Termostato;
import org.fja.navalbattle.model.ferramentas.Radar;
import org.fja.navalbattle.model.navios.Navio;

public class Tabuleiro {
 
	private Navio[] navios;

    private Navio[][] tabuleiro;
	 
	private Radar radar;
	 
	private Termostato termostato;

    public Tabuleiro() {
        tabuleiro = new Navio[10][10];
    }
	 
	public boolean verificaDerrota() {
        return false;
	}
	 
	public void usarRadar() {
	 
	}
	 
	public void usarTermostato() {
	 
	}
	 
	public void aplicarTemplate(Template template) {
	 
	}

    public void addNavio(Navio navio, Orientacao orientacao, Coordenada coordenada) {

    }
	 
	public Template getTemplate() {
		return null;
	}

    public Disparo recebeDisparo(Disparo disparo) {
        return null;
    }

    public boolean[][] getTabuleiroDeAcertos() {
        return new boolean[10][10];
    }
	 
}
 
