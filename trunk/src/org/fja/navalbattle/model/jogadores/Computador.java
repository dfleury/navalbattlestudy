package org.fja.navalbattle.model.jogadores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.fja.exceptions.AtribuicaoUnicaException;
import org.fja.navalbattle.model.cenario.Coordenada;
import org.fja.navalbattle.model.cenario.Orientacao;
import org.fja.navalbattle.model.jogadores.estrategia.Estrategia;
import org.fja.navalbattle.model.navios.*;
import org.fja.navalbattle.model.templates.Template;

/**
 * Jogador de inteligência artificial
 * @author Diego Fleury
 */
public class Computador extends Jogador {

    /**
     * Estrategia a ser utilizada em combate
     */
	private Estrategia estrategia;

    /**
     * Cria um novo jogador computador
     * @param nome Nome do jogador
     * @param template Template que utilizará
     * @param estrategia Estratégia de jogo
	 * @throws org.fja.exceptions.AtribuicaoUnicaException
     */
	public Computador(String nome, Template template, Estrategia estrategia)
			throws AtribuicaoUnicaException {

		inicializaTabuleiro();
		inicializaMatrizGuia();
		inicializaTemplate(template);

        setNome(nome);
        this.estrategia = estrategia;
	}

    /**
     * Faz uso da estratégia e joga em determinada coordenada
     */
    public void jogar() {
        Coordenada coordenada = estrategia.pensar(getTabuleiroOponente().getTabuleiroDeAcertos(), matrizGuia);
        jogar(coordenada.getX(), coordenada.getY());
    }

	/**
	 * Posiciona os navios no template
	 */
	public void posicionarArsenal() {

		// Monta uma lista de navios disponíveis
		ArrayList<Navio> navios = new ArrayList<Navio>();
		navios.add(new Portavioes());
		navios.add(new Fragata());
		navios.add(new Fragata());
		navios.add(new Submarino());
		navios.add(new Submarino());
		navios.add(new Veleiro());

		// Declara variáveis que serão utilizadas neste processo
		Random random = new Random();
		Orientacao orientacao;
		Coordenada coordenada;
		Template template = getTemplate();
		int x, y;
		Navio navio;


		// Itera sobe os navios disponíveis
		Iterator<Navio> it = navios.iterator();

		while(it.hasNext()) {

			navio = it.next();

			do {

				// Escolhe a orientação
				orientacao = random.nextBoolean() ? Orientacao.HORIZONTAL : Orientacao.VERTICAL;
				navio.setOrientacao(orientacao);

				// Escolhe posição
				x = random.nextInt(10);
				y = random.nextInt(10);
				coordenada = new Coordenada(x, y);
				
			// Verifica se a posição sorteada está disponível para adicionar o navio
			} while(!template.posicaoLegal(navio, coordenada));

			// Adiciona navio ao template
			template.adicionaNavio(navio, coordenada);

			String nome = navio.getClass().getName();
			StringBuilder output = new StringBuilder("Jogador ");
			output.append(this.getNome());
			output.append(" posicionou sua unidade ");
			output.append(nome.substring(nome.lastIndexOf(".") + 1));
			output.append(" na coordenada (");
			output.append(coordenada.getX());
			output.append(", ");
			output.append(coordenada.getY());
			output.append(") ocupando ");
			output.append(navio.getTamanho());
			output.append(" posicoes em orientacao ");
			output.append(orientacao.toString());
			System.out.println(output.toString());
		}

		// Tenta aplicar o template ao tabuleiro
		try {
			getTabuleiro().aplicarTemplate(template);
		}
		catch(AtribuicaoUnicaException e) {
			System.out.println(e);
		}

		System.out.println("=================================");

		jogadorPronto();

	}
	 
}
 
