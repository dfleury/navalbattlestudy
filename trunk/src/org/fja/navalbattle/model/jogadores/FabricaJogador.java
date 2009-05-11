package org.fja.navalbattle.model.jogadores;

import org.fja.navalbattle.model.jogadores.estrategia.Dificuldade;
import org.fja.navalbattle.model.jogadores.estrategia.Estrategia;
import org.fja.navalbattle.model.jogadores.estrategia.EstrategiaDificil;
import org.fja.navalbattle.model.jogadores.estrategia.EstrategiaFacil;
import org.fja.navalbattle.model.templates.GerenciadorTemplates;

/**
 * Tem a responsabilidade de criar as instâncias dos jogadores
 * @author Diego Fleury
 */
public class FabricaJogador {

    /**
     * Retorna um novo jogador humano
     * @return Jogador humano
     */
	public Humano criarHumano() {
		return new Humano("Anônimo", GerenciadorTemplates.getInstance().criarTemplate());
	}

    /**
     * Retorna um novo jogador artificial
     * @param dificuldade Nível de dificuldade da A.I.
     * @return Jogador computador
     */
	public Computador criarComputador(Dificuldade dificuldade) {

        Estrategia estrategia = new EstrategiaFacil();

        if (dificuldade == Dificuldade.DIFICIL) {
            estrategia = new EstrategiaDificil();
        }

		return new Computador("Computador", GerenciadorTemplates.getInstance().criarTemplate(), estrategia);
	}
	 
}
 
