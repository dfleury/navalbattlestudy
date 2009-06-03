package org.fja.navalbattle.model;

import org.fja.navalbattle.model.jogadores.Computador;
import org.fja.navalbattle.model.partida.Partida;
import org.fja.navalbattle.model.ranking.Ranking;
import org.fja.navalbattle.model.templates.GerenciadorTemplates;
import org.fja.navalbattle.model.jogadores.GerenciadorJogador;
import org.fja.navalbattle.model.jogadores.Humano;

/**
 * Inicializa todos controles básicos da regra de negócio
 *
 * @author Diego Fleury
 */
public class BatalhaNaval {

    /**
     * Usada no padrão Singleton
     */
	private static BatalhaNaval instance;

    /**
     * Referência da partida em andamento
     */
	private Partida partida;

    /**
     * Referência do controle de Ranking
     */
    private Ranking ranking;

    /**
     * Referência do gerenciador de templates
     */
	private GerenciadorTemplates gerenciadorTemplates;

    /**
     * Referência do gerenciador de Jogadores
     */
	private GerenciadorJogador gerenciadorJogadores;

    /**
     * Inicializa controles Singleton básicos para que suas instancias sejam criadas
     */
    private BatalhaNaval() {
        gerenciadorTemplates = GerenciadorTemplates.getInstance();
        gerenciadorJogadores = GerenciadorJogador.getInstance();
        ranking = Ranking.getInstance();
    }

    /**
     * Fornece a referência da instância de BatalhaNaval
     * @return Instância de Batalha Naval
     */
	public static BatalhaNaval getInstance() {
		if (instance == null) {
            instance = new BatalhaNaval();
        }
        
        return instance;
	}

    /**
     * Cria os jogadores e uma partida
     */
	public void criarNovaPartida() {

        Humano jogadorHumano = gerenciadorJogadores.novoHumano();
        Computador jogadorComputador = gerenciadorJogadores.novoComputador();

        jogadorHumano.setTabuleiroOponente(jogadorComputador.getTabuleiro());
        jogadorComputador.setTabuleiroOponente(jogadorHumano.getTabuleiro());

        partida = new Partida(jogadorHumano, jogadorComputador);
	}

    /**
     * Salva a partida no ranking
     */
    public void salvarPartidaEncerrada() {
        ranking.salvarResultadoPartida(partida);
    }
	 
}