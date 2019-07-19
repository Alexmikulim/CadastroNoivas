package br.up.cadastronoivos.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.up.cadastronoivos.entidades.ClienteNoivos;
import br.up.cadastronoivos.servico.ServicoClienteNoivos;
import br.up.cadastronoivos.web.JSFUtils;

@Named
@RequestScoped
public class ClienteNoivosBean {

	@EJB
	private ServicoClienteNoivos servicoNoivos;

	private ClienteNoivos noivos;

	private ClienteNoivosBean() {
		this.noivos = new ClienteNoivos();
	}

	/**
	 * metodo para listar os noivos cadastrados
	 * 
	 * @return
	 */
	public List<ClienteNoivos> listarClientenoivos() {
		return this.servicoNoivos.listarCliente();
	}

	/**
	 * Metodo para cadastrar os noivos
	 */
	public void cadastrarCliente() {
		try {
			this.servicoNoivos.cadastrarCliente(noivos);
			JSFUtils.enviarMensagemDeInformacao("Dados Cadastrados!");
			this.noivos = new ClienteNoivos();
		} catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}

	/**
	 * metodo para excluir os noivos
	 * 
	 * @param noivos
	 */
	public void excluirCLiente(ClienteNoivos noivos) {
		try {
		this.servicoNoivos.excluirCliente(noivos);
		JSFUtils.enviarMensagemDeInformacao("Cadastros dos Noivos excluido com Sucesso!!");
		}catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}

	public ClienteNoivos getCliente() {
		return noivos;
	}

	public ServicoClienteNoivos getServicocliente() {
		return servicoNoivos;
	}

	public void setCliente(ClienteNoivos noivos) {
		this.noivos = noivos;
	}

	public void setServicocliente(ServicoClienteNoivos servicoNoivos) {
		this.servicoNoivos = servicoNoivos;
	}
}
