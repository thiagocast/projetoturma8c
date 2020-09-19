package br.com.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.projetofinal.beans.Usuario;

/*
 * DAO = Data Access Object
 * CRUD = Create Read Update Delete
 */

//Nome é fundamental no DAO e precisa seguir o padrão do springboot

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
	Usuario findByEmailAndSenha(String email, String senha);		//Email e Senha no nome do metodo devem casar com o atributo definido na classe Usuario
	
}
