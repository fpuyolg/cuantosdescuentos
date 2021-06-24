package com.portfolio.cuantosdescuentos;

import java.io.Serializable;

public class HistoCliPK implements Serializable{

	private int id_cliente;
	private int id_oferta;
	
	public HistoCliPK () {		// Constructor por defecto
	}
	
	public HistoCliPK (int id_cliente, int id_oferta) {		// Constructor que indica la composición de la clave principal de la tabla Histo_Cli
		this.id_cliente=id_cliente;
		this.id_oferta=id_oferta;
	}
}
