package com.planner.empresarial.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.planner.empresarial.model.Cargo;
import com.planner.empresarial.model.Funcionario;
import com.planner.empresarial.model.TipoPessoa;
import com.planner.empresarial.repository.Cargos;
import com.planner.empresarial.service.CadastroFuncionarioService;
import com.planner.empresarial.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroFuncionarioService cadastroFuncionarioService;

	private Funcionario funcionario;

	public CadastroFuncionarioBean() {
		limpar();

	}

	private void limpar() {
		funcionario = new Funcionario();
	}

	public void salvar() {
		this.funcionario = cadastroFuncionarioService.salvar(this.funcionario);
		limpar();

		FacesUtil.addInfoMessage("Funcionario salvo com sucesso!");
	}

	public boolean isEditando() {
		return funcionario.getId() != null;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

}
