package br.up.cadastronoivos.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.up.cadastronoivos.entidades.ClienteNoivos;

@Stateless
public class ServicoClienteNoivos {

	@PersistenceContext
	private EntityManager em;

	public void cadastrarCliente(ClienteNoivos noivos) {
		this.em.persist(noivos);

	}

	public List<ClienteNoivos> listarCliente() {
		Query query = this.em.createQuery("SELECT c FROM ClienteNoivos c", ClienteNoivos.class);
		return query.getResultList();
	}

	public void excluirCliente(ClienteNoivos noivos) throws Exception {
		if (listarClienteValorPago(noivos).isEmpty()) {
			this.em.remove(this.em.merge(noivos));
		}else {
			throw new Exception("Nao é possivel excluir, pois o contrato ja foi pago");
		}
		
	}
	
	public List<ClienteNoivos> listarClienteValorPago(ClienteNoivos noivos) {
		Query query = this.em.createQuery("SELECT c FROM ClienteNoivos c WHERE c.valorPago=:p1", ClienteNoivos.class);
		query.setParameter("p1", "Sim");
		return query.getResultList();
	}

}
