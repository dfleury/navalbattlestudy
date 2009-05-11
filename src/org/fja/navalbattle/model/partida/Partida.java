package org.fja.navalbattle.model.partida;

import org.fja.navalbattle.model.BatalhaNaval;
import org.fja.navalbattle.model.jogadores.Humano;
import org.fja.navalbattle.model.jogadores.Jogador;

/**
 * Define uma partida
 * @author Diego Fleury
 */
public class Partida {

    /**
     * Cronometro do jogo
     */
	private Cronometro cronometro;

    /**
     * Referência do jogador 1
     */
	private Jogador jogador1;

    /**
     * Referência do jogador 2
     */
	private Jogador jogador2;

    /**
     * Referência do jogador atual
     */
    private Jogador jogadorAtual;

    /**
     * Recebe os jogadores, inicia o cronometro e libera para o primeiro jogador fazer sua jogada
     * @param jogador1 Jogador 1
     * @param jogador2 Jogador 2
     */
	public Partida(Jogador jogador1, Jogador jogador2) {
         this.jogador1 = jogador1;
         this.jogador2 = jogador2;

         jogador1.registraPartida(this);
         jogador2.registraPartida(this);

         cronometro.iniciar();

         double numeroAleatorio = Math.random();
         if (Math.round(numeroAleatorio) == 0) {
             jogadorAtual = jogador1;
         } else {
             jogadorAtual = jogador2;
         }

         jogadorAtual.jogar();
	}

    /**
     * Verifica se ouve um derrotado. Se sim, encerra a partida, senao, troca o jogador atual e aguarda jogada
     */
    public void notificaJogada() {
        if (jogadorAtual.getTabuleiroOponente().verificaDerrota() == false) {
            cambiarJogadores();
            jogadorAtual.jogar();
        } else {
            encerrarPartida();
        }
    }

    /**
     * Troca o jogador atual
     */
    private void cambiarJogadores() {
        if (jogadorAtual == jogador1) {
            jogadorAtual = jogador2;
        } else {
            jogadorAtual = jogador1;
        }
    }

    /**
     * Retorna todos humanos da partida para que possam ser salvos no ranking
     * @return Vetor de Humano
     */
	public Humano[] getHumanos() {
        //Checo se os dois são humanos e mando num array de duas posições
		if (jogador1 instanceof Humano && jogador2 instanceof Humano) {
            return new Humano[] {(Humano)jogador1, (Humano)jogador2};
        } else {
            // Senão testo qual deles é, e mando um array de uma só posição
            if (jogador1 instanceof Humano) {
                return new Humano[] {(Humano)jogador1};
            } else {
                return new Humano[] {(Humano)jogador2};
            }
        }
	}

    /**
     * Informa ao jogo que a partida foi encerrada
     */
    public void encerrarPartida() {
        BatalhaNaval.getInstance().salvarPartidaEncerrada();
    }
	 
}