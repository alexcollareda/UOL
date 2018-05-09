package br.com.uol.gameraccess.ejb.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa a entidade Gamer contida no banco de dados
 * 
 * @author Alex Collareda
 *
 */

@Entity
@Table(name = "GAMER")
public class GamerPO {

	@Id
	@Column(name = "ID_GAMER", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idGamer;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "TELEFONE", nullable = true)
	private String telefone;

	@Column(name = "TEAM", nullable = false)
	private int teamSelecionado;

	@Column(name = "CODINOME", nullable = false)
	private String codinomeSelecionado;

	public long getIdGamer() {
		return idGamer;
	}

	public void setIdGamer(long idGamer) {
		this.idGamer = idGamer;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getTeamSelecionado() {
		return teamSelecionado;
	}

	public void setTeamSelecionado(int teamSelecionado) {
		this.teamSelecionado = teamSelecionado;
	}

	public String getCodinomeSelecionado() {
		return codinomeSelecionado;
	}

	public void setCodinomeSelecionado(String codinomeSelecionado) {
		this.codinomeSelecionado = codinomeSelecionado;
	}
}