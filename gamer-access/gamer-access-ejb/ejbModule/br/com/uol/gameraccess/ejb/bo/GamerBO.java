package br.com.uol.gameraccess.ejb.bo;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.uol.gameraccess.ejb.dao.GamerDAO;
import br.com.uol.gameraccess.ejb.po.GamerPO;

/**
 * Classe de business Object para interações referente a entidade/funcionalidade
 * Jogador
 *
 * Classe deve ser utilizada com a anotação @EJB
 * 
 * @author Alex Collareda
 *
 */
@Stateless
public class GamerBO {

	@Inject
	private GamerDAO gamerDAO;

	/**
	 * Metodo
	 * 
	 * @param gamerCadastro
	 * @throws Exception
	 */
	public void cadastrarGamer(GamerPO gamerCadastro) throws Exception {
		/**
		 * Verificaçoes de regra de negocio
		 */
		if (gamerCadastro == null) {
			throw new Exception("Gamer Inválido");
		} else if (gamerCadastro.getNome() == null || gamerCadastro.getNome().isEmpty()) {
			throw new Exception("Nome Inválido");
		} else if (gamerCadastro.getEmail() == null || gamerCadastro.getEmail().isEmpty()) {
			throw new Exception("E-mail Inválido");
		} else if (gamerCadastro.getTeamSelecionado() == 0) {
			throw new Exception("Team Inválido");
		} else if (gamerCadastro.getCodinomeSelecionado() == null || gamerCadastro.getCodinomeSelecionado().isEmpty()) {
			throw new Exception("Codinome Inválido");
		}

		salvarGamer(gamerCadastro);
	}

	/**
	 * Metodo privado responsável por chamar o DAO para salvar a entidade
	 * 
	 * @param gamerCadastro
	 */
	private void salvarGamer(GamerPO gamerCadastro) {
		gamerDAO.cadastrar(gamerCadastro);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<GamerPO> buscarGamers() {
		// Ideal Usar LOGGER, mas como me atrasei com a entrega por problemas no
		// meu ambiente, deixarei como sysout
		System.out.println("GamerBO - Buscando gamers cadastrados");
		return gamerDAO.listarGamers();
	}
}