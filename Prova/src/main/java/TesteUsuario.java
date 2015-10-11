
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.endpoint.model.Usuario;

public class TesteUsuario {
	public static void main(String[] args) {
		
		
		
		Usuario usuario = new Usuario();
		
		usuario.setNome("wladimir");
		usuario.setSenha("123");
		usuario.setEmail("wladimir@gmail.com");
		usuario.setTelefone(12345678);
		usuario.setData_criacao(new Date());
		usuario.setData_atualizacao(new Date());
		




		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EndPointPU");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = null;

		try {
			trx = manager.getTransaction();
			trx.begin();
			manager.persist(usuario);
		
			trx.commit();
		} catch (RuntimeException e) {
			if (trx.isActive())
				trx.rollback();
			throw e;

		}

	}

	
}
