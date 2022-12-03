package br.unitins.kj.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cidade extends DefaultEntity{
	private String nome;
	
	@ManyToOne
	@Column(name="id_estado")
	private Estado estado;
	
	@OneToMany
	@Column(name="lista_usuarios")
	private List<Usuario> listaUsuarios_cidade;
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
