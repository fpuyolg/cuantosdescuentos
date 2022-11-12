package com.portfolio.cuantosdescuentos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.cuantosdescuentos.dao.HistoCliRepository;
import com.portfolio.cuantosdescuentos.entity.HistoCli;
import com.portfolio.cuantosdescuentos.entity.HistoricoCliente;

@Service
public class HistoCliServiceImpl implements HistoCliService {
	
	@Autowired
	private HistoCliRepository histoCliRepository;
	
	public HistoCliServiceImpl(HistoCliRepository thisHistoCliRepository) {
		histoCliRepository=thisHistoCliRepository;
	}

	//@Override
	//public List<HistoCli> findById_cliente(int id_cliente) {  // Versión del histórico con el código del ticket en lugar del título


	@Override
	public List<Object[]> findById_cliente(int id_cliente) {
		List<Object[]> listaHistoCli = histoCliRepository.findById_cliente(id_cliente);
		return listaHistoCli;
	}

}
