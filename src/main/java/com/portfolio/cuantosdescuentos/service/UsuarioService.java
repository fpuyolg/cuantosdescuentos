package com.portfolio.cuantosdescuentos.service;

import com.portfolio.cuantosdescuentos.entity.Usuario;

public interface UsuarioService {
	
	public void save(Usuario nUsuario);
	public Usuario findByIdUsuario(String id_usuario);

}
