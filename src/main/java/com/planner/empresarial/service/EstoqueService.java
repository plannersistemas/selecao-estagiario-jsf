package com.planner.empresarial.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.Transient;

import com.planner.empresarial.model.ItemPedido;
import com.planner.empresarial.model.Pedido;
import com.planner.empresarial.repository.Pedidos;
import com.planner.empresarial.util.jpa.Transactional;

public class EstoqueService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pedidos pedidos;
	
	@Transactional
	public void baixarItensEstoque(Pedido pedido) {
			pedido = this.pedidos.porId(pedido.getId());
			
			for(ItemPedido item : pedido.getItens()){
				item.getProduto().baixarEstoque(item.getQuantidade());
			}
	}

	@Transient
	public void retornarItensEstoque(Pedido pedido) {
		pedido = this.pedidos.porId(pedido.getId());
		
		for( ItemPedido item : pedido.getItens()){
			item.getProduto().adicionarEstoque(item.getQuantidade());
		}
	}

}
