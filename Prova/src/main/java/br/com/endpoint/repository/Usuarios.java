package br.com.endpoint.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.endpoint.model.Usuario;

public class Usuarios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject	
	private EntityManager manager;
	
	
	
	public Usuario guardar(Usuario usuario) {
		return manager.merge(usuario);
	}
	
	public Usuario porEmail(String email) {
		try {
			return  manager.createQuery("from Usuario where upper(email) = :email", Usuario.class)
				.setParameter("email", email.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	
	
	public List<Usuario> todos() {
		return manager.createQuery("from Usuario", 
				Usuario.class).getResultList();
	}
	
	

	public Usuario porId(Long codigo) {
		
		return manager.find(Usuario.class, codigo);
	}

	public Usuario porData(Date data_atualizacao) {
		try {
			return  manager.createQuery("from Usuario where data_atualizacao = :data_atualizacao", Usuario.class)
					.setParameter("data_atualizacao",data_atualizacao)
					.getSingleResult();	
		} catch (NoResultException e) {
			return null;
		}
		
		
	}


	
	

}
