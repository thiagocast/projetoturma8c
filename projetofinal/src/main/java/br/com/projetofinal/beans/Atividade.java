package br.com.projetofinal.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "itmn232_atividade")
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atividade")
	private int id_atividade;

	@JsonIgnoreProperties("id_atividade")
	@OneToMany(mappedBy = "id_atividade", cascade = CascadeType.ALL)
	private List<Ocorrencia> ocorrencias;

	@Column(name = "nome_atividade", length = 100, nullable = false)
	private String nome_atividade;

	public int getId_atividade() {
		return id_atividade;
	}

	public void setId_atividade(int id_atividade) {
		this.id_atividade = id_atividade;
	}

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public String getNome_atividade() {
		return nome_atividade;
	}

	public void setNome_atividade(String nome_atividade) {
		this.nome_atividade = nome_atividade;
	}

	public Atividade(int id_atividade, List<Ocorrencia> ocorrencias, String nome_atividade) {
		super();
		this.id_atividade = id_atividade;
		this.ocorrencias = ocorrencias;
		this.nome_atividade = nome_atividade;
	}

	public Atividade() {
		super();
	}
}
