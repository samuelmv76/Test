package org.cifpAviles.pruebaSpring.controller;

import java.util.List;

import org.cifpAviles.pruebaSpring.entities.Empleado;
import org.cifpAviles.pruebaSpring.services.EmpleadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class EmpleadoController {
	
	private final EmpleadoService empleadoService;
	
	public EmpleadoController(EmpleadoService empleadoService) {
		this.empleadoService=empleadoService;
		
	}
	
	@GetMapping("info_empleados")
	public String getEmpleados(Model model) {
		
		//model.addAttribute("nombre","Sergio");
		return "lista_empleados";
	}
	
	@ModelAttribute("Empleados")
	public List<Empleado> listaEmpleados(){
		return empleadoService.findAll();	
		
	}
}
