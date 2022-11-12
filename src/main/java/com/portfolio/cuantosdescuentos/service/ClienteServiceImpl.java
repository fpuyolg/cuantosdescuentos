package com.portfolio.cuantosdescuentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.cuantosdescuentos.dao.ClienteRepository;
import com.portfolio.cuantosdescuentos.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteServiceImpl (ClienteRepository thisClienteRepository) {
		clienteRepository=thisClienteRepository;
	}

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public void save(Cliente nuevoCliente) {
		clienteRepository.save(nuevoCliente);
	}

	public Cliente findByDni(String dni) {
		Cliente clienteLogado = clienteRepository.findByDni(dni);
		return clienteLogado;
	}



}
