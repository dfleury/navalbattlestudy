package org.fja.navalbattle.model.ferramentas;

import org.fja.navalbattle.model.cenario.Tabuleiro;

/**
 * Define a interface de uma ferramenta de jogo
 * @author Diego Fleury
 */
public interface Ferramentas {

    /**
     * Este metodo recebe os tabuleiros de ambos jogadores para dar flexibilidade às ferramentas
     * atuais e também as futuras
     * @param tabuleiro Tabuleiro do jogador
     * @param tabuleiroOponente Tabuleiro do oponente
     */
	public abstract void usar(Tabuleiro tabuleiro, Tabuleiro tabuleiroOponente);

}
 
