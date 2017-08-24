package com.planner.empresarial.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.planner.empresarial.model.Produto;
import com.planner.empresarial.repository.Produtos;
import com.planner.empresarial.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;
	
	@Transactional
	public Produto salvar(Produto produto) {
		Produto produtoExistente = produtos.porSku(produto.getSku());
		
		if (produtoExistente != null && !produtoExistente.equals(produto)) {
			throw new NegocioException("Já existe um produto com o SKU informado.");
		}
		
		return produtos.guardar(produto);
	}
	
}
