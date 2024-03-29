package org.fja.navalbattle.model.jogadores;

import org.fja.navalbattle.control.Controlador;

/**
 * Fornece métodos de gerência sobre os jogadores
 * @author Diego Fleury
 */
public class GerenciadorJogador {

    /**
     * Instância do jogador
     */
	private static GerenciadorJogador instance;

    /**
     * Referência da fábrica de jogadores
     */
	private FabricaJogador fabricaJogador;

    /**
     * Inicializa o gerenciador e a fabrica
     */
    private GerenciadorJogador() {
        fabricaJogador = new FabricaJogador();
    }

    /**
     * Devolve a instância única
     * @return Gerenciador de Jogadores
     */
	public static GerenciadorJogador getInstance() {
        if (instance == null) {
            instance = new GerenciadorJogador();
        }

        return instance;
	}

    /**
     * Retorna uma referência da fabrica criada
     * @return Fábrica de jogadores
     */
	public FabricaJogador getFabricaJogador() {
		return fabricaJogador;
	}

    /**
     * Cria um novo jogador humano
     * @return Jogador humano
     */
    public Humano novoHumano() {
        Humano jogadorHumano = fabricaJogador.criarHumano();

        // Pergunta ao usuário se ele que abrir um jogador já existente
        Controlador controlador = Controlador.getInstance();
        if (controlador.perguntaAbrirJogador()) {
            jogadorHumano = controlador.abrirJogador();
        }

        return jogadorHumano;
    }

    /**
     * Cria um novo jogador computador
     * @return Jogador computador
     */
    public Computador novoComputador() {
        Computador jogadorComputador = fabricaJogador.criarComputador(Controlador.getInstance().perguntaNivelComputador());

        return jogadorComputador;
    }

    /**
     * Abre arquivo de um jogador humano já existênte
     * @param id Identificador de jogador
     * @return Jogador humano
     */
	public Humano abrirHumano(int id) {
        // Implementar a abertuda de um jogador humano
		return null;
	}

    /**
     * Salva em arquivo o jogador humano atual
     * @param jogador Jogador humano a ser salvo
     */
	public void salvarHumano(Humano jogador) {
        // TODO Implementar ação de salvar um jogador humano
	}

    /**
     * Lista todos jogadores humanos salvos em arquivo
     * @return Vetor de jogadores humanos
     */
	public Humano[] listarHumanos() {
        // TODO Fazer a listagem de todos os humanos salvos em arquivo
		return null;
	}
	 
}
 
