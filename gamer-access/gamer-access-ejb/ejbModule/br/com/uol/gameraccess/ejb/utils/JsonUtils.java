package br.com.uol.gameraccess.ejb.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Classe utilit�ria para recuperar informa��es que est�o em JSON
 * 
 * @author Alex Collareda
 *
 */
public class JsonUtils {

	/**
	 * M�todo respons�vel por Ler o JSON do parametro urlJson, e converter para um objeto utilit�rio JSON;
	 * 
	 * @param urlJson
	 * @return TeamJsonObject
	 * @throws Exception
	 */
	public static TeamJsonObject converterJsonParaTeamObjeto(String urlJson) throws Exception {
		TeamJsonObject objConvertido = null;
		try {
			InputStreamReader reader = new InputStreamReader(new URL(urlJson).openStream());
			objConvertido = new Gson().fromJson(reader, TeamJsonObject.class);

		} catch (JsonSyntaxException | JsonIOException | IOException e) {
			e.printStackTrace();
			throw new Exception("Erro ao realizar a busca da lista dos vingadores em JSON", e);
		}

		return objConvertido;
	}
}
