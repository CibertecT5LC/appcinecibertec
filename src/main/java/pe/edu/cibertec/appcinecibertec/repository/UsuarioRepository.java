package pe.edu.cibertec.appcinecibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.appcinecibertec.model.bd.Usuario;

@Repository
public interface UsuarioRepository extends
 JpaRepository<Usuario, Integer>{
	
	Usuario findByEmail(String email);
	
	Usuario findByNomusuario(String username);

}
