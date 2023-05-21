package pe.edu.cibertec.appcinecibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.appcinecibertec.model.bd.Estado;

@Repository
public interface EstadoRepository 
	extends JpaRepository<Estado, Integer>{
		
}