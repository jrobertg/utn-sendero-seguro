package mx.edu.utn.senderoseguro.web.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPrincipal {
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/")
	public ModelAndView home() {
		ModelAndView view = new ModelAndView("inicio/home");
		view.addObject("titulo", "Dashboard");
		return view;
	}
}
