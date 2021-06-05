package com.portfolio.cuantosdescuentos.entity;

import java.util.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
