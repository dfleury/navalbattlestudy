package org.fja.navalbattle.model.jogadores;

import org.fja.navalbattle.model.jogadores.estrategia.Dificuldade;
import org.fja.navalbattle.model.jogadores.estrategia.Estrategia;
import org.fja.navalbattle.model.jogadores.estrategia.EstrategiaDificil;
import org.fja.navalbattle.model.jogadores.estrategia.EstrategiaFacil;
import org.fja.navalbattle.model.templates.GerenciadorTemplates;

public class FabricaJogador {
 
	public Humano criarHumano() {
		return new Humano("Anônimo", GerenciadorTemplates.getInstance().criarTemplate());
	}
	 
	public Computador criarComputador(Dificuldade dificuldade) {

        Estrategia estrategia = new EstrategiaFacil();

        if (dificuldade == Dificuldade.DIFICIL) {
            estrategia = new EstrategiaDificil();
        }

		return new Computador("Computador", GerenciadorTemplates.getInstance().criarTemplate(), estrategia);
	}
	 
}
 
