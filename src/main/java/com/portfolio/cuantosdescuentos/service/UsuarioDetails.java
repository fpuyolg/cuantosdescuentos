package com.portfolio.cuantosdescuentos.service;

import java.util.*;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.portfolio.cuantosdescuentos.entity.Usuario;

public class UsuarioDetails implements UserDetails{

	private Usuario usuario;
	
	public UsuarioDetails (Usuario usuarioLogado) {
		usuario=usuarioLogado;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return usuario.getClave();
	}

	@Override
	public String getUsername() {
		return usuario.getNombre_usuario();
	}
	
	public String getId() {
		return usuario.getId_usuario();	// Añadimos getter para obtener la clave en el acceso al área de clientes
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
