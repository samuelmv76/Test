package org.cifpAviles.pruebaSpring.controller;

import java.util.List;
import java.util.Optional;

import org.cifpAviles.pruebaSpring.entities.Empleado;
import org.cifpAviles.pruebaSpring.services.EmpleadoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/empleado")
public class EmpleadoRestController {
	
	private final EmpleadoService empleadoService;
	
	public EmpleadoRestController(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;

	}
	
	@GetMapping("info_empleado")
	@ResponseBody
	public List<Empleado> getEmpleados(){
		return empleadoService.findAll();
	}
	
	@PostMapping("add_empleado")
	public void crearEmpleado(@RequestBody Empleado empleado) {
		empleadoService.insert(empleado);
		
	}
	
	@GetMapping("get_empleado/{id}")
	@ResponseBody
	public Optional<Empleado> obtenerEmpleadoPorId(@PathVariable Long id){
		return empleadoService.findById(id);
	}
	
	@DeleteMapping("delete_empleado/{id}")
	public void eliminarEmpleadoPorId(@PathVariable Long id) {
		Empleado emp = new Empleado();
		emp.setId(id);
		empleadoService.borrar(emp);
	}
	
}