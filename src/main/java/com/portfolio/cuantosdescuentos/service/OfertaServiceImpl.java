package com.portfolio.cuantosdescuentos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.cuantosdescuentos.dao.OfertaRepository;
import com.portfolio.cuantosdescuentos.entity.Oferta;

@Service
public class OfertaServiceImpl implements OfertaService {
	
	private OfertaRepository ofertaRepository;
	
	@Autowired
	public OfertaServiceImpl (OfertaRepository thisOfertaRepository) {
		ofertaRepository=thisOfertaRepository;
	}

	@Override
	public List<Oferta> findAll() {
		return ofertaRepository.findAll();
	}

	@Override
	public void save(Oferta nuevaOferta) {
		ofertaRepository.save(nuevaOferta);
	}

	public Oferta findById(int id_oferta) {
		Oferta oferta = ofertaRepository.findById(id_oferta);
		return oferta;
	}

}
