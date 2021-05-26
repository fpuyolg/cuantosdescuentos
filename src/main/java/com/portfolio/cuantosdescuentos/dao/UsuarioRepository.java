package com.portfolio.cuantosdescuentos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.cuantosdescuentos.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	// No tenemos que implementar la interface ya que JPA nos provee de los métodos necesarios
	
}
