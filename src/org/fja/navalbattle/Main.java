package org.fja.navalbattle;

import org.fja.navalbattle.model.BatalhaNaval;

/**
 * Inícia o jogo
 * @author Diego Fleury
 */
public class Main {

    /**
	 * Inícia o jogo
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		BatalhaNaval bn = BatalhaNaval.getInstance();
		bn.prepararNovaPartida();
    }

}