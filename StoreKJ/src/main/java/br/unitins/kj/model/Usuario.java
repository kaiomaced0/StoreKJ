package br.unitins.kj.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import br.unitins.kj.model.especial.Gostei;


@Entity
public class Usuario extends DefaultEntity{
	
	private String nome;
	
	@NotBlank(message=" Login não informado!")
	private String login;
	
	@NotBlank(message=" Senha não Informada!")
	private String senha;
	
	private LocalDate dataNascimento;

	private Perfil perfil;

	@ManyToOne
	private Cidade cidade;
	
	@OneToOne
	private Gostei gostei;
	
	@OneToMany
	@Column(name="endereco")
	private List<Endereco> enderecos;
	
	private Double valorGastoLoja;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public Double getValorGastoLoja() {
		return valorGastoLoja;
	}
	public void setValorGastoLoja(Double valorGastoLoja) {
		this.valorGastoLoja = valorGastoLoja;
	}
	
	
	
}
