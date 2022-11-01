package com.portfolio.cuantosdescuentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portfolio.cuantosdescuentos.dao.UsuarioRepository;
import com.portfolio.cuantosdescuentos.entity.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		System.out.println(">>>>>>>>>>>>>>  Entramos en getUserByUsername");
		Usuario usuarioLogado;
		
		try {
			usuarioLogado = usuarioRepository.getUserByUsername(userName);
			System.out.println(">>>>>>>>>>>>>>  usuarioLogado= '" + usuarioLogado.getNombre_usuario() + "' clave: '" + usuarioLogado.getClave()
											+ "' Rol: '" + usuarioLogado.getRol() + "'");
		}catch (Exception e){
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		return new UsuarioDetails(usuarioLogado);
	}

}
