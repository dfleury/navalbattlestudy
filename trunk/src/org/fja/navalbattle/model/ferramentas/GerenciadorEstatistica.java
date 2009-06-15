package org.fja.navalbattle.model.ferramentas;

import org.fja.navalbattle.model.cenario.Disparo;

/**
 * Fornece dados estatísticos dos disparos para utilização das ferramentas
 * @author Diego Fleury
 */
public class GerenciadorEstatistica {

    /**
     * Instância do Gerenciador de Estatística
     */
	private static GerenciadorEstatistica instance;

    /**
     * Matriz que contém a quantidade de tiros acertados em cada coordenada dos
	 * tabuleiros.
     */
	private int[][] matrizAcertos;

    /**
     * Número total de tiros
     */
	private int totalTiros;

    /**
     * Instancia o objeto de estatística
     */
	private GerenciadorEstatistica() {
        /*
		 * TODO Analisar necessidade de implementacao no construtor de
		 * GerenciadorEstatistica
		 */
	}

    /**
     * Retorna instância criada
     * @return Instância do gerenciador
     */
	public static GerenciadorEstatistica getInstance() {
		if (instance == null) {
			instance = new GerenciadorEstatistica();
		}
		
		return instance;
	}

    /**
     * Salva disparto efetuado por quaisquer jogadores
     * @param disparo Disparo efetuado
     */
	public void salvarDisparo(Disparo disparo) {
        // TODO Salvar estatistica de disparo efetuado
	}
	 
}
 
