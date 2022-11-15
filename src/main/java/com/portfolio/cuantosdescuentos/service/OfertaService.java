package com.portfolio.cuantosdescuentos.service;

import java.util.List;
import com.portfolio.cuantosdescuentos.entity.Oferta;

public interface OfertaService {
			
	public List<Oferta> findAll();
	public void save(Oferta nOferta);
	public Oferta findById(int id_oferta);

}
