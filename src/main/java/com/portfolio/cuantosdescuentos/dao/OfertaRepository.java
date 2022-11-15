package com.portfolio.cuantosdescuentos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.cuantosdescuentos.entity.Oferta;

public interface OfertaRepository extends JpaRepository<Oferta, Integer>{

	Oferta findById(int id_oferta);
}
