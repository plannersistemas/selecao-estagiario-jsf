package com.planner.empresarial.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.planner.empresarial.model.Cargo;
import com.planner.empresarial.repository.Cargos;
import com.planner.empresarial.repository.filter.CargoFilter;
import com.planner.empresarial.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaCargosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Cargos cargos;
	
	private CargoFilter filtro;
	private List<Cargo> cargosFiltrados;
	private Cargo cargoSelecionado;
	
	public PesquisaCargosBean() {
		filtro = new CargoFilter();
	}
	public void excluir(){
		cargos.remover(cargoSelecionado);
		cargosFiltrados.remove(cargoSelecionado);
		
		FacesUtil.addInfoMessage("Cargo " + cargoSelecionado.getId() + " excluído com sucesso.");
	}
	public void pesquisar(){
		cargosFiltrados = cargos.filtrados(filtro);
	}
	
	public List<Cargo> getCargosFiltrados() {
		return cargosFiltrados;
	}
	
	public List<Cargo> getCargos(){
		return cargosFiltrados=cargos.filtrados(filtro);
	}	
			
	public CargoFilter getFiltro() {
		return filtro;
	}
	
	public Cargo getCargoSelecionado() {
		return cargoSelecionado;
	}
	public void setCargoSelecionado(Cargo cargoSelecionado) {
		this.cargoSelecionado = cargoSelecionado;
	}
}
