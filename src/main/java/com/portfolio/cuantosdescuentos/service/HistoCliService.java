package com.portfolio.cuantosdescuentos.service;

import java.util.List;
import com.portfolio.cuantosdescuentos.entity.HistoCli;
import com.portfolio.cuantosdescuentos.entity.HistoricoCliente;

public interface HistoCliService {
	
	public List<Object[]> findById_cliente(int id_cliente);
	// public List<HistoCli> findById_cliente(int id_cliente); VERSIÓN QUE MUESTRA HISTÓRICO CON LOS CÓDIGOS DE LOS TICKETS EN LUGAR DEL TÍTULO
	
}
