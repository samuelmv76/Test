package org.cifpAviles.pruebaSpring.controller;

import java.util.List;

import org.cifpAviles.pruebaSpring.entities.Empleado;
import org.cifpAviles.pruebaSpring.services.EmpleadoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
}
