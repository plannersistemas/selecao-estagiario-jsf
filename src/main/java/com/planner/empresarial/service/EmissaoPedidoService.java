package com.planner.empresarial.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.planner.empresarial.model.Pedido;
import com.planner.empresarial.model.StatusPedido;
import com.planner.empresarial.repository.Pedidos;
import com.planner.empresarial.util.jpa.Transactional;

public class EmissaoPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	@Inject
	private Pedidos pedidos;
	
	@Inject
	EstoqueService estoqueService;
	
	@Transactional
	public Pedido emitir(Pedido pedido) {
		pedido = this.cadastroPedidoService.salvar(pedido);
		 
		if(pedido.isNaoEmissivel()){
			throw new NegocioException("Pedido não pode ser emitido com status "
					+ pedido.getStatus().getDescricao() + ".");
		}
		
		this.estoqueService.baixarItensEstoque(pedido);
		
		pedido.setStatus(StatusPedido.EMITIDO);
		
		pedido = this.pedidos.guardar(pedido);
		
		return pedido;
	}

}
