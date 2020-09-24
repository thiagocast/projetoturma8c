package br.com.projetofinal.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.beans.Usuario;
import br.com.projetofinal.dao.UsuarioDAO;

@CrossOrigin("*")
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioDAO dao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void method(HttpServletResponse httpServletResponse) {
	    httpServletResponse.setHeader("Location", "/index.html");
	    httpServletResponse.setStatus(302);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario dados) {
		Usuario u = dao.findByRacfAndSenha(dados.getRacf(), dados.getSenha());
		if (u == null) {
			return ResponseEntity.status(401).build();
		}
		return ResponseEntity.ok(u);
	}

}
