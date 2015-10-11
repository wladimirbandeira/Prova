package br.com.endpoint.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import br.com.endpoint.model.Usuario;
import br.com.endpoint.services.CadastroUsuarioService;
import br.com.endpoint.util.jpa.FacesUtil;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;

	
	
	
	@Inject
	private CadastroUsuarioService cadastroUsuarioService;

	
	
	
	public CadastroUsuarioBean(){
		usuario = new Usuario();
	}
	
//	
//	Md5PasswordEncoder md5 = new Md5PasswordEncoder();
//	usuario.setSenha(md5.encode(usuario.getSenha()));
	
	public void salvar(){
		
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		usuario.setSenha(md5.encodePassword(usuario.getSenha(),usuario));
		
		this.usuario = cadastroUsuarioService.salvar(this.usuario);
		limpar();
		FacesUtil.addInfoMessage("salvo com sucesso");
	}

	
	public void limpar(){
		usuario = null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
