package com.portfolio.cuantosdescuentos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.cuantosdescuentos.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	// No tenemos que implementar la interface ya que JPA nos provee de los métodos necesarios. Sólo hay que añadir aquellos que sean personalizado
	
	Cliente findByDni(String dni);
	// Derived Query (introducer "findBy" + criterio "Dni". Referencia: https://www.baeldung.com/spring-data-derived-queries
	
}
