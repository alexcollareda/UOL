package br.com.uol.gameraccess.web.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.uol.gameraccess.ejb.bo.GamerBO;
import br.com.uol.gameraccess.ejb.po.GamerPO;

/**
 * Classe de Backing bean, respons�vel por ser o controlador da tela de cadastro de gamer
 * 
 * @author Alex Collareda
 *
 */
@ManagedBean
public class ListarGamerBean {

	@EJB
	private GamerBO gamerBO;

	private List<GamerPO> listGamer;

	/**
	 * Metodo construtor, sera chamado sempre que a tela que possua o apontamento para ListarGamerBean, for instanciada
	 */
	@PostConstruct
	public void init() {
	}

	public void listar() {
		listGamer = gamerBO.buscarGamers();
	}

	public List<GamerPO> getListGamer() {
		return listGamer;
	}

	public void setListGamer(List<GamerPO> listGamer) {
		this.listGamer = listGamer;
	}

}