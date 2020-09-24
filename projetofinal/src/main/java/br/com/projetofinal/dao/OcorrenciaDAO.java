package br.com.projetofinal.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.projetofinal.beans.Ocorrencia;

public interface OcorrenciaDAO extends CrudRepository<Ocorrencia, Integer> {
	ArrayList<Ocorrencia> findAllByStatus(int id);
	
	@Query(value="SELECT * FROM itmn232_ocorrencia WHERE id_usuario_id_usuario LIKE ?1",nativeQuery = true)
	ArrayList<Ocorrencia> findByUserid(int id);
}
