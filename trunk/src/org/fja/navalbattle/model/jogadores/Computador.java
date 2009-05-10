package org.fja.navalbattle.model.jogadores;

import org.fja.navalbattle.model.cenario.Coordenada;
import org.fja.navalbattle.model.jogadores.estrategia.Estrategia;
import org.fja.navalbattle.model.templates.Template;

public class Computador extends Jogador {
 
	private Estrategia estrategia;
	 
	public Computador(String nome, Template template, Estrategia estrategia) {
        super(nome, template);
        this.estrategia = estrategia;
	}

    public void jogar() {
        Coordenada coordenada = estrategia.pensar(getTabuleiroOponente().getTabuleiroDeAcertos(), matrizGuia);
        jogar(coordenada.getX(), coordenada.getY());
    }
	 
}
 
