package br.com.uol.gameraccess.ejb.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import br.com.uol.gameraccess.ejb.vo.Vingadores;

public class TeamJsonObject {

	List<Vingadores> vingadores;

	public List<Vingadores> getVingadores() {
		return vingadores;
	}

	@XmlElement
	public void setVingadores(List<Vingadores> vingadores) {
		this.vingadores = vingadores;
	}

}