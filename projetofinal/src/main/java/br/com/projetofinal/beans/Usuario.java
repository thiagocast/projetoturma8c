package br.com.projetofinal.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//Elementos com "@" definem annotations e devem estar logo acima das classes
@Entity 												//define que a classe será uma tabela no banco de dados
@Table(name="TB_USUARIO")								//nome da tabela
public class Usuario {
	
	@Id													//Define que o atributo será uma chave primária
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//Coluna ID será incrementada automaticamente pelo DB
	@Column(name="id")									//nome exato da coluna no DB
	private int id;
	
	@Column(name="nome", length=40)
	private String nome;
	
	@Column(name="email", length=70)
	private String email;
	
	@Column(name="senha", length=20)
	private String senha;
	
	@Column(name="foto")
	private String foto;
	
	@Transient											//Necessário para criar variáveis dentro da classe que não existem no banco de dados
	private String teste;
	
	public Usuario() {
		super();
	}
	public Usuario(int id, String nome, String email, String senha, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	
}
