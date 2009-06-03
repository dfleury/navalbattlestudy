package org.fja.navalbattle.model.templates;

import org.fja.navalbattle.control.Controlador;

/**
 * Gerenciamento de templates
 * @author Diego Fleury
 */
public class GerenciadorTemplates {

    /**
     * Instância única de GerencaidorTemplates
     */
	private static GerenciadorTemplates instance;

    /**
     * Lista de templates disponivéis para uso
     */
	private Template[] templates;

    /**
     * Instancia GerenciadorTemplates
     */
    private GerenciadorTemplates() {
        // TODO Verificar necessidade de implementação no construtor de GerenciadorTemplates
    }

    /**
     * Retorna a instância de GerenciadorTemplates
     * @return Instância de GerenciadorTemplates
     */
	public static GerenciadorTemplates getInstance() {
		if (instance == null) {
            instance = new GerenciadorTemplates();
        }

        return instance;
	}

    /**
     * Cria um template vazio
     * @return Template vazio
     */
	public Template criarTemplate() {
		return new Template();
	}

    /**
     * Abre um template já existente
     * @param nome Nome do template
     * @return Objeto de template escolhido
     */
	public Template abrirTemplate(String nome) {
        String templatesPath = Controlador.getEnderecoTemplates();
        // TODO abrir um objeto de template salvo em disco
		return null;
	}

    /**
     * Salva um template
     * @param template Template a ser salvo
     */
	public void salvarTemplate(Template template) {
        // TODO Salvar objetos de template em disco
	}

    /**
     * Retorna uma lista de templates disponíveis
     * @return Lista de templates disponíveis
     */
	public Template[] listarTemplates() {
        // TODO Listar todos templates da pasta de templates
        String templatesPath = Controlador.getEnderecoTemplates();
		return null;
	}
	 
}