package org.fja.navalbattle.model;

import org.fja.navalbattle.model.partida.Partida;
import org.fja.navalbattle.model.ranking.Ranking;
import org.fja.navalbattle.model.templates.GerenciadorTemplates;
import org.fja.navalbattle.model.jogadores.GerenciadorJogador;
import org.fja.navalbattle.model.jogadores.Jogador;

/**
 * Inicializa todos controles básicos da regra de negócio
 * @author Diego Fleury
 */
public class BatalhaNaval {

    /**
     * Referência única da classe BatalhaNaval
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
	 * Os dois jogadores que irão se enfrentar
	 */
	Jogador jogador1, jogador2;

    /**
     * Inicializa controles Singleton básicos para que suas instâncias sejam
	 * logo criadas para depois serem simplesmente resgatadas
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
	 * Cria os jogadores e solicita-os que posicionem seus navios
	 */
	public void prepararNovaPartida() {
		//jogador1 = gerenciadorJogadores.novoHumano();
		jogador1 = gerenciadorJogadores.novoComputador();
        jogador2 = gerenciadorJogadores.novoComputador();

		jogador1.posicionarArsenal();
		jogador2.posicionarArsenal();
	}

	/**
	 * Aguarda ambos jogadores a travarem seus exercitos para travar as posições
	 * e começar a partida.
	 */
	public void travarPosicoes() {
		if (jogador1.estaPosicionado() && jogador2.estaPosicionado()) {
			comecarNovaPartida();
		}
	}

    /**
     * Cria os jogadores e uma partida
     */
	private void comecarNovaPartida() {
        jogador1.setTabuleiroOponente(jogador2.getTabuleiro());
        jogador2.setTabuleiroOponente(jogador1.getTabuleiro());

        partida = new Partida(jogador1, jogador2);
		partida.comecar();
	}

    /**
     * Salva a partida no ranking
     */
    public void salvarPartidaEncerrada() {
        ranking.salvarResultadoPartida(partida);

		System.out.println("=================================");
		System.out.println("Fim de jogo. O jogador vencedor foi: " +
				partida.getJogadorVencedor().getNome());
    }
	 
}