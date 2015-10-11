package br.com.endpoint.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;

import br.com.endpoint.model.Usuario;

public class CadastrarTesteUsuario {

	
	@PersistenceContext
	private EntityManager manager;

	@Test
	public Usuario guardar(Usuario usuario) {
		
		usuario.setNome("dougas");
		usuario.setSenha("123");
		usuario.setEmail("dougas@gmail.com");
		usuario.setTelefone(12345678);
		usuario.setData_criacao(new Date());
		usuario.setData_atualizacao(new Date());
	
		
		return manager.merge(usuario);
	}
	
	

}
