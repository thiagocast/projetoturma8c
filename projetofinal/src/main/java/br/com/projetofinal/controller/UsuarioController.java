package br.com.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.beans.Usuario;
import br.com.projetofinal.dao.UsuarioDAO;

@RestController											//Define a classe como Controller
public class UsuarioController {
	
	@Autowired											//Delega ao springboot utilizar os métodos do DAO
	private UsuarioDAO dao;
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario dados){
		Usuario u = dao.findByEmailAndSenha(dados.getEmail(), dados.getSenha());
		if(u==null) {
			return ResponseEntity.status(401).build();
		}
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getUser(@PathVariable int id){ 		//nome da variavel tem que ser igual ao nome declarado no annotation
		Usuario u = dao.findById(id).orElse(null);
		if(u==null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(u);
	}

	@GetMapping("/usuarios")
	public ResponseEntity<ArrayList<Usuario>> getAll(){
		ArrayList<Usuario> u = (ArrayList<Usuario>)dao.findAll();		//Necessário fazer um casting sobre o tipo iterable para Arraylist
		if(u.size()==0) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(u);
	}
	
}
