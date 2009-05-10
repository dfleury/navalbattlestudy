package org.fja.navalbattle.model.ranking;

import java.util.ArrayList;
import org.fja.navalbattle.model.jogadores.Humano;
import org.fja.navalbattle.model.partida.Partida;

public class Ranking {

    private static Ranking instance;

    private Ranking() {

    }

    public static Ranking getInstance() {
        if (instance == null) {
            instance = new Ranking();
        }

        return instance;
    }
	 
	public void salvarResultadoPartida(Partida partida) {
	 
	}
	 
	public void montarRanking(ArrayList<Humano> humanos) {
	 
	}
	 
}
 
