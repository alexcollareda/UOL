package br.com.uol.gameraccess.ejb.bo;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.uol.gameraccess.ejb.dao.GamerDAO;
import br.com.uol.gameraccess.ejb.utils.JsonUtils;
import br.com.uol.gameraccess.ejb.utils.XMLUtils;
import br.com.uol.gameraccess.ejb.vo.LigaDaJustica;
import br.com.uol.gameraccess.ejb.vo.Vingadores;

/**
 * Classe EJB/Business Object, para tratamento de regra de neg�cios refente � Team's Object {Vingadores,LigaDaJustica}
 * 
 * @author Alex Collareda
 *
 */
@Stateless
public class TeamBO {
	/**
	 * Atributo statico para URL do JSON Vingadores
	 */
	private static final String URL_JSON_VINGADORES = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";

	/**
	 * Atributo statico para URL do XML Liga da Justiça
	 */
	private static final String URL_XML_LIGADAJUSTICA = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml";

	private static final int TEAM_VINGADORES = 1;

	private static final int TEAM_LIGA_DA_JUSTICA = 2;

	@Inject
	private GamerDAO gamerDAO;

	/**
	 * Metodo responsavel por requisitar a lista de vingadores
	 * 
	 * @return List<Vingadores>
	 * @throws Exception
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Vingadores> recuperarListaVingadores() throws Exception {
		return JsonUtils.converterJsonParaTeamObjeto(URL_JSON_VINGADORES).getVingadores();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Vingadores> recuperarListaVingadoresApenasDisponivel() throws Exception {
		List<String> listCadastrado = gamerDAO.listarCodinomesCadastradoPorTeam(TEAM_VINGADORES);
		List<Vingadores> vingadoresRetorno = new ArrayList<Vingadores>();

		for (Vingadores vingadorJson : recuperarListaVingadores()) {
			if (!listCadastrado.contains(vingadorJson.getCodinome())) {
				vingadoresRetorno.add(vingadorJson);
			}
		}

		return vingadoresRetorno;
	}

	/**
	 * M�todo respons�vel por requisitar a lista de Justiceiros
	 * 
	 * @return List<LigaDaJustica>
	 * @throws Exception
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<LigaDaJustica> recuperarListaLigaDaJustica() throws Exception {
		return converterStringParaListaLigaDaJustica(XMLUtils.buscarListaLigaDaJustica(URL_XML_LIGADAJUSTICA));
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<LigaDaJustica> recuperarListaLigaDaJusticaApenasDisponivel() throws Exception {
		List<String> listCadastrado = gamerDAO.listarCodinomesCadastradoPorTeam(TEAM_LIGA_DA_JUSTICA);
		List<LigaDaJustica> vigaDaJusticaRetorno = new ArrayList<LigaDaJustica>();

		for (LigaDaJustica ligaDaJusticaJson : recuperarListaLigaDaJustica()) {
			if (!listCadastrado.contains(ligaDaJusticaJson.getCodinome())) {
				vigaDaJusticaRetorno.add(ligaDaJusticaJson);
			}
		}

		return vigaDaJusticaRetorno;
	}

	/**
	 * M�todo recebe um Array de String e converte para uma lista de {@link LigaDaJustica}
	 * 
	 * @param listaXML
	 * @return List<LigaDaJustica>
	 */
	private List<LigaDaJustica> converterStringParaListaLigaDaJustica(String[] listaXML) {
		List<LigaDaJustica> ligaDaJusticaList = new ArrayList<LigaDaJustica>();

		for (String cod : listaXML) {
			ligaDaJusticaList.add(new LigaDaJustica(cod));
		}

		return ligaDaJusticaList;
	}

}