package br.com.uol.gameraccess.ejb.utils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="liga_da_justica")
public class TeamXmlObject {
	private Codinomes codinomes;

	public Codinomes getCodinomes() {
		return codinomes;
	}

	@XmlElement
	public void setCodinomes(Codinomes codinomes) {
		this.codinomes = codinomes;
	}

	@Override
	public String toString() {
		return "ClassPojo [codinomes = " + codinomes + "]";
	}
}