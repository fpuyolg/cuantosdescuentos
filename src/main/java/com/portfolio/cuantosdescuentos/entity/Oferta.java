package com.portfolio.cuantosdescuentos.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;


@Entity
@Table(name="ofertas")
public class Oferta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oferta")
	private int id_oferta;
	
	//@NotEmpty(message="Campo DNI obligatorio")
	//@Pattern(regexp="^[0-9]{8}[A-Z]{1}", message="Si el primer dígito es 0 debe ponerlo. La letra debe ser mayúscula")
	@Column(name="id_empresa")
	private String id_empresa;
	
	//@NotEmpty(message="Campo Nombre obligatorio")
	@Column(name="titulo")
	private String titulo;
	
	//@NotEmpty(message="Campo teléfono obligatorio")
	//@Pattern(regexp="^[0-9]{9}", message="Indique 9 dígitos")
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="imagen")
	private byte[] imagen;
			
	//@Pattern(regexp=".+@.+\\..+", message="Email incorrecto")
	@Column(name="id_categoria")
	private String idCategoria;
	
	@Column(name="fecha_desde")
	private LocalDate fecha_desde;
	
	@Column(name="fecha_hasta")
	private LocalDate fecha_hasta;
	
	@Column(name="precio")
	private Float precio;
	
	public Oferta() {    // Constructor vacío requerido por Hibernate
		
	}

	public Oferta(int id_oferta, String id_empresa, String titulo, String descripcion, String id_categoria,
			LocalDate fecha_desde, LocalDate fecha_hasta, Float precio) {
		this.id_oferta = id_oferta;
		this.id_empresa = id_empresa;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.idCategoria = id_categoria;
		this.fecha_desde = fecha_desde;
		this.fecha_hasta = fecha_hasta;
		this.precio = precio;
	}

	public String getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(String id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getId_categoria() {
		return idCategoria;
	}

	public void setId_categoria(String id_categoria) {
		this.idCategoria = id_categoria;
	}

	public LocalDate getFecha_desde() {
		return fecha_desde;
	}

	public void setFecha_desde(LocalDate fecha_desde) {
		this.fecha_desde = fecha_desde;
	}

	public LocalDate getFecha_hasta() {
		return fecha_hasta;
	}

	public void setFecha_hasta(LocalDate fecha_hasta) {
		this.fecha_hasta = fecha_hasta;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public int getId_oferta() {
		return id_oferta;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public String toString() {
		return "Oferta [id_oferta=" + id_oferta + ", id_empresa=" + id_empresa + ", titulo=" + titulo + ", descripcion="
				+ descripcion + ", id_categoria=" + idCategoria + ", fecha_desde=" + fecha_desde + ", fecha_hasta="
				+ fecha_hasta + ", precio=" + precio + "]";
	}
	
}
