package com.portfolio.cuantosdescuentos.service;

import java.util.List;
import com.portfolio.cuantosdescuentos.entity.HistoCli;

public interface HistoCliService {
	public List<HistoCli> findById_cliente(int id_cliente);

}
