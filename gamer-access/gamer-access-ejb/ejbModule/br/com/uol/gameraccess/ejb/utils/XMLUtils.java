package br.com.uol.gameraccess.ejb.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * Classe utilit�ria para recuperar informa��es que est�o em XML
 * 
 * @author Alex Collareda
 *
 */
public class XMLUtils {

	public static String[] buscarListaLigaDaJustica(String urlXML) throws Exception {
		String[] retorno = null;

		try {
			retorno = ((TeamXmlObject) JAXBContext.newInstance(TeamXmlObject.class).createUnmarshaller().unmarshal(new InputStreamReader(new URL(urlXML).openStream()))).getCodinomes().getCodinome();
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar lista da liga da justi�a no XML", e);
		}

		return retorno;
	}
}
