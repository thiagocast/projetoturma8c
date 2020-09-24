package br.com.projetofinal.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.projetofinal.beans.Atividade;

public interface AtividadeDAO extends CrudRepository<Atividade, Integer>{
	@Query(value="SELECT id_atividade,nome_atividade FROM itmn232_atividade",nativeQuery = true)
	ArrayList<Atividade> findAllAtividades();
}
