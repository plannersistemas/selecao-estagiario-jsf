package com.planner.empresarial.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.planner.empresarial.model.Grupo;
import com.planner.empresarial.model.Usuario;
import com.planner.empresarial.repository.Usuarios;
import com.planner.empresarial.util.cdi.CDIServiceLocator;

public class AppUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuarios usuarios = CDIServiceLocator.getBean(Usuarios.class);
		Usuario usuario = usuarios.porEmail(email);
		
		UsuarioSistema user = null;
		
		if (usuario != null) {
			user = new UsuarioSistema(usuario, getGrupos(usuario));
		}
		
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for (Grupo grupo : usuario.getGrupos()) {
			authorities.add(new SimpleGrantedAuthority(grupo.getNome().toUpperCase()));
		}
		
		return authorities;
	}

}
