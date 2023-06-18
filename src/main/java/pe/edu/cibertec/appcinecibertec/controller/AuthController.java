package pe.edu.cibertec.appcinecibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@GetMapping("/login")
	public String login() {
		return "auth/frmLogin";
	}
	
	@GetMapping("/registrar")
	public String registrar() {
		return "auth/frmRegistro";
	}
}
