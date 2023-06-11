package pe.edu.cibertec.appcinecibertec.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.appcinecibertec.model.bd.Empleado;


@Repository
public interface EmpleadoRepository 
	extends JpaRepository<Empleado, Integer>{
	
	@Transactional
	@Modifying
	@Query(
			value = "{call sp_RegistrarEmpleado(:nomempleado, :apeempleado)}"
			, nativeQuery = true)
	void registrarEmpleado(@Param("nomempleado") String nomempleado,
						@Param("apeempleado") String apeempleado);

}
