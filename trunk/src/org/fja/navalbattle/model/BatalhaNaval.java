package org.fja.navalbattle.model;

import org.fja.navalbattle.model.jogadores.Computador;
import org.fja.navalbattle.model.partida.Partida;
import org.fja.navalbattle.model.ranking.Ranking;
import org.fja.navalbattle.model.templates.GerenciadorTemplates;
import org.fja.navalbattle.model.jogadores.GerenciadorJogador;
import org.fja.navalbattle.model.jogadores.Humano;

public class BatalhaNaval {
 
	private static BatalhaNaval instance;
	 
	private Partida partida;

    private Ranking ranking;
	 
	private GerenciadorTemplates gerenciadorTemplates;
	 
	private GerenciadorJogador gerenciadorJogadores;

    private BatalhaNaval() {
        gerenciadorTemplates = GerenciadorTemplates.getInstance();
        gerenciadorJogadores = GerenciadorJogador.getInstance();
        ranking = Ranking.getInstance();
    }
	 
	public static BatalhaNaval getInstance() {
		if (instance == null) {
            instance = new BatalhaNaval();
        }
        
        return instance;
	}
	 
	public void criarNovaPartida() {

        Humano jogadorHumano = gerenciadorJogadores.novoHumano();
        Computador jogadorComputador = gerenciadorJogadores.novoComputador();

        jogadorHumano.setTabuleiroOponente(jogadorComputador.getTabuleiro());
        jogadorComputador.setTabuleiroOponente(jogadorHumano.getTabuleiro());

        partida = new Partida(jogadorHumano, jogadorComputador);

	}

    // TODO: implementar escolha de template por parte dos jogadores
	 
}
 
