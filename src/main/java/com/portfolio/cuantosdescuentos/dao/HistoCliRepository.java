package com.portfolio.cuantosdescuentos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portfolio.cuantosdescuentos.entity.HistoCli;

public interface HistoCliRepository extends JpaRepository <HistoCli, Integer>{
	
	@Query("FROM HistoCli WHERE id_cliente = ?1")		// Desde ClientesController llamamos al método enviándole el id_cliente que se recibe en ?1
	List<HistoCli> findById_cliente(int id_cliente);
}
