package mx.edu.utn.senderoseguro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utn.senderoseguro.modelo.User;

@Repository
public interface RepositorioUsuario extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	
	User findByEmailAndIdStatus(String email, Integer idStatus);
	
}
