package br.com.endpoint.services;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.com.endpoint.jsf.NegocioException;
import br.com.endpoint.model.Usuario;
import br.com.endpoint.repository.Usuarios;
import br.com.endpoint.security.Seguranca;
import br.com.endpoint.util.jpa.Transactional;

public class CadastroUsuarioService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;

	@Transactional
	public Usuario salvar(Usuario usuario) {


		Usuario usuarioExistente = usuarios.porEmail(usuario.getEmail());

		if (usuarioExistente != null && !usuarioExistente.equals(usuario)) {
			throw new NegocioException("E-mail já existente");
		}


		return usuarios.guardar(usuario);
	}

	@Transactional
	public Usuario editar(Usuario usuario) {

		Date data = new Date();

		Usuario usuarioExistente = usuarios.porEmail(usuario.getEmail());

		Usuario dataUsuario = usuarios.porData(usuario.getData_atualizacao());
		
		
		

		if (usuarioExistente != null && !usuarioExistente.equals(usuario)) {
			throw new NegocioException("E-mail já existente");
		}

		
		if (dataUsuario.getData_atualizacao() != data) {
			usuario.setData_atualizacao(data);
		}

		return usuarios.guardar(usuario);
	}

}
