package com.planner.empresarial.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.planner.empresarial.model.Funcionario;
import com.planner.empresarial.repository.Funcionarios;
import com.planner.empresarial.repository.filter.FuncionarioFilter;
import com.planner.empresarial.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFuncionariosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Funcionarios funcionarios;
	
	private FuncionarioFilter filtro;
	private List<Funcionario> funcionariosFiltrados;
	private Funcionario funcionarioSelecionado;
	
	public PesquisaFuncionariosBean() {
		filtro = new FuncionarioFilter();
	}
	public void excluir(){
		funcionarios.remover(funcionarioSelecionado);
		funcionariosFiltrados.remove(funcionarioSelecionado);
		
		FacesUtil.addInfoMessage("Funcionario " + funcionarioSelecionado.getId() + " excluído com sucesso.");
	}
	public void pesquisar(){
		funcionariosFiltrados = funcionarios.filtrados(filtro);
	}
	
	public List<Funcionario> getFuncionariosFiltrados() {
		return funcionariosFiltrados;
	}
	
	public FuncionarioFilter getFiltro() {
		return filtro;
	}
	
	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}
	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}
}
