package com.portfolio.cuantosdescuentos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.cuantosdescuentos.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

	Categoria findByIdCategoria(int id_categoria);
}
