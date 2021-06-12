package com.portfolio.cuantosdescuentos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.cuantosdescuentos.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	Cliente findByDni(String dni);
	
	// No tenemos que implementar la interface ya que JPA nos provee de los métodos necesarios
	
}
