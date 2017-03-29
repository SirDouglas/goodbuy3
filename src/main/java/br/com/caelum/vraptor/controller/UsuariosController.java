package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UsuarioDao;
import br.com.caelum.vraptor.modelo.Usuario;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UsuariosController {
	
	
	
	private final UsuarioDao dao;
	
	private final UsuarioWeb usuarioWeb;
	
	
	private final Result result;
	
	
	private final Validator validator;
	
	
	/**
	 * @deprecated CDI eyes only
	 */
	public UsuariosController() {
		this(null,null,null,null);
	}
	
	
           @Inject
	public UsuariosController(UsuarioDao dao, Result result, Validator validator,UsuarioWeb usuarioWeb) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
	}

	public void novo() {
		
	}
	
	@Post("/usuario")
	public void adiciona(Usuario usuario) {
		if (dao.existeUsuario(usuario)) {
			validator.add(new SimpleMessage("Login já existe","usuario.login")); 
		validator.onErrorUsePageOf(UsuariosController.class).novo();
		}
dao.adiciona(usuario);
result.redirectTo(ProdutosController.class).lista();
	}
	
	
	@Get("/login")
	public void loginForm() {
		
	}
	
	@Post("/login") 
	public void login(Usuario usuario) {
		Usuario carregado = dao.carrega(usuario);
		if (carregado == null) {
			validator.add(new SimpleMessage("Login e ou senha Invalida","usuario.login"));
		}
		validator.onErrorUsePageOf(UsuariosController.class).loginForm();
		usuarioWeb.login(carregado);
				result.redirectTo(ProdutosController.class).lista();
	}
	
	@Path("/logout")
	public void logout() {
		usuarioWeb.logout();
		result.redirectTo(ProdutosController.class).lista();
	}
	
}
