package org.fja.navalbattle.model.jogadores;

public class Perfil {
 
	private int vitorias;
	 
	private int derrotas;
	 
	private int partidas;
    
    public Perfil() {
        vitorias = 0;
        derrotas = 0;
        partidas = 0;
    }

    public void incrementaVitorias() {
        vitorias++;
        incrementaPartidas();
    }
    
    public void incrementaDerrotas() {
        derrotas++;
        incrementaPartidas();
    }

    private void incrementaPartidas() {
        partidas++;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getPartidas() {
        return partidas;
    }
	 
}
 
