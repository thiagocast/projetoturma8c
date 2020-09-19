package br.com.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.beans.Artista;
import br.com.projetofinal.dao.ArtistaDAO;

@RestController
public class ArtistaController {
	@Autowired
	private ArtistaDAO dao;
	
	
	@PostMapping("/gravar")
	public ResponseEntity<Artista> gravar(@RequestBody Artista dados){
		try {
			dao.save(dados);
			return ResponseEntity.ok(dados);
		} catch (Exception e) {
			return ResponseEntity.status(500).build();		
		}
	}
	
	@GetMapping("/nacionalidade/{nac}")
	public ResponseEntity<ArrayList<Artista>> getNacio(@PathVariable String nac){
		ArrayList<Artista> u = (ArrayList<Artista>)dao.findByNacionalidade(nac);
		if(u==null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("/artistas/{id}")
	public ResponseEntity<Artista> getArtista(@PathVariable int id){
		Artista u = dao.findById(id).orElse(null);
		if(u==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("/artistas")
	public ResponseEntity<ArrayList<Artista>> getAll(){
		ArrayList<Artista> u = (ArrayList<Artista>)dao.findAll();
		if(u.size()==0) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(u);
	}
	
}
