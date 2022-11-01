package com.portfolio.cuantosdescuentos.service;

import java.util.List;
import com.portfolio.cuantosdescuentos.entity.HistoCli;
import com.portfolio.cuantosdescuentos.entity.HistoricoCliente;

public interface HistoCliService {
	public List<HistoCli> findById_cliente(int id_cliente);
//	public List<HistoricoCliente> findById_Oferta(int id_cliente);
}
