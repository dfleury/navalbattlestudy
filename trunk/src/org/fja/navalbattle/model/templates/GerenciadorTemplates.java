package org.fja.navalbattle.model.templates;

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
     * @return Template varioa
     */
	public Template criarTemplate() {
		return null;
	}

    /**
     * Abre um template já existente
     * @param nome Nome do template
     * @return Objeto de template escolhido
     */
	public Template abrirTemplate(String nome) {
		return null;
	}

    /**
     * Salva um template
     * @param template Template a ser salvo
     */
	public void salvarTemplate(Template template) {
	 
	}

    /**
     * Retorna uma lista de templates disponíveis
     * @return Lista de templates disponíveis
     */
	public Template[] listarTemplates() {
		return null;
	}
	 
}