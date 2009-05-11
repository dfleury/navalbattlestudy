package org.fja.navalbattle.model.cenario;

import org.fja.navalbattle.model.templates.Template;
import org.fja.navalbattle.model.ferramentas.Termostato;
import org.fja.navalbattle.model.ferramentas.Radar;
import org.fja.navalbattle.model.navios.Navio;

/**
 * Tabuleiro de jogo batalha naval
 * @author Diego Fleury
 */
public class Tabuleiro {

    /**
     * Navios existentes nesta instância tabuleiro
     */
	private Navio[] navios;

    /**
     * Posiciona as referências dos navios nas coordenadas
     */
    private Navio[][] tabuleiro;

    /**
     * Referência da ferramenta de radar
     */
	private Radar radar;

    /**
     * Referência da ferramenta de termostato
     */
	private Termostato termostato;

    /**
     * Instância um tabuleiro
     */
    public Tabuleiro() {
        tabuleiro = new Navio[10][10];
    }

    /**
     * Checa se todos navios do tabuleiro tem como dano o mesmo valor do atributo tamanho
     * @return Se jogador foi derrotado ou não
     */
	public boolean verificaDerrota() {
        return false;
	}

    /**
     * Utiliza ferramenta de radar
     */
	public void usarRadar() {
	 
	}

    /**
     * Utiliza ferramenta de termostato
     */
	public void usarTermostato() {
	 
	}

    /**
     * Recebe um template e aplica ele sobre o tabuleiro
     * @param template Template com as posições dos navios
     */
	public void aplicarTemplate(Template template) {
	 
	}

    /**
     * Adiciona um navio do tabuleiro
     * @param navio Navio a ser adicionado
     * @param orientacao Orientação vertical ou horizontal
     * @param coordenada Coordenada do pivô
     */
    public void addNavio(Navio navio, Orientacao orientacao, Coordenada coordenada) {

    }

    /**
     * Retorna o template construído
     * @return template construído
     */
	public Template getTemplate() {
		return null;
	}

    /**
     * Recebe um objeto de disparo e retorna o mesmo objeto de disparo dizendo se acertou ou não
     * @param disparo Disparo feito pelo oponente
     * @return Objeto Disparo contendo atributo acertou com valor alterado
     */
    public Disparo recebeDisparo(Disparo disparo) {
        return null;
    }

    /**
     * Retorna uma matriz de 10x10 com boolean onde já ouve tiros acertados
     * @return Matriz de acertos
     */
    public boolean[][] getTabuleiroDeAcertos() {
        return new boolean[10][10];
    }
	 
}
 
