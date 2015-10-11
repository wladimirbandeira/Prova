package br.com.endpoint.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.endpoint.model.Usuario;
import br.com.endpoint.repository.Usuarios;
import br.com.endpoint.services.CadastroUsuarioService;

@Named
@ViewScoped
public class PesquisaUsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;
	

	private Usuario usuario;

	private List<Usuario> usuariosFiltrados;

	Date data = new Date();


	public void inicializar() {
		

		
		
		usuariosFiltrados = usuarios.todos();


	}

	
	public PesquisaUsuarioBean() {
		usuariosFiltrados = new ArrayList<>();
	}

	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
