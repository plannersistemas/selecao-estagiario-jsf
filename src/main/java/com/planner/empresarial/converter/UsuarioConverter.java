package com.planner.empresarial.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.planner.empresarial.model.Usuario;
import com.planner.empresarial.repository.Usuarios;
import com.planner.empresarial.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter {

	//@Inject
	private Usuarios usuarios;
	
	public UsuarioConverter() {
		this.usuarios = (Usuarios) CDIServiceLocator.getBean(Usuarios.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;

		if (value != null) {
			retorno = this.usuarios.porId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Usuario) value).getId().toString();
		}
		return "";
	}

}