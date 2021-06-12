package com.portfolio.cuantosdescuentos.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsuarioDetailsService implements UserDetailsService{
	
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException{
		return null;
	}

}
