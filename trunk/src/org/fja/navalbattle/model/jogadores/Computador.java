package org.fja.navalbattle.model.jogadores;

import org.fja.navalbattle.model.cenario.Coordenada;
import org.fja.navalbattle.model.jogadores.estrategia.Estrategia;
import org.fja.navalbattle.model.templates.Template;

/**
 * Jogador de inteligência artificial
 * @author Diego Fleury
 */
public class Computador extends Jogador {

    /**
     * Estrategia a ser utilizada em combate
     */
	private Estrategia estrategia;

    /**
     * Cria um novo jogador computador
     * @param nome Nome do jogador
     * @param template Template que utilizará
     * @param estrategia Estratégia de jogo
     */
	public Computador(String nome, Template template, Estrategia estrategia) {
        inicializaTabuleiro();
        inicializaMatrizGuia();
        getTabuleiro().aplicarTemplate(template);
        setNome(nome);
        this.estrategia = estrategia;
	}

    /**
     * Faz uso da estratégia e joga em determinada coordenada
     */
    public void jogar() {
        Coordenada coordenada = estrategia.pensar(getTabuleiroOponente().getTabuleiroDeAcertos(), matrizGuia);
        jogar(coordenada.getX(), coordenada.getY());
    }
	 
}
 
