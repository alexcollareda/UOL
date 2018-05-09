package br.com.uol.gameraccess.ejb.vo;

/**
 * View Object Vingadores, criado para transacionar informa��es sem carregar "sujeira" na mem�ria
 * 
 * @author Alex Collareda
 *
 */
public class Vingadores {

	private String codinome;

	public String getCodinome() {
		return codinome;
	}

	public void setCodinome(String codinome) {
		this.codinome = codinome;
	}
}