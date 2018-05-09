package br.com.uol.gameraccess.web.bean.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Classe utilitaria para classes de backing bean
 * 
 * @author Alex Collareda
 *
 */
public class BeanUtil {
	/**
	 * Metodo que recebe String's que serão apresentadas em tela
	 * 
	 * @param titulo
	 * @param mensagem
	 */
	public void addMessage(String titulo, String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(titulo, mensagem));
	}
}