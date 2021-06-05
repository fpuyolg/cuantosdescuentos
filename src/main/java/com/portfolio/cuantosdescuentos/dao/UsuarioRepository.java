package com.portfolio.cuantosdescuentos.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.portfolio.cuantosdescuentos.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	
	@Query("SELECT u FROM Usuario u WHERE u.nombre_usuario = :nombre_usuario")
	public Usuario getUserByUsername(@Param("nombre_usuario") String nombre_usuario);
	
}

