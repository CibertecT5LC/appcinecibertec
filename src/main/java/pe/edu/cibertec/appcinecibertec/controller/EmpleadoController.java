package pe.edu.cibertec.appcinecibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.cibertec.appcinecibertec.service.EmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping("/frmempleado")
	public String frmMantEmpleado(Model model) {
		model.addAttribute("listaempleados", 
				empleadoService.listarEmpleados());
		return "empleado/frmempleado";
	}
	
}
