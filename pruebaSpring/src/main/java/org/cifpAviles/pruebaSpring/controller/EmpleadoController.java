package org.cifpAviles.pruebaSpring.controller;

import java.util.List;
import java.util.Optional;

import org.cifpAviles.pruebaSpring.entities.Empleado;
import org.cifpAviles.pruebaSpring.services.EmpleadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("empleado")
public class EmpleadoController {
	
	private final EmpleadoService empleadoService;
	
	public EmpleadoController(EmpleadoService empleadoService) {
		this.empleadoService=empleadoService;
	}
	
	@GetMapping("info_empleados")
	public String getEmpleados(Model model) {
		model.addAttribute("nombre","Manel");
		return "lista_empleados";
	}
	
	@ModelAttribute("empleados")
	public List<Empleado> listaEmpleados(){
		return empleadoService.findAll();
	}
	
	@GetMapping("nuevo_empleado")
	public String mostrarFormulario(Model model){
		model.addAttribute("empleado",new Empleado());
		return "crear_empleado";
	}
	
	@PostMapping("add_empleado")
	public String crearEmpleado(@ModelAttribute Empleado empleado) {
		empleadoService.insert(empleado);
		return "pagina_exito";
	}
	
	@GetMapping("buscar_empleado")
	public String mostrarFormularioBuscar(Model model){
		model.addAttribute("empleado",new Empleado());
		return "buscar_empleado";
	}
	
	@PostMapping("get_empleado")
	public String obtenerEmpleadoPorId(@ModelAttribute Empleado empleado, Model model) {
		Optional<Empleado> em=empleadoService.findById(empleado.getId());
		model.addAttribute("empleado",(Empleado)em.get());
		return "pagina_exito";
	} 
	
	@GetMapping("borrar_empleado")
	public String mostrarFormularioBorrar(Model model){
		model.addAttribute("empleado",new Empleado());
		return "borrar_empleado";
	}
	
	@PostMapping("delete_empleado")
	public String borrarEmpleado(@ModelAttribute Empleado empleado, Model model) {
		empleadoService.borrar(empleado);
		return "pagina_exito";
	} 
}