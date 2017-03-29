package br.com.caelum.vraptor.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.Restrito;
import br.com.caelum.vraptor.controller.UsuarioWeb;
import br.com.caelum.vraptor.controller.UsuariosController;
import br.com.caelum.vraptor.core.InterceptorStack;



@RequestScoped
@Named
@Intercepts
public class AutorizacaoInterceptor implements Interceptor{
    
	
	private final UsuarioWeb usuario;
	
	
	private final Result result;

	
	/**
     * @deprecated CDI eyes only
     */
    protected AutorizacaoInterceptor() {
        this(null,null);
    }
	     @Inject
	public AutorizacaoInterceptor(UsuarioWeb usuario,Result result) {
		// TODO Auto-generated constructor stub
		this.usuario = usuario;
		this.result = result;
	}

	public boolean accepts(ControllerMethod arg0) {
		// TODO Auto-generated method stub
		 return !usuario.isLogado() && arg0.containsAnnotation(Restrito.class);
	}


	public void intercept(InterceptorStack arg0, ControllerMethod arg1, Object arg2) throws InterceptionException {
		// TODO Auto-generated method stub
		result.redirectTo(UsuariosController.class).loginForm();
	}

}
