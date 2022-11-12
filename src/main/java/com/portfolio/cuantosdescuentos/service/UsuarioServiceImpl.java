package com.portfolio.cuantosdescuentos.service;

import org.springframework.stereotype.Service;
import com.portfolio.cuantosdescuentos.dao.UsuarioRepository;
import com.portfolio.cuantosdescuentos.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository thisUsuarioRepository) {
		usuarioRepository=thisUsuarioRepository;
	}

	@Override
	public void save(Usuario nUsuario) {
		usuarioRepository.save(nUsuario);
	} 

	@Override
	public Usuario findByIdUsuario(String id_usuario) {
		Usuario usuarioActualizando = usuarioRepository.findByIdUsuario(id_usuario);
		return usuarioActualizando;
	}

}
