package com.portfolio.cuantosdescuentos.service;

import java.util.List;
import com.portfolio.cuantosdescuentos.entity.Cliente;

public interface ClienteService {
			
	public List<Cliente> findAll();
	public void save(Cliente nCliente);

}
