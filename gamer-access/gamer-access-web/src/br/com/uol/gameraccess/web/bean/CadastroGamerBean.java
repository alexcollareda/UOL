package br.com.uol.gameraccess.web.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.uol.gameraccess.ejb.bo.GamerBO;
import br.com.uol.gameraccess.ejb.bo.TeamBO;
import br.com.uol.gameraccess.ejb.po.GamerPO;
import br.com.uol.gameraccess.ejb.vo.LigaDaJustica;
import br.com.uol.gameraccess.ejb.vo.Vingadores;
import br.com.uol.gameraccess.web.bean.util.BeanUtil;

/**
 * Classe de Backing bean, responsavel por ser o controlador da tela de cadastro
 * de gamer
 * 
 * @author Alex Collareda
 *
 */
@ManagedBean
public class CadastroGamerBean extends BeanUtil {

	@EJB
	private GamerBO gamerBO;

	@EJB
	private TeamBO teamBO;

	private GamerPO novoGamer;

	private List<Vingadores> listVingadores;

	private List<LigaDaJustica> listLigaDaJustica;

	/**
	 * Método construtor, sera chamado sempre que a tela que possua o
	 * apontamento para CadastroGamerBean, for instanciada
	 */
	@PostConstruct
	public void init() {
		novoGamer = new GamerPO();
		buscarListaVingadores();
		buscarListaLigaDaJustica();
	}

	public void verificarListaTeamSelecionado() {
		if (novoGamer.getTeamSelecionado() == 1 && (listVingadores == null || listVingadores.isEmpty())) {
			addMessage("Atenção", "Nenhum codinome disponível para o Team Vingadores, tente o Team Liga da Justiça");
		} else if (novoGamer.getTeamSelecionado() == 2 && (listLigaDaJustica == null || listLigaDaJustica.isEmpty())) {
			addMessage("Atenção", "Nenhum codinome disponível para o Team Liga da Justiça, tente o Team Vingadores");
		}
	}

	private void buscarListaVingadores() {
		try {
			listVingadores = teamBO.recuperarListaVingadoresApenasDisponivel();
		} catch (Exception e) {
			e.printStackTrace();
			addMessage("Erro", "Erro ao recuperar Vingadores");
		}
	}

	private void buscarListaLigaDaJustica() {
		try {
			listLigaDaJustica = teamBO.recuperarListaLigaDaJusticaApenasDisponivel();
		} catch (Exception e) {
			e.printStackTrace();
			addMessage("Erro", "Erro ao recuperar Liga da Justiça");
		}
	}

	public void cadastrarGamer() {
		try {
			gamerBO.cadastrarGamer(novoGamer);
			addMessage("Sucesso", novoGamer.getCodinomeSelecionado() + " Cadastrado com Sucesso!");
		} catch (Exception e) {
			addMessage("Erro", e.getMessage());
		}
	}

	public List<Vingadores> getListVingadores() {
		return listVingadores;
	}

	public void setListVingadores(List<Vingadores> listVingadores) {
		this.listVingadores = listVingadores;
	}

	public List<LigaDaJustica> getListLigaDaJustica() {
		return listLigaDaJustica;
	}

	public void setListLigaDaJustica(List<LigaDaJustica> listLigaDaJustica) {
		this.listLigaDaJustica = listLigaDaJustica;
	}

	public GamerPO getNovoGamer() {
		return novoGamer;
	}

	public void setNovoGamer(GamerPO novoGamer) {
		this.novoGamer = novoGamer;
	}
}