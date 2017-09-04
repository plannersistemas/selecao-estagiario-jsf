package com.planner.empresarial.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.planner.empresarial.model.Funcionario;
import com.planner.empresarial.repository.Funcionarios;
import com.planner.empresarial.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Funcionario.class)
public class FuncionarioConverter implements Converter {

	//@Inject
	private Funcionarios funcionarios;
	
	public FuncionarioConverter() {
		this.funcionarios = CDIServiceLocator.getBean(Funcionarios.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Funcionario retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = this.funcionarios.porId(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Funcionario funcionario= (Funcionario) value;
			return funcionario.getId() == null ? null : funcionario.getId().toString();
		}
		return "";
	}

}