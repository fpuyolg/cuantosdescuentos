package com.portfolio.cuantosdescuentos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.cuantosdescuentos.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
	
		Empresa findByCif(String cif);
	
}
