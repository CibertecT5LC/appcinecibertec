package pe.edu.cibertec.appcinecibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.cibertec.appcinecibertec.model.bd.Empleado;

public interface EmpleadoRepository 
extends JpaRepository<Empleado, Integer>{

}
