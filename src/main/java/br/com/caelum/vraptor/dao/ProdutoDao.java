package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.modelo.Produto;

@RequestScoped
public class ProdutoDao  {
	
	
	/**
	 * 
	 */

	@Inject
	private EntityManager manager;

	
	public void adicionar(Produto produto) {
		manager.persist(produto);
	}
	
	public void alterar(Produto produto) {
		manager.merge(produto);
	}
	
	public void remove(Produto produto) {
		manager.remove(produto);
	}
	
	public List<Produto> lista() {
		return manager.createQuery("select p FROM Produto p").getResultList();
	
		
	}
	
	public Produto mostra(Produto produto) {
		return 	manager.find(Produto.class,produto.getId());
	}
	

			
	public List<Produto> busca(String nome) {
		// TODO Auto-generated method stub
		return manager.createQuery("select p From Produto p where nome like :nome").setParameter("nome","%" + nome + "%").getResultList();
	}

	public Produto recarrega(Produto produto) {
	return manager.find(Produto.class, produto.getId());
		
	}
}
