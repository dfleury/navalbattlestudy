package org.fja.navalbattle.model.cenario;

public class Disparo extends Coordenada {
 
	private boolean acertou;

    public Disparo(int x, int y) {
        super(x, y);
    }

    public void setAcertou(boolean acertou) {
        this.acertou = acertou;
    }

    public boolean getAcertou() {
        return acertou;
    }
	 
}
 
