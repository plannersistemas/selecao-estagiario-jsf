package com.planner.empresarial.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.planner.empresarial.model.Produto;
import com.planner.empresarial.repository.Produtos;
import com.planner.empresarial.repository.filter.ProdutoFilter;
import com.planner.empresarial.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produtos produtos;
	
	private ProdutoFilter filtro;
	private List<Produto> produtosFiltrados;
	
	private Produto produtoSelecionado;
	
	public PesquisaProdutosBean() {
		filtro = new ProdutoFilter();
	}
	
	public void excluir() {
		produtos.remover(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);
		
		FacesUtil.addInfoMessage("Produto " + produtoSelecionado.getSku() 
				+ " excluído com sucesso.");
	}
	
	public void pesquisar() {
		produtosFiltrados = produtos.filtrados(filtro);
	}
	
	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
}