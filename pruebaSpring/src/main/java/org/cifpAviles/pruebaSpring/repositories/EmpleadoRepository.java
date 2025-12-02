package org.cifpAviles.pruebaSpring.repositories;
import java.util.List;

import org.cifpAviles.pruebaSpring.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EmpleadoRepository extends JpaRepository<Empleado,Long>{
	@Query("select e from Empleado where e.nombre=?1 ")
	List<Empleado>findByEdadGreaterThan(String nombre);

}
