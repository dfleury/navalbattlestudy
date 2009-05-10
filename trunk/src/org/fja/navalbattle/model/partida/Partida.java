package org.fja.navalbattle.model.partida;

import org.fja.navalbattle.model.cenario.Disparo;
import org.fja.navalbattle.model.jogadores.Humano;
import org.fja.navalbattle.model.jogadores.Computador;
import org.fja.navalbattle.model.jogadores.Jogador;

public class Partida {
 
	private Cronometro cronometro;
	 
	private Jogador jogador1;
	 
	private Jogador jogador2;

    private Jogador jogadorAtual;
	 
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

    public void notificaJogada() {
        if (jogadorAtual.getTabuleiroOponente().verificaDerrota() == false) {
            cambiarJogadores();
            jogadorAtual.jogar();
        }
    }

    private void cambiarJogadores() {
        if (jogadorAtual == jogador1) {
            jogadorAtual = jogador2;
        } else {
            jogadorAtual = jogador1;
        }
    }
	 
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
	 
}
 
