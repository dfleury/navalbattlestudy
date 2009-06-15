package org.fja.navalbattle.model.cenario;

import org.fja.exceptions.AtribuicaoUnicaException;
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
	 * Template que será usado na partida
	 */
	private Template template;

	/**
	 * Tabuleiro com a indexação dos acertos
	 */
	private boolean[][] tabuleiroDeAcertos;

    /**
     * Instância um tabuleiro
     */
    public Tabuleiro() {
		navios = new ArrayList<Navio>();
        tabuleiro = new Navio[10][10];
		tabuleiroDeAcertos = new boolean[10][10];
    }

    /**
     * Checa se todos navios do tabuleiro tem como dano o mesmo valor do
	 * atributo tamanho
     * @return Se jogador foi derrotado ou não
     */
	public boolean verificaDerrota() {
        Iterator<Navio> it = navios.iterator();

		Navio navio;

		// Itera sobre os navios
		while (it.hasNext()) {
			navio = it.next();

			// Se verdadeiro, significa que ainda não foi derrotado
			if (navio.getDanos() < navio.getTamanho()) {
				return false;
			}
		}

        return true;
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
	 * @throws org.fja.exceptions.AtribuicaoUnicaException
     */
	public void aplicarTemplate(Template template)
		throws AtribuicaoUnicaException {

		if (this.template == null) {
			this.template = template;
			this.tabuleiro = template.getTabuleiro();

			Navio navio;

			// Varre todas as posições em busca dos tabuleiros
			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 10; y++) {

					navio = this.tabuleiro[x][y];

					if (navio != null) {
						adicionaNavio(navio);
					}

				}
			}

		} else {
			throw new AtribuicaoUnicaException("Template não pode ser " +
					"aplicado mais de uma vez");
		}

	}

    /**
     * Adiciona um navio do tabuleiro
     * @param navio Navio a ser adicionado
     */
    public void adicionaNavio(Navio navio) {
        // Verifica se o máximo de navios foi alcançado
        if (navios.size() <= 6) {

			if (!navios.contains(navio)) {

				/*
				 * Verifica se o limite de navios para um determinado tipo foi
				 * alcançado. Se a quantidade for menor que o limite, adiciona
				 * o navio
				 */
				if (contaTipoDeNavio(navio) < navio.getLimiteDeUnidades()) {
					navios.add(navio);
				}

			}

        }
    }

    /**
     * Retorna uma cópia do template construído
     * @return template construído
     */
	public Template getTemplate() {
		return (Template)template.clone();
	}

    /**
     * Recebe um objeto de disparo e retorna o mesmo objeto de disparo dizendo
	 * se acertou ou não.
     * @param disparo Disparo feito pelo oponente
     * @return Objeto Disparo contendo atributo acertou com valor alterado
     */
    public Disparo recebeDisparo(Disparo disparo) {
		Navio alvo = tabuleiro[disparo.getX()][disparo.getY()];

		// Assume que o disparo não acertou
		disparo.setAcertou(false);

		// Verifica se há algum navio na coordenada
		if (alvo != null) {
			// Informa dano
			alvo.recebeDano(disparo);
			// Informa que o disparo acertou
			disparo.setAcertou(true);
			// Marca no índice do tabuleiro onde o disparo foi feito
			tabuleiroDeAcertos[disparo.getX()][disparo.getY()] = true;
			System.out.println(" Acertou!");
		} else {
			System.out.println(" Errou!");
		}
		
        return disparo;
    }

    /**
     * Retorna uma matriz de 10x10 com boolean onde já ouve tiros acertados
     * @return Matriz de acertos
     */
    public boolean[][] getTabuleiroDeAcertos() {
        return tabuleiroDeAcertos;
    }

    /**
     * Ao passar uma instância de navio, são contados quantos navios do mesmo 
	 * tipo já existem na lista de navios.
     * @param navio Navio que terá seu tipo pesquisado
     * @return Quantidade de vezes que o tipo de navio foi encontrado
     */
    private int contaTipoDeNavio(Navio navio) {
        int contador = 0;

        Iterator<Navio> it = navios.iterator();
        while (it.hasNext()) {
            /*
			 * Verifica se o tipo passado é do mesmo tipo do item corrente da
			 * iteração.
			 */
            if (it.next().getClass().isInstance(navio)) {
                contador++;
            }
        }

        return contador;
    }
	 
}