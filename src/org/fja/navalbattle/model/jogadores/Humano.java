package org.fja.navalbattle.model.jogadores;

import org.fja.navalbattle.control.Controlador;
import org.fja.navalbattle.model.templates.Template;

/**
 * Define um jogador humano
 * @author Diego Fleury
 */
public class Humano extends Jogador {

    /**
     * Referência do perfil do jogador
     */
	private Perfil perfil;

    /**
     * Cria a instância do jogador humano
     * @param nome Nome do jogador
     * @param template Template inicial
     */
	public Humano(String nome, Template template) {
        inicializaTabuleiro();
        inicializaMatrizGuia();
        getTabuleiro().aplicarTemplate(template);
        setNome(nome);
        perfil = new Perfil();
	}

    /**
     * Retorna perfil do jogador
     * @return perfil do jogador
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * Aguarda jogador escolher coordenada de disparo
     */
    public void jogar() {
        Controlador.getInstance().aguardaJogada();
    }

}
 
