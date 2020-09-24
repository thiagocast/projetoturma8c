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
@Table(name = "itmn232_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int id_usuario;

	@JsonIgnoreProperties("id_usuario")
	@OneToMany(mappedBy = "id_usuario", cascade = CascadeType.ALL)
	private List<Ocorrencia> ocorrencias;

	@Column(name = "nome_usuario", length = 100, nullable = false)
	private String nomeUsuario;

	@Column(name = "email_usuario", length = 100)
	private String emailUsuario;

	@Column(name = "racf", length = 7, nullable = false, unique = true)
	private String racf;

	@Column(name = "senha", length = 50, nullable = false)
	private String senha;

	@Column(name = "link_foto")
	private String linkFoto;

	@Column(name = "gestor")
	private int gestor = 1;

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getRacf() {
		return racf;
	}

	public void setRacf(String racf) {
		this.racf = racf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}

	public int getGestor() {
		return gestor;
	}

	public void setGestor(int gestor) {
		this.gestor = gestor;
	}

	public Usuario(int id_usuario, List<Ocorrencia> ocorrencias, String nomeUsuario, String emailUsuario, String racf,
			String senha, String linkFoto, int gestor) {
		super();
		this.id_usuario = id_usuario;
		this.ocorrencias = ocorrencias;
		this.nomeUsuario = nomeUsuario;
		this.emailUsuario = emailUsuario;
		this.racf = racf;
		this.senha = senha;
		this.linkFoto = linkFoto;
		this.gestor = gestor;
	}

	public Usuario() {
		super();
	}
}