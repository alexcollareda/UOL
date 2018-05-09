package br.com.uol.gameraccess.ejb.vo;

/**
 * View Object da Liga da Justiça, criado para transacionar informações sem
 * carregar "sujeira" na memória
 * 
 * @author Alex Collareda
 *
 */
public class LigaDaJustica {
	private String codinome;

	public LigaDaJustica(String codinome) {
		super();
		this.codinome = codinome;
	}

	public String getCodinome() {
		return codinome;
	}

	public void setCodinome(String codinome) {
		this.codinome = codinome;
	}
}
