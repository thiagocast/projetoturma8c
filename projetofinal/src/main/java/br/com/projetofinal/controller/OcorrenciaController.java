package br.com.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.beans.Ocorrencia;
import br.com.projetofinal.dao.OcorrenciaDAO;

@CrossOrigin("*")
@RestController
public class OcorrenciaController {
	@Autowired
	private OcorrenciaDAO dao;
	
	@GetMapping("/ocorrencias/{id}")
	public ResponseEntity<ArrayList<Ocorrencia>> getOcorrencias(@PathVariable int id){
		ArrayList<Ocorrencia> u = (ArrayList<Ocorrencia>)dao.findAllByStatus(id);
		if(u==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("/ocorrencias/")
	public ResponseEntity<ArrayList<Ocorrencia>> getAllOcorrencias(){
		ArrayList<Ocorrencia> u = (ArrayList<Ocorrencia>)dao.findAll();
		if(u==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(u);
	}

	@GetMapping("/ocorrencias/colab/{id}")
	public ResponseEntity<ArrayList<Ocorrencia>> getOcorrenciasColab(@PathVariable int id){
		ArrayList<Ocorrencia> u = dao.findByUserid(id);
		if(u==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(u);
	}
	@PostMapping("/atualizarocorrencia")
	public ResponseEntity<Ocorrencia> atualizarOcorrencia(@RequestBody Ocorrencia dados){
		try {
			dao.save(dados);
			return ResponseEntity.ok(dados);
		} catch (Exception e) {
			return ResponseEntity.status(500).build();		
		}
	}
	
}
