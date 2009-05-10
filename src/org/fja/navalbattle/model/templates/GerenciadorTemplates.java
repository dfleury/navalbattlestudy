package org.fja.navalbattle.model.templates;

public class GerenciadorTemplates {
 
	private static GerenciadorTemplates instance;
	 
	private Template[] templates;
	 
    private GerenciadorTemplates() {

    }
	 
	public static GerenciadorTemplates getInstance() {
		if (instance == null) {
            instance = new GerenciadorTemplates();
        }

        return instance;
	}
	 
	public Template criarTemplate() {
		return null;
	}
	 
	public Template abrirTemplate(String nome) {
		return null;
	}
	 
	public void salvarTemplate(Template template) {
	 
	}
	 
	public Template[] listarTemplates() {
		return null;
	}
	 
}
 
