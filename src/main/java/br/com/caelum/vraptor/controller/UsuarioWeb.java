package br.com.caelum.vraptor.controller;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.vraptor.modelo.Usuario;

import java.io.Serializable;


@Named
@SessionScoped
public class UsuarioWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private  Usuario logado;
	
	public void login(Usuario usuario) {
		this.logado = usuario;
		
	}
	
	public String getNome() {
		return logado.getNome();
		
	}
	
	public boolean isLogado() {
		return logado != null;
	}

	public void logout() {
		this.logado = null;
		
	}

}
