package br.com.caelum.vraptor.controller;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.component.Imagens;
import br.com.caelum.vraptor.modelo.Produto;
import br.com.caelum.vraptor.observer.upload.UploadSizeLimit;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class ImagensController {

	

	private Validator validation;
	
	

	private Result result;

private Imagens imagens;


	private String pastaImagens = "/imagens";
	
	/**
	 * @deprecated CDI eyes only
	 */
	public ImagensController() {
		this(null,null,null);
	}
	
	
	@Inject
	public ImagensController(Validator validator,Result result,Imagens imagens) {
	this.validation = validator;
	this.result = result;
this.imagens = imagens;
	}
	
	   
	@Post("/produtos/{produto.id}/imagem")
	public void upload(Produto produto,UploadedFile imagem) {
		validation.onErrorRedirectTo(ProdutosController.class).edita(produto.getId());
		validation.addIf(imagem == null,new SimpleMessage("imagem.nula", "imagem não pode ser nula")).onErrorRedirectTo(ProdutosController.class).edita(produto.getId());
	validation.ensure(imagem.getContentType().startsWith("image"),new SimpleMessage("imagem", "naoeimagem"));
validation.onErrorRedirectTo(ProdutosController.class).edita(produto.getId());
//onErrorUsePageOf().edita(produto.getId());
		
	/*	File imagem1 = new File("/imagens",imagem.getFileName()); */
	imagens.salva(imagem, produto);
		result.redirectTo(ProdutosController.class)
		.edita(produto.getId());
	

	}
	
	@Get("/produtos/{produto.id}/imagem")
	public File download(Produto produto) {
		return imagens.mostra(produto);
	}
	


}
