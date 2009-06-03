package org.fja.navalbattle.model.cenario;

import java.util.ArrayList;
import java.util.Iterator;
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
	private ArrayList<Navio> navios;

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
        // TODO Implementar verificação de derrota
        return false;
	}

    /**
     * Utiliza ferramenta de radar
     */
	public void usarRadar() {
        // TODO Implementar a utilização do radar
	}

    /**
     * Utiliza ferramenta de termostato
     */
	public void usarTermostato() {
        // TODO Implementar a utilização do termostato
	}

    /**
     * Recebe um template e aplica ele sobre o tabuleiro
     * @param template Template com as posições dos navios
     */
	public void aplicarTemplate(Template template) {
        // TODO Implementar a aplicação de um template
	}

    /**
     * Adiciona um navio do tabuleiro
     * @param navio Navio a ser adicionado
     * @param orientacao Orientação vertical ou horizontal
     * @param coordenada Coordenada do pivô
     */
    public void addNavio(Navio navio, Orientacao orientacao, Coordenada coordenada) {
        // Verifica se o máximo de navios foi alcançado
        if (navios.size() <= 5) {

            /*
             * Verifica se o limite de navios para um determinado tipo foi alcançado.
             * Se a quantidade for menor que o limite, adiciona o navio
             */
            if (contaTipoDeNavio(navio) < navio.getLimiteDeUnidades()) {
                navios.add(navio);
            }

        }
    }

    /**
     * Retorna o template construído
     * @return template construído
     */
	public Template getTemplate() {
        // TODO Implementar o retorno do template construído
		return null;
	}

    /**
     * Recebe um objeto de disparo e retorna o mesmo objeto de disparo dizendo se acertou ou não
     * @param disparo Disparo feito pelo oponente
     * @return Objeto Disparo contendo atributo acertou com valor alterado
     */
    public Disparo recebeDisparo(Disparo disparo) {
        // TODO Implementar o recebimento de um disparo
        return null;
    }

    /**
     * Retorna uma matriz de 10x10 com boolean onde já ouve tiros acertados
     * @return Matriz de acertos
     */
    public boolean[][] getTabuleiroDeAcertos() {
        // TODO Implementar getTabuleiroDeAcertos
        return new boolean[10][10];
    }

    /**
     * Ao passar uma instância de navio, são contados quantos navios do mesmo tipo já existem na lista de navios
     * @param navio Navio que terá seu tipo pesquisado
     * @return Quantidade de vezes que o tipo de navio foi encontrado
     */
    private int contaTipoDeNavio(Navio navio) {
        int contador = 0;

        Iterator<Navio> it = navios.iterator();
        while (it.hasNext()) {
            // Verifica se o tipo passado é do mesmo tipo do item corrente da iteração
            if (it.next().getClass().isInstance(navio)) {
                contador++;
            }
        }

        return contador;
    }
	 
}
 
