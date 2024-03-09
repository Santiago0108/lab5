package com.xv.consumeapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



@Controller
public class UserController {
	
	Juego juego = new Juego();
	
	@RequestMapping("/hello")
	//@ResponseBody
	private String hello() {
	    return "hello";
	}
	 
	 @RequestMapping("/user/{id}")
	 @ResponseBody
	 private ModelAndView getUser(@PathVariable Integer id, Model model)   {
		 String uri = "https://jsonplaceholder.typicode.com/todos/" + id;
		  RestTemplate restTemplate = new RestTemplate();
		  
		  User user = restTemplate.getForObject(uri, User.class);
		  
		  ModelAndView modelAndView = new ModelAndView("user");
		  modelAndView.addObject("user", user);

		  return modelAndView;
	 }
	 
	 @RequestMapping("/juego")
	 private String mostrarJuego(Model model) {
	        model.addAttribute("juego", juego);
	        return "guess";
	  }
	 
	 @PostMapping("/juego")
	    private String procesarJugada(@RequestParam("numero") int numeroIngresado, Model model) {
	        
	        juego.checkNum(numeroIngresado);
	        
	        model.addAttribute("juego", juego);
	        
	        return "guess"; // Devolver la vista de nuevo
	    }
	 
	 @RequestMapping("/reset")
	    private String reiniciarJuego() {
	        juego.reiniciar();
	        return "redirect:/juego"; // Redirigir al usuario de vuelta al juego
	    }
}
