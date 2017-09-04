package com.planner.empresarial.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.planner.empresarial.model.Cargo;
import com.planner.empresarial.service.CadastroCargoService;
import com.planner.empresarial.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroCargoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroCargoService cadastroCargoService;

	private Cargo cargo;

	public CadastroCargoBean() {
		limpar();

	}

	private void limpar() {
		cargo = new Cargo();
	}

	public void salvar() {
		this.cargo = cadastroCargoService.salvar(this.cargo);
		limpar();

		FacesUtil.addInfoMessage("Cargo salvo com sucesso!");
	}

	public boolean isEditando() {
		return cargo.getId() != null;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Cargo getCargo() {
		return cargo;
	}

}
