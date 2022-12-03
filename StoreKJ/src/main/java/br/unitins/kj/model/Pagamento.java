package br.unitins.kj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Pagamento extends DefaultEntity{

	private TipoPagamento tipoPagamento;
	
	@ManyToOne
	@Column(name="usuario_Pagamento")
	private Usuario usuario;

	@OneToOne
	@Column(name="Compra_pagamento")
	private Compra compra;
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
}
