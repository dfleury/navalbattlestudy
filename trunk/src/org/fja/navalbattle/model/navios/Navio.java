package org.fja.navalbattle.model.navios;

import org.fja.navalbattle.model.cenario.Disparo;
import org.fja.navalbattle.model.cenario.Orientacao;

/**
 * Define característica comuns de um navio
 * @author Diego Fleury
 */
public abstract class Navio {

    /**
     * Quantidade de coordenadas que este ocupa
     */
	private int tamanho;

    /**
     * Quantidade de danos recebidos
     */
	private int danos;

    /**
     * Orientação vertical ou horizontal
     */
	private Orientacao orientacao;

    /**
     * Limite de unidades de um determinado tipo de navio
     */
    private int limiteDeUnidades;

    /**
     * Inicializa o tamanho do navio
     * @param tamanho Quantidade de coordenadas ocupadas
     */
	protected void inicializaTamanho(int tamanho) {
        if (tamanho > 0) {
            this.tamanho = tamanho;
        }
	}

    /**
     * Inicializa o limite de unidades de um determinado tipo de navio
     * @param limiteDeUnidades
     */
    protected void inicializaLimiteDeUnidades(int limiteDeUnidades) {
        if (limiteDeUnidades > 0) {
            this.limiteDeUnidades = limiteDeUnidades;
        }
    }

    /**
     * Registra que recebeu um dano
     * @param disparo Disparo recebido
     */
	public void recebeDano(Disparo disparo) {
        danos++;
	}

    /**
     * Determina a orientação do navio
     * @param orientacao Orientação vertical ou horizontal
     */
	public void setOrientacao(Orientacao orientacao) {
        this.orientacao = orientacao;
	}

    /**
     * Retorna o tamanho do navio
     * @return Tamanho do navio
     */
	public int getTamanho() {
        return tamanho;
	}

    /**
     * Retorna o limite de unidades de um determinado tipo
     * @return Limite de unidades
     */
	public int getLimiteDeUnidades() {
        return limiteDeUnidades;
	}

    /**
     * Retorna a quantidade de danos atual
     * @return Quantidade de danos atual
     */
	public int getDanos() {
        return danos;
	}

    /**
     * Retorna a orientação em que o navio está posicionado
     * @return Orientação do navio
     */
	public Orientacao getOrientacao() {
        return orientacao;
	}
	
}