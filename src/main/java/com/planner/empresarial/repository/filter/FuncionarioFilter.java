package com.planner.empresarial.repository.filter;

import java.io.Serializable;

import com.planner.empresarial.model.Cargo;

public class FuncionarioFilter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private double salario;
	private String matricula;
	private String nomeCargo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeCargo() {
		return nomeCargo;
	}
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
