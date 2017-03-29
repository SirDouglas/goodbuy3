package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.modelo.Carrinho;
import br.com.caelum.vraptor.modelo.Item;

@Controller
public class CarrinhoController {

	private final Carrinho carrinho;
	private final ProdutoDao dao;
	private final Result result;
	
	/**
	 * @deprecated CDI eyes only
	 */
	public CarrinhoController() {
		this(null,null,null);
	}
	
	@Inject
	public CarrinhoController(Carrinho carrinho,ProdutoDao dao,Result result) {
		this.carrinho = carrinho;
		this.dao = dao;
		this.result = result;
	}
	
	@Post("/carrinho")
	public void adiciona(Item item) {
	item.setProduto(dao.recarrega(item.getProduto()));	
		carrinho.adiciona(item);
			result.redirectTo(this).visualiza();
	}
	
	@Get("/carrinho")
	public void visualiza() {
		
	}
	
	@Delete("/carrinho/{indiceItem}")
	public void remove(int indiceItem) {
		carrinho.remove(indiceItem);
		result.redirectTo(this).visualiza();
		
	}
	
}
