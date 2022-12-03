package br.unitins.kj.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.kj.application.Session;
import br.unitins.kj.model.Carrinho;
import br.unitins.kj.model.ProdutoQuantidade;
@ViewScoped
@Named
public class CarrinhoController implements Serializable{

	private static final long serialVersionUID = -5026285540821281897L;
	
	private Carrinho carrinho;
	
	
	public List<ProdutoQuantidade> getProdutosCarrinho() {
		Session session = Session.getInstance();
		
		carrinho = (Carrinho) session.get("carrinho");
		
		if (carrinho == null) {
			Carrinho carrinho = new Carrinho();
			return carrinho.getProdutos();
		}
		return carrinho.getProdutos();
	}
}
