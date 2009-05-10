package org.fja.navalbattle.model.jogadores;

import org.fja.navalbattle.model.templates.Template;

public class Humano extends Jogador {
 
	private Perfil perfil;

    private String nome;
	 
	public Humano(String nome, Template template) {
        super(nome, template);
        perfil = new Perfil();
	}

    public Perfil getPerfil() {
        return perfil;
    }

    public void jogar() {
        // TODO: habilitar interface do usuário para que o jogador possa escolher um número
    }

}
 
