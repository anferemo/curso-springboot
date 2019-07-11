package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*import java.util.Map; Otra clase para enviar datos a la vista*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/*import org.springframework.ui.ModelMap; Otra clase para enviar datos a la vista*/ 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
/*import org.springframework.web.servlet.ModelAndView; Otra clase para enviar datos a la vista*/

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping(value= {"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Este es el parametro titulo con model");		
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario user = new Usuario();
		user.setNombre("Andrés");
		user.setApellido("Reyes");
		user.setEmail("anreyes@personalsoft.com.co");
		model.addAttribute("usuario", user);
		model.addAttribute("titulo", "Perfil de usuario: ".concat(user.getNombre()));	
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
				
		
		model.addAttribute("titulo", "Listado de Usuarios");
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){ //El ModelAttribute es para que este disponible en cualquier vista
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andres", "Reyes", "andres@mail.com.co"),
				new Usuario("Monica", "Naranjo", "moni@mail.com"),
				new Usuario("Natalia", "Ramirez", "natis88@mail.com.co"),
				new Usuario("Andrea", "Pereira", "andrea@mail.com.co"));
		return usuarios;
	}
}
