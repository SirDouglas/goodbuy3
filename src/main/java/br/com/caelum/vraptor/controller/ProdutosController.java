package br.com.caelum.vraptor.controller;


import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.modelo.Produto;
import br.com.caelum.vraptor.validator.Validator;
import static br.com.caelum.vraptor.view.Results.*;

@Controller
public class ProdutosController {

	@Inject
    private ProdutoDao dao;
	
	@Inject
	private Result result;
	
	@Inject
	private Validator validator;



	
	@Get("/produtos")
	public List<Produto> lista() {
		return dao.lista();
	}
	
	@Restrito
	@Post("/produtos")
	public void adiciona(@NotNull  @Valid Produto produto) {
		validator.validate(produto);
		validator.onErrorUsePageOf(ProdutosController.class).formulario();
		dao.adicionar(produto);
		result.redirectTo(ProdutosController.class).lista();
	}
	
	@Restrito
	@Get("produtos/novo")
	public void formulario() {
		
	}
	@Restrito
	@Get("produtos/{id}")
	public Produto edita(Long id) {
		Produto produto = new Produto();
		produto.setId(id);
		return dao.mostra(produto);
		}
	
	@Restrito
	@Put("/produtos/{produto.id}")
	public void altera(Produto produto) {
		dao.alterar(produto);
		result.redirectTo(this).lista();
	}
	
	  @Restrito
	  @Delete("/produtos/{id}")
	public void remove(Long id) {
		Produto produto = new Produto();
		produto.setId(id);
	produto =	dao.mostra(produto);
		dao.remove(produto);
		result.redirectTo(this).lista();
	}
	  
	  public List<Produto> busca(String nome) {
		  result.include("nome", nome);
		  return dao.busca(nome);
	  }
	  
	  @Get("/produtos/busca.json")
	  public void buscaJson(String q) {
		  result.use(json()).withoutRoot()
	      .from(dao.busca(q))
	    .exclude("id", "descricao")
	    .serialize(); 
	  }


	
}
