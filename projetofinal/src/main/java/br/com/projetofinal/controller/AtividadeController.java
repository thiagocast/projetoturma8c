package br.com.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.beans.Atividade;
import br.com.projetofinal.dao.AtividadeDAO;

@CrossOrigin("*")
@RestController
public class AtividadeController {
	@Autowired
	private AtividadeDAO dao;
	
	@GetMapping("/atividades")
	public ResponseEntity<ArrayList<Atividade>> getAll(){
		ArrayList<Atividade> u = (ArrayList<Atividade>)dao.findAllAtividades();
		if(u.size()==0) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(u);
	}

}
