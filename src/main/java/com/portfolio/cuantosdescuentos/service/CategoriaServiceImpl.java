package com.portfolio.cuantosdescuentos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.cuantosdescuentos.dao.CategoriaRepository;
import com.portfolio.cuantosdescuentos.dao.OfertaRepository;
import com.portfolio.cuantosdescuentos.entity.Categoria;
import com.portfolio.cuantosdescuentos.entity.Oferta;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	public CategoriaServiceImpl (CategoriaRepository thisCategoriaRepository) {
		categoriaRepository=thisCategoriaRepository;
	}

	@Override
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria findByIdCategoria(int id_categoria) {
		return categoriaRepository.findByIdCategoria(id_categoria);
	}

}
