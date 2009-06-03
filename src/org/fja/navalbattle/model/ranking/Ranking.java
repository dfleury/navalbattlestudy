package org.fja.navalbattle.model.ranking;

import java.util.ArrayList;
import org.fja.navalbattle.model.jogadores.Humano;
import org.fja.navalbattle.model.partida.Partida;

/**
 * Atualiza o ranking dos jogadores
 * @author Diego Fleury
 */
public class Ranking {

    /**
     * Instância única do objeto de Ranking
     */
    private static Ranking instance;

    /**
     * Instancia o objeto
     */
    private Ranking() {
        // TODO Verificar necessidade de implementação no construtor do Ranking
    }

    /**
     * Retorna instância criada
     * @return Instância de Ranking
     */
    public static Ranking getInstance() {
        if (instance == null) {
            instance = new Ranking();
        }

        return instance;
    }

    /**
     * Salva resultado de uma partida
     * @param partida Partida que deseja-se salvar
     */
	public void salvarResultadoPartida(Partida partida) {
        // TODO salva o resultado da partida
	}

    /**
     * Faz leitura dos resultados anteriores para montar um ranking
     * @param humanos Recebe lista de jogadores vindo da gerencia de jogadores e monta o ranking atual
     */
	public void montarRanking(Humano[] humanos) {
        // TODO Implementar a montagem do ranking
	}
	 
}
 
