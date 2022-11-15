package com.portfolio.cuantosdescuentos.service;

import java.util.List;
import com.portfolio.cuantosdescuentos.entity.Categoria;

public interface CategoriaService {
			
	public List<Categoria> findAll();
	public Categoria findByIdCategoria(int id_categoria);

}
