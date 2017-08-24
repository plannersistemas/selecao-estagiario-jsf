package com.planner.empresarial.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.planner.empresarial.model.Pedido;
import com.planner.empresarial.model.StatusPedido;
import com.planner.empresarial.repository.Pedidos;
import com.planner.empresarial.util.jpa.Transactional;

public class CancelamentoPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pedidos pedidos;
	
	@Inject
	private EstoqueService estoqueService; 
	
	@Transactional
	public Pedido cancelar(Pedido pedido) {
		pedido = this.pedidos.porId(pedido.getId());
		
		
		if(pedido.isNaoCancelavel()){
			throw new NegocioException("pedido não pode ser cancelado no status "
					+ pedido.getStatus().getDescricao() + ".");
		}
		
		if(pedido.isEmitido()){
			this.estoqueService.retornarItensEstoque(pedido);
		}
		
		pedido.setStatus(StatusPedido.CANCELADO);
		pedido = this.pedidos.guardar(pedido);
		return pedido;
	}
	
}
