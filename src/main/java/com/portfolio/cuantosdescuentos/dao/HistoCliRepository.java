package com.portfolio.cuantosdescuentos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portfolio.cuantosdescuentos.entity.HistoCli;
import com.portfolio.cuantosdescuentos.entity.HistoricoCliente;

public interface HistoCliRepository extends JpaRepository <HistoCli, Integer>{
	
	@Query("SELECT h, o FROM  HistoCli h, Oferta o WHERE h.id_oferta=o.id_oferta and h.id_cliente = ?1")
	List<Object[]> findById_cliente(int id_cliente);
} 