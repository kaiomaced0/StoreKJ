package br.unitins.kj.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

import br.unitins.kj.application.Session;
import br.unitins.kj.application.Util;
import br.unitins.kj.model.Carrinho;
import br.unitins.kj.model.Produto;
import br.unitins.kj.model.ProdutoQuantidade;
import br.unitins.kj.repository.ProdutoRepository;

@RequestScoped
@Named
public class HomeController {
	
	@Inject
	private ProdutoRepository repository;
	private List<Produto> listaProduto;
	
	@PostConstruct
	public void init() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		Object resultado = flash.get("pesquisaProduto");
		// verificando se teve consulta de produto pela pesquisa no template
		if (resultado != null)
			setProdutos((ArrayList<Produto>)resultado);
		else
			setProdutos(repository.buscarTodos());
	}
	
	public void adicionarCarrinho(Produto produto) {
		Carrinho carrinho;
		
		Session session = Session.getInstance();
		if (session.get("carrinho") != null){
			carrinho = (Carrinho) session.get("carrinho"); 
		} else {
			carrinho = new Carrinho();
		}
		
		// verificando se existe itens de compra
		if (carrinho.getProdutos() == null)
			carrinho.setProdutos(new ArrayList<ProdutoQuantidade>());
		
			
		// buscando um item na lista do carrinho
		Optional<ProdutoQuantidade> pQuantidade = carrinho.getProdutos().stream()
				.filter(pQuant -> pQuant.getProduto().equals(produto.getId())).findAny();
		
		ProdutoQuantidade item = pQuantidade.orElse(new ProdutoQuantidade());
		
		item.setValor(produto.getValor());
		item.setProduto(produto);
		item.setQuantidade(item.getQuantidade()+1);
			
		
		// buscando se existe um item no carrinho para alterar
		int indice = -1; 
		for (int index = 0; index < carrinho.getProdutos().size(); index++) {
			if (carrinho.getProdutos().get(index).getProduto().equals(produto)) {
				indice = index;
				break;
			}
		}
		
		if (indice >= 0)
			carrinho.getProdutos().set(indice, item);
		else
			carrinho.getProdutos().add(item);
		
		// adicionando na sessao
		session.put("carrinho", carrinho);
		
		Util.addInfoMessage(item.getProduto().getNome()+ " adicionado ao carrinho.");
		
	}


	public List<Produto> getProdutos() {
		return listaProduto;
	}

	public void setProdutos(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

}
