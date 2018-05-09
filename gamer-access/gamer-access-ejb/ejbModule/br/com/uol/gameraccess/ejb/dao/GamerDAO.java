package br.com.uol.gameraccess.ejb.dao;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.uol.gameraccess.ejb.po.GamerPO;

/**
 * Classe responsavel por transacao com Banco de dados referente a entidade
 * GamerPO;
 * 
 * @author Alex Collareda
 *
 */
@ManagedBean
public class GamerDAO {

	/**
	 * Referencia ao persistence-unit que referencia um datasource no servidor
	 * container no arquivo persistence.xml
	 */
	@PersistenceContext(unitName = "JPAGamerAccess")
	private EntityManager em;

	/**
	 * Método realiza o cadastro de um novo gamer ou atualiza um gamer ja
	 * existente
	 * 
	 * @param gamerCadastro
	 */
	public void cadastrar(GamerPO gamerCadastro) {
		if (gamerCadastro.getIdGamer() == 0) {
			em.merge(gamerCadastro);
		} else {
			em.persist(gamerCadastro);
		}
	}

	/**
	 * Método que realiza a busca dos codinomes cadastrados por TEAM
	 * 
	 * @param team
	 * @return List<String>
	 */
	public List<String> listarCodinomesCadastradoPorTeam(int team) {
		// Ideal Usar logger, mas como me atrasei com a entrega por problemas no
		// meu ambiente, deixarei como sysout
		System.out.println("DAO - listando codinomes já cadastrados por team");
		TypedQuery<String> query = em.createQuery(getSqlListarCodinomesCadastradoPorTeam(), String.class);
		query.setParameter("team", team);
		return query.getResultList();
	}

	/**
	 * Metodo retorna todos os gamers cadastrados sem Where
	 * 
	 * @return List<GamerPO>
	 */
	public List<GamerPO> listarGamers() {
		// Ideal Usar logger, mas como me atrasei com a entrega por problemas no
		// meu ambiente, deixarei como sysout
		System.out.println("DAO - listando todos os gamers cadastrados");
		TypedQuery<GamerPO> query = em.createQuery(getSqlListarGamers(), GamerPO.class);
		return query.getResultList();
	}

	/**
	 * Metodo responsavel por recuperar sql para listar os gamers cadastrados.
	 * 
	 * @return String
	 */
	private String getSqlListarGamers() {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT gamer FROM GamerPO gamer");
		return hql.toString();
	}

	/**
	 * Metodo responsavel por recuperar o sql para listar todos os codinomes
	 * cadastrados
	 * 
	 * @return String
	 */
	private String getSqlListarCodinomesCadastradoPorTeam() {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT gamer.codinomeSelecionado FROM GamerPO gamer WHERE gamer.teamSelecionado = :team");
		return hql.toString();
	}
}