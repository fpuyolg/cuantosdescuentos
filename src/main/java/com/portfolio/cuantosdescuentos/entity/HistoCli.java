package com.portfolio.cuantosdescuentos.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import com.portfolio.cuantosdescuentos.HistoCliPK;

@Entity
@IdClass(HistoCliPK.class)
public class HistoCli {
	
	@Id int id_cliente;
	
	// @Column(name="id_cliente")
	// private int id_cliente;
	
	@Id int id_oferta;
	// @Column(name="id_oferta")
	// private int id_oferta;
	
	@Column(name="usado")
	private boolean usado;
	
	@Column(name="fecha")
	private LocalDate fecha;
	
	public HistoCli() {
		
	}

	public HistoCli(int id_cliente, int id_oferta, boolean usado, LocalDate fecha) {
		this.id_cliente = id_cliente;
		this.id_oferta = id_oferta;
		this.usado = usado;
		this.fecha = fecha;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_oferta() {
		return id_oferta;
	}

	public void setId_oferta(int id_oferta) {
		this.id_oferta = id_oferta;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "HistoCli [id_cliente=" + id_cliente + ", id_oferta=" + id_oferta + ", usado=" + usado + ", fecha="
				+ fecha + "]";
	}
	
}
