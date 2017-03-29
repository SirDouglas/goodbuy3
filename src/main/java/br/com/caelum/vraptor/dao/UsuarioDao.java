package br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.modelo.Usuario;

public class UsuarioDao {
	
	@Inject
	private EntityManager manager;

	public boolean existeUsuario(Usuario usuario) {
			if (manager.createQuery("select u from Usuario u where login = :login and senha = :senha").setParameter("login", usuario.getLogin())
		.setParameter("senha", usuario.getSenha()).getResultList().size() == 1) {
				System.out.println("Bom dia!!!!!!");
		return true; }
			return false;
	}

	public void adiciona(Usuario usuario) {
		manager.persist(usuario);
		
	}

	public Usuario carrega(Usuario usuario) {
		// TODO Auto-generated method stub
		if (this.existeUsuario(usuario)) {
			return (Usuario) manager.createQuery("select u from Usuario u where login = :login and senha = :senha").setParameter("login", usuario.getLogin())
					.setParameter("senha", usuario.getSenha()).getSingleResult();
		}
	return null;
	}

}
