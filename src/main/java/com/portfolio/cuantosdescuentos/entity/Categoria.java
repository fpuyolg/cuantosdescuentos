package com.portfolio.cuantosdescuentos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="categorias")
public class Categoria {
	
	@Id
	@Column(name="id_categoria")
	private int idCategoria;
	
	@Column(name="nombre")
	private String nombre;
	
}