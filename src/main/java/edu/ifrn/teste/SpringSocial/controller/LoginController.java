package edu.ifrn.teste.SpringSocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.POST,path= {"/index"})
	public String login() {
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET,path= {"/entrar"})
	public String entrar() {
		System.out.println("Testando");
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.GET,path= {"/teste"})
	public String teste() {
		System.out.println("Testando");
		return "paginateste";
	}
	
	
	
}
