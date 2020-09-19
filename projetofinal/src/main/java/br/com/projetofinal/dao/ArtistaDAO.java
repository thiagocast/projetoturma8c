package br.com.projetofinal.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.projetofinal.beans.Artista;

/*
 * DAO = Data Access Object
 * CRUD = Create Read Update Delete
 */

//Nome é fundamental no DAO e precisa seguir o padrão do springboot

public interface ArtistaDAO extends CrudRepository<Artista, Integer>{
	
	ArrayList<Artista> findByNacionalidade(String nacionalidade);		//Email e Senha no nome do metodo devem casar com o atributo definido na classe Usuario
	
}
