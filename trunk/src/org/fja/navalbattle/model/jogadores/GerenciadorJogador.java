package org.fja.navalbattle.model.jogadores;

import org.fja.navalbattle.model.jogadores.estrategia.Dificuldade;

public class GerenciadorJogador {
 
	private static GerenciadorJogador instance;
	 
	private FabricaJogador fabricaJogador;

    private GerenciadorJogador() {
        fabricaJogador = new FabricaJogador();
    }
	 
	public static GerenciadorJogador getInstance() {
        if (instance == null) {
            instance = new GerenciadorJogador();
        }

        return instance;
	}
	 
	public FabricaJogador getFabricaJogador() {
		return fabricaJogador;
	}

    public Humano novoHumano() {
        Humano jogadorHumano = fabricaJogador.criarHumano();
        
        // TODO: perguntar ao usuário se ele gostaria de abrir um jogador já existem

        return jogadorHumano;
    }

    public Computador novoComputador() {
        Computador jogadorComputador = fabricaJogador.criarComputador(Dificuldade.FACIL);

        // TODO: perguntar ao usuário o nível do jogador computador

        return jogadorComputador;
    }
	 
	public Humano abrirHumano(int id) {
		return null;
	}
	 
	public void salvarHumano(Humano jogador) {
	 
	}
	 
	public Humano[] listarHumanos() {
		return null;
	}
	 
}
 
