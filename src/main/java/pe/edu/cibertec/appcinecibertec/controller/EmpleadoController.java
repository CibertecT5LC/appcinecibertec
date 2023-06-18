package pe.edu.cibertec.appcinecibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.cibertec.appcinecibertec.model.bd.Empleado;
import pe.edu.cibertec.appcinecibertec.model.bd.Estado;
import pe.edu.cibertec.appcinecibertec.model.bd.Sala;
import pe.edu.cibertec.appcinecibertec.model.request.SalaRequest;
import pe.edu.cibertec.appcinecibertec.model.response.ResultadoResponse;
import pe.edu.cibertec.appcinecibertec.service.EmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	
	@Autowired
	
	private EmpleadoService empleadoService;

	@GetMapping("/frmempleado")
	//@PreAuthorize(value = "ADMIN")
	public String frmMantEmpleado(Model model) {
		model.addAttribute("listaempleados", 
				empleadoService.listarEmpleados());
		return "empleado/frmempleado";
	}
	
	
	@PostMapping("/registrarEmpleado")
	@ResponseBody
	public ResultadoResponse registrarEmpleado(
			@RequestBody Empleado empleado
			) {
		String mensaje ="Empleado registrado correctamente";
		Boolean respuesta = true;
		try {			
			empleadoService.registrarEmpleado(empleado);
		}catch(Exception ex) {
			mensaje = "Empleado no registrado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	
	@GetMapping("/listarempleados")
	@ResponseBody
	public List<Empleado> listarEmpleados(){
		return empleadoService.listarEmpleados();
	}
	
}
