package org.fja.navalbattle.model.jogadores;

import org.fja.exceptions.AtribuicaoUnicaException;
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

	private static int sequenciaHumano = 1;
	private static int sequenciaComputador = 1;

    /**
     * Retorna um novo jogador humano
     * @return Jogador humano
     */
	public Humano criarHumano() {
		try {
			return new Humano("Anônimo " + FabricaJogador.sequenciaHumano++,
					GerenciadorTemplates.getInstance().criarTemplate());
		}
		catch(AtribuicaoUnicaException e) {
			System.out.println(e);
			return null;
		}
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

		try {
			return new Computador("Computador " + FabricaJogador.sequenciaComputador++,
					GerenciadorTemplates.getInstance().criarTemplate(), estrategia);
		}
		catch(AtribuicaoUnicaException e) {
			System.out.println(e);
			return null;
		}
	}
	 
}
 
