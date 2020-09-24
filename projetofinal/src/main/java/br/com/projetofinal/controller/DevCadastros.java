package br.com.projetofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.projetofinal.beans.Atividade;
import br.com.projetofinal.beans.Ocorrencia;
import br.com.projetofinal.beans.Usuario;
import br.com.projetofinal.dao.AtividadeDAO;
import br.com.projetofinal.dao.OcorrenciaDAO;
import br.com.projetofinal.dao.UsuarioDAO;

public class DevCadastros {
	@Autowired
	private OcorrenciaDAO daoOcorrencia;
	
	@Autowired
	private UsuarioDAO daoUsuario;
	
	@Autowired
	private AtividadeDAO daoAtividade;
	
	@PostMapping("/gravarocorrencia")
	public ResponseEntity<Ocorrencia> gravarOcorrencia(@RequestBody Ocorrencia dados){
		try {
			daoOcorrencia.save(dados);
			return ResponseEntity.ok(dados);
		} catch (Exception e) {
			return ResponseEntity.status(500).build();		
		}
	}
	
	@PostMapping("/gravarousuario")
	public ResponseEntity<Usuario> gravarUsuario(@RequestBody Usuario dados){
		try {
			daoUsuario.save(dados);
			return ResponseEntity.ok(dados);
		} catch (Exception e) {
			return ResponseEntity.status(500).build();		
		}
	}
	
	@PostMapping("/gravarAtividade")
	public ResponseEntity<Atividade> gravarAtividade(@RequestBody Atividade dados){
		try {
			daoAtividade.save(dados);
			return ResponseEntity.ok(dados);
		} catch (Exception e) {
			return ResponseEntity.status(500).build();		
		}
	}
}
