package com.planner.empresarial.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.planner.empresarial.model.Cliente;
import com.planner.empresarial.repository.Clientes;
import com.planner.empresarial.util.jpa.Transactional;

public class CadastroClienteService  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Clientes clientes;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clientes.porDocumentoReceitaFederal(cliente.getDocumentoReceitaFederal()); 
		
		if(clienteExistente != null && !clienteExistente.equals(cliente)){
			throw new NegocioException("Já existe um cliente com o Documento da Receita informado. ");
		}
		return clientes.guardar(cliente);
	}

}
